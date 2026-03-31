package com.example.demo.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.model.User;

@Mapper
public interface UserMapper {
	
	//사용자목록
	public List<User> selectUserList(HashMap<String, Object> resultMap);
	public User selectUser(HashMap<String,Object>map);
	
	public int insertUser(HashMap<String,Object>map);
	
	public int deleteUser(HashMap<String,Object>map);



}
