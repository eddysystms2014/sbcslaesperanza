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
import modelo.entidades.Divisionpolitica;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import modelo.dao.exceptions.NonexistentEntityException;
import modelo.dao.exceptions.PreexistingEntityException;
import modelo.entidades.Institucion;

/**
 *
 * @author JC-PC
 */
public class DivisionpoliticaJpaController implements Serializable {

    public DivisionpoliticaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Divisionpolitica divisionpolitica) throws PreexistingEntityException, Exception {
        if (divisionpolitica.getDivisionpoliticaList() == null) {
            divisionpolitica.setDivisionpoliticaList(new ArrayList<Divisionpolitica>());
        }
        if (divisionpolitica.getInstitucionList() == null) {
            divisionpolitica.setInstitucionList(new ArrayList<Institucion>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Divisionpolitica divCodloc = divisionpolitica.getDivCodloc();
            if (divCodloc != null) {
                divCodloc = em.getReference(divCodloc.getClass(), divCodloc.getCodloc());
                divisionpolitica.setDivCodloc(divCodloc);
            }
            List<Divisionpolitica> attachedDivisionpoliticaList = new ArrayList<Divisionpolitica>();
            for (Divisionpolitica divisionpoliticaListDivisionpoliticaToAttach : divisionpolitica.getDivisionpoliticaList()) {
                divisionpoliticaListDivisionpoliticaToAttach = em.getReference(divisionpoliticaListDivisionpoliticaToAttach.getClass(), divisionpoliticaListDivisionpoliticaToAttach.getCodloc());
                attachedDivisionpoliticaList.add(divisionpoliticaListDivisionpoliticaToAttach);
            }
            divisionpolitica.setDivisionpoliticaList(attachedDivisionpoliticaList);
            List<Institucion> attachedInstitucionList = new ArrayList<Institucion>();
            for (Institucion institucionListInstitucionToAttach : divisionpolitica.getInstitucionList()) {
                institucionListInstitucionToAttach = em.getReference(institucionListInstitucionToAttach.getClass(), institucionListInstitucionToAttach.getIdinstitucion());
                attachedInstitucionList.add(institucionListInstitucionToAttach);
            }
            divisionpolitica.setInstitucionList(attachedInstitucionList);
            em.persist(divisionpolitica);
            if (divCodloc != null) {
                divCodloc.getDivisionpoliticaList().add(divisionpolitica);
                divCodloc = em.merge(divCodloc);
            }
            for (Divisionpolitica divisionpoliticaListDivisionpolitica : divisionpolitica.getDivisionpoliticaList()) {
                Divisionpolitica oldDivCodlocOfDivisionpoliticaListDivisionpolitica = divisionpoliticaListDivisionpolitica.getDivCodloc();
                divisionpoliticaListDivisionpolitica.setDivCodloc(divisionpolitica);
                divisionpoliticaListDivisionpolitica = em.merge(divisionpoliticaListDivisionpolitica);
                if (oldDivCodlocOfDivisionpoliticaListDivisionpolitica != null) {
                    oldDivCodlocOfDivisionpoliticaListDivisionpolitica.getDivisionpoliticaList().remove(divisionpoliticaListDivisionpolitica);
                    oldDivCodlocOfDivisionpoliticaListDivisionpolitica = em.merge(oldDivCodlocOfDivisionpoliticaListDivisionpolitica);
                }
            }
            for (Institucion institucionListInstitucion : divisionpolitica.getInstitucionList()) {
                Divisionpolitica oldIdlocalizacionOfInstitucionListInstitucion = institucionListInstitucion.getIdlocalizacion();
                institucionListInstitucion.setIdlocalizacion(divisionpolitica);
                institucionListInstitucion = em.merge(institucionListInstitucion);
                if (oldIdlocalizacionOfInstitucionListInstitucion != null) {
                    oldIdlocalizacionOfInstitucionListInstitucion.getInstitucionList().remove(institucionListInstitucion);
                    oldIdlocalizacionOfInstitucionListInstitucion = em.merge(oldIdlocalizacionOfInstitucionListInstitucion);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findDivisionpolitica(divisionpolitica.getCodloc()) != null) {
                throw new PreexistingEntityException("Divisionpolitica " + divisionpolitica + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Divisionpolitica divisionpolitica) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Divisionpolitica persistentDivisionpolitica = em.find(Divisionpolitica.class, divisionpolitica.getCodloc());
            Divisionpolitica divCodlocOld = persistentDivisionpolitica.getDivCodloc();
            Divisionpolitica divCodlocNew = divisionpolitica.getDivCodloc();
            List<Divisionpolitica> divisionpoliticaListOld = persistentDivisionpolitica.getDivisionpoliticaList();
            List<Divisionpolitica> divisionpoliticaListNew = divisionpolitica.getDivisionpoliticaList();
            List<Institucion> institucionListOld = persistentDivisionpolitica.getInstitucionList();
            List<Institucion> institucionListNew = divisionpolitica.getInstitucionList();
            if (divCodlocNew != null) {
                divCodlocNew = em.getReference(divCodlocNew.getClass(), divCodlocNew.getCodloc());
                divisionpolitica.setDivCodloc(divCodlocNew);
            }
            List<Divisionpolitica> attachedDivisionpoliticaListNew = new ArrayList<Divisionpolitica>();
            for (Divisionpolitica divisionpoliticaListNewDivisionpoliticaToAttach : divisionpoliticaListNew) {
                divisionpoliticaListNewDivisionpoliticaToAttach = em.getReference(divisionpoliticaListNewDivisionpoliticaToAttach.getClass(), divisionpoliticaListNewDivisionpoliticaToAttach.getCodloc());
                attachedDivisionpoliticaListNew.add(divisionpoliticaListNewDivisionpoliticaToAttach);
            }
            divisionpoliticaListNew = attachedDivisionpoliticaListNew;
            divisionpolitica.setDivisionpoliticaList(divisionpoliticaListNew);
            List<Institucion> attachedInstitucionListNew = new ArrayList<Institucion>();
            for (Institucion institucionListNewInstitucionToAttach : institucionListNew) {
                institucionListNewInstitucionToAttach = em.getReference(institucionListNewInstitucionToAttach.getClass(), institucionListNewInstitucionToAttach.getIdinstitucion());
                attachedInstitucionListNew.add(institucionListNewInstitucionToAttach);
            }
            institucionListNew = attachedInstitucionListNew;
            divisionpolitica.setInstitucionList(institucionListNew);
            divisionpolitica = em.merge(divisionpolitica);
            if (divCodlocOld != null && !divCodlocOld.equals(divCodlocNew)) {
                divCodlocOld.getDivisionpoliticaList().remove(divisionpolitica);
                divCodlocOld = em.merge(divCodlocOld);
            }
            if (divCodlocNew != null && !divCodlocNew.equals(divCodlocOld)) {
                divCodlocNew.getDivisionpoliticaList().add(divisionpolitica);
                divCodlocNew = em.merge(divCodlocNew);
            }
            for (Divisionpolitica divisionpoliticaListOldDivisionpolitica : divisionpoliticaListOld) {
                if (!divisionpoliticaListNew.contains(divisionpoliticaListOldDivisionpolitica)) {
                    divisionpoliticaListOldDivisionpolitica.setDivCodloc(null);
                    divisionpoliticaListOldDivisionpolitica = em.merge(divisionpoliticaListOldDivisionpolitica);
                }
            }
            for (Divisionpolitica divisionpoliticaListNewDivisionpolitica : divisionpoliticaListNew) {
                if (!divisionpoliticaListOld.contains(divisionpoliticaListNewDivisionpolitica)) {
                    Divisionpolitica oldDivCodlocOfDivisionpoliticaListNewDivisionpolitica = divisionpoliticaListNewDivisionpolitica.getDivCodloc();
                    divisionpoliticaListNewDivisionpolitica.setDivCodloc(divisionpolitica);
                    divisionpoliticaListNewDivisionpolitica = em.merge(divisionpoliticaListNewDivisionpolitica);
                    if (oldDivCodlocOfDivisionpoliticaListNewDivisionpolitica != null && !oldDivCodlocOfDivisionpoliticaListNewDivisionpolitica.equals(divisionpolitica)) {
                        oldDivCodlocOfDivisionpoliticaListNewDivisionpolitica.getDivisionpoliticaList().remove(divisionpoliticaListNewDivisionpolitica);
                        oldDivCodlocOfDivisionpoliticaListNewDivisionpolitica = em.merge(oldDivCodlocOfDivisionpoliticaListNewDivisionpolitica);
                    }
                }
            }
            for (Institucion institucionListOldInstitucion : institucionListOld) {
                if (!institucionListNew.contains(institucionListOldInstitucion)) {
                    institucionListOldInstitucion.setIdlocalizacion(null);
                    institucionListOldInstitucion = em.merge(institucionListOldInstitucion);
                }
            }
            for (Institucion institucionListNewInstitucion : institucionListNew) {
                if (!institucionListOld.contains(institucionListNewInstitucion)) {
                    Divisionpolitica oldIdlocalizacionOfInstitucionListNewInstitucion = institucionListNewInstitucion.getIdlocalizacion();
                    institucionListNewInstitucion.setIdlocalizacion(divisionpolitica);
                    institucionListNewInstitucion = em.merge(institucionListNewInstitucion);
                    if (oldIdlocalizacionOfInstitucionListNewInstitucion != null && !oldIdlocalizacionOfInstitucionListNewInstitucion.equals(divisionpolitica)) {
                        oldIdlocalizacionOfInstitucionListNewInstitucion.getInstitucionList().remove(institucionListNewInstitucion);
                        oldIdlocalizacionOfInstitucionListNewInstitucion = em.merge(oldIdlocalizacionOfInstitucionListNewInstitucion);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = divisionpolitica.getCodloc();
                if (findDivisionpolitica(id) == null) {
                    throw new NonexistentEntityException("The divisionpolitica with id " + id + " no longer exists.");
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
            Divisionpolitica divisionpolitica;
            try {
                divisionpolitica = em.getReference(Divisionpolitica.class, id);
                divisionpolitica.getCodloc();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The divisionpolitica with id " + id + " no longer exists.", enfe);
            }
            Divisionpolitica divCodloc = divisionpolitica.getDivCodloc();
            if (divCodloc != null) {
                divCodloc.getDivisionpoliticaList().remove(divisionpolitica);
                divCodloc = em.merge(divCodloc);
            }
            List<Divisionpolitica> divisionpoliticaList = divisionpolitica.getDivisionpoliticaList();
            for (Divisionpolitica divisionpoliticaListDivisionpolitica : divisionpoliticaList) {
                divisionpoliticaListDivisionpolitica.setDivCodloc(null);
                divisionpoliticaListDivisionpolitica = em.merge(divisionpoliticaListDivisionpolitica);
            }
            List<Institucion> institucionList = divisionpolitica.getInstitucionList();
            for (Institucion institucionListInstitucion : institucionList) {
                institucionListInstitucion.setIdlocalizacion(null);
                institucionListInstitucion = em.merge(institucionListInstitucion);
            }
            em.remove(divisionpolitica);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Divisionpolitica> findDivisionpoliticaEntities() {
        return findDivisionpoliticaEntities(true, -1, -1);
    }

    public List<Divisionpolitica> findDivisionpoliticaEntities(int maxResults, int firstResult) {
        return findDivisionpoliticaEntities(false, maxResults, firstResult);
    }

    private List<Divisionpolitica> findDivisionpoliticaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Divisionpolitica.class));
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

    public Divisionpolitica findDivisionpolitica(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Divisionpolitica.class, id);
        } finally {
            em.close();
        }
    }

    public int getDivisionpoliticaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Divisionpolitica> rt = cq.from(Divisionpolitica.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
