/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import modelo.entidades.Institucion;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import modelo.dao.exceptions.IllegalOrphanException;
import modelo.dao.exceptions.NonexistentEntityException;
import modelo.entidades.Localizacion;

/**
 *
 * @author JC-PC
 */
public class LocalizacionJpaController implements Serializable {

    public LocalizacionJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Localizacion localizacion) {
        if (localizacion.getInstitucionList() == null) {
            localizacion.setInstitucionList(new ArrayList<Institucion>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Institucion> attachedInstitucionList = new ArrayList<Institucion>();
            for (Institucion institucionListInstitucionToAttach : localizacion.getInstitucionList()) {
                institucionListInstitucionToAttach = em.getReference(institucionListInstitucionToAttach.getClass(), institucionListInstitucionToAttach.getIdinstitucion());
                attachedInstitucionList.add(institucionListInstitucionToAttach);
            }
            localizacion.setInstitucionList(attachedInstitucionList);
            em.persist(localizacion);
            for (Institucion institucionListInstitucion : localizacion.getInstitucionList()) {
                Localizacion oldIdlocalizacionOfInstitucionListInstitucion = institucionListInstitucion.getIdlocalizacion();
                institucionListInstitucion.setIdlocalizacion(localizacion);
                institucionListInstitucion = em.merge(institucionListInstitucion);
                if (oldIdlocalizacionOfInstitucionListInstitucion != null) {
                    oldIdlocalizacionOfInstitucionListInstitucion.getInstitucionList().remove(institucionListInstitucion);
                    oldIdlocalizacionOfInstitucionListInstitucion = em.merge(oldIdlocalizacionOfInstitucionListInstitucion);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Localizacion localizacion) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Localizacion persistentLocalizacion = em.find(Localizacion.class, localizacion.getId());
            List<Institucion> institucionListOld = persistentLocalizacion.getInstitucionList();
            List<Institucion> institucionListNew = localizacion.getInstitucionList();
            List<String> illegalOrphanMessages = null;
            for (Institucion institucionListOldInstitucion : institucionListOld) {
                if (!institucionListNew.contains(institucionListOldInstitucion)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Institucion " + institucionListOldInstitucion + " since its idlocalizacion field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<Institucion> attachedInstitucionListNew = new ArrayList<Institucion>();
            for (Institucion institucionListNewInstitucionToAttach : institucionListNew) {
                institucionListNewInstitucionToAttach = em.getReference(institucionListNewInstitucionToAttach.getClass(), institucionListNewInstitucionToAttach.getIdinstitucion());
                attachedInstitucionListNew.add(institucionListNewInstitucionToAttach);
            }
            institucionListNew = attachedInstitucionListNew;
            localizacion.setInstitucionList(institucionListNew);
            localizacion = em.merge(localizacion);
            for (Institucion institucionListNewInstitucion : institucionListNew) {
                if (!institucionListOld.contains(institucionListNewInstitucion)) {
                    Localizacion oldIdlocalizacionOfInstitucionListNewInstitucion = institucionListNewInstitucion.getIdlocalizacion();
                    institucionListNewInstitucion.setIdlocalizacion(localizacion);
                    institucionListNewInstitucion = em.merge(institucionListNewInstitucion);
                    if (oldIdlocalizacionOfInstitucionListNewInstitucion != null && !oldIdlocalizacionOfInstitucionListNewInstitucion.equals(localizacion)) {
                        oldIdlocalizacionOfInstitucionListNewInstitucion.getInstitucionList().remove(institucionListNewInstitucion);
                        oldIdlocalizacionOfInstitucionListNewInstitucion = em.merge(oldIdlocalizacionOfInstitucionListNewInstitucion);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = localizacion.getId();
                if (findLocalizacion(id) == null) {
                    throw new NonexistentEntityException("The localizacion with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Localizacion localizacion;
            try {
                localizacion = em.getReference(Localizacion.class, id);
                localizacion.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The localizacion with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Institucion> institucionListOrphanCheck = localizacion.getInstitucionList();
            for (Institucion institucionListOrphanCheckInstitucion : institucionListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Localizacion (" + localizacion + ") cannot be destroyed since the Institucion " + institucionListOrphanCheckInstitucion + " in its institucionList field has a non-nullable idlocalizacion field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(localizacion);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Localizacion> findLocalizacionEntities() {
        return findLocalizacionEntities(true, -1, -1);
    }

    public List<Localizacion> findLocalizacionEntities(int maxResults, int firstResult) {
        return findLocalizacionEntities(false, maxResults, firstResult);
    }

    private List<Localizacion> findLocalizacionEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Localizacion.class));
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

    public Localizacion findLocalizacion(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Localizacion.class, id);
        } finally {
            em.close();
        }
    }

    public int getLocalizacionCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Localizacion> rt = cq.from(Localizacion.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
