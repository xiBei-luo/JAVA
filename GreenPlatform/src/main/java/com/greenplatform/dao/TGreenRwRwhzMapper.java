package com.greenplatform.dao;

import com.greenplatform.model.TGreenRwRwhz;
import com.greenplatform.model.TGreenRwRwhzExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TGreenRwRwhzMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_green_rw_rwhz
     *
     * @mbggenerated
     */
    int countByExample(TGreenRwRwhzExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_green_rw_rwhz
     *
     * @mbggenerated
     */
    int deleteByExample(TGreenRwRwhzExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_green_rw_rwhz
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(@Param("cUserid") String cUserid, @Param("cRwlb") String cRwlb, @Param("cRwsj") String cRwsj);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_green_rw_rwhz
     *
     * @mbggenerated
     */
    int insert(TGreenRwRwhz record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_green_rw_rwhz
     *
     * @mbggenerated
     */
    int insertSelective(TGreenRwRwhz record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_green_rw_rwhz
     *
     * @mbggenerated
     */
    List<TGreenRwRwhz> selectByExample(TGreenRwRwhzExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_green_rw_rwhz
     *
     * @mbggenerated
     */
    TGreenRwRwhz selectByPrimaryKey(@Param("cUserid") String cUserid, @Param("cRwlb") String cRwlb, @Param("cRwsj") String cRwsj);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_green_rw_rwhz
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") TGreenRwRwhz record, @Param("example") TGreenRwRwhzExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_green_rw_rwhz
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") TGreenRwRwhz record, @Param("example") TGreenRwRwhzExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_green_rw_rwhz
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(TGreenRwRwhz record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_green_rw_rwhz
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(TGreenRwRwhz record);
}