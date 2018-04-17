package com.yc.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class City implements Serializable {
	private Integer id;
	private Province province;
	private String city;
	private Set towns=new HashSet();
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Province getProvince() {
		return province;
	}
	public void setProvince(Province province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Set getTowns() {
		return towns;
	}
	public void setTowns(Set towns) {
		this.towns = towns;
	}
	@Override
	public String toString() {
		return "City [id=" + id + ", province=" + province + ", city=" + city + ", towns=" + towns + "]";
	}
	
}
