package com.example.dsns.article;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ArticleMapper {
	Long create(@Param("article") Article article);
}
