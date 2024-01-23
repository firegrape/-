package com.bitc.plummarketdb.service;

import com.bitc.plummarketdb.DTO.ListDTO;
import com.bitc.plummarketdb.mapper.WriteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WriteServiceImpl implements WriteService {
    @Autowired
    WriteMapper writeMapper;

    @Override
    public void InsertList(ListDTO list) throws Exception {
        writeMapper.InsertList(list);
    }

    @Override
    public List<ListDTO> SelectList() throws Exception {
        return writeMapper.SelectList();
    }
}
