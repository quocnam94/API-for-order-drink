package com.order_processing.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
@Table(name = "orders")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "total_price")
	private double totalPrice;
	
	@Column(name = "temp_total_price")
	private double tempTotalPrice;
	
	@Column(name = "shipping_fee")
	private double shippingFee;

	@JsonIgnore	
	@ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinTable(
			name = "detail_orders",
			joinColumns = @JoinColumn(name="id_order"),
			inverseJoinColumns = @JoinColumn(name="id_detail_tea"))
	private List<DetailTea> detailTea;
	
	@JoinColumn(name = "id_voucher")
	@OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	private Voucher voucher;

	public Order() {
	}

	public Order(String address, double totalPrice, double tempTotalPrice, double shippingFee,
			List<DetailTea> detailTea, Voucher voucher) {
		this.address = address;
		this.totalPrice = totalPrice;
		this.tempTotalPrice = tempTotalPrice;
		this.shippingFee = shippingFee;
		this.detailTea = detailTea;
		this.voucher = voucher;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getTempTotalPrice() {
		return tempTotalPrice;
	}

	public void setTempTotalPrice(double tempTotalPrice) {
		this.tempTotalPrice = tempTotalPrice;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	public double getShippingFee() {
		return shippingFee;
	}

	public void setShippingFee(double shippingFee) {
		this.shippingFee = shippingFee;
	}

	public List<DetailTea> getDetailTea() {
		return detailTea;
	}

	public void setDetailTea(List<DetailTea> detailTea) {
		this.detailTea = detailTea;
	}

	public Voucher getVoucher() {
		return voucher;
	}

	public void setVoucher(Voucher voucher) {
		this.voucher = voucher;
	}

	
}
