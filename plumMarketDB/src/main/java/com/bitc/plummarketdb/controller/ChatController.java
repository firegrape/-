package com.bitc.plummarketdb.controller;

import com.bitc.plummarketdb.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {
    @Autowired
    private ChatService chatService;
}