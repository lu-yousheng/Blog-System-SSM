package com.example.demo.mapper;

import com.example.demo.entity.Userinfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    //注册
    int reg(Userinfo userinfo);

    //根据用户名查询useinfo对象
    Userinfo getUserByname(@Param("username") String username);
}
