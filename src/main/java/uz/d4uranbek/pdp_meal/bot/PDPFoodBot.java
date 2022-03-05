package uz.d4uranbek.pdp_meal.bot;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import uz.d4uranbek.pdp_meal.bot.handlers.UpdateHandler;

/**
 * Author : Qozoqboyev Ixtiyor
 * Time : 02.03.2022 15:25
 * Project : pdp_meal
 */
@Component
public class PDPFoodBot extends TelegramLongPollingBot {

    private final UpdateHandler handler;

    public PDPFoodBot(@Lazy UpdateHandler handler) {
        this.handler = handler;
    }

    public void run(){
        try {
            TelegramBotsApi api = new TelegramBotsApi(DefaultBotSession.class);
            api.registerBot(new PDPFoodBot(handler));
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpdateReceived(Update update) {
        handler.handle(update);
    }


    @Override
    public String getBotToken() {
        return "5127587569:AAHgKzAC0_ffnBdoq5fz49X2l41_Qkb8Mdo";
    }


    @Override
    public String getBotUsername() {
        return "@PDP_food_bot";
    }

    public void executePhoto(SendPhoto sendPhoto) {
        try {
            execute(sendPhoto);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public void executeMessage(BotApiMethod<?> message) {
        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }


}
