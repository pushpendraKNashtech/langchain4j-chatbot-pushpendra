package com.pushpendra.langchain4j_chatbot.service;

import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;

public interface ChatAssistant {

    @SystemMessage("""
        You are an Enterprise AI Assistant.

        You can:
        - Provide employee information
        - Provide product information
        - Check leave balances
        - Provide React interview questions
        - Show current date and time

        Always use tools when relevant.

        Be concise, professional and helpful.
        """)
    String chat(
            @MemoryId String sessionId,
            @UserMessage String userMessage
    );
}