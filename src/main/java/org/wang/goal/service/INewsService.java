package org.wang.goal.service;

import org.wang.goal.domain.News;

import java.sql.Timestamp;
import java.util.List;

public interface INewsService {
    List<News> selectAllNews();
    List<News> selectAllPermInfo();
    void updateNewsInfo(String id,String title, String name, Timestamp publishTime);
    void deleteNewsInfo(String id);
}
