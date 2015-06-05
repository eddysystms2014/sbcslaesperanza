/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import modelo.dao.exceptions.NonexistentEntityException;
import modelo.entidades.Divisionpolitica;
import modelo.entidades.Institucion;

/**
 *
 * @author JC-PC
 */
public class InstitucionJpaController implements Serializable {

    public InstitucionJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Institucion institucion) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Divisionpolitica idlocalizacion = institucion.getIdlocalizacion();
            if (idlocalizacion != null) {
                idlocalizacion = em.getReference(idlocalizacion.getClass(), idlocalizacion.getCodloc());
                institucion.setIdlocalizacion(idlocalizacion);
            }
            em.persist(institucion);
            if (idlocalizacion != null) {
                idlocalizacion.getInstitucionList().add(institucion);
                idlocalizacion = em.merge(idlocalizacion);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Institucion institucion) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Institucion persistentInstitucion = em.find(Institucion.class, institucion.getIdinstitucion());
            Divisionpolitica idlocalizacionOld = persistentInstitucion.getIdlocalizacion();
            Divisionpolitica idlocalizacionNew = institucion.getIdlocalizacion();
            if (idlocalizacionNew != null) {
                idlocalizacionNew = em.getReference(idlocalizacionNew.getClass(), idlocalizacionNew.getCodloc());
                institucion.setIdlocalizacion(idlocalizacionNew);
            }
            institucion = em.merge(institucion);
            if (idlocalizacionOld != null && !idlocalizacionOld.equals(idlocalizacionNew)) {
                idlocalizacionOld.getInstitucionList().remove(institucion);
                idlocalizacionOld = em.merge(idlocalizacionOld);
            }
            if (idlocalizacionNew != null && !idlocalizacionNew.equals(idlocalizacionOld)) {
                idlocalizacionNew.getInstitucionList().add(institucion);
                idlocalizacionNew = em.merge(idlocalizacionNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = institucion.getIdinstitucion();
                if (findInstitucion(id) == null) {
                    throw new NonexistentEntityException("The institucion with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Institucion institucion;
            try {
                institucion = em.getReference(Institucion.class, id);
                institucion.getIdinstitucion();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The institucion with id " + id + " no longer exists.", enfe);
            }
            Divisionpolitica idlocalizacion = institucion.getIdlocalizacion();
            if (idlocalizacion != null) {
                idlocalizacion.getInstitucionList().remove(institucion);
                idlocalizacion = em.merge(idlocalizacion);
            }
            em.remove(institucion);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Institucion> findInstitucionEntities() {
        return findInstitucionEntities(true, -1, -1);
    }

    public List<Institucion> findInstitucionEntities(int maxResults, int firstResult) {
        return findInstitucionEntities(false, maxResults, firstResult);
    }

    private List<Institucion> findInstitucionEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Institucion.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Institucion findInstitucion(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Institucion.class, id);
        } finally {
            em.close();
        }
    }

    public int getInstitucionCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Institucion> rt = cq.from(Institucion.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
