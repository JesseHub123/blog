package com.seecen.dao;

import com.seecen.model.Type;
import java.util.List;

public interface ITypeDao {
    int deleteByPrimaryKey(Integer blogTypeId);

    int insert(Type record);

    Type selectByPrimaryKey(Integer blogTypeId);

    List<Type> selectAll();

    int updateByPrimaryKey(Type record);
}