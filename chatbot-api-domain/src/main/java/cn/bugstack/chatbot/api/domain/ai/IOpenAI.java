package cn.bugstack.chatbot.api.domain.ai;

import java.io.IOException;

/**
 * @author zxh
 * @description ChatGPT openai 接口
 */
public interface IOpenAI {

    String doChatGPT(String question) throws IOException;

}
