package com.spring.ai.firstproject.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ollama")
public class ollamaController {


      private ChatClient chatClient;

              

            public ollamaController(ChatClient.Builder builder)
            {

                this.chatClient=builder.build();
            }

              
     @GetMapping("/chat")
            public ResponseEntity<String> chat(@RequestParam(value = "q",required = true) String w)
            {
                var resultresponse= chatClient.prompt(w).call().content();
                return ResponseEntity.ok(resultresponse);

            }
    
}
