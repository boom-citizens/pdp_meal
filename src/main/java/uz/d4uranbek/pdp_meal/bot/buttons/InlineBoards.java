package uz.d4uranbek.pdp_meal.bot.buttons;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import uz.d4uranbek.pdp_meal.criteria.GenericCriteria;
import uz.d4uranbek.pdp_meal.dto.department.DepartmentDto;
import uz.d4uranbek.pdp_meal.service.department.DepartmentServiceImpl;
import uz.d4uranbek.pdp_meal.utils.Emojis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author : Qozoqboyev Ixtiyor
 * Time : 02.03.2022 21:00
 * Project : pdp_meal
 */
@Component
public class InlineBoards {
    private static final InlineKeyboardMarkup board = new InlineKeyboardMarkup();
    private final DepartmentServiceImpl departmentService;

    public InlineBoards(DepartmentServiceImpl departmentService) {
        this.departmentService = departmentService;
    }

    public InlineKeyboardMarkup languageButtons() {
        InlineKeyboardButton uz = new InlineKeyboardButton(Emojis.UZ + " Uzbek");
        uz.setCallbackData("uz");

        InlineKeyboardButton ru = new InlineKeyboardButton(Emojis.RU + " Uzbek");
        ru.setCallbackData("ru");

        InlineKeyboardButton en = new InlineKeyboardButton(Emojis.EN + " Uzbek");
        en.setCallbackData("en");

        board.setKeyboard(Arrays.asList(List.of(uz), List.of(ru), List.of(en)));
        return board;
    }

    public InlineKeyboardMarkup departmentButtons() {
        List<DepartmentDto> departmentDtos = departmentService.getAll(new GenericCriteria());
        List<List<InlineKeyboardButton>> lists = new ArrayList<>();

        for (DepartmentDto departmentDto : departmentDtos) {
            InlineKeyboardButton inlineKeyboardButton = new InlineKeyboardButton(departmentDto.getName());
            inlineKeyboardButton.setCallbackData(departmentDto.getName());
            lists.add(List.of(inlineKeyboardButton));
        }

      /*  InlineKeyboardButton mentors = new InlineKeyboardButton("Mentors D");
        mentors.setCallbackData("mentors");

        InlineKeyboardButton economic = new InlineKeyboardButton("Economic D");
        economic.setCallbackData("economic");

        InlineKeyboardButton sales = new InlineKeyboardButton("Sales D");
        sales.setCallbackData("sales");
*/
        board.setKeyboard(lists);
        return board;
    }

    public ReplyKeyboard forHeadButtons(Long chatId) {
        InlineKeyboardButton yes = new InlineKeyboardButton("Yes");
        yes.setCallbackData("yes"+chatId);

        InlineKeyboardButton no = new InlineKeyboardButton("No");
        no.setCallbackData("no "+chatId);

        board.setKeyboard(List.of(List.of(yes, no)));
        return board;
    }
}
