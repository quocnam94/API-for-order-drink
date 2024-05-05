package com.order_processing.dto;

import java.util.List;

public class DetailTeaRequest {
	
	private Integer idTea;
	private String name;
	private String description;
	private Double price;
	private Integer idSize;
    private List<Integer> idToppings;

	public DetailTeaRequest() {
	}
	
	public DetailTeaRequest(Integer idTea, String name, String description, Double price, Integer idSize,
			List<Integer> idToppings) {
		this.idTea = idTea;
		this.name = name;
		this.description = description;
		this.price = price;
		this.idSize = idSize;
		this.idToppings = idToppings;
	}

	public Integer getIdTea() {
		return idTea;
	}

	public void setIdTea(Integer idTea) {
		this.idTea = idTea;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getIdSize() {
		return idSize;
	}

	public void setIdSize(Integer idSize) {
		this.idSize = idSize;
	}

	public List<Integer> getIdToppings() {
		return idToppings;
	}

	public void setIdToppings(List<Integer> idToppings) {
		this.idToppings = idToppings;
	}

}
