package com.bitc.plummarketdb.mapper;

import com.bitc.plummarketdb.DTO.ListDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface WriteMapper {

    void InsertList(ListDTO list)throws Exception;

    List<ListDTO> SelectList()throws Exception;
}
