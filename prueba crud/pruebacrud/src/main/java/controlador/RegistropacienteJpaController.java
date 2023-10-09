/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import controlador.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import modelo.Registropaciente;

/**
 *
 * @author ferna
 */
public class RegistropacienteJpaController implements Serializable {

    public RegistropacienteJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    //direccionar hacia la persistencia
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("miDB");

    //crear la entidad
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    //constructor vacio
    public RegistropacienteJpaController() {
    }

    public void create(Registropaciente registropaciente) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(registropaciente);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Registropaciente registropaciente) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            registropaciente = em.merge(registropaciente);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = registropaciente.getIdpaciente();
                if (findRegistropaciente(id) == null) {
                    throw new NonexistentEntityException("The registropaciente with id " + id + " no longer exists.");
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
            Registropaciente registropaciente;
            try {
                registropaciente = em.getReference(Registropaciente.class, id);
                registropaciente.getIdpaciente();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The registropaciente with id " + id + " no longer exists.", enfe);
            }
            em.remove(registropaciente);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Registropaciente> findRegistropacienteEntities() {
        return findRegistropacienteEntities(true, -1, -1);
    }

    public List<Registropaciente> findRegistropacienteEntities(int maxResults, int firstResult) {
        return findRegistropacienteEntities(false, maxResults, firstResult);
    }

    private List<Registropaciente> findRegistropacienteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Registropaciente.class));
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

    public Registropaciente findRegistropaciente(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Registropaciente.class, id);
        } finally {
            em.close();
        }
    }

    public int getRegistropacienteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Registropaciente> rt = cq.from(Registropaciente.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
