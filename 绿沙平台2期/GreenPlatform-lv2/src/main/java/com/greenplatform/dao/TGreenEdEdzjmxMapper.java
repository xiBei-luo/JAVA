package com.greenplatform.dao;

import com.greenplatform.model.TGreenEdEdzjmx;
import com.greenplatform.model.TGreenEdEdzjmxExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TGreenEdEdzjmxMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_green_ed_edzjmx
     *
     * @mbggenerated
     */
    int countByExample(TGreenEdEdzjmxExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_green_ed_edzjmx
     *
     * @mbggenerated
     */
    int deleteByExample(TGreenEdEdzjmxExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_green_ed_edzjmx
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String cLsh);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_green_ed_edzjmx
     *
     * @mbggenerated
     */
    int insert(TGreenEdEdzjmx record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_green_ed_edzjmx
     *
     * @mbggenerated
     */
    int insertSelective(TGreenEdEdzjmx record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_green_ed_edzjmx
     *
     * @mbggenerated
     */
    List<TGreenEdEdzjmx> selectByExample(TGreenEdEdzjmxExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_green_ed_edzjmx
     *
     * @mbggenerated
     */
    TGreenEdEdzjmx selectByPrimaryKey(String cLsh);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_green_ed_edzjmx
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") TGreenEdEdzjmx record, @Param("example") TGreenEdEdzjmxExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_green_ed_edzjmx
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") TGreenEdEdzjmx record, @Param("example") TGreenEdEdzjmxExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_green_ed_edzjmx
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(TGreenEdEdzjmx record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_green_ed_edzjmx
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(TGreenEdEdzjmx record);
}