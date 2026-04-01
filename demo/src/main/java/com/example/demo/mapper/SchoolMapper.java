package com.example.demo.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.model.Dept;
import com.example.demo.model.Professor;
import com.example.demo.model.Student;
import com.example.demo.model.User;

@Mapper
public interface SchoolMapper {
	// 교수 목록
	public List<Professor> selectProfList(HashMap<String, Object> map);
	// 학생 목록
	public List<Student> selectStuList(HashMap<String, Object> map);
	
	//학과목록
	public List<Dept> selectDeptList(HashMap<String, Object> map);
	
	//학생추가
	public int insertStu(HashMap<String, Object> map);
	
	public int insertProf(HashMap<String, Object> map);
	
	//학생정보
	public Student selectStu(HashMap<String, Object> map);
	
	//학생삭제
	public int deleteStu(HashMap<String, Object> map);
	
	
	//교수삭제
	public int deleteProf(HashMap<String, Object> map);
	
	
	
	public Professor selectprof(HashMap<String, Object> map);
	
	
	public int updateStu(HashMap<String, Object> map);

	
	
}