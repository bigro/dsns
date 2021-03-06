package com.example.dsns.article;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ArticleMapper {
	Long create(@Param("article") Article article);

    List<Article> searchAll();

    Article getBy(@Param("identifier") Identifier identifier);

    void delete(@Param("identifier") Identifier identifier);
}
