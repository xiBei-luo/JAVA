package com.luo.service.Impl;

import com.luo.dao.AreaMapper;
import com.luo.model.AreaModel;
import com.luo.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by Luowenlv on 2018/9/29,9:47
 */
@Service
public class AreaServiceImpl implements AreaService {
    @Autowired
    private AreaMapper areaMapper;


    @Override
    public List getAllArea() {
        return areaMapper.getAllArea();
    }

    @Override
    public AreaModel getAreaById(Integer areaId) {
        return areaMapper.getAreaById(areaId);
    }

    @Override
    public void addArea(AreaModel areaModel) {
        Date currentDate = new Date();
        areaModel.setCreate_time(currentDate);
        areaModel.setEdit_last_time(currentDate);
        areaMapper.addArea(areaModel);
    }

    @Override
    public void delAreaById(Integer areaId) {
        areaMapper.delAreaById(areaId);
    }

    @Override
    public AreaModel updateAreaById(Integer areaId) {
        return areaMapper.getAreaById(areaId);
    }

    @Override
    public void doUpdateArea(AreaModel areaModel) {
        areaModel.setEdit_last_time(new Date());
        areaMapper.doUpdateArea(areaModel);
    }
}
