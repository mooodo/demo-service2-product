/*
 * created by 2019年7月10日 上午9:30:18
 */
package com.demo2.product.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.demo2.product.entity.Supplier;
import com.demo2.product.service.SupplierService;

/**
 * The supplier service fallback class.
 * @author fangang
 */
@Component
public class SupplierHystrixImpl implements SupplierService {
	private static Supplier DEFAULT_DATA = new Supplier((long)0, "默认供应商");

	@Override
	public Supplier loadSupplier(Long id) {
		Supplier supplier = (Supplier)DEFAULT_DATA.clone();
		supplier.setId(id);
		return supplier;
	}

	@Override
	public List<Supplier> loadSuppliers(String ids) {
		List<Supplier> list = new ArrayList<>();
		if(ids==null) return list;
		String[] idArray = ids.split(",");
		for(String id : idArray) {
			Supplier supplier = (Supplier)DEFAULT_DATA.clone();
			supplier.setId(new Long(id));
			list.add(supplier);
		}
		return list;
	}

}
