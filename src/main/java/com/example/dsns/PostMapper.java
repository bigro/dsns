package com.example.dsns;

import javafx.geometry.Pos;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PostMapper {
	Identifier create(Post post);
}
