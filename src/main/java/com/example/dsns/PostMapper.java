package com.example.dsns;

import javafx.geometry.Pos;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PostMapper {
	Long create(@Param("post") Post post);
}
