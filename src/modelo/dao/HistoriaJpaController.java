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
import modelo.entidades.Historia;
import modelo.entidades.Paciente;

/**
 *
 * @author EddyA
 */
public class HistoriaJpaController implements Serializable {

    public HistoriaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Historia historia) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Paciente idpaciente = historia.getIdpaciente();
            if (idpaciente != null) {
                idpaciente = em.getReference(idpaciente.getClass(), idpaciente.getIdpaciente());
                historia.setIdpaciente(idpaciente);
            }
            em.persist(historia);
            if (idpaciente != null) {
                idpaciente.getHistoriaList().add(historia);
                idpaciente = em.merge(idpaciente);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Historia historia) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Historia persistentHistoria = em.find(Historia.class, historia.getIdhistoria());
            Paciente idpacienteOld = persistentHistoria.getIdpaciente();
            Paciente idpacienteNew = historia.getIdpaciente();
            if (idpacienteNew != null) {
                idpacienteNew = em.getReference(idpacienteNew.getClass(), idpacienteNew.getIdpaciente());
                historia.setIdpaciente(idpacienteNew);
            }
            historia = em.merge(historia);
            if (idpacienteOld != null && !idpacienteOld.equals(idpacienteNew)) {
                idpacienteOld.getHistoriaList().remove(historia);
                idpacienteOld = em.merge(idpacienteOld);
            }
            if (idpacienteNew != null && !idpacienteNew.equals(idpacienteOld)) {
                idpacienteNew.getHistoriaList().add(historia);
                idpacienteNew = em.merge(idpacienteNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = historia.getIdhistoria();
                if (findHistoria(id) == null) {
                    throw new NonexistentEntityException("The historia with id " + id + " no longer exists.");
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
            Historia historia;
            try {
                historia = em.getReference(Historia.class, id);
                historia.getIdhistoria();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The historia with id " + id + " no longer exists.", enfe);
            }
            Paciente idpaciente = historia.getIdpaciente();
            if (idpaciente != null) {
                idpaciente.getHistoriaList().remove(historia);
                idpaciente = em.merge(idpaciente);
            }
            em.remove(historia);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Historia> findHistoriaEntities() {
        return findHistoriaEntities(true, -1, -1);
    }

    public List<Historia> findHistoriaEntities(int maxResults, int firstResult) {
        return findHistoriaEntities(false, maxResults, firstResult);
    }

    private List<Historia> findHistoriaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Historia.class));
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

    public Historia findHistoria(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Historia.class, id);
        } finally {
            em.close();
        }
    }

    public int getHistoriaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Historia> rt = cq.from(Historia.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
