package uz.d4uranbek.pdp_meal.bot.processors;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;
import uz.d4uranbek.pdp_meal.bot.PDPFoodBot;
import uz.d4uranbek.pdp_meal.bot.state.UserState;

/**
 * Author : Qozoqboyev Ixtiyor
 * Time : 02.03.2022 23:31
 * Project : pdp_meal
 */
@Component
public class MainProcessor {

    private final PDPFoodBot bot;

    public MainProcessor(PDPFoodBot bot) {
        this.bot = bot;
    }


    public static void process(Update update, UserState state) {
        Message message = update.getMessage();
        long chatId =message.getChatId();
        User user = message.getFrom();

        if(UserState.OVQAT_ZAKAZ.equals(state)){
            //mealList();
        }

    }
}
