package control;

import conexion.Conexion;
import entidades.TblReservacion;
import entidades.TblTipoReservacion;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class TipoReservacionControlador {
    
    private EntityManager entityManager(){
        return Conexion.getObjConexion().getEMF().createEntityManager();
    }
    
    public List<TblTipoReservacion> ListarTodos(){
        EntityManager em = entityManager();
        try{
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery cq = cb.createQuery();
            Root<TblTipoReservacion> rt = cq.from(TblTipoReservacion.class);
            cq.select(rt);
            Query q = em.createQuery(cq);
            return q.getResultList();
        }finally{
            em.close();
        }
    }
    
    public List<TblTipoReservacion> ListarActivos(){
        EntityManager em = entityManager();
        try{
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery cq = cb.createQuery();
            Root<TblTipoReservacion> rt = cq.from(TblTipoReservacion.class);
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
    
    public List<TblTipoReservacion> tipoReservaciones(int Filtro){
        EntityManager em = entityManager();
        try{
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery cq = cb.createQuery();
            Root<TblTipoReservacion> rt = cq.from(TblTipoReservacion.class);
            cq.select(rt);
            Predicate activo = cb.equal(rt.get("Disponible"), 1);
            Predicate filtro = cb.equal(rt.get("idTipoReservacion"), Filtro);
            Predicate finalWhere = cb.and(filtro, activo);
            cq.where(finalWhere);
            Query q = em.createQuery(cq);
            return q.getResultList();
        }finally{
            em.close();
        }
    }
    
    public List<TblTipoReservacion> buscarId(int id){
        EntityManager em = entityManager();
        try{
            Query q = em.createQuery("SELECT t FROM TblTipoReservacion t WHERE t.idTipoReservacion = :id");
            q.setParameter("id", id);
            List<TblTipoReservacion> resultado = q.getResultList();
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
            TblTipoReservacion tipo;
            
            tipo = em.getReference(TblTipoReservacion.class, id);
            tipo.getIdTipoReservacion();
            
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
    
    public void Crear(TblTipoReservacion a){
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
    
    public void Editar(TblTipoReservacion a){
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
    
    public void EliminadoLogico(TblTipoReservacion a){
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
    
}
