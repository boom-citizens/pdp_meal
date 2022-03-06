package uz.d4uranbek.pdp_meal.bot.processors;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.DeleteMessage;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ForceReplyKeyboard;
import uz.d4uranbek.pdp_meal.bot.PDPFoodBot;
import uz.d4uranbek.pdp_meal.bot.buttons.InlineBoards;
import uz.d4uranbek.pdp_meal.bot.buttons.MarkupBoards;
import uz.d4uranbek.pdp_meal.bot.state.State;
import uz.d4uranbek.pdp_meal.bot.state.UserState;
import uz.d4uranbek.pdp_meal.dto.auth.AuthCreateDto;
import uz.d4uranbek.pdp_meal.service.auth.AuthServiceImpl;

import uz.d4uranbek.pdp_meal.utils.Emojis;

import java.io.File;
import java.util.Locale;
import java.util.Objects;

/**
 * Author : Qozoqboyev Ixtiyor
 * Time : 02.03.2022 20:16
 * Project : pdp_meal
 */
@Component
public class AuthorizationProcessor {

    private final PDPFoodBot bot;
    private final State state;
    private final AuthServiceImpl authService;
    private final InlineBoards inlineBoards;
    private final MarkupBoards markupBoards;
    public AuthorizationProcessor(PDPFoodBot bot, State state, AuthServiceImpl authService, InlineBoards inlineBoards, MarkupBoards markupBoards) {
        this.bot = bot;
        this.state = state;
        this.authService = authService;
        this.inlineBoards = inlineBoards;
        this.markupBoards = markupBoards;
    }


    public void process(Update update, UserState state) {
        Message message = update.getMessage();
        long chatID = message.getChatId();
        User user = message.getFrom();
        AuthCreateDto authCreateDto=new AuthCreateDto();
        if (Objects.isNull(state)) {
            SendPhoto sendPhoto = new SendPhoto();
            sendPhoto.setChatId(message.getChatId().toString());
            sendPhoto.setPhoto(new InputFile(new File("src/main/resources/statics/logo.png")));
            sendPhoto.setCaption("Welcome to our %s %s".formatted("PDPFoodBot", user.getFirstName()));
            bot.executePhoto(sendPhoto);

            SendMessage sendMessage = messageObj(chatID, "Choose language please");
            sendMessage.setReplyMarkup(inlineBoards.languageButtons());
            bot.executeMessage(sendMessage);
            changeState(chatID, UserState.LANGUAGE);
        } else if (UserState.LANGUAGE.equals(state)) {
            bot.executeMessage(new DeleteMessage("" + chatID, message.getMessageId()));
        }else if (UserState.DEPARTMENT.equals(state)) {
            bot.executeMessage(new DeleteMessage("" + chatID, message.getMessageId()));
        } else if (UserState.DEPARTMENT_CHOSEN.equals(state)) {
            bot.executeMessage(new DeleteMessage("" + chatID, message.getMessageId()));
        } else if (UserState.DEPARTMENT_ACCEPTED.equals(state)) {
            authCreateDto.setFullName(message.getText());
            SendMessage sendMessage = messageObj(chatID, "Your password please");
            sendMessage.setReplyMarkup(new ForceReplyKeyboard());
            bot.executeMessage(sendMessage);
            changeState(chatID, UserState.PASSWORD);
        } else if (UserState.PASSWORD.equals(state)) {
            authCreateDto.setPassword(message.getText());
            SendMessage sendMessage = messageObj(chatID, Emojis.PHONE + "Share your phone number please");
            sendMessage.setReplyMarkup(MarkupBoards.sharePhoneNumber());
            bot.executeMessage(sendMessage);
            changeState(chatID, UserState.PHONE);
        } else if (UserState.PHONE.equals(state)) {
            if (message.hasContact()) {
                authCreateDto.setPhone(message.getContact().getPhoneNumber());
                SendMessage sendMessage = messageObj(chatID, "Enter your position");
                sendMessage.setReplyMarkup(new ForceReplyKeyboard());
                bot.executeMessage(sendMessage);
                changeState(chatID, UserState.POSITION);
            } else {
                authCreateDto.setPhone(message.getText());
                SendMessage sendMessage = messageObj(chatID, "Enter your position");
                sendMessage.setReplyMarkup(new ForceReplyKeyboard());
                bot.executeMessage(sendMessage);
                changeState(chatID, UserState.POSITION);
            }
        } else if (UserState.POSITION.equals(state)) {
            authCreateDto.setPosition(message.getText());
            SendMessage sendMessage = messageObj(chatID, "Successfully registered");
            sendMessage.setReplyMarkup(MarkupBoards.mainMenu());
            bot.executeMessage(sendMessage);
            authCreateDto.setRole("EMPLOYEE");
            authCreateDto.setStatus("ACTIVE");
            authCreateDto.setChatId(chatID);
            authService.create(authCreateDto);
            changeState(chatID, UserState.AUTHORIZED);
        }
    }

    private void changeState(long chatID, UserState newState) {
        state.setState(chatID, newState);
    }

    private SendMessage messageObj(long chatID, String text) {
        return new SendMessage(String.valueOf(chatID), text);
    }
}
