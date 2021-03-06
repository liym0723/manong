package com.manong.controller;
import com.manong.pojo.ResponseJsonResult;
import com.manong.service.ProductCategroyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.manong.pojo.EasyUITree;

import java.util.List;

@Controller
@RequestMapping("/product_category")
public class ProductCategroyController {
    @Autowired
    private ProductCategroyService productCategroyService;

    @RequestMapping("/list")
    @ResponseBody
    public List<EasyUITree> findById(@RequestParam(value="id",defaultValue = "0")Short parent_id){
        List<EasyUITree> easyUITrees = productCategroyService.findById(parent_id);
        return easyUITrees;
    }



    @RequestMapping("/add")
    @ResponseBody
    public ResponseJsonResult addCreategory(Short parentid, String name){
        return productCategroyService.addCategory(parentid, name);
    }

    @RequestMapping("/del")
    @ResponseBody
    public ResponseJsonResult delteCategory(Short parentid, Short id){
        return productCategroyService.delteCategory(parentid, id);
    }
}
