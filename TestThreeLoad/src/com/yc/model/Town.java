package com.yc.model;
import java.io.Serializable;

public class Town implements Serializable {
	private Integer id;
	private City city;
	private String town;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	public String getTown() {
		return town;
	}
	public void setTown(String town) {
		this.town = town;
	}
	@Override
	public String toString() {
		return "Town [id=" + id + ", city=" + city + ", town=" + town + "]";
	}
	
}
