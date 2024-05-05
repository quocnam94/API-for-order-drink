package com.order_processing.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "topping")
public class Topping {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "price")
	private double price;
	
	@JsonIgnore
	@ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinTable(
			name = "detail_topping",
			joinColumns = @JoinColumn(name="id_topping"),
			inverseJoinColumns = @JoinColumn(name="id_detail_tea"))
	private List<DetailTea> detailTea;

	public Topping() {
	}

	public Topping(int id, String name, double price, List<DetailTea> detailTea) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.detailTea = detailTea;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public List<DetailTea> getDetailTea() {
		return detailTea;
	}

	public void setDetailTea(List<DetailTea> detailTea) {
		this.detailTea = detailTea;
	}
			
}
