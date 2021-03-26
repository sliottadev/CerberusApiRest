package com.carberus.controllers;

import com.carberus.models.Option;
import com.carberus.models.Product;
import com.carberus.models.PromotionItem;
import com.carberus.repositories.IProductRepo;
import com.carberus.repositories.ProductRepo;

public class ProductController implements IProductController {

	private IProductRepo productRepo = new ProductRepo();
	
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
