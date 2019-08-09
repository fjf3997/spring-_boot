package com.fjf.dao;

import com.fjf.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface UserDao {
    List<User> queryUserList();
}
