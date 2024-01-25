package com.bitc.plummarketdb.DTO;

import lombok.Data;

@Data
public class userDTO {
    private String userIdx;
    private String userId;
    private String userPw;
    private String userNick;
    private String userEmail;
    private String userAdress;
    private String userPhoneNum;
    private String userDeletedYn;
    private String userFavlist;
    private int userRating;
    private int sendIdx;
    private int receiveIdx;
    private String userProfile;
    private String userComment;
    private String listCount;
}
