package com.greenplatform.dao.owerMapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OwerTGreenGoldDzhzMapper {
    //查询点赞表中一工累计了多少次点赞
    int selectSumGoldDzhz();
}
