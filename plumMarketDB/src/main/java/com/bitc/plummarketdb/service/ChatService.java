package com.bitc.plummarketdb.service;

import com.bitc.plummarketdb.DTO.userDTO;

import java.util.List;

public interface ChatService {
    List<userDTO> selectChatList(int idx)throws Exception;

    void deleteChatList(userDTO user)throws Exception;
}
