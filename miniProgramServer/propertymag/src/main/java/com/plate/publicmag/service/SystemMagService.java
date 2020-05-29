package com.plate.publicmag.service;

import com.plate.publicmag.model.baseModel.ReturnModel;

import javax.servlet.http.HttpSession;

public interface SystemMagService {
    ReturnModel selectMenuByLoginUser(HttpSession httpSession);

    ReturnModel selectAllMenu();
}
