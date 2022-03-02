package uz.d4uranbek.pdp_meal.bot;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

/**
 * Author : Qozoqboyev Ixtiyor
 * Time : 02.03.2022 15:25
 * Project : pdp_meal
 */
@Component
public class PDPFoodBot extends TelegramLongPollingBot {

    @Override
    public void onUpdateReceived(Update update) {

    }


    @Override
    public String getBotToken() {
        return "5127587569:AAHgKzAC0_ffnBdoq5fz49X2l41_Qkb8Mdo";
    }


    @Override
    public String getBotUsername() {
        return "@PDP_food_bot";
    }
}
