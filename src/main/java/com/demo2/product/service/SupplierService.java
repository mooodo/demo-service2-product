/* 
 * Created by 2019年1月30日
 */
package com.demo2.product.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
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
	 * @param id the id of the supplier
	 * @return the supplier
	 */
	@GetMapping("orm/supplier/loadSupplier")
	public Supplier loadSupplier(@RequestParam("id")Long id);
	/**
	 * @param ids the list of ids of suppliers
	 * @return the list of suppliers by ids
	 */
	@GetMapping("orm/supplier/loadSuppliers")
	public List<Supplier> loadSuppliers(@RequestParam("ids") String ids);
}
