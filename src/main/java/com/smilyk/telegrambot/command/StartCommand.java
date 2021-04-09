package com.smilyk.telegrambot.command;
import com.smilyk.telegrambot.entity.TelegramUser;
import com.smilyk.telegrambot.services.SendBotMessageService;
import com.smilyk.telegrambot.services.TelegramUserService;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.Optional;

public class StartCommand implements Command {

    private final SendBotMessageService sendBotMessageService;
    private final TelegramUserService telegramUserService;

    public final static String START_MESSAGE = "Привет. Я Javarush Telegram Bot. Я помогу тебе быть в курсе последних " +
        "статей тех авторов, котрые тебе интересны. Я еще маленький и только учусь.";

    public StartCommand(SendBotMessageService sendBotMessageService, TelegramUserService telegramUserService) {
        this.sendBotMessageService = sendBotMessageService;
        this.telegramUserService = telegramUserService;
    }

    @Override
    public void execute(Update update) {
        String chatId = update.getMessage().getChatId().toString();

        telegramUserService.findByChatId(chatId).ifPresentOrElse(
            user -> {
                user.setActive(true);
                telegramUserService.save(user);
            },
            () -> {
                TelegramUser telegramUser = new TelegramUser();
                telegramUser.setActive(true);
                telegramUser.setChatId(chatId);
                telegramUserService.save(telegramUser);
            });

        sendBotMessageService.sendMessage(chatId, START_MESSAGE);
    }
}
