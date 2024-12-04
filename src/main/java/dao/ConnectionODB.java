package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectionODB {
    public static EntityManager connect() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("./db/trabajadores.odb");
        EntityManager em = emf.createEntityManager();
        return em;
    }
}
