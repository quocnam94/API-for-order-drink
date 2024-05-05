package com.order_processing.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.order_processing.dto.DetailTeaRequest;
import com.order_processing.dto.OrderRequest;
import com.order_processing.entity.Categories;
import com.order_processing.entity.DetailTea;
import com.order_processing.entity.Order;
import com.order_processing.entity.Size;
import com.order_processing.entity.Teas;
import com.order_processing.entity.Topping;
import com.order_processing.entity.Voucher;
import com.order_processing.service.CategoriesService;
import com.order_processing.service.DetailTeaService;
import com.order_processing.service.OrderService;
import com.order_processing.service.SizeService;
import com.order_processing.service.TeaService;
import com.order_processing.service.ToppingService;
import com.order_processing.service.VoucherService;

@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private CategoriesService categoriesService;
	@Autowired
	private TeaService teaService;
	@Autowired
	private SizeService sizeService;
	@Autowired
	private ToppingService toppingService;
	@Autowired
	private OrderService orderService;
	@Autowired
	private VoucherService voucherService;
	@Autowired
	private DetailTeaService detailTeaService;
	
	@GetMapping("/getCategories")
	public List<Categories> getCategories() {
		List<Categories> categories = categoriesService.findAll();
		return categories;
	}
	
	@GetMapping("/getTeas")
	public List<Teas> getTeas() {
		List<Teas> teas = teaService.findAll();
		return teas;
	}
	
	@GetMapping("/getTea/{teaId}")
	public Teas getTea(@PathVariable int teaId) {
		Teas tea = teaService.findById(teaId);
		return tea;
	}
	
	@PostMapping("/orderDetailTea")
	public DetailTea orderDetailTea(@RequestBody DetailTeaRequest request) {
		DetailTea detailTea = new DetailTea();
	    int idTea = request.getIdTea();
		Integer idSize = request.getIdSize();
		List<Integer> idToppings = request.getIdToppings();
		Teas tea = teaService.findById(idTea);
		Size sizeDetail = null;
		if (idSize != null) {
			sizeDetail = sizeService.findById(idSize).orElse(null);
		}
		List<Topping> toppingDetails = toppingService.findByIds(idToppings);
		detailTea.setIdTea(tea.getId());
		detailTea.setName(tea.getName());
		detailTea.setDescription(tea.getDescription());
		detailTea.setPrice(tea.getPrice());
		detailTea.setSize(sizeDetail);
	    detailTea.setTopping(toppingDetails);
	    double sizePrice = 0;
	    if (sizeDetail != null) {
		    sizePrice = sizeDetail.getPrice();
		}
		double teaPrice = tea.getPrice();
		double toppingPrice = 0;
		for (Topping topping : toppingDetails) {
			toppingPrice += topping.getPrice();
		}
		double tempTotalPrice = sizePrice + teaPrice + toppingPrice;
		detailTea.setTempTotalPrice(tempTotalPrice);
	    detailTeaService.save(detailTea);
		return detailTea;
	}
	
	@PostMapping("/sumOrder")
	public Order orders(@RequestBody OrderRequest request) {
	    Order order = new Order();
	    List<Integer> idDetailTeas = request.getIdDetailTeas();
	    Integer idVoucher = request.getIdVoucher();
	    String address = request.getAddress();
	    List<DetailTea> detailTeas = detailTeaService.findByIds(idDetailTeas);
	    Voucher detailVoucher = null;
	    if (idVoucher != null) {
	        detailVoucher = voucherService.findById(idVoucher).orElse(null);
	    }
	    order.setDetailTea(detailTeas);
	    double tempTotalPrice = 0;
	    for (DetailTea detailTea : detailTeas) {
	        tempTotalPrice += detailTea.getTempTotalPrice();
	    }
	    order.setTempTotalPrice(tempTotalPrice);
	    order.setVoucher(detailVoucher);
	    order.setAddress(address);
	    double shippingFee = 20000;
	    order.setShippingFee(shippingFee);
	    double totalPrice = tempTotalPrice;
	    if (detailVoucher != null && detailVoucher.getDiscount() < 1) {
	        totalPrice = tempTotalPrice * (1 - detailVoucher.getDiscount());
	    } else if (detailVoucher != null) {
	        totalPrice = tempTotalPrice - detailVoucher.getDiscount();
	    }
	    order.setTotalPrice(totalPrice + shippingFee);
	    orderService.save(order);
	    return order;
	}
	
}
