package repo;
import entity.Album;
import entity.Artist;
import util.PersistenceUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

public class AlbumRepository {
    EntityManagerFactory entityManagerFactory= PersistenceUtil.getEntityManageFactory();

    public void create(Artist artist){
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(artist);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
    public Album findById(int id){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Album album=entityManager.find(Album.class,id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return album;

    }
    public Album findByName(String name){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        TypedQuery<Album> query = entityManager.createNamedQuery("Album.findByName",Album.class);
        Album result = query.setParameter("name",name).getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        return result;

    }
    public Album findByArtist(int id){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        TypedQuery<Album> query = entityManager.createNamedQuery("Album.findByArtist",Album.class);
        Album result = query.setParameter("artistid",id).getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        return result;

    }



}
