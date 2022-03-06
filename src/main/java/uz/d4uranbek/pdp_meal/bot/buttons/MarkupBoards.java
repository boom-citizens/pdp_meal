package uz.d4uranbek.pdp_meal.bot.buttons;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import uz.d4uranbek.pdp_meal.utils.Emojis;

import java.util.List;

/**
 * Author : Qozoqboyev Ixtiyor
 * Time : 02.03.2022 21:00
 * Project : pdp_meal
 */
@Component
public class MarkupBoards {
    private static final ReplyKeyboardMarkup board = new ReplyKeyboardMarkup();

    public static ReplyKeyboard sharePhoneNumber() {
        KeyboardButton phoneContact = new KeyboardButton(Emojis.PHONE + "Share Phone Number");
        phoneContact.setRequestContact(true);
        board.setResizeKeyboard(true);
        board.setSelective(true);
        KeyboardRow row = new KeyboardRow();
        row.add(phoneContact);
        board.setKeyboard(List.of(row));
        return board;
    }

    public static ReplyKeyboard mainMenu() {
        KeyboardRow row1 = new KeyboardRow();
        row1.add(new KeyboardButton("Order meal"));
        row1.add(new KeyboardButton("Cancel order"));

        KeyboardRow row2 = new KeyboardRow();
        row2.add(new KeyboardButton("Update order"));
        row2.add(new KeyboardButton("Write comment"));

        KeyboardRow row3 = new KeyboardRow();
        row3.add(new KeyboardButton("Settings"));

        board.setKeyboard(List.of(row1, row2, row3));
        board.setResizeKeyboard(true);
        board.setSelective(true);
        return board;
    }

    public static ReplyKeyboard adminMainMenu() {
        KeyboardRow row1 = new KeyboardRow();
        row1.add(new KeyboardButton("Users"));
        row1.add(new KeyboardButton("My orders"));

        KeyboardRow row2 = new KeyboardRow();
        row2.add(new KeyboardButton("Settings"));

        board.setKeyboard(List.of(row1, row2));
        board.setResizeKeyboard(true);
        board.setSelective(true);
        return board;
    }

    public static ReplyKeyboard deliverMainMenu() {
        KeyboardRow row1 = new KeyboardRow();
        row1.add(new KeyboardButton("Today orders"));
        row1.add(new KeyboardButton("Add meals"));

        KeyboardRow row2 = new KeyboardRow();
        row2.add(new KeyboardButton("Update meals"));
        row2.add(new KeyboardButton("settings"));

        board.setKeyboard(List.of(row1, row2));
        board.setResizeKeyboard(true);
        board.setSelective(true);
        return board;
    }
}
