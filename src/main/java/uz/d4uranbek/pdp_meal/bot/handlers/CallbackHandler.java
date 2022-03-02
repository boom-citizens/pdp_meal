package uz.d4uranbek.pdp_meal.bot.handlers;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.DeleteMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ForceReplyKeyboard;
import uz.d4uranbek.pdp_meal.bot.PDPFoodBot;
import uz.d4uranbek.pdp_meal.bot.state.State;
import uz.d4uranbek.pdp_meal.bot.state.UserState;

/**
 * Author : Qozoqboyev Ixtiyor
 * Time : 02.03.2022 19:04
 * Project : pdp_meal
 */
@Component
public class CallbackHandler implements BaseHandler {

    private final PDPFoodBot bot;
    private final State state;

    public CallbackHandler(PDPFoodBot bot, State state) {
        this.bot = bot;
        this.state = state;
    }

    @Override
    public void process(Update update) {
        CallbackQuery callbackQuery = update.getCallbackQuery();
        Message message = callbackQuery.getMessage();
        long chatId = message.getChatId();
        String data = callbackQuery.getData();
        switch (data) {
            case "ru", "uz", "en" -> {
                SendMessage sendMessage = messageObj(chatId, "Please send your fullName");
                sendMessage.setReplyMarkup(new ForceReplyKeyboard());
                bot.executeMessage(new DeleteMessage("" + chatId, message.getMessageId()));
                bot.executeMessage(sendMessage);
                changeState(chatId,UserState.LANGUAGE_CHOSEN);
            }
            case "mentors", "economic", "sales" -> {
                SendMessage sendMessage = messageObj(chatId, "Your information is being verified");
                bot.executeMessage(new DeleteMessage("" + chatId, message.getMessageId()));
                bot.executeMessage(sendMessage);
                changeState(chatId,UserState.DEPARTMENT_CHOSEN);
            }
        }
    }

    private void changeState(long chatID, UserState newState) {
        state.setState(chatID, newState);
    }

    private SendMessage messageObj(long chatID, String text) {
        return new SendMessage("" + chatID, text);
    }

}
