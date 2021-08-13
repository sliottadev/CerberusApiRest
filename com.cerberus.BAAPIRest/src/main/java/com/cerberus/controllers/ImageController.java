package com.cerberus.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ImageController path: "../res/"
 * Controla ABM Imagenes, get de imagenes
 * Entidades Relacionadas: Image
 */
@RestController
@RequestMapping("api/res")
@CrossOrigin(origins = "http://localhost:4200")
public class ImageController {
}
