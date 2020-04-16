package util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceUtil {
    static EntityManagerFactory entityManagerFactory;

    public static EntityManagerFactory getEntityManageFactory() {

        if (entityManagerFactory == null) {
            entityManagerFactory = Persistence.createEntityManagerFactory("MusicAlbumsPU");
        }
        return entityManagerFactory;

    }

}


