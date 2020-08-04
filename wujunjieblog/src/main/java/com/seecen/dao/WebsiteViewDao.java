package com.seecen.dao;

import com.seecen.model.WebsiteView;
import java.util.List;

public interface WebsiteViewDao {
    int deleteByPrimaryKey(Integer wid);

    int insert(WebsiteView record);

    WebsiteView selectByPrimaryKey();

    List<WebsiteView> selectAll();

    int updateByPrimaryKey();
}