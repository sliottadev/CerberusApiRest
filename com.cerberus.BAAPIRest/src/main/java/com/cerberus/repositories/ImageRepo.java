package com.cerberus.repositories;

import com.cerberus.enums.LoggerType;
import com.cerberus.helpers.Logger;
import com.cerberus.models.Image;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;

@Repository
public class ImageRepo implements IImageRepo{

    private EntityManagerFactory emf;
    private EntityManager manager;
    private Logger log;

    public ImageRepo() {
        this.emf = Persistence.createEntityManagerFactory("Persistencia");
        this.manager = emf.createEntityManager();
        this.log = new Logger();
    }

    @SuppressWarnings("unchecked")
    @Override
    public Iterable<Image> GetImages() {
        this.log.Write(LoggerType.LOG_START, "GetOrders");
        Iterable<Image> aux = new ArrayList<Image>();
        try {
            this.manager.getTransaction().begin();
            aux = this.manager.createQuery("FROM Image").getResultList();
            this.manager.getTransaction().commit();
            return aux;

        } catch (Exception e) {
            e.printStackTrace();
            this.log.Write(LoggerType.LOG_ERROR, "Error al obtener lista de Imagenes");
            this.manager.getTransaction().rollback();
            return null;
        }
        finally {
            this.log.Write(LoggerType.LOG_END, "GetImages");
        }
    }

    @Override
    public Image GetImageById(Integer id) {
        this.log.Write(LoggerType.LOG_START, "GetImageById = " + id.toString());
        Image aux = new Image();
        try {
            this.manager.getTransaction().begin();
            aux = (Image) this.manager.createQuery("FROM Image i WHERE i.imageId = " + id.toString()).getSingleResult();
            this.manager.getTransaction().commit();
            return aux;
        } catch (Exception e) {
            e.printStackTrace();
            this.log.Write(LoggerType.LOG_ERROR, "Error al obtener imagen id = " + id.toString());
            return null;
        }
        finally {
            this.log.Write(LoggerType.LOG_END, "GetImageById = " + id.toString());
        }
    }

    @Override
    public Image CreateImage(Image image) {
        this.manager.getTransaction().begin();
        this.manager.persist(image);
        this.manager.flush();
        this.manager.getTransaction().commit();
        return image;
    }

    @Override
    public Image UpdateImage(Image image, Integer id) {
        Image imageToUpdate = this.GetImageById(id);
        this.manager.getTransaction().begin();
        imageToUpdate.setImageId(image.getImageId());
        imageToUpdate.setFileName(image.getFileName());
        imageToUpdate.setDescription(image.getDescription());
        imageToUpdate.setData(image.getData());
        this.manager.flush();
        this.manager.getTransaction().commit();
        return imageToUpdate;
    }

    @Override
    public void DeleteImage(Integer id) {
        this.manager.getTransaction().begin();
        Query query = this.manager.createQuery("delete from Image WHERE id = " + id.toString());
        query.executeUpdate();
        this.manager.getTransaction().commit();
    }
}
