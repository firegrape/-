package com.bitc.plummarketdb.mapper;

import com.bitc.plummarketdb.DTO.userDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ChatMapper {
    List<userDTO> selectChatList(int idx)throws Exception;

    void deleteChatList(userDTO user)throws Exception;
}
