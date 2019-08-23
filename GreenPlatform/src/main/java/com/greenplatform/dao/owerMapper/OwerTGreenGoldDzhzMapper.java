package com.greenplatform.dao.owerMapper;

import com.greenplatform.model.TGreenGoldDzhz;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mapper
public interface OwerTGreenGoldDzhzMapper {
    //查询点赞表中一工累计了多少次点赞
    int selectSumGoldDzhz();

    //查询点赞排行榜前十
    List selectGreenGoldDzhzRank();

    //根据id查询点赞排名
    Map selectTGreenGoldDzhzBycUserid(String cUserid);

    //查询排名
    Map selectGreenGoldDzhzAllRank();

}
