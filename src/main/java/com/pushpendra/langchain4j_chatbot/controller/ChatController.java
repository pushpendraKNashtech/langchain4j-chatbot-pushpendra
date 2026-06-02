package com.pushpendra.langchain4j_chatbot.controller;

import com.pushpendra.langchain4j_chatbot.service.ChatAssistant;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/chat")
public class ChatController {

    private final ChatAssistant assistant;

    public ChatController(ChatAssistant assistant) {
        this.assistant = assistant;
    }

    @GetMapping
    public String test() {
        return "Chat endpoint working";
    }

    @PostMapping
    public String chat(@RequestBody ChatRequest request) {

        if (request.getMessage() == null ||
            request.getMessage().trim().isEmpty()) {

            return "Please enter a valid message.";
        }

        try {
            return assistant.chat(
        "session-1",
        request.getMessage()
);
        } catch (Exception ex) {
            return "AI service is temporarily unavailable.";
        }
    }
}