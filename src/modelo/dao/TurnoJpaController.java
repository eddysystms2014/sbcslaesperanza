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
import modelo.entidades.Medico;
import modelo.entidades.Paciente;
import modelo.entidades.Turno;

/**
 *
 * @author EddyA
 */
public class TurnoJpaController implements Serializable {

    public TurnoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Turno turno) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Medico idmedico = turno.getIdmedico();
            if (idmedico != null) {
                idmedico = em.getReference(idmedico.getClass(), idmedico.getIdmedico());
                turno.setIdmedico(idmedico);
            }
            Paciente idpaciente = turno.getIdpaciente();
            if (idpaciente != null) {
                idpaciente = em.getReference(idpaciente.getClass(), idpaciente.getIdpaciente());
                turno.setIdpaciente(idpaciente);
            }
            em.persist(turno);
            if (idmedico != null) {
                idmedico.getTurnoList().add(turno);
                idmedico = em.merge(idmedico);
            }
            if (idpaciente != null) {
                idpaciente.getTurnoList().add(turno);
                idpaciente = em.merge(idpaciente);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Turno turno) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Turno persistentTurno = em.find(Turno.class, turno.getIdturno());
            Medico idmedicoOld = persistentTurno.getIdmedico();
            Medico idmedicoNew = turno.getIdmedico();
            Paciente idpacienteOld = persistentTurno.getIdpaciente();
            Paciente idpacienteNew = turno.getIdpaciente();
            if (idmedicoNew != null) {
                idmedicoNew = em.getReference(idmedicoNew.getClass(), idmedicoNew.getIdmedico());
                turno.setIdmedico(idmedicoNew);
            }
            if (idpacienteNew != null) {
                idpacienteNew = em.getReference(idpacienteNew.getClass(), idpacienteNew.getIdpaciente());
                turno.setIdpaciente(idpacienteNew);
            }
            turno = em.merge(turno);
            if (idmedicoOld != null && !idmedicoOld.equals(idmedicoNew)) {
                idmedicoOld.getTurnoList().remove(turno);
                idmedicoOld = em.merge(idmedicoOld);
            }
            if (idmedicoNew != null && !idmedicoNew.equals(idmedicoOld)) {
                idmedicoNew.getTurnoList().add(turno);
                idmedicoNew = em.merge(idmedicoNew);
            }
            if (idpacienteOld != null && !idpacienteOld.equals(idpacienteNew)) {
                idpacienteOld.getTurnoList().remove(turno);
                idpacienteOld = em.merge(idpacienteOld);
            }
            if (idpacienteNew != null && !idpacienteNew.equals(idpacienteOld)) {
                idpacienteNew.getTurnoList().add(turno);
                idpacienteNew = em.merge(idpacienteNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = turno.getIdturno();
                if (findTurno(id) == null) {
                    throw new NonexistentEntityException("The turno with id " + id + " no longer exists.");
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
            Turno turno;
            try {
                turno = em.getReference(Turno.class, id);
                turno.getIdturno();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The turno with id " + id + " no longer exists.", enfe);
            }
            Medico idmedico = turno.getIdmedico();
            if (idmedico != null) {
                idmedico.getTurnoList().remove(turno);
                idmedico = em.merge(idmedico);
            }
            Paciente idpaciente = turno.getIdpaciente();
            if (idpaciente != null) {
                idpaciente.getTurnoList().remove(turno);
                idpaciente = em.merge(idpaciente);
            }
            em.remove(turno);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Turno> findTurnoEntities() {
        return findTurnoEntities(true, -1, -1);
    }

    public List<Turno> findTurnoEntities(int maxResults, int firstResult) {
        return findTurnoEntities(false, maxResults, firstResult);
    }

    private List<Turno> findTurnoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Turno.class));
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

    public Turno findTurno(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Turno.class, id);
        } finally {
            em.close();
        }
    }

    public int getTurnoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Turno> rt = cq.from(Turno.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
