package com.greenplatform.dao;

import com.greenplatform.model.TGreenGoldDzhz20191104;
import com.greenplatform.model.TGreenGoldDzhz20191104Example;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TGreenGoldDzhz20191104Mapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_green_gold_dzhz_20191104
     *
     * @mbggenerated
     */
    int countByExample(TGreenGoldDzhz20191104Example example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_green_gold_dzhz_20191104
     *
     * @mbggenerated
     */
    int deleteByExample(TGreenGoldDzhz20191104Example example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_green_gold_dzhz_20191104
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String cUserid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_green_gold_dzhz_20191104
     *
     * @mbggenerated
     */
    int insert(TGreenGoldDzhz20191104 record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_green_gold_dzhz_20191104
     *
     * @mbggenerated
     */
    int insertSelective(TGreenGoldDzhz20191104 record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_green_gold_dzhz_20191104
     *
     * @mbggenerated
     */
    List<TGreenGoldDzhz20191104> selectByExample(TGreenGoldDzhz20191104Example example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_green_gold_dzhz_20191104
     *
     * @mbggenerated
     */
    TGreenGoldDzhz20191104 selectByPrimaryKey(String cUserid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_green_gold_dzhz_20191104
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") TGreenGoldDzhz20191104 record, @Param("example") TGreenGoldDzhz20191104Example example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_green_gold_dzhz_20191104
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") TGreenGoldDzhz20191104 record, @Param("example") TGreenGoldDzhz20191104Example example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_green_gold_dzhz_20191104
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(TGreenGoldDzhz20191104 record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_green_gold_dzhz_20191104
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(TGreenGoldDzhz20191104 record);
}