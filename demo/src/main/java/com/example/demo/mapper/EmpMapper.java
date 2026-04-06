package com.example.demo.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.model.Emp;
import com.example.demo.model.User;

@Mapper
public interface EmpMapper {
	//여러개 리턴->selectXXXList
	//emp목록
	public List<Emp> selectEmpList(HashMap<String, Object> resultMap);
	int insertEmp(HashMap<String, Object> resultMap);
	int DeleteEmp(HashMap<String, Object> resultMap);
	public Emp selectEmp(HashMap<String, Object> resultMap);
	public int selectEmpCount(HashMap<String, Object> resultMap);
	
	
}

