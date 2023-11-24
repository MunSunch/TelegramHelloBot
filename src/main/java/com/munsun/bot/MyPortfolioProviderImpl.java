package com.munsun.bot;

import org.telegram.telegrambots.meta.api.objects.Message;

import java.util.stream.Collectors;

public class MyPortfolioProviderImpl extends MyPortfolioProviderAbstract implements MessageProvider{
    @Override
    public String getResponse(Message message) {
        Commands command = Commands.getCommand(message.getText())
                .orElseThrow(NullPointerException::new);
        System.out.println("Поступила команда "+command.name());
        String result;
        switch (command) {
            case START -> result = getStartResponse();
            case NEXT_PROJECT -> result = getNextProjectResponse();
            case PREV_PROJECT -> result = getPrevProjectResponse();
            case ALL_PROJECTS -> result = getProjectsResponse();
            case CONTACTS -> result = getContactsResponse();
            default -> result = getUnknownCommandResponse();
        }
        return result;
    }

    private String getContactsResponse() {
        System.out.println("Получение контактов...");
        return Constants.CONTACTS_MESSAGE.getDescription();
    }

    private String getPrevProjectResponse() {
        System.out.println("Получение следующего проекта...");
        return getPrevProject().toString();
    }

    private String getNextProjectResponse() {
        System.out.println("Получение предыдущего проекта...");
        return getNextProject().toString();
    }

    private String getProjectsResponse() {
        System.out.println("Получение всех проектов...");
        String clrf = "\n";
        return getProjects().stream()
                .map(Object::toString)
                .collect(Collectors.joining(clrf));
    }

    private String getUnknownCommandResponse() {
        System.out.println("Неизвестная команда...");
        return Constants.UNKNOWN_COMMAND.getDescription();
    }

    private String getStartResponse() {
        System.out.println("Приветствие...");
        return Constants.START_MESSAGE.getDescription();
    }
}
