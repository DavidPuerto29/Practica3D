package dao;

import clases.Trabajador;

import javax.persistence.EntityManager;
import javax.persistence.RollbackException;

public class TrabajadorDAO {

    public static boolean insertarTrabajador(Trabajador empleado) {
        try {
            EntityManager em = ConnectionODB.connect();
            em.getTransaction().begin();
            em.persist(empleado);
            em.getTransaction().commit();
        }catch (RollbackException e){
            System.out.println("La transacción no ha podido ser realizada, volviendo al estado original.");
            return false;
        }
        return true;


    }
}
