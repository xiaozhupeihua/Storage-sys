package com.springboot.storage.mapper;

import com.springboot.storage.entity.Article;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

//@Description ：数据库接口mapper接口类

@Mapper
public interface StorageMapper{

    /*  通过物品编号查找
        @param num
        @return  相同num的信息的集合   */
    public List<Article> findById(String num);

    /*  查找所有物品的信息
        @return 所有的物品   */
    public List<Article> ListArticle();

    /*  分页查询物品信息
        @param starRows
        @return 每一页的物品信息的集合  */
    public List<Article> queryPage(Integer starRows);

    public int getRowsCount();//每一行的个数 @return

    /*  插入物品的信息
        @param article
        @return 是否成功   */
    public int InsertRow(Article article);

    /*  通过id删除物品的信息
        @param id
        @return 是否成功   */
    public int DeleteRow(int id);

    /*  更新物品的信息
        @param article
        @return 是否成功   */
    public int UpdateRow(Article article);

}
