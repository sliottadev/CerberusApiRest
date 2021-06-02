package com.cerberus.services;

import com.cerberus.models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public Product GetProductById(Integer id) {
		return productRepo.GetProductById(id);
	}

	@Override
	public Iterable<Category> GetCategories() {
		return productRepo.GetCategories();
	}

	@Override
	public Iterable<PromotionItem> GetPromotionItemByPromotionId(Integer id) {
		return productRepo.GetPromotionItemByPromotionId(id);
	}
}
