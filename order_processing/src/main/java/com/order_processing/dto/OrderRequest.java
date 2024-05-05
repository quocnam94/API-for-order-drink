package com.order_processing.dto;

import java.util.List;

public class OrderRequest {
	
	private String address;	
	private Integer idVoucher;
	private List<Integer> idDetailTeas;

	public OrderRequest() {
	}

	public OrderRequest(String address, Integer idVoucher, List<Integer> idDetailTeas) {
		this.address = address;
		this.idVoucher = idVoucher;
		this.idDetailTeas = idDetailTeas;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Integer> getIdDetailTeas() {
		return idDetailTeas;
	}

	public void setIdDetailTeas(List<Integer> idDetailTeas) {
		this.idDetailTeas = idDetailTeas;
	}

	public Integer getIdVoucher() {
		return idVoucher;
	}

	public void setIdVoucher(Integer idVoucher) {
		this.idVoucher = idVoucher;
	}
	
}
