package uz.d4uranbek.pdp_meal.bot.handlers;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Update;
import uz.d4uranbek.pdp_meal.bot.buttons.MarkupBoards;
import uz.d4uranbek.pdp_meal.bot.processors.AuthorizationProcessor;

import uz.d4uranbek.pdp_meal.bot.processors.MainProcessor;
import uz.d4uranbek.pdp_meal.bot.state.State;
import uz.d4uranbek.pdp_meal.bot.state.UserState;
import uz.d4uranbek.pdp_meal.entity.auth.User;

import java.io.File;

/**
 * Author : Qozoqboyev Ixtiyor
 * Time : 02.03.2022 19:04
 * Project : pdp_meal
 */
@Component
public class MessageHandler implements BaseHandler {

    private final AuthorizationProcessor authorizationProcessor;
    private final MainProcessor mainProcessor;
    private final State state;

    public MessageHandler(AuthorizationProcessor authorizationProcessor, MainProcessor mainProcessor, State state) {
        this.authorizationProcessor = authorizationProcessor;
        this.mainProcessor = mainProcessor;
        this.state = state;
    }

    @Override
    public void process(Update update) {
        long chatId = update.getMessage().getChatId();

        if (!isAuthorized(chatId)){
            authorizationProcessor.process(update,state.getState(chatId));
        }

        //getUsersByChatId(""+chatId);
        User user=new User();

        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(""+chatId);
        if (user.getRole().getCode().equals("ADMIN")) {
            sendPhoto.setReplyMarkup(MarkupBoards.adminMainMenu());
            sendPhoto.setPhoto(new InputFile(new File("src/main/resources/statics/contentManager.jpg")));
        }else  if (user.getRole().getCode().equals("DELIVER")) {
            sendPhoto.setReplyMarkup(MarkupBoards.deliverMainMenu());
            sendPhoto.setPhoto(new InputFile(new File("src/main/resources/statics/headDepartment.jpg")));
        }


        if(update.getMessage().hasText()){
            String text=update.getMessage().getText();
            if(text.equals("Order meal")){
                changeState(chatId,UserState.ORDER_MEAL);
            }else if(text.equals("Cancel order")){
                changeState(chatId,UserState.CANCEL_ORDER);
            }else if(text.equals("Update order")){
                changeState(chatId,UserState.UPDATE_ORDER);
            }else if(text.equals("Write Comment")){
                changeState(chatId,UserState.WRITE_COMMENT);
            }else if(text.equals("Settings")){
                changeState(chatId,UserState.SETTINGS);
            }else if(text.equals("Users")){
                changeState(chatId,UserState.USERS);
            }else if(text.equals("My orders")){
                changeState(chatId,UserState.MY_ORDERS);
            }else if(text.equals("Today orders")){
                changeState(chatId,UserState.TODAY_ORDERS);
            }else if(text.equals("Add meals")){
                changeState(chatId,UserState.ADD_MEALS);
            }else if(text.equals("Update meals")){
                changeState(chatId,UserState.UPDATE_MEALS);
            }
            mainProcessor.process(update,state.getState(chatId));
        }
    }


    private boolean isAuthorized(long chatId) {
        return UserState.AUTHORIZED.equals(state.getState(chatId));
    }

    private void changeState(long chatID, UserState newState) {
        state.setState(chatID, newState);
    }


}
