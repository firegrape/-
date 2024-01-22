package com.bitc.plummarketdb.mapper;


import com.bitc.plummarketdb.DTO.userDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    int isUserInfo(String userId, String userPw) throws Exception;

    userDTO getUserInfo(String userId)throws Exception;

    userDTO selectList()throws Exception;
}
