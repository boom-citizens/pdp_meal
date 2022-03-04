package uz.d4uranbek.pdp_meal.bot.buttons;

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
        row1.add(new KeyboardButton("Ovqat zakaz"));
        row1.add(new KeyboardButton("Zakaz atmen"));

        KeyboardRow row2 = new KeyboardRow();
        row2.add(new KeyboardButton("Zakaz update"));
        row2.add(new KeyboardButton("Add name"));

        KeyboardRow row3 = new KeyboardRow();
        row3.add(new KeyboardButton("settings"));

        board.setKeyboard(List.of(row1, row2, row3));
        board.setResizeKeyboard(true);
        board.setSelective(true);
        return board;
    }

    public static ReplyKeyboard adminMainMenu() {
        KeyboardRow row1 = new KeyboardRow();
        row1.add(new KeyboardButton("Users"));
        row1.add(new KeyboardButton("My zakazs"));

        KeyboardRow row2 = new KeyboardRow();
        row2.add(new KeyboardButton("settings"));

        board.setKeyboard(List.of(row1, row2));
        board.setResizeKeyboard(true);
        board.setSelective(true);
        return board;
    }

    public static ReplyKeyboard headDepartmentMainMenu() {
        KeyboardRow row1 = new KeyboardRow();
        row1.add(new KeyboardButton("Accept users"));
        row1.add(new KeyboardButton("My zakazs"));

        KeyboardRow row2 = new KeyboardRow();
        row2.add(new KeyboardButton("settings"));

        board.setKeyboard(List.of(row1, row2));
        board.setResizeKeyboard(true);
        board.setSelective(true);
        return board;
    }

    public static ReplyKeyboard deliverMainMenu() {
        KeyboardRow row1 = new KeyboardRow();
        row1.add(new KeyboardButton("Today zakaz"));
        row1.add(new KeyboardButton("Add meal"));

        KeyboardRow row2 = new KeyboardRow();
        row2.add(new KeyboardButton("Meal update"));
        row2.add(new KeyboardButton("settings"));

        board.setKeyboard(List.of(row1, row2));
        board.setResizeKeyboard(true);
        board.setSelective(true);
        return board;
    }
}
