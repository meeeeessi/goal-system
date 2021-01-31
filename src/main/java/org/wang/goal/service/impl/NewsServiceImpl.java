package org.wang.goal.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wang.goal.domain.News;
import org.wang.goal.mapper.NewsMapper;
import org.wang.goal.service.INewsService;

import java.sql.Timestamp;
import java.util.List;

@Service
public class NewsServiceImpl implements INewsService {

    @Autowired
    private NewsMapper newsMapper;

    @Override
    public List<News> selectAllNews() {
        return newsMapper.selectAllNews();
    }

    @Override
    public List<News> selectAllPermInfo() {
        return newsMapper.selectAllPermInfo();
    }

    @Override
    public void updateNewsInfo(String id,String title, String name, Timestamp publishTime) {
        newsMapper.updateNewsInfo(id,title,name,publishTime);
    }

    @Override
    public void deleteNewsInfo(String id) {
        newsMapper.deleteNewsInfo(id);
    }
}
