package com.order_processing.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "detail_tea")
public class DetailTea {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "id_tea")
	private int idTea;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "price")
	private double price;
	
	@Column(name = "temp_total_price")
	private double tempTotalPrice;
	
	@JoinColumn(name = "id_size")
	@OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	private Size size;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinTable(
			name = "detail_topping",
			joinColumns = @JoinColumn(name = "id_detail_tea"),
			inverseJoinColumns = @JoinColumn(name = "id_topping"))
    private List<Topping> topping;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinTable(
			name = "detail_orders",
			joinColumns = @JoinColumn(name = "id_detail_tea"),
			inverseJoinColumns = @JoinColumn(name = "id_order"))
    private List<Order> order;

	public DetailTea() {
	}

	public DetailTea(int idTea, String name, String description, double price, double tempTotalPrice, Size size,
			List<Topping> topping, List<Order> order) {
		this.idTea = idTea;
		this.name = name;
		this.description = description;
		this.price = price;
		this.tempTotalPrice = tempTotalPrice;
		this.size = size;
		this.topping = topping;
		this.order = order;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getIdTea() {
		return idTea;
	}

	public void setIdTea(int idTea) {
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getTempTotalPrice() {
		return tempTotalPrice;
	}

	public void setTempTotalPrice(double tempTotalPrice) {
		this.tempTotalPrice = tempTotalPrice;
	}

	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}

	public List<Topping> getTopping() {
		return topping;
	}

	public void setTopping(List<Topping> topping) {
		this.topping = topping;
	}

	public List<Order> getOrder() {
		return order;
	}

	public void setOrder(List<Order> order) {
		this.order = order;
	}
	
}
