package com.springboot.storage.service;

import com.springboot.storage.entity.Article;
import com.springboot.storage.mapper.StorageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StorageService {

    @Autowired//对类成员变量、方法及构造函数进行标注，让 spring 完成 bean 自动装配的工作
    StorageMapper storageMapper;

    //查询操作（根据物品编码查询）
    public List<Article> findById(String num) {
        return storageMapper.findById(num);
    }

    //查询所有
    public List<Article> ListArticle() {
        return storageMapper.ListArticle();
    }

    //查询页数
    public List<Article> queryPage(Integer starRows) {
        return storageMapper.queryPage(starRows);
    }

    //每一行的个数
    public int getRowsCount() {
        return storageMapper.getRowsCount();
    }

    //插入操作
    public Article insertRow(Article article) {
        storageMapper.InsertRow(article);
        return  article;
    }

    //删除操作
    public int deleteRow(Integer id) {
        return storageMapper.DeleteRow(id);
    }

    //更新操作
    public int updateRow(Article article) {
        return storageMapper.UpdateRow(article);
    }

}
