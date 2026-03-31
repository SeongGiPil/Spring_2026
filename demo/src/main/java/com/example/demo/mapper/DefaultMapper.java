package com.example.demo.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.model.Student;
import com.example.demo.model.User;

@Mapper
public interface DefaultMapper {
	//여러개 리턴->selectXXXList
	public List<User> selectUserList(HashMap<String, Object> resultMap);
	//한개 리턴->selectXXX
	public User selectUser();
	//삭제
	public int deleteUser();
}



