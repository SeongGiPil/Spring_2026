package com.example.demo.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.Student;
import com.google.gson.Gson;


@Mapper
public interface StudentMapper {
	public List<Student> selectStudentList(HashMap<String,Object>map);
	
	public int deleteStudent(HashMap<String,Object>map);
	public Student selectStudent(HashMap<String, Object> map);
	public int insertStudent(HashMap<String, Object> map);
	
}
