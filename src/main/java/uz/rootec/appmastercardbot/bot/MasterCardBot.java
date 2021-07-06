package uz.rootec.appmastercardbot.bot;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;
import uz.rootec.appmastercardbot.service.BotService;

import java.util.List;

/**
 * Created by Sherlock on 23.06.2021.
 */
@Component
public class MasterCardBot extends TelegramLongPollingBot {

    @Value("${bot.token}")
    private String botToken;

    @Value("${bot.username}")
    private String botUsername;

    @Autowired
    BotService botService;

    @SneakyThrows
    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage()){
            if (update.getMessage().hasText()){
                String text = update.getMessage().getText();
                if (text.equals("/start")){
                    botService.chooseLanguage(update);
                } else if (text.equals(BotContstant.UZBEK) || text.equals(BotContstant.RUSSIAN)){
                    botService.sendPolicy(update);
                } else if (text.equals(BotContstant.ACCEPT)){
//                    botService.
                }
            }
        }
    }

    @Override
    public String getBotUsername() {
        return botUsername;
    }

    @Override
    public String getBotToken() {
        return botToken;
    }
}
