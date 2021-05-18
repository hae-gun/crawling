package com.example.controller;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.repository.JdbcAccountRepository;
import com.example.service.JdbcService;
import com.example.vo.Account;
import com.example.vo.TestVo;

@RestController
@RequestMapping("/test")
public class Test {
	
	private final TestVo testVo;
	private final JdbcService jdbcService; 
	
	public Test(TestVo testVo,JdbcService jdbcService) {
		this.testVo = testVo;
		this.jdbcService = jdbcService;
	}
	
	@GetMapping("/json")
	public void json() throws IOException, ParseException {
		ClassPathResource cpr = new ClassPathResource("/json/result.json");
		byte[] bdata = FileCopyUtils.copyToByteArray(cpr.getInputStream());
		String jsonTxt = new String(bdata,StandardCharsets.UTF_8);
		JSONParser parser = new JSONParser();
		JSONObject jObj = (JSONObject) parser.parse(jsonTxt);
		List<TestVo> list = new ArrayList<>();
		for(Object key: jObj.keySet()) {
			list.add(new TestVo(key.toString(),jObj.get(key).toString()));
		}
		System.out.println(list);
	}
	
	@GetMapping("/accounts")
	public List<Account> getAll(){
		return jdbcService.getAllEmail();
	}
	
	@GetMapping("/account/{id}")
	public Account findById(@PathVariable Long id){
		return jdbcService.findById(id);
	}
}
