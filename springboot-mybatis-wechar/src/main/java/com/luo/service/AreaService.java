package com.luo.service;

import com.luo.model.AreaModel;

import java.util.List;

/**
 * Created by Luowenlv on 2018/9/29,9:45
 */
public interface AreaService {
    public List getAllArea();

    public AreaModel getAreaById(Integer areaId);

    public void addArea(AreaModel areaModel);

    public void delAreaById(Integer areaId);

    public AreaModel updateAreaById(Integer areaId);

    public void doUpdateArea(AreaModel areaModel);
}
