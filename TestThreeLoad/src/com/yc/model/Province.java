package com.yc.model;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Province implements Serializable {
	private Integer id;
	private String province;
	private Set cities=new HashSet();
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public Set getCities() {
		return cities;
	}
	public void setCities(Set cities) {
		this.cities = cities;
	}
	@Override
	public String toString() {
		return "Province [id=" + id + ", province=" + province + ", cities=" + cities + "]";
	}
	
}
