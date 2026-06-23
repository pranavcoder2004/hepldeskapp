package com.bel.helpdesk.controller;

import com.bel.helpdesk.service.AiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ai")
public class AiController {
    @Autowired
    AiService aiService;


    @PostMapping
    public ResponseEntity<String>getResponse(@RequestParam(name = "q") String query,@RequestHeader String userId){
        return new ResponseEntity(aiService.getResponseFromAssistant(query,userId), HttpStatusCode.valueOf(200));
    }
}
