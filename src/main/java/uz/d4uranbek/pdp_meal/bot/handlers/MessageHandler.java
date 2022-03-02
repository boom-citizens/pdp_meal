package uz.d4uranbek.pdp_meal.bot.handlers;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;
import uz.d4uranbek.pdp_meal.bot.state.State;

/**
 * Author : Qozoqboyev Ixtiyor
 * Time : 02.03.2022 19:04
 * Project : pdp_meal
 */
@Component
public class MessageHandler implements BaseHandler{


    private final State state;

    public MessageHandler(State state) {
        this.state = state;
    }

    @Override
    public void process(Update update) {

    }


}
