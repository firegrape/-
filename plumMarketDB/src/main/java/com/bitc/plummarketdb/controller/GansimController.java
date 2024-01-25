package com.bitc.plummarketdb.controller;

import com.bitc.plummarketdb.DTO.GansimDTO;
import com.bitc.plummarketdb.service.GansimService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class GansimController {

    @Autowired
    private GansimService gansimService;

    @GetMapping("/gansim")
    @ResponseBody
    public List<GansimDTO> GansimList(HttpServletRequest request) throws Exception {
        String id = request.getParameter("userId");

        List<GansimDTO> gansimList = gansimService.selectGansimList(id);
        return  gansimList;
    }
}
