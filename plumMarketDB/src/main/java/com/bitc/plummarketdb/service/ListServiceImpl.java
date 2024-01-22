package com.bitc.plummarketdb.service;


import com.bitc.plummarketdb.DTO.ListDTO;
import com.bitc.plummarketdb.mapper.ListMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ListServiceImpl implements ListService {
    @Autowired
    private ListMapper listMapper;
    @Override
    public ListDTO selectListInfo() throws Exception {
        return null;
    }
}
