package com.bitc.plummarketdb.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ListMapper {
    void updateHit(@Param("idx") String idx)throws Exception;
}
