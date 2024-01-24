package com.bitc.plummarketdb.service;


import com.bitc.plummarketdb.DTO.userDTO;

public interface UserService {
    int isUserInfo(String userId, String userPw)throws Exception;

    userDTO getUserInfo(String userId)throws Exception;

    void insertUser(userDTO user)throws Exception;

    void UploadProFile(userDTO user)throws Exception;
}
