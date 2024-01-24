package com.bitc.plummarketdb.service;


import com.bitc.plummarketdb.DTO.userDTO;
import com.bitc.plummarketdb.mapper.ChatMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatServiceImpl implements ChatService {
    @Autowired
    private ChatMapper chatMapper;

    @Override
    public List<userDTO> selectChatList(int idx) throws Exception {
        return chatMapper.selectChatList(idx);
    }

    @Override
    public void deleteChatList(userDTO user) throws Exception {
        chatMapper.deleteChatList(user);
    }
}
