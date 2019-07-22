package com.greenplatform.dao.owerMapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface OwerTGreenGoldDzhzMapper {
    //查询点赞表中一工累计了多少次点赞
    int selectSumGoldDzhz();

    //查询点赞排行榜前十
    List selectGreenGoldDzhzRank();
}
