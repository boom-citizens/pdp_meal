package uz.d4uranbek.pdp_meal.bot;

/**
 * Author : Qozoqboyev Ixtiyor
 * Time : 02.03.2022 15:21
 * Project : pdp_meal
 */

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import uz.d4uranbek.pdp_meal.bot.handlers.UpdateHandler;

@Component
public class TelegramBotConfigurer {

    public void run(){
        try {
            TelegramBotsApi api = new TelegramBotsApi(DefaultBotSession.class);
            api.registerBot(new PDPFoodBot());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
