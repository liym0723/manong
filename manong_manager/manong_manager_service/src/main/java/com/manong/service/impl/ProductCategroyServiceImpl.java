package com.manong.service.impl;

import com.manong.mapper.ProductCategoryMapper;
import com.manong.pojo.ProductCategory;
import com.manong.pojo.ProductCategoryExample;
import com.manong.service.ProductCategroyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.manong.pojo.EasyUITree;

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
            easyUITrees.add(easyUITree);
        }

        return easyUITrees;
    }
}
