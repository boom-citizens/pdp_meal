package uz.d4uranbek.pdp_meal.bot.handlers;

import org.telegram.telegrambots.meta.api.objects.Update;

/**
 * Author : Qozoqboyev Ixtiyor
 * Time : 02.03.2022 18:59
 * Project : pdp_meal
 */
public interface BaseHandler {
    void process(Update update);
}
