package com.bitc.plummarketdb.controller;


import com.bitc.plummarketdb.DTO.ListDTO;
import com.bitc.plummarketdb.DTO.userDTO;
import com.bitc.plummarketdb.service.ListService;
import com.bitc.plummarketdb.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class ListController {
    @Autowired
    private ListService listService;
    @Autowired
    private UserService userService;

    @PostMapping("/countHit")
    @ResponseBody
    public void updateSellReservation(HttpServletRequest request)throws Exception {

        String idx = request.getParameter("idx");

        listService.updateHit(idx);


    }

    @PostMapping("/userInfo")
    @ResponseBody
    public String userSelect(HttpServletRequest request)throws Exception{
        String nick = request.getParameter("nick");

        JSONObject data = new JSONObject();
        userDTO user = userService.getUserInfo(nick);

        data.put("userIdx", user.getUserIdx());
        data.put("userId", user.getUserId());
        data.put("userPw", user.getUserPw());
        data.put("userNick", user.getUserNick());
        data.put("userEmail", user.getUserEmail());
        data.put("userAddress", user.getUserAdress());
        data.put("userPhone_num", user.getUserPhoneNum());
        data.put("delete", user.getUserDeletedYn());
        data.put("favlist", user.getUserFavlist());
        data.put("userRating", user.getUserRating());
        data.put("user_profile",user.getUserProfile());
        data.put("userComment",user.getUserComment());
        data.put("listCount",user.getListCount());

       return data.toString();
    }

    @PostMapping("/mRating")
    @ResponseBody
    public void minusRating(HttpServletRequest request)throws Exception{
        String nick = request.getParameter("nick");
       userService.MinusRating(nick);

    }

    @PostMapping("/pRating")
    @ResponseBody
    public void PlusRating(HttpServletRequest request)throws Exception{
        String nick = request.getParameter("nick");
        userService.PlusRating(nick);

    }

}
