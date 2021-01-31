package org.wang.goal.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.wang.goal.domain.News;

import java.sql.Timestamp;
import java.util.List;

@Mapper
public interface NewsMapper {
    List<News> selectAllNews();
    List<News> selectAllPermInfo();
    void updateNewsInfo(String id,String title, String name, Timestamp publishTime);
    void deleteNewsInfo(String id);
}
