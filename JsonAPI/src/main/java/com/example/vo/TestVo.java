package com.example.vo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "test")
public class TestVo {

	@Id
	private int id;
	private String name;
	private String url;
	
	public TestVo() {
	}
	public TestVo(String name, String url) {
		this.name = name;
		this.url = url;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	@Override
	public String toString() {
		return "TestVo [name=" + name + ", url=" + url + "]";
	}
	
	
}
