package com.bel.helpdesk.service;

import com.bel.helpdesk.tool.DataBaseTool;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

@Service
public class AiService {

    @Autowired
    ChatClient chatClient;

    @Value("classpath:/system-prompt.st")
    Resource resource;





    public String getResponseFromAssistant(String query,String userId){
       return chatClient.prompt().tools(new DataBaseTool()).user(query).system(resource).advisors(u-> u.param(ChatMemory.CONVERSATION_ID,userId)).call().chatResponse().getResult().getOutput().getText();
    }

}
