package com.munsun.bot;

import org.telegram.telegrambots.meta.api.objects.Message;

public interface MessageProvider {
    String getResponse(Message message);
}
