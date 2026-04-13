package session;

import entity.Barbero;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Stateless
public class BarberoFacade extends AbstractFacade<Barbero> 
                            implements BarberoFacadeLocal {

    @PersistenceContext(unitName = "LaboratorioN2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BarberoFacade() {
        super(Barbero.class);
    }

    public Barbero findById(Long id) {
        try {
            Query q = em.createNamedQuery("Barbero.findByIdBarbero");
            q.setParameter("idBarbero", id);
            return (Barbero) q.getSingleResult();
        } catch (Exception e) {
            System.out.print("Excepcion: " + e);
            return null;
        }
    }
    
    public List<Barbero> findByName(String name) {        
    String $name = "%" + name.replaceAll(" ", "%") + "%";        
    CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();          
    CriteriaQuery<Barbero> criteriaQuery = 
    criteriaBuilder.createQuery(Barbero.class);        
    Root<Barbero> barbero = criteriaQuery.from(Barbero.class);        
    criteriaQuery.select(barbero);        
    criteriaQuery.where(criteriaBuilder.like(barbero.get("Nombres").as(String.class)
    , $name));        
    List<Barbero> list = em.createQuery(criteriaQuery).getResultList();       
    return list;    
    }   
}