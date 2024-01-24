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

    @Override
    public List<ListDTO> PanmaeSelectList(String userNick) throws Exception {
        return writeMapper.PanmaeSelectList(userNick);
    }

    @Override
    public void updateSellReservation(ListDTO list) throws Exception {
        writeMapper.updateSellReservation(list);
    }

    @Override
    public void updatesellComplete(ListDTO list) throws Exception {
        writeMapper.updatesellComplete(list);
    }

    @Override
    public void updateSellDelete(ListDTO list) throws Exception {
        writeMapper.updateSellDelete(list);
    }
}
