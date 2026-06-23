package com.bel.helpdesk.conf;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AiConfig {
    private ChatClient chatClient;

    @Bean(name = "ollama")
    ChatClient getChatClient(OllamaChatModel chatModel, ChatMemory chatMemory){
        MessageChatMemoryAdvisor ms = MessageChatMemoryAdvisor.builder(chatMemory).build();
        return ChatClient.builder(chatModel).defaultAdvisors(ms).defaultSystem("summarize every thing in 400 words").defaultAdvisors(new SimpleLoggerAdvisor()).build();
    }
}
