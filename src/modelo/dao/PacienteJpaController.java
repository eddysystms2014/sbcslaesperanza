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
import modelo.entidades.Turno;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import modelo.dao.exceptions.NonexistentEntityException;
import modelo.dao.exceptions.PreexistingEntityException;
import modelo.entidades.Historia;
import modelo.entidades.Paciente;

/**
 *
 * @author EddyA
 */
public class PacienteJpaController implements Serializable {

    public PacienteJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Paciente paciente) throws PreexistingEntityException, Exception {
        if (paciente.getTurnoList() == null) {
            paciente.setTurnoList(new ArrayList<Turno>());
        }
        if (paciente.getHistoriaList() == null) {
            paciente.setHistoriaList(new ArrayList<Historia>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Turno> attachedTurnoList = new ArrayList<Turno>();
            for (Turno turnoListTurnoToAttach : paciente.getTurnoList()) {
                turnoListTurnoToAttach = em.getReference(turnoListTurnoToAttach.getClass(), turnoListTurnoToAttach.getIdturno());
                attachedTurnoList.add(turnoListTurnoToAttach);
            }
            paciente.setTurnoList(attachedTurnoList);
            List<Historia> attachedHistoriaList = new ArrayList<Historia>();
            for (Historia historiaListHistoriaToAttach : paciente.getHistoriaList()) {
                historiaListHistoriaToAttach = em.getReference(historiaListHistoriaToAttach.getClass(), historiaListHistoriaToAttach.getIdhistoria());
                attachedHistoriaList.add(historiaListHistoriaToAttach);
            }
            paciente.setHistoriaList(attachedHistoriaList);
            em.persist(paciente);
            for (Turno turnoListTurno : paciente.getTurnoList()) {
                Paciente oldIdpacienteOfTurnoListTurno = turnoListTurno.getIdpaciente();
                turnoListTurno.setIdpaciente(paciente);
                turnoListTurno = em.merge(turnoListTurno);
                if (oldIdpacienteOfTurnoListTurno != null) {
                    oldIdpacienteOfTurnoListTurno.getTurnoList().remove(turnoListTurno);
                    oldIdpacienteOfTurnoListTurno = em.merge(oldIdpacienteOfTurnoListTurno);
                }
            }
            for (Historia historiaListHistoria : paciente.getHistoriaList()) {
                Paciente oldIdpacienteOfHistoriaListHistoria = historiaListHistoria.getIdpaciente();
                historiaListHistoria.setIdpaciente(paciente);
                historiaListHistoria = em.merge(historiaListHistoria);
                if (oldIdpacienteOfHistoriaListHistoria != null) {
                    oldIdpacienteOfHistoriaListHistoria.getHistoriaList().remove(historiaListHistoria);
                    oldIdpacienteOfHistoriaListHistoria = em.merge(oldIdpacienteOfHistoriaListHistoria);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPaciente(paciente.getIdpaciente()) != null) {
                throw new PreexistingEntityException("Paciente " + paciente + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Paciente paciente) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Paciente persistentPaciente = em.find(Paciente.class, paciente.getIdpaciente());
            List<Turno> turnoListOld = persistentPaciente.getTurnoList();
            List<Turno> turnoListNew = paciente.getTurnoList();
            List<Historia> historiaListOld = persistentPaciente.getHistoriaList();
            List<Historia> historiaListNew = paciente.getHistoriaList();
            List<Turno> attachedTurnoListNew = new ArrayList<Turno>();
            for (Turno turnoListNewTurnoToAttach : turnoListNew) {
                turnoListNewTurnoToAttach = em.getReference(turnoListNewTurnoToAttach.getClass(), turnoListNewTurnoToAttach.getIdturno());
                attachedTurnoListNew.add(turnoListNewTurnoToAttach);
            }
            turnoListNew = attachedTurnoListNew;
            paciente.setTurnoList(turnoListNew);
            List<Historia> attachedHistoriaListNew = new ArrayList<Historia>();
            for (Historia historiaListNewHistoriaToAttach : historiaListNew) {
                historiaListNewHistoriaToAttach = em.getReference(historiaListNewHistoriaToAttach.getClass(), historiaListNewHistoriaToAttach.getIdhistoria());
                attachedHistoriaListNew.add(historiaListNewHistoriaToAttach);
            }
            historiaListNew = attachedHistoriaListNew;
            paciente.setHistoriaList(historiaListNew);
            paciente = em.merge(paciente);
            for (Turno turnoListOldTurno : turnoListOld) {
                if (!turnoListNew.contains(turnoListOldTurno)) {
                    turnoListOldTurno.setIdpaciente(null);
                    turnoListOldTurno = em.merge(turnoListOldTurno);
                }
            }
            for (Turno turnoListNewTurno : turnoListNew) {
                if (!turnoListOld.contains(turnoListNewTurno)) {
                    Paciente oldIdpacienteOfTurnoListNewTurno = turnoListNewTurno.getIdpaciente();
                    turnoListNewTurno.setIdpaciente(paciente);
                    turnoListNewTurno = em.merge(turnoListNewTurno);
                    if (oldIdpacienteOfTurnoListNewTurno != null && !oldIdpacienteOfTurnoListNewTurno.equals(paciente)) {
                        oldIdpacienteOfTurnoListNewTurno.getTurnoList().remove(turnoListNewTurno);
                        oldIdpacienteOfTurnoListNewTurno = em.merge(oldIdpacienteOfTurnoListNewTurno);
                    }
                }
            }
            for (Historia historiaListOldHistoria : historiaListOld) {
                if (!historiaListNew.contains(historiaListOldHistoria)) {
                    historiaListOldHistoria.setIdpaciente(null);
                    historiaListOldHistoria = em.merge(historiaListOldHistoria);
                }
            }
            for (Historia historiaListNewHistoria : historiaListNew) {
                if (!historiaListOld.contains(historiaListNewHistoria)) {
                    Paciente oldIdpacienteOfHistoriaListNewHistoria = historiaListNewHistoria.getIdpaciente();
                    historiaListNewHistoria.setIdpaciente(paciente);
                    historiaListNewHistoria = em.merge(historiaListNewHistoria);
                    if (oldIdpacienteOfHistoriaListNewHistoria != null && !oldIdpacienteOfHistoriaListNewHistoria.equals(paciente)) {
                        oldIdpacienteOfHistoriaListNewHistoria.getHistoriaList().remove(historiaListNewHistoria);
                        oldIdpacienteOfHistoriaListNewHistoria = em.merge(oldIdpacienteOfHistoriaListNewHistoria);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = paciente.getIdpaciente();
                if (findPaciente(id) == null) {
                    throw new NonexistentEntityException("The paciente with id " + id + " no longer exists.");
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
            Paciente paciente;
            try {
                paciente = em.getReference(Paciente.class, id);
                paciente.getIdpaciente();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The paciente with id " + id + " no longer exists.", enfe);
            }
            List<Turno> turnoList = paciente.getTurnoList();
            for (Turno turnoListTurno : turnoList) {
                turnoListTurno.setIdpaciente(null);
                turnoListTurno = em.merge(turnoListTurno);
            }
            List<Historia> historiaList = paciente.getHistoriaList();
            for (Historia historiaListHistoria : historiaList) {
                historiaListHistoria.setIdpaciente(null);
                historiaListHistoria = em.merge(historiaListHistoria);
            }
            em.remove(paciente);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Paciente> findPacienteEntities() {
        return findPacienteEntities(true, -1, -1);
    }

    public List<Paciente> findPacienteEntities(int maxResults, int firstResult) {
        return findPacienteEntities(false, maxResults, firstResult);
    }

    private List<Paciente> findPacienteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Paciente.class));
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

    public Paciente findPaciente(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Paciente.class, id);
        } finally {
            em.close();
        }
    }

    public int getPacienteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Paciente> rt = cq.from(Paciente.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
