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
import modelo.entidades.Especialidad;
import modelo.entidades.Turno;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import modelo.dao.exceptions.NonexistentEntityException;
import modelo.entidades.Medico;

/**
 *
 * @author EddyA
 */
public class MedicoJpaController implements Serializable {

    public MedicoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Medico medico) {
        if (medico.getTurnoList() == null) {
            medico.setTurnoList(new ArrayList<Turno>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Especialidad idespecialidad = medico.getIdespecialidad();
            if (idespecialidad != null) {
                idespecialidad = em.getReference(idespecialidad.getClass(), idespecialidad.getIdespecialidad());
                medico.setIdespecialidad(idespecialidad);
            }
            List<Turno> attachedTurnoList = new ArrayList<Turno>();
            for (Turno turnoListTurnoToAttach : medico.getTurnoList()) {
                turnoListTurnoToAttach = em.getReference(turnoListTurnoToAttach.getClass(), turnoListTurnoToAttach.getIdturno());
                attachedTurnoList.add(turnoListTurnoToAttach);
            }
            medico.setTurnoList(attachedTurnoList);
            em.persist(medico);
            if (idespecialidad != null) {
                idespecialidad.getMedicoList().add(medico);
                idespecialidad = em.merge(idespecialidad);
            }
            for (Turno turnoListTurno : medico.getTurnoList()) {
                Medico oldIdmedicoOfTurnoListTurno = turnoListTurno.getIdmedico();
                turnoListTurno.setIdmedico(medico);
                turnoListTurno = em.merge(turnoListTurno);
                if (oldIdmedicoOfTurnoListTurno != null) {
                    oldIdmedicoOfTurnoListTurno.getTurnoList().remove(turnoListTurno);
                    oldIdmedicoOfTurnoListTurno = em.merge(oldIdmedicoOfTurnoListTurno);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Medico medico) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Medico persistentMedico = em.find(Medico.class, medico.getIdmedico());
            Especialidad idespecialidadOld = persistentMedico.getIdespecialidad();
            Especialidad idespecialidadNew = medico.getIdespecialidad();
            List<Turno> turnoListOld = persistentMedico.getTurnoList();
            List<Turno> turnoListNew = medico.getTurnoList();
            if (idespecialidadNew != null) {
                idespecialidadNew = em.getReference(idespecialidadNew.getClass(), idespecialidadNew.getIdespecialidad());
                medico.setIdespecialidad(idespecialidadNew);
            }
            List<Turno> attachedTurnoListNew = new ArrayList<Turno>();
            for (Turno turnoListNewTurnoToAttach : turnoListNew) {
                turnoListNewTurnoToAttach = em.getReference(turnoListNewTurnoToAttach.getClass(), turnoListNewTurnoToAttach.getIdturno());
                attachedTurnoListNew.add(turnoListNewTurnoToAttach);
            }
            turnoListNew = attachedTurnoListNew;
            medico.setTurnoList(turnoListNew);
            medico = em.merge(medico);
            if (idespecialidadOld != null && !idespecialidadOld.equals(idespecialidadNew)) {
                idespecialidadOld.getMedicoList().remove(medico);
                idespecialidadOld = em.merge(idespecialidadOld);
            }
            if (idespecialidadNew != null && !idespecialidadNew.equals(idespecialidadOld)) {
                idespecialidadNew.getMedicoList().add(medico);
                idespecialidadNew = em.merge(idespecialidadNew);
            }
            for (Turno turnoListOldTurno : turnoListOld) {
                if (!turnoListNew.contains(turnoListOldTurno)) {
                    turnoListOldTurno.setIdmedico(null);
                    turnoListOldTurno = em.merge(turnoListOldTurno);
                }
            }
            for (Turno turnoListNewTurno : turnoListNew) {
                if (!turnoListOld.contains(turnoListNewTurno)) {
                    Medico oldIdmedicoOfTurnoListNewTurno = turnoListNewTurno.getIdmedico();
                    turnoListNewTurno.setIdmedico(medico);
                    turnoListNewTurno = em.merge(turnoListNewTurno);
                    if (oldIdmedicoOfTurnoListNewTurno != null && !oldIdmedicoOfTurnoListNewTurno.equals(medico)) {
                        oldIdmedicoOfTurnoListNewTurno.getTurnoList().remove(turnoListNewTurno);
                        oldIdmedicoOfTurnoListNewTurno = em.merge(oldIdmedicoOfTurnoListNewTurno);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = medico.getIdmedico();
                if (findMedico(id) == null) {
                    throw new NonexistentEntityException("The medico with id " + id + " no longer exists.");
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
            Medico medico;
            try {
                medico = em.getReference(Medico.class, id);
                medico.getIdmedico();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The medico with id " + id + " no longer exists.", enfe);
            }
            Especialidad idespecialidad = medico.getIdespecialidad();
            if (idespecialidad != null) {
                idespecialidad.getMedicoList().remove(medico);
                idespecialidad = em.merge(idespecialidad);
            }
            List<Turno> turnoList = medico.getTurnoList();
            for (Turno turnoListTurno : turnoList) {
                turnoListTurno.setIdmedico(null);
                turnoListTurno = em.merge(turnoListTurno);
            }
            em.remove(medico);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Medico> findMedicoEntities() {
        return findMedicoEntities(true, -1, -1);
    }

    public List<Medico> findMedicoEntities(int maxResults, int firstResult) {
        return findMedicoEntities(false, maxResults, firstResult);
    }

    private List<Medico> findMedicoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Medico.class));
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

    public Medico findMedico(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Medico.class, id);
        } finally {
            em.close();
        }
    }

    public int getMedicoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Medico> rt = cq.from(Medico.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
