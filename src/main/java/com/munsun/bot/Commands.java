package com.munsun.bot;

import java.util.Arrays;
import java.util.Optional;

public enum Commands {
    START("/start"),
    NEXT_PROJECT("/next"),
    PREV_PROJECT("/prev"),
    ALL_PROJECTS("/all"),
    CONTACTS("/contacts");

    private final String title;

    Commands(String title) {
        this.title = title;
    }

    public static Optional<Commands> getCommand(String nameCommand) {
        return Arrays.stream(Commands.values())
                .filter(x -> x.title.equals(nameCommand))
                .findFirst();
    }
}
