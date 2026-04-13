package session;

import entity.Barbero;
import java.util.List;
import javax.ejb.Local;

@Local
public interface BarberoFacadeLocal {
    void create(Barbero barbero);
    void edit(Barbero barbero);
    void remove(Barbero barbero);
    Barbero find(Object id);
    List<Barbero> findAll();
    List<Barbero> findRange(int[] range);
    int count();
    public Barbero findById(Long id);
    public List<Barbero> findByName(String name);
}