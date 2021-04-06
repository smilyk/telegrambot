package com.smilyk.telegrambot.bot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.lang.*;

/**
 * Telegrambot for Javarush Community from Javarush community.
 */
@Component
public class TelegramBot extends TelegramLongPollingBot {
    @Value("${bot.username}")
    private String username;

    @Value("${bot.token}")
    private String token;

//    здесь нужно добавить username нашего бота, к которому будем соединяться;
    @Override
    public String getBotUsername() {
        return username;
    }
//    токен бота.
    @Override
    public String getBotToken() {
        return token;
    }

//    точка входа, куда будут поступать сообщения от пользователей.
    @Override
    public void onUpdateReceived(Update update) {
//        Нужно, чтобы мы извлекли сообщение, которое пришло к боту,
//        и передали его обратно. Так мы будем знать, что бот работает.
        if(update.hasMessage() && update.getMessage().hasText()) {
            String message = update.getMessage().getText().trim();
            String chatId = update.getMessage().getChatId().toString();

            SendMessage sm = new SendMessage();
            sm.setChatId(chatId);
            sm.setText(message);

            try {
                execute(sm);
            } catch (TelegramApiException e) {
                //todo add logging to the project.
                e.printStackTrace();
            }
        }
    }
}
