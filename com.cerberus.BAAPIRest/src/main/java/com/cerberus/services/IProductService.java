package com.cerberus.services;

import com.cerberus.models.Category;
import com.cerberus.models.Product;
import com.cerberus.models.PromotionItem;

public interface IProductService {

	public Iterable<Product> GetProducts();

	public Product GetProductById(Integer id);

	public Iterable<Category> GetCategories();

	public Iterable<PromotionItem> GetPromotionItemByPromotionId(Integer id);
}
