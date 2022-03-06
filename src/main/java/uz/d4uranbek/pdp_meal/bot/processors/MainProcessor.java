package uz.d4uranbek.pdp_meal.bot.processors;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;
import uz.d4uranbek.pdp_meal.bot.PDPFoodBot;
import uz.d4uranbek.pdp_meal.bot.state.State;
import uz.d4uranbek.pdp_meal.bot.state.UserState;
import uz.d4uranbek.pdp_meal.dto.meal.MealDto;
import uz.d4uranbek.pdp_meal.service.meal.MealServiceImpl;

import java.time.LocalDate;
import java.util.List;

/**
 * Author : Qozoqboyev Ixtiyor
 * Time : 02.03.2022 23:31
 * Project : pdp_meal
 */
@Component
public class MainProcessor {

    private final State state;
    private final PDPFoodBot bot;
    private final MealServiceImpl mealService;

    public MainProcessor(State state, PDPFoodBot bot, MealServiceImpl mealService) {
        this.state = state;
        this.bot = bot;
        this.mealService = mealService;
    }


    public void process(Update update, UserState state) {
        Message message = update.getMessage();
        long chatId =message.getChatId();
        User user = message.getFrom();

        if(UserState.ORDER_MEAL.equals(state)){
            List<MealDto> mealDtos = mealService.getAllByDate(LocalDate.now().toString());
            SendMessage sendMessage=messageObj(chatId,getDataMeals(mealDtos));
            bot.executeMessage(sendMessage);
        }

    }

    private String getDataMeals(List<MealDto> mealDtos) {
        StringBuilder stringBuilder = new StringBuilder("");
        int i = 1;
        for (MealDto mealDto : mealDtos) {
            stringBuilder.append(String.format("%s. %s \n", i++, mealDto.getName()));
        }
        return stringBuilder.toString();
    }


    private void changeState(long chatID, UserState newState) {
        state.setState(chatID, newState);
    }

    private SendMessage messageObj(long chatID, String text) {
        return new SendMessage(String.valueOf(chatID), text);
    }

}
