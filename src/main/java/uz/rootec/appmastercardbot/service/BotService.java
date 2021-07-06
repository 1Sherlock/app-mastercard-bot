package uz.rootec.appmastercardbot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import uz.rootec.appmastercardbot.bot.BotContstant;
import uz.rootec.appmastercardbot.bot.MasterCardBot;

/**
 * Created by Sherlock on 24.06.2021.
 */
@Service
public class BotService {
    @Autowired
    MasterCardBot masterCardBot;
    @Autowired
    ButtonService buttonService;

    public void chooseLanguage(Update update) throws TelegramApiException {
        SendMessage sendMessage =new SendMessage();
        sendMessage.setChatId(update.getMessage().getChatId());
        sendMessage.setText(BotContstant.CHOOSELANGUAGEUZ + "\n\n" + BotContstant.CHOOSELANGUAGERU);
        sendMessage.setReplyMarkup(buttonService.languageButton());
        masterCardBot.execute(sendMessage);
    }

    public void sendPolicy(Update update) throws TelegramApiException {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(update.getMessage().getChatId());
        sendMessage.setText(BotContstant.POLICY);
        sendMessage.setReplyMarkup(buttonService.accept());
        masterCardBot.execute(sendMessage);
    }
}
