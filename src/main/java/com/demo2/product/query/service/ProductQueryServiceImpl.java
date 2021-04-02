/* 
 * Created by 2019年1月29日
 */
package com.demo2.product.query.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.demo2.support.entity.ResultSet;
import com.demo2.support.service.impl.QueryServiceImpl;
import com.demo2.product.entity.Product;
import com.demo2.product.entity.Supplier;
import com.demo2.product.service.SupplierService;

/**
 * The implement of the query service for products.
 * @author fangang
 */
public class ProductQueryServiceImpl extends QueryServiceImpl {
	@Autowired
	private SupplierService supplierService;

	@Override
	protected ResultSet afterQuery(Map<String, Object> params,
			ResultSet resultSet) {
		@SuppressWarnings("unchecked")
		List<Product> list = (List<Product>)resultSet.getData();
		for(Product product : list) {
			Long supplierId = product.getSupplierId();
			Supplier supplier = supplierService.loadSupplier(supplierId);
			product.setSupplier(supplier);
		}
		resultSet.setData(list);
		return resultSet;
	}
	
}
