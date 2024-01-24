package com.bitc.plummarketdb.controller;

import com.bitc.plummarketdb.DTO.userDTO;
import com.bitc.plummarketdb.service.ChatService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ChatController {
    @Autowired
    private ChatService chatService;

    @RequestMapping(value = "/chatList", method = {RequestMethod.POST})
    @ResponseBody
    public String androidInsertList(HttpServletRequest request, Model model) throws Exception {

        String idx = request.getParameter("user_idx");
        int idx1 = Integer.parseInt(idx);

        List<userDTO> chatList = chatService.selectChatList(idx1);
        JSONArray jsonArray = new JSONArray();

        for(userDTO item : chatList){
            JSONObject data = new JSONObject();
            data.put("user_idx", item.getUserIdx());
            data.put("user_nick",item.getUserNick());
            data.put("send_idx",item.getSendIdx());
            data.put("receive_idx",item.getReceiveIdx());
            jsonArray.put(data);
        }

        return jsonArray.toString();
    }

    @RequestMapping(value = "/deleteList", method = {RequestMethod.POST})
    @ResponseBody
    public void androidDeleteChat(HttpServletRequest request, Model model) throws Exception {
        String idx = request.getParameter("idx");
        String reIdx = request.getParameter("reIdx");
        int idx1 = Integer.parseInt(idx);
        int idx2 = Integer.parseInt(reIdx);

        userDTO user = new userDTO();

        user.setSendIdx(idx1);
        user.setReceiveIdx(idx2);

        chatService.deleteChatList(user);
    }
}