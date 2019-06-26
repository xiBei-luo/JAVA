package com.luo.dao;

import com.luo.model.AreaModel;

import java.util.List;

/**
 * Created by Luowenlv on 2018/9/29,9:37
 */
public interface AreaMapper {
    public List getAllArea();

    public AreaModel getAreaById(Integer areaId);

    public void addArea(AreaModel areaModel);

    public void delAreaById(Integer areaId);

    public AreaModel updateAreaById(Integer areaId);//直接调用getAreaById

    public void doUpdateArea(AreaModel areaModel);
}
