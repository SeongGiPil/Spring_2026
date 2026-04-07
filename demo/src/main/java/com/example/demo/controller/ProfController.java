package com.example.demo.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dao.EmpService;
import com.example.demo.dao.ProfService;
import com.google.gson.Gson;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class ProfController {
	
	@Autowired
	ProfService profService;
	
	// 웹브라우저로 접속하는 주소, return은 jsp파일
	
	
	@RequestMapping("/prof/list.do") 
	public String Emp(HttpServletRequest request, Model model, @RequestParam HashMap<String, Object> map) throws Exception{
		return "prof/prof-list";
	}
	
	@RequestMapping("/prof/add.do") 
	public String add(Model model) throws Exception{
		return "/prof/prof-add";
	}
	@RequestMapping("/prof/view.do") 
	public String view(HttpServletRequest request, Model model, @RequestParam HashMap<String, Object> map) throws Exception{
		System.out.println(map);
		request.setAttribute("map", map);
		return "/prof/prof-view"; 
	}
	
	
	
	
	
	@RequestMapping(value = "/prof-add.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String add(Model model, @RequestParam HashMap<String, Object> map) throws Exception {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		System.out.println(map);
		resultMap= profService.addProf(map);

		return new Gson().toJson(resultMap); 
	}
	@RequestMapping(value = "/prof/list.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String copy(Model model, @RequestParam HashMap<String, Object> map) throws Exception {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		int pageSize = Integer.parseInt((String) map.get("pageSize"));
		int offSet = Integer.parseInt((String) map.get("offSet"));
		map.put("pageSize", pageSize);
		map.put("offSet", offSet);
		
		resultMap = profService.getProfList(map);
		
		return new Gson().toJson(resultMap); 
	}

	
	
	@RequestMapping(value = "/prof-remove.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String remove(Model model, @RequestParam HashMap<String, Object> map) throws Exception {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		System.out.println(map);
		resultMap = profService.removeProf(map);
		
		return new Gson().toJson(resultMap); 
	}
	
	@RequestMapping(value = "/prof/info.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String info(Model model, @RequestParam HashMap<String, Object> map) throws Exception {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		resultMap = profService.getProfInfo(map);

		return new Gson().toJson(resultMap); 
	}
	
	
	
	
	
	
	
	
	
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	