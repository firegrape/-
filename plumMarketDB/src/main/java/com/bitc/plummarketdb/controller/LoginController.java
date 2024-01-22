package com.bitc.plummarketdb.controller;

import com.bitc.plummarketdb.DTO.userDTO;
import com.bitc.plummarketdb.service.UserService;
import jakarta.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("")
public class LoginController {
    @Autowired
    private UserService userService;

    @RequestMapping(value= "/LoginChk", method = {RequestMethod.POST})
    @ResponseBody
    public String androidPage(HttpServletRequest request, Model model) {

        try{
            String androidID = request.getParameter("id");
            String androidPW = request.getParameter("pw");
            System.out.println("안드로이드에서 받아온 id : " + androidID);
            System.out.println("안드로이드에서 받아온 pw : " + androidPW);


            int userChk = userService.isUserInfo(androidID, androidPW);
            if(userChk == 1) {

                JSONObject data = new JSONObject();
                userDTO user = userService.getUserInfo(androidID);

                data.put("user_idx", user.getUserIdx());
                data.put("user_id", user.getUserId());
                data.put("user_pw",user.getUserPw());
                data.put("user_nick",user.getUserNick());
                data.put("user_email",user.getUserEmail());
                data.put("user_address",user.getUserAdress());
                data.put("user_phone_num",user.getUserPhoneNum());
                data.put("delete",user.getUserDeletedYn());
                data.put("favlist",user.getUserFavlist());
                data.put("rating",user.getUserRating());

                return data.toString();
            }else{

                return null;
            }

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }


    @GetMapping("/rest")
    @ResponseBody
    public String findAllMember() throws Exception {


        userDTO user = userService.selectList();


        JSONObject member = new JSONObject();

        member.put("id", user.getUserId());
        member.put("pw",user.getUserPw());


        return member.toString();
    }



}