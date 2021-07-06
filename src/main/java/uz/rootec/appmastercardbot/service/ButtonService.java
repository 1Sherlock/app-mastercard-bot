package uz.rootec.appmastercardbot.service;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import uz.rootec.appmastercardbot.bot.BotContstant;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sherlock on 24.06.2021.
 */
@Service
public class ButtonService {
    public ReplyKeyboardMarkup languageButton() {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setSelective(true);
        List<KeyboardRow> rows = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();
        KeyboardButton button = new KeyboardButton();
        button.setText(BotContstant.UZBEK);
        KeyboardButton button1 = new KeyboardButton();
        button1.setText(BotContstant.RUSSIAN);

        row.add(button);
        row.add(button1);
        rows.add(row);

        return replyKeyboardMarkup.setKeyboard(rows);
    }

    public ReplyKeyboard accept() {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setSelective(true);
        List<KeyboardRow> rows = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();
        KeyboardButton button = new KeyboardButton();
        button.setText(BotContstant.ACCEPT);
        row.add(button);
        rows.add(row);
        return replyKeyboardMarkup.setKeyboard(rows);
    }
}
