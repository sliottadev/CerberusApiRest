package com.cerberus.controllers;

import com.cerberus.helpers.Logger;
import com.cerberus.models.Product;
import com.cerberus.models.PromotionItem;
import com.cerberus.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * ProductController Path: "../products/"
 * Controla: ABM Productos, opciones de producto, promociones, categorias, etc.
 * Entidades Relacionadas: Category, Product,PromotionItem
 */
@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    IProductService productService;

    @Autowired
    Logger log;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping
    public Iterable<Product> GetProducts() {
        return productService.GetProducts();
    }

    @GetMapping("/{id}")
    public Product GetProductById(@PathVariable Integer id) {
        return productService.GetProductById(id);
    }

    @GetMapping("promotionItems")
    public Iterable<PromotionItem> GetPromotionItems() {
        return productService.GetPromotionItems();
    }

    @GetMapping("promotionItemsByPromotionId/{id}")
    public Iterable<PromotionItem> GetPromotionItemByPromotionId(@PathVariable Integer id) {
        return productService.GetPromotionItemByPromotionId(id);
    }

    @GetMapping("promotionItems/{id}")
    public PromotionItem GetPromotionItemById(@PathVariable Integer id) {
        return productService.GetPromotionItemById(id);
    }
}
