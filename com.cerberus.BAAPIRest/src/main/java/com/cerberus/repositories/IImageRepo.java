package com.cerberus.repositories;

import com.cerberus.models.Image;

public interface IImageRepo {
    public Iterable<Image> GetImages();

    public Image GetImageById(Integer id);

    public Image CreateImage(Image image);

    public Image UpdateImage(Image image, Integer id);

    public void DeleteImage(Integer id);

}
