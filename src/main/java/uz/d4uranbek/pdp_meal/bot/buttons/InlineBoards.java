package uz.d4uranbek.pdp_meal.bot.buttons;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import uz.d4uranbek.pdp_meal.utils.Emojis;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

/**
 * Author : Qozoqboyev Ixtiyor
 * Time : 02.03.2022 21:00
 * Project : pdp_meal
 */
public class InlineBoards {
    private static final InlineKeyboardMarkup board=new InlineKeyboardMarkup();

    public static InlineKeyboardMarkup languageButtons(){
        InlineKeyboardButton uz=new InlineKeyboardButton(Emojis.UZ+" Uzbek");
        uz.setCallbackData("uz");

        InlineKeyboardButton ru=new InlineKeyboardButton(Emojis.RU+" Uzbek");
        ru.setCallbackData("ru");

        InlineKeyboardButton en = new InlineKeyboardButton(Emojis.EN + " Uzbek");
        en.setCallbackData("en");

        board.setKeyboard(Arrays.asList(List.of(uz),List.of(ru),List.of(en)));
        return board;
    }
}
