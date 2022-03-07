package uz.d4uranbek.pdp_meal.bot.handlers;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.DeleteMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ForceReplyKeyboard;
import uz.d4uranbek.pdp_meal.bot.PDPFoodBot;
import uz.d4uranbek.pdp_meal.bot.buttons.InlineBoards;
import uz.d4uranbek.pdp_meal.bot.state.State;
import uz.d4uranbek.pdp_meal.bot.state.UserState;
import uz.d4uranbek.pdp_meal.criteria.GenericCriteria;
import uz.d4uranbek.pdp_meal.dto.department.DepartmentDto;
import uz.d4uranbek.pdp_meal.service.auth.AuthServiceImpl;
import uz.d4uranbek.pdp_meal.service.department.DepartmentServiceImpl;

import java.util.List;

import static uz.d4uranbek.pdp_meal.bot.processors.AuthorizationProcessor.authCreateDto;

/**
 * Author : Qozoqboyev Ixtiyor
 * Time : 02.03.2022 19:04
 * Project : pdp_meal
 */
@Component
public class CallbackHandler implements BaseHandler {

    private final PDPFoodBot bot;
    private final State state;
    private final DepartmentServiceImpl departmentService;
    private final InlineBoards inlineBoards;
    private final AuthServiceImpl authService;

    public CallbackHandler(PDPFoodBot bot, State state, DepartmentServiceImpl departmentService, InlineBoards inlineBoards, AuthServiceImpl authService) {
        this.bot = bot;
        this.state = state;
        this.departmentService = departmentService;
        this.inlineBoards = inlineBoards;
        this.authService = authService;
    }

    @Override
    public void process(Update update) {
        CallbackQuery callbackQuery = update.getCallbackQuery();
        Message message = callbackQuery.getMessage();
        long chatId = message.getChatId();
        String data = callbackQuery.getData();
        switch (data) {
            case "ru" -> sendMessageFullname(chatId,"ru");
            case "uz" -> sendMessageFullname(chatId,"uz");
            case "en" -> sendMessageFullname(chatId,"en");
        }
        List<DepartmentDto> departmentDtos = departmentService.getAll(new GenericCriteria());
        for (DepartmentDto departmentDto : departmentDtos) {
            if(departmentDto.getName().equals(data)){
                sendMessageToUser(chatId,message);
                sendMessageToHead(departmentDto.getHeaderChatId(),message);
            }
        }
        if(data.startsWith("yes")){
            String chatId1 = data.substring(3);
            SendMessage sendMessage = messageObj(Long.parseLong(chatId1), "Please send your fullName");
            sendMessage.setReplyMarkup(new ForceReplyKeyboard());
            bot.executeMessage(sendMessage);
            changeState(chatId, UserState.DEPARTMENT_ACCEPTED);
        }else if(data.startsWith("no ")){
            String chatId1=data.substring(3);
            SendMessage sendMessage = messageObj(Long.parseLong(chatId1), "You have not been granted access");
            bot.executeMessage(sendMessage);
        }
    }

    private void sendMessageFullname(long chatId, String lang){
        /*SendMessage sendMessage = messageObj(chatId, "Choose Department please ");
        sendMessage.setReplyMarkup(inlineBoards.departmentButtons());
        bot.executeMessage(new DeleteMessage("" + chatId, message.getMessageId()));
        bot.executeMessage(sendMessage);*/
        SendMessage sendMessage = messageObj(chatId, "Please send your fullName");
        sendMessage.setReplyMarkup(new ForceReplyKeyboard());
        bot.executeMessage(sendMessage);
        authCreateDto.setLanguage(lang);
        changeState(chatId, UserState.LANGUAGE_CHOSEN);
    }

    private void sendMessageToHead(long chatId, Message message) {;
        SendMessage sendMessage = messageObj(chatId,"Do you confirm this user "+message.getChat().getUserName()) ;
        sendMessage.setReplyMarkup(inlineBoards.forHeadButtons(message.getChatId()));
        bot.executeMessage(sendMessage);
    }

    private void sendMessageToUser(long chatId, Message message) {
        SendMessage sendMessage = messageObj(chatId, "Your information is being verified ...");
        bot.executeMessage(new DeleteMessage("" + chatId, message.getMessageId()));
        bot.executeMessage(sendMessage);
        changeState(chatId, UserState.DEPARTMENT_CHOSEN);
    }

    private void changeState(long chatID, UserState newState) {
        state.setState(chatID, newState);
    }

    private SendMessage messageObj(long chatID, String text) {
        return new SendMessage("" + chatID, text);
    }

}
