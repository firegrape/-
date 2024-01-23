package com.bitc.plummarketdb.service;

import com.bitc.plummarketdb.DTO.ListDTO;

import java.util.List;


public interface WriteService {
    void InsertList(ListDTO list)throws Exception;

    List<ListDTO> SelectList()throws Exception;
}
