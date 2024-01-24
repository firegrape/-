package com.bitc.plummarketdb.service;

import com.bitc.plummarketdb.DTO.ListDTO;

import java.util.List;


public interface WriteService {
    void InsertList(ListDTO list)throws Exception;

    List<ListDTO> SelectList()throws Exception;

    List<ListDTO> PanmaeSelectList(String userNick)throws Exception;

    void updateSellReservation(ListDTO list)throws Exception;

    void updatesellComplete(ListDTO list)throws Exception;

    void updateSellDelete(ListDTO list)throws Exception;
}
