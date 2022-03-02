package uz.d4uranbek.pdp_meal.bot.processors;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;
import uz.d4uranbek.pdp_meal.bot.PDPFoodBot;
import uz.d4uranbek.pdp_meal.bot.buttons.InlineBoards;
import uz.d4uranbek.pdp_meal.bot.state.State;
import uz.d4uranbek.pdp_meal.bot.state.UserState;

import java.io.File;
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

    public AuthorizationProcessor(PDPFoodBot bot, State state) {
        this.bot = bot;
        this.state = state;
    }


    public void process(Update update, UserState state) {
        Message message=update.getMessage();
        long chatID = message.getChatId();
        User user = message.getFrom();
        if (Objects.isNull(state)) {
            SendPhoto sendPhoto = new SendPhoto();
            sendPhoto.setChatId(message.getChatId().toString());
            sendPhoto.setPhoto(new InputFile(new File("src/main/resources/statics/logo.png")));
            sendPhoto.setCaption("Welcome to our %s %s".formatted("PDPFoodBot", user.getFirstName()));
            bot.executePhoto(sendPhoto);

            SendMessage sendMessage=messageObj(chatID,"Choose language please");
            sendMessage.setReplyMarkup(InlineBoards.languageButtons());
            bot.executeMessage(sendMessage);
            changeState(chatID,UserState.LANGUAGE);

        }
        }

    private void changeState(long chatID, UserState newState) {
        state.setState(chatID, newState);
    }


    private SendMessage messageObj(long chatID, String text) {
        return new SendMessage(String.valueOf(chatID),text);
    }
}
