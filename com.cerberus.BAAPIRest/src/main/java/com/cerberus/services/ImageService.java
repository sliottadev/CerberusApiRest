package com.cerberus.services;

import com.cerberus.models.Image;
import com.cerberus.repositories.IImageRepo;
import com.cerberus.repositories.IOrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Servicios de Images.
 *
 * @author Cerberus
 * @see Image
 * @see IOrderRepo
 */
@Service
public class ImageService implements IImageService{
    @Autowired
    IImageRepo imageRepo;

    /**
     * Retorna la lista de images.
     *
     * @return lista de images
     */
    @Override
    public Iterable<Image> GetImages() {
        return imageRepo.GetImages();
    }

    /**
     * Busca un image por Id.
     *
     * @param id id de image a buscar
     * @return image existente
     */
    @Override
    public Image GetImageById(Integer id) {
        return imageRepo.GetImageById(id);
    }

    /**
     * Crea una nueva image.
     *
     * @param image image a crear
     * @return nueva image
     */
    public Image CreateImage(Image image) {
        return imageRepo.CreateImage(image);
    }

    /**
     * Actualiza image existente.
     *
     * @param image image a actualizar
     * @return image actualizada
     */
    public Image UpdateImage(Image image, Integer id) {
        return imageRepo.UpdateImage(image, id);
    }

    /**
     * Borra image existente.
     *
     * @param id id de image a eliminar
     */
    public void DeleteImage(Integer id) { imageRepo.DeleteImage(id);
    }

}
