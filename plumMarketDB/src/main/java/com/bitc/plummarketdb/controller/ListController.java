package com.bitc.plummarketdb.controller;


import com.bitc.plummarketdb.service.ListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ListController {
    @Autowired
    private ListService listService;
}
