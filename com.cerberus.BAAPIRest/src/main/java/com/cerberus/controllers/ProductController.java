package com.cerberus.controllers;

import com.cerberus.helpers.Logger;
import com.cerberus.models.Category;
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

    // Devuelve lista de todos los items por id de promocion. 1 pizza con 2 pintas
    @GetMapping("promotionItemsByPromotionId/{id}")
    public Iterable<PromotionItem> GetPromotionItemByPromotionId(@PathVariable Integer id) {
        return productService.GetPromotionItemByPromotionId(id);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/categories")
    public Iterable<Category> GetCategories() {
        return productService.GetCategories();
    }

    /*
    // No sirve por ahora
    // Devuelve lista de todos los promotion items. 1 pizza. 3 pintas. 2 pizzas. 2 pintas
    @GetMapping("promotionItems")
    public Iterable<PromotionItem> GetPromotionItems() {
        return productService.GetPromotionItems();
    }

    // Seguramente no se use, es el id de la tabla intermedia
    @GetMapping("promotionItems/{id}")
    public PromotionItem GetPromotionItemById(@PathVariable Integer id) {
        return productService.GetPromotionItemById(id);
    }
    */
}
