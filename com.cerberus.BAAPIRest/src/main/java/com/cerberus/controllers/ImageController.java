package com.cerberus.controllers;

import com.cerberus.models.Image;
import com.cerberus.models.Image;
import com.cerberus.services.IImageService;
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

    @GetMapping
    public Iterable<Image> GetImages() {
        return imageService.GetImages();
    }

    @GetMapping("/{id}")
    public Image GetImageById(@PathVariable Integer id) {
        return imageService.GetImageById(id);
    }

    @PostMapping
    public Image CreateImage(@RequestBody Image image) {
        return imageService.CreateImage(image);
    }

    @PutMapping("/{id}")
    public Image UpdateImage(@RequestBody Image order, @PathVariable Integer id) {
        return imageService.UpdateImage(order, id);
    }

    @DeleteMapping("/{id}")
    public void DeleteImage(@PathVariable Integer id) {
        imageService.DeleteImage(id);
    }
}
