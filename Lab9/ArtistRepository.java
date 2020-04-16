package repo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import entity.Artist;
import util.PersistenceUtil;
public class ArtistRepository {
    EntityManagerFactory entityManagerFactory= PersistenceUtil.getEntityManageFactory();

    public void create(Artist artist){
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(artist);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
    public Artist findById(int id){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Artist Artist=entityManager.find(entity.Artist.class,id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return Artist;

    }
    public Artist findByName(String name){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        TypedQuery<Artist> query = entityManager.createNamedQuery("Artist.findByName",Artist.class);
        Artist result = query.setParameter("name",name).getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        return result;

    }


}
