package com.manong.service.impl;

import com.manong.mapper.UserMapper;
import com.manong.pojo.User;
import com.manong.pojo.UserExample;
import com.manong.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User getUserById(Integer id) {

        UserExample userExample = new UserExample();

        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andIdEqualTo(id);

        List<User> userList = userMapper.selectByExample(userExample);
        if(userList.size() != 0|| !userList.isEmpty()){
            return userList.get(0);
        }
        return null;

    }
}
