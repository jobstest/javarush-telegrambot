package com.github.jobstest.jrtb.service;

import com.github.jobstest.jrtb.bot.JavaRushTelegramBot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
@Service
public class SendBotMessageServiceImpl implements SendBotMessageService{

    private final JavaRushTelegramBot javarushBot;

    @Autowired
    public SendBotMessageServiceImpl(JavaRushTelegramBot javarushBot){
        this.javarushBot = javarushBot;
    }

    @Override
    public void sendMessage(String chatId, String messge){
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.enableHtml(true);
        sendMessage.setText(messge);

        try {
            javarushBot.execute(sendMessage);
        } catch (TelegramApiException e){
            e.printStackTrace();
        }
    }

}
