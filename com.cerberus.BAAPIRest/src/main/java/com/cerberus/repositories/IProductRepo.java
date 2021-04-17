package com.cerberus.repositories;

import com.cerberus.models.Option;
import com.cerberus.models.Product;
import com.cerberus.models.PromotionItem;

public interface IProductRepo {

	public Iterable<Product> GetProducts();

	public Iterable<Option> GetProductsOptions();

	public Iterable<Option> GetOptionsByProductId(Integer id);

	public Option GetOptionById(Integer id);

	public Product GetProductById(Integer id);

	public Iterable<PromotionItem> GetPromotionItems();

	public Iterable<PromotionItem> GetPromotionItemByPromotionId(Integer id);

	public PromotionItem GetPromotionItemById(Integer id);


}
