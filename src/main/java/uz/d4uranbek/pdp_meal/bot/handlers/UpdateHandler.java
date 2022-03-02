package uz.d4uranbek.pdp_meal.bot.handlers;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;

/**
 * Author : Qozoqboyev Ixtiyor
 * Time : 02.03.2022 19:04
 * Project : pdp_meal
 */
@Component
public class UpdateHandler {
    private final MessageHandler messageHandler;
    private final CallbackHandler callbackHandler;

    public UpdateHandler(MessageHandler messageHandler, CallbackHandler callbackHandler) {
        this.messageHandler = messageHandler;
        this.callbackHandler = callbackHandler;
    }

    public void handle(Update update) {
        if (update.hasMessage()) messageHandler.process(update);
        else if (update.hasCallbackQuery()) callbackHandler.process(update);
    }
}
