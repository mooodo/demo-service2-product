/* 
 * Created by 2019年1月30日
 */
package com.demo2.product.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo2.product.entity.Supplier;
import com.demo2.product.service.impl.SupplierHystrixImpl;

/**
 * The service of suppliers.
 * @author fangang
 */
@FeignClient(value="service-supplier", fallback=SupplierHystrixImpl.class)
public interface SupplierService {
	/**
	 * @param id
	 * @return the supplier
	 */
	@RequestMapping(value = "orm/supplier/loadSupplier", method = RequestMethod.GET)
	public Supplier loadSupplier(@RequestParam("id")Long id);
	/**
	 * @param ids
	 * @return
	 */
	@PostMapping("orm/supplier/loadSuppliers")
	public List<Supplier> loadSuppliers(@RequestParam("ids") String ids);
	
	/**
	 * @return the list of supplier
	 */
	@GetMapping("orm/supplier/listOfSuppliers")
	public List<Supplier> listOfSuppliers();
}
