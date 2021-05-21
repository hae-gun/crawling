package com.example.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.BojService;
import com.example.service.JpaServices;
import com.example.vo.TestVo;

@RestController
@RequestMapping("/json")
public class JsonController {
	

	private final JpaServices jpaServices;
	private final BojService bojService;
	public JsonController(JpaServices jpaServices,BojService bojService) {
		System.out.println("make JsonController");
		this.jpaServices = jpaServices;
		this.bojService = bojService;
	}
//	
	
	@GetMapping("/test")
	public List<TestVo> getAll(TestVo vo) {
		System.out.println(jpaServices.findAll());
		return jpaServices.findAll();
	}
	
	@PostMapping("/data")
	public TestVo addVo(TestVo testVo) {
		System.out.println(testVo);
		return jpaServices.insertOne(testVo);
	}
	@GetMapping("/test2")
	public void testBoj() throws FileNotFoundException, IOException, ParseException {
		System.out.println(bojService.getJsonData());
	}
}