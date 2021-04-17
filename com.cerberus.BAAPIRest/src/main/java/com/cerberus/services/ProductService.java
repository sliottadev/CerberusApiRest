package com.cerberus.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cerberus.models.Option;
import com.cerberus.models.Product;
import com.cerberus.models.PromotionItem;
import com.cerberus.repositories.IProductRepo;

@Service
public class ProductService implements IProductService {
	
	@Autowired
	private IProductRepo productRepo;
	
	@Override
	public Iterable<Product> GetProducts() {
		return productRepo.GetProducts();		
	}

	@Override
	public Iterable<Option> GetProductsOptions() {
		return productRepo.GetProductsOptions();
	}

	@Override
	public Iterable<Option> GetOptionsByProductId(Integer id) {
		return productRepo.GetOptionsByProductId(id);
	}

	@Override
	public Option GetOptionById(Integer id) {
		return productRepo.GetOptionById(id);
	}

	@Override
	public Product GetProductById(Integer id) {
		return productRepo.GetProductById(id);
	}

	@Override
	public Iterable<PromotionItem> GetPromotionItems() {
		return productRepo.GetPromotionItems();
	}

	@Override
	public Iterable<PromotionItem> GetPromotionItemByPromotionId(Integer id) {
		return productRepo.GetPromotionItemByPromotionId(id);
	}

	@Override
	public PromotionItem GetPromotionItemById(Integer id) {
		return productRepo.GetPromotionItemById(id);
	}

}
