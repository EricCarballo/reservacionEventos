package conexion;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Conexion {
    private static Conexion objConexion = new Conexion();
    private EntityManagerFactory EMF;

    public Conexion() {
        EMF = Persistence.createEntityManagerFactory("ReservacionEventosPU");
    }
    
    public static Conexion getObjConexion() {
        return objConexion;
    }

    public EntityManagerFactory getEMF() {
        return EMF;
    }
}
