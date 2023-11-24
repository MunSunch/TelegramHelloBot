package com.munsun.bot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.Arrays;
import java.util.List;

public class HelloBot extends TelegramLongPollingBot {
    private String name;
    private MessageProvider provider;

    public HelloBot(String name, String token, MessageProvider provider) {
        super(token);
        this.name = name;
        this.provider = provider;
    }

    @Override
    public void onUpdateReceived(Update update) {
        var message = update.getMessage();
        var user = message.getFrom();
        System.out.println("Получение сообщения от " + user.getFirstName());
        String response = provider.getResponse(message);
        send(user.getId(), response);
    }

    public void send(Long userId, String message) {
        SendMessage sendMessage = SendMessage.builder()
                                            .chatId(userId)
                                            .text(message)
                                            .build();
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            System.out.println("Ошибка отправки: "+e.getMessage());
        }
    }

    @Override
    public String getBotUsername() {
        return name;
    }
}
