package control;

import conexion.Conexion;
import entidades.TblEmpleados;
import entidades.TblReservacion;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.swing.JOptionPane;
import org.eclipse.persistence.jpa.JpaHelper;

public class ReservacionControlador {
    
    public static EntityManager entityManager(){
        return Conexion.getObjConexion().getEMF().createEntityManager();
    }
    
    public List<TblReservacion> ListarTodos(){
        EntityManager em = entityManager();
        try{
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery cq = cb.createQuery();
            Root<TblReservacion> rt = cq.from(TblReservacion.class);
            cq.select(rt);
            Query q = em.createQuery(cq);
            return q.getResultList();
        }finally{
            em.close();
        }
    }
    
    public List<TblReservacion> ListarActivos(){
        EntityManager em = entityManager();
        try{
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery cq = cb.createQuery();
            Root<TblReservacion> rt = cq.from(TblReservacion.class);
            cq.select(rt);
            Predicate activo = cb.equal(rt.get("disponible"), 1);
            cq.where(activo);
            Query q = em.createQuery(cq);
            return q.getResultList();
        }catch(Exception ex){
            System.out.println("ERROR: " + ex.getMessage());
        }finally{
            em.close();
        }
        return null;
    }
    
    public List<TblReservacion> buscarId(String id){
        EntityManager em = entityManager();
        try{
            Query q = em.createQuery("SELECT t FROM TblEmpleados t WHERE t.idEmpleado = :id");
            q.setParameter("id", id);
            List<TblReservacion> resultado = q.getResultList();
            return resultado;
        }finally{
            em.close();
        }
    }
    
    public void Eliminar(int id){
        EntityManager em = null;
        try{
            em = entityManager();
            em.getTransaction().begin();
            TblReservacion tipo;
            
            tipo = em.getReference(TblReservacion.class, id);
            tipo.getIdReservacion();
            
            em.remove(tipo);
            em.getTransaction().commit();
        }catch(Exception ex){
            System.out.println("ERROR: " + ex.getMessage());
        }finally{
            if (em != null) {
                em.close();
            }
        }
    }
    
    public void Crear(TblReservacion a){
        EntityManager em = entityManager();
        try{
            em.getTransaction().begin();
            em.persist(a);
            em.getTransaction().commit();
        }catch(Exception ex){
            System.out.println("ERROR: " + ex.getMessage());
        }finally{
            entityManager().close();
        }
    }
    
    public void Editar(TblReservacion a){
        EntityManager em = entityManager();
        try{
            em.getTransaction().begin();
            em.merge(a);
            em.getTransaction().commit();
        }catch(Exception ex){
            System.out.println("ERROR: " + ex.getMessage());
        }finally{
            entityManager().close();
        }
    }
    
    public int EliminadoLogico(int id){
        EntityManager em = entityManager();
        int update = 0;
        try{
            em.getTransaction().begin();
            Query q = em.createQuery("UPDATE TblReservacion t SET t.disponible = :activo WHERE t.idReservacion = :id");
            q.setParameter("activo", false);
            q.setParameter("id", id);
            update = q.executeUpdate();
            if (update > 0) {
                JOptionPane.showMessageDialog(null, "Se Eliminó Correctamente", "Usuario Eliminado", JOptionPane.INFORMATION_MESSAGE);
            }
            em.getTransaction().commit();
        }catch(Exception ex){
            System.out.println("ERROR: " + ex.getMessage());
        }finally{
            em.close();
        }
        return update;
    }
    
}
