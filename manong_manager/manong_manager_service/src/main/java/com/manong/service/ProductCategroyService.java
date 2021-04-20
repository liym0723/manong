package com.manong.service;

import com.manong.pojo.ResponseJsonResult;
import org.springframework.stereotype.Service;
import com.manong.pojo.EasyUITree;
import java.util.List;

public interface ProductCategroyService {
    List<EasyUITree> findById(Short parentid);
    ResponseJsonResult addCategory(Short parentid, String name);
    ResponseJsonResult delteCategory(Short parentid, Short id);
}
