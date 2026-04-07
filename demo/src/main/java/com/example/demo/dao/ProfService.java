package com.example.demo.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.common.Message;
import com.example.demo.mapper.ProfMapper;
import com.example.demo.model.Prof;

@Service
public class ProfService {
	
	@Autowired 
	ProfMapper profMapper;
	
	
	public HashMap<String, Object> getProfList(HashMap<String, Object>map){
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		
		
		try {
			List<Prof> list = profMapper.selectProfList(map);
			int totalCount=profMapper.selectProfCount(map);
			resultMap.put("totalCount",totalCount);
			
			resultMap.put("list",list);
			
			
			resultMap.put("result", "success");
			
			resultMap.put("message",Message.MSG_SEARCH);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			resultMap.put("message",Message.MSG_SERVER_ERR);
		}
		return resultMap;
	}
	
	public HashMap<String, Object> addProf(HashMap<String, Object> map){
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		try {
		int cnt = profMapper.insertProf(map);
			resultMap.put("result", "success");
			resultMap.put("message", Message.MSG_ADD);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			resultMap.put("result", "fail");
			resultMap.put("message", Message.MSG_SERVER_ERR);
		}
		return resultMap;
	}

	
	public HashMap<String, Object> removeProf(HashMap<String, Object> map) {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		try {
			 int cnt = profMapper.DeleteProf(map);
			resultMap.put("result","success");
			resultMap.put("message", Message.MSG_REMOVE);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			resultMap.put("result", "fail");
			resultMap.put("message", Message.MSG_SERVER_ERR);
		}
		return resultMap;
	}
	
	public HashMap<String, Object> getProfInfo(HashMap<String, Object> map) {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		try {
			Prof info = profMapper.selectProf(map);
			
			resultMap.put("info", info);
			resultMap.put("result", "success");
			resultMap.put("message", Message.MSG_SEARCH);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			resultMap.put("result", "fail");
			resultMap.put("message", Message.MSG_SERVER_ERR);
		}
		return resultMap;
	}
}

	
