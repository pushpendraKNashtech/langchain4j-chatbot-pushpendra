package com.pushpendra.langchain4j_chatbot.config;

import com.pushpendra.langchain4j_chatbot.service.ChatAssistant;
import com.pushpendra.langchain4j_chatbot.tools.EnterpriseTools;

import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.googleai.GoogleAiGeminiChatModel;
import dev.langchain4j.service.AiServices;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AiConfig {

    @Value("${gemini.api.key}")
    private String apiKey;

    @Bean
    public ChatModel chatModel() {

        return GoogleAiGeminiChatModel.builder()
                .apiKey(apiKey)
                .modelName("gemini-2.5-flash")
                .temperature(0.2)
                .maxOutputTokens(200)
                .build();
    }

    @Bean
    public ChatAssistant assistant(ChatModel chatModel) {

        return AiServices.builder(ChatAssistant.class)
                .chatModel(chatModel)
                .tools(new EnterpriseTools())
                .chatMemoryProvider(
                        memoryId ->
                                MessageWindowChatMemory.withMaxMessages(10))
                .build();
    }
}