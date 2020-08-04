package com.seecen.dao;

import com.seecen.model.Subscribe;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ISubscribeDao {
    int deleteByPrimaryKey(@Param("sId") Integer sId, @Param("sEmail") String sEmail);

    int insert(Subscribe record);

    Subscribe selectByPrimaryKey(@Param("sId") Integer sId, @Param("sEmail") String sEmail);

    List<Subscribe> selectAll();

    int updateByPrimaryKey(Subscribe record);
}