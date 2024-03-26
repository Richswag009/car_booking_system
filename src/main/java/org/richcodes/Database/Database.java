package org.richcodes.Database;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Database {

    private static final EntityManagerFactory entityManagerFactory;
    static {
        entityManagerFactory = Persistence.createEntityManagerFactory("com.richcodes.hibernate");
    }
    public static EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }

}


