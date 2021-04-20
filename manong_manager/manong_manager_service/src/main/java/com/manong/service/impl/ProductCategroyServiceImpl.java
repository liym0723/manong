package com.manong.service.impl;

import com.manong.mapper.ProductCategoryMapper;
import com.manong.pojo.*;
import com.manong.service.ProductCategroyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductCategroyServiceImpl implements ProductCategroyService {

    @Autowired
    private ProductCategoryMapper productCategoryMapper;

    @Override
    public List<EasyUITree> findById(Short parentid) {
        ProductCategoryExample productCategoryExample = new ProductCategoryExample();
        ProductCategoryExample.Criteria criteria = productCategoryExample.createCriteria();

        criteria.andParentIdEqualTo(parentid);
        List<ProductCategory> productCategories = productCategoryMapper.selectByExample(productCategoryExample);

        List<EasyUITree> easyUITrees = new ArrayList<>(productCategories.size());

        for (ProductCategory productCategory : productCategories){
            EasyUITree easyUITree = new EasyUITree();
            easyUITree.setId(productCategory.getId());
            easyUITree.setText(productCategory.getName());
            easyUITree.setState(productCategory.getId() == 0 ? "close" : "open");
            easyUITree.setAttributes(productCategory.getParentId() + "");
            easyUITrees.add(easyUITree);
        }

        return easyUITrees;
    }

    @Override
    public ResponseJsonResult addCategory(Short parentid, String name) {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setParentId(parentid);
        productCategory.setName(name);
        productCategoryMapper.insert(productCategory);

        ResponseJsonResult responseJsonResult = new ResponseJsonResult();
        responseJsonResult.setMsg(productCategory.getId() + "");
        return responseJsonResult;

    }

    @Override
    public ResponseJsonResult delteCategory(Short parentid, Short id) {
        // 删除父类的时候 子类不需要删除
        ProductCategoryExample productCategoryExample = new ProductCategoryExample();
        ProductCategoryExample.Criteria criteria = productCategoryExample.createCriteria();

        criteria.andIdEqualTo(id);
        productCategoryMapper.deleteByExample(productCategoryExample);

        ResponseJsonResult result = new ResponseJsonResult();
        result.setStatus(200);
        result.setMsg("success");
        return result;
    }
}
