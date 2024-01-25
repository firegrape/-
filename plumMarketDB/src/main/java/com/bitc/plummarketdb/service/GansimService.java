package com.bitc.plummarketdb.service;

import com.bitc.plummarketdb.DTO.GansimDTO;

import java.util.List;

public interface GansimService {
    List<GansimDTO> selectGansimList(String id) throws Exception;
}
