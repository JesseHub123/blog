package com.seecen.dao;

import com.seecen.model.User;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IUserDao {
    int deleteByPrimaryKey(@Param("userid") Integer userid, @Param("username") String username);

    int insert(User record);

    User selectByPrimaryKey(@Param("userid") Integer userid, @Param("username") String username);

    List<User> selectAll();

    int updateByPrimaryKey(User record);
    User doLogin(@Param("username") String username,@Param("password") String password);
}