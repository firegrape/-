package com.bitc.plummarketdb.controller;


import com.bitc.plummarketdb.DTO.ListDTO;
import com.bitc.plummarketdb.service.WriteService;
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
@RequestMapping("")
public class WriteController {
    @Autowired
    private WriteService writeService;

    @RequestMapping(value = "/insertList", method = {RequestMethod.POST})
    @ResponseBody
    public void androidInsertList(HttpServletRequest request, Model model) throws Exception {
//         전송된 데이터를 파라미터로 받아오는 부분
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        String nick = request.getParameter("nick");
        String loc = request.getParameter("loc");
        String money = request.getParameter("money");
        int money1 = Integer.parseInt(money);

        // ListDTO 객체를 생성하고 값을 설정합니다.
        ListDTO list = new ListDTO();
        list.setListTitle(title);
        list.setListContent(content);
        list.setListMoney(money1);
        list.setListUserNick(nick);
        list.setListLoc(loc);
        System.out.println(list);
//
//        // WriteService를 사용하여 리스트에 항목을 추가합니다.
        writeService.InsertList(list);
    }

    @RequestMapping(value = "/selectList", method = {RequestMethod.GET})
    @ResponseBody
    public String androidSelectList(HttpServletRequest request)throws Exception{

        JSONObject data1 = new JSONObject();

        List<ListDTO> list1 = writeService.SelectList();

        JSONArray jsonArray = new JSONArray();
        for(ListDTO list : list1){
            JSONObject data = new JSONObject();
            data.put("list_idx", list.getListIdx());
            data.put("list_title", list.getListTitle());
            data.put("list_content", list.getListContent());
            data.put("list_user_nick", list.getListUserNick());
            data.put("list_money", list.getListMoney());

            jsonArray.put(data);
        }

        return jsonArray.toString();
    }

    @RequestMapping(value = "/selectPanmaeList", method = {RequestMethod.POST})
    @ResponseBody
    public String androidPanmaeSelectList(HttpServletRequest request)throws Exception{
        String userNick = request.getParameter("nick");

        JSONObject data1 = new JSONObject();

        List<ListDTO> list1 = writeService.PanmaeSelectList(userNick);

        JSONArray jsonArray = new JSONArray();
        for(ListDTO list : list1){
            JSONObject data = new JSONObject();
            data.put("list_idx", list.getListIdx());
            data.put("list_title", list.getListTitle());
            data.put("list_content", list.getListContent());
            data.put("list_user_nick", list.getListUserNick());
            data.put("list_money", list.getListMoney());

            jsonArray.put(data);
        }

        return jsonArray.toString();
    }

    @RequestMapping(value = "/updateSellReservation", method = {RequestMethod.POST})
    @ResponseBody
    public void updateSellReservation(HttpServletRequest request, ListDTO list)throws Exception {

        try {
            String idxString = request.getParameter("idx");
            int listIdx = Integer.parseInt(idxString);
            list.setListIdx(listIdx);
            writeService.updateSellReservation(list);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/updatesellComplete", method = {RequestMethod.POST})
    @ResponseBody
    public void updatesellComplete(HttpServletRequest request, ListDTO list)throws Exception {

        try {
            String idxString = request.getParameter("idx");
            int listIdx = Integer.parseInt(idxString);
            list.setListIdx(listIdx);
            writeService.updatesellComplete(list);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/updateSellDelete", method = {RequestMethod.POST})
    @ResponseBody
    public void updateSellDelete(HttpServletRequest request, ListDTO list)throws Exception {

        try {
            String idxString = request.getParameter("idx");
            int listIdx = Integer.parseInt(idxString);
            list.setListIdx(listIdx);
            writeService.updateSellDelete(list);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

