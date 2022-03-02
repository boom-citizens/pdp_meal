package uz.d4uranbek.pdp_meal.bot.handlers;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;
import uz.d4uranbek.pdp_meal.bot.processors.AuthorizationProcessor;
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

    }

    private boolean isAuthorized(long chatId) {
        return UserState.AUTHORIZED.equals(state.getState(chatId));
    }

    private void changeState(long chatID, UserState newState) {
        state.setState(chatID, newState);
    }



}
