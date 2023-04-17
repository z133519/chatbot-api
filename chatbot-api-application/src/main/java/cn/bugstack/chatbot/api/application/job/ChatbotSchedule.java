package cn.bugstack.chatbot.api.application.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

public class ChatbotSchedule {
    private Logger logger = LoggerFactory.getLogger(ChatbotSchedule.class);
    @Value("${chatbot-api.groupId}")
    private String groupId;
    @Value("${chatbot-api.cookie}")
    private String cookie;
}
