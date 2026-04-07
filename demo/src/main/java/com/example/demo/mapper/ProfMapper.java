package com.example.demo.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.model.Prof;

@Mapper
public interface ProfMapper {
	//여러개 리턴->selectXXXList
	//emp목록
	public List<Prof> selectProfList(HashMap<String, Object> resultMap);
	int insertProf(HashMap<String, Object> resultMap);
	int DeleteProf(HashMap<String, Object> resultMap);
	public Prof selectProf(HashMap<String, Object> resultMap);
	public int selectProfCount(HashMap<String, Object> resultMap);
	
	
}

