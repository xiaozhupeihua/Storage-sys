package com.springboot.storage.controller;

import com.springboot.storage.entity.Article;
import com.springboot.storage.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin//跨域CORS支持
@RestController//映射请求
public class StorageController {

    @Autowired//对类成员变量、方法及构造函数进行标注，让 spring 完成 bean 自动装配的工作
    private StorageService storageService;

    /*  通过num查询  模糊查询
        @param num
        @return    */
    @RequestMapping(value = "/ListById")//用来处理请求地址映射
    @ResponseBody
    public List<Article> findById(String num) {
        return storageService.findById(num);
    }

    //  查询所有 @return
    @RequestMapping(value = "/ListArticle")//用来处理请求地址映射
    @ResponseBody
    public List<Article> ListArticle() {
        return storageService.ListArticle();
    }

    /*  查询页数
        @param page
        @return     */
    @RequestMapping(value ="/page")//用来处理请求地址映射
    @ResponseBody
    public List<Article> queryPage(Integer page) {
        int pageNow = page == null ? 1 : page;//传入的页数是null  就查询第一页   否则就根据传入的页数进行查询
        int pageSize=5;
        int startRows = pageSize * (pageNow - 1);//开始的行数
        List<Article> list = storageService.queryPage(startRows);
        return list;
    }

    //每一行的个数
    @RequestMapping(value ="rows")//用来处理请求地址映射
    @ResponseBody
    public int getRowsCount(){
        return storageService.getRowsCount();
    }

    /*  插入物品
        @param article
        @return         */
    @RequestMapping(value = "/insert", method = RequestMethod.POST)//用来处理请求地址映射
    public Article insertRow(Article article) {
        return storageService.insertRow(article);
    }

    /*  通过物品id删除物品
        @param id
        @return          */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)//用来处理请求地址映射
    public Integer deleteRow(Integer id) {
        System.out.println(id);

        int result = storageService.deleteRow(id);
        return result;
    }

    /*  更新物品
        @param article
        @return     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)//用来处理请求地址映射
    @ResponseBody
    public String updateRow(Article article) {
        int result = storageService.updateRow(article);
        if (result >= 1) {
            return "修改成功";
        } else {
            return "修改失败";
        }
    }

}
