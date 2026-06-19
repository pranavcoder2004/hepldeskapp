package com.bel.helpdesk.conf;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AiConfig {
    private ChatClient chatClient;

    @Bean(name = "ollama")
    ChatClient getChatClient(OllamaChatModel chatModel, ChatMemory chatMemory){
        return ChatClient.builder(chatModel).build();
    }
}
