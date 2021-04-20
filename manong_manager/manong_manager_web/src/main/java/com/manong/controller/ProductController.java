package com.manong.controller;

import com.manong.pojo.Product;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ProductController {

    @RequestMapping("/product_list")
    public String product_list(){
        return "product_list";
    }


}
