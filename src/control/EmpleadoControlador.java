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

public class EmpleadoControlador {
    
    public static EntityManager entityManager(){
        return Conexion.getObjConexion().getEMF().createEntityManager();
    }
    
    public List<TblEmpleados> ListarTodos(){
        EntityManager em = entityManager();
        try{
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery cq = cb.createQuery();
            Root<TblReservacion> rt = cq.from(TblEmpleados.class);
            cq.select(rt);
            Query q = em.createQuery(cq);
            return q.getResultList();
        }finally{
            em.close();
        }
    }
    
    public List<TblEmpleados> ListarActivos(){
        EntityManager em = entityManager();
        try{
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery cq = cb.createQuery();
            Root<TblEmpleados> rt = cq.from(TblEmpleados.class);
            cq.select(rt);
            Predicate activo = cb.equal(rt.get("activo"), 1);
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
    
    public boolean Login(String User, String Pass){
        EntityManager em = entityManager();
        boolean existente;
        try{
            Query q = em.createQuery("SELECT t.usuario, t.contrasenia FROM TblEmpleados t WHERE t.usuario = :usuario AND t.contrasenia = :contrasenia AND t.activo = 1");
            q.setParameter("usuario", User);
            q.setParameter("contrasenia", Pass);
            List resultado = q.getResultList();
            if(resultado.size() > 0){
                existente = true;
            }else{
                existente = false;
            }
        }catch(Exception ex){
            existente = false;
            System.out.println("ERROR: " + ex.getMessage());
        }
        return existente;
    }
    
    public List<TblEmpleados> obtenerNombre(String user, String pass){
        EntityManager em = entityManager();
        try{
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery cq = cb.createQuery();
            Root<TblEmpleados> rt = cq.from(TblEmpleados.class);
            cq.select(rt);
            Predicate USER = cb.equal(rt.get("usuario"), user);
            Predicate PASS = cb.equal(rt.get("contrasenia"), pass);
            Predicate finalWhere = cb.and(USER, PASS);
            cq.where(finalWhere);
            Query q = em.createQuery(cq);
            return q.getResultList();
        }finally{
            em.close();
        }
    }
    
    public List<TblEmpleados> buscarId(int id){
        EntityManager em = entityManager();
        try{
            Query q = em.createQuery("SELECT t FROM TblEmpleados t WHERE t.idEmpleado = :id");
            q.setParameter("id", id);
            List<TblEmpleados> resultado = q.getResultList();
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
            TblEmpleados tipo;
            
            tipo = em.getReference(TblEmpleados.class, id);
            tipo.getIdEmpleado();
            
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
    
    public void Crear(TblEmpleados a){
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
    
    public void Editar(TblEmpleados a){
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
            Query q = em.createQuery("UPDATE TblEmpleados t SET t.activo = :activo WHERE t.idEmpleado = :id");
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
