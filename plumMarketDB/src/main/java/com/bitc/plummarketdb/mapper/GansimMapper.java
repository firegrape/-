package com.bitc.plummarketdb.mapper;

import com.bitc.plummarketdb.DTO.GansimDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GansimMapper {
    List<GansimDTO> selectGansimList(String id) throws Exception;
}
