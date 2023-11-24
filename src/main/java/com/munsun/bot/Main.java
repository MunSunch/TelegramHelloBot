package com.munsun.bot;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class Main {
    public static void main(String[] args) throws TelegramApiException {
        TelegramBotsApi api = new TelegramBotsApi(DefaultBotSession.class);
        var provider = new MyPortfolioProviderImpl();
            provider.appendNewProject(new Project("Сервис перевода с карты на карту",
                    "В данном проекте реализовал REST сервис на Spring boot для перевода с карты на карту, который взаимодействует с фронтенд приложением(Подробности по ссылке)." +
                            "\n" +
                            "Используемые технологии: Java17, Spring boot, Docker, Logback, JUnit, Mockito, Testcontainers, Lombok, ModelMapper.",
                    "https://github.com/MunSunch/Card2Card"));
            provider.appendNewProject(new Project("Интерпретор для языка SQL",
                    "В проекте представлен умный парсер запросов категории DML, написанных на SQL, в java код для выполнения операций с коллекциями.",
                    "https://github.com/MunSunch/MySQL_language"));
            provider.appendNewProject(new Project("Итоговый проект интенсива Digital Design",
                    "На примере разработки REST сервиса постигал spring-дзен под руководством ментора.",
                    "https://github.com/MunSunch/DigDes"));
            provider.appendNewProject(new Project("Интерпретатор математических выражений на C++",
                    "В проекте реализован глупый интерпретатор для вычисления бинарных операций, поддерживающих корректную последовательность вычислений со скобками.",
                    "https://github.com/MunSunch/Sorting-station-algorithmPublic"));
            provider.appendNewProject(new Project("Ролевая РПГ",
                    "Применяя принципы SOLID и DRY, а также шаблоны проектирования, разработал игру с своей атакующей системой и сюжетом.",
                    "https://github.com/MunSunch/GameForHeadsAndHands"));
            provider.appendNewProject(new Project("REST сервис на Spring Boot по работе с документацией ОАО \"РЖД\"",
                    "Помимо самого сервиса также разработал примитивного клиента на html, css, js, bootstrap.",
                    "https://github.com/MunSunch/NotificationService"));

        api.registerBot(new HelloBot(Constants.TELEGRAM_BOT_NAME.getDescription(),
                Constants.TELEGRAM_BOT_TOKEN.getDescription(),
                provider));
    }
}
