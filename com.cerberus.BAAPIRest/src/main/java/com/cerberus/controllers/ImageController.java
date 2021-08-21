package com.cerberus.controllers;

import com.cerberus.models.Image;
import com.cerberus.models.Order;
import com.cerberus.services.IImageService;
import com.cerberus.services.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * ImageController path: "../res/"
 * Controla ABM Imagenes, get de imagenes
 * Entidades Relacionadas: Image
 */
@RestController
@RequestMapping("api/res")
@CrossOrigin(origins = "http://localhost:4200")
public class ImageController {
    @Autowired
    IImageService imageService;

    @PostMapping
    public Image CreateImage(@RequestBody Image image) {
        return imageService.CreateImage(image);
    }
}
