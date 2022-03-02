package uz.d4uranbek.pdp_meal.bot.handlers;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;
import uz.d4uranbek.pdp_meal.bot.processors.AuthorizationProcessor;
import uz.d4uranbek.pdp_meal.bot.processors.MainProcessor;
import uz.d4uranbek.pdp_meal.bot.state.State;
import uz.d4uranbek.pdp_meal.bot.state.UserState;

/**
 * Author : Qozoqboyev Ixtiyor
 * Time : 02.03.2022 19:04
 * Project : pdp_meal
 */
@Component
public class MessageHandler implements BaseHandler {

    private final AuthorizationProcessor authorizationProcessor;
    private final State state;

    public MessageHandler(AuthorizationProcessor authorizationProcessor, State state) {
        this.authorizationProcessor = authorizationProcessor;
        this.state = state;
    }

    @Override
    public void process(Update update) {
        long chatId = update.getMessage().getChatId();
        if (!isAuthorized(chatId)){
            authorizationProcessor.process(update,state.getState(chatId));
        }

        if(update.getMessage().hasText()){
            String text=update.getMessage().getText();
            if(text.equals("Ovqat zakaz")){
                changeState(chatId,UserState.OVQAT_ZAKAZ);
            }else if(text.equals("Zakaz atmen")){
                changeState(chatId,UserState.ZAKAZ_ATMEN);
            }else if(text.equals("Zakaz update")){
                changeState(chatId,UserState.ZAKAZ_UPDATE);
            }else if(text.equals("Add name")){
                changeState(chatId,UserState.ADD_NAME);
            }else if(text.equals("Settings")){
                changeState(chatId,UserState.SETTINGS);
            }
        }
        MainProcessor.process(update,state.getState(chatId));
    }


    private boolean isAuthorized(long chatId) {
        return UserState.AUTHORIZED.equals(state.getState(chatId));
    }

    private void changeState(long chatID, UserState newState) {
        state.setState(chatID, newState);
    }


}
