package com.manong.service;

import org.springframework.stereotype.Service;
import com.manong.pojo.EasyUITree;
import java.util.List;

public interface ProductCategroyService {
    List<EasyUITree> findById(Short parentid);
}
