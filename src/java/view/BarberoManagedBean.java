package view;

import entity.Barbero;
import session.BarberoFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.event.AjaxBehaviorEvent;

@Named(value = "barberoManagedBean")
@SessionScoped
public class BarberoManagedBean implements Serializable {

    @EJB
    private BarberoFacadeLocal barberoFacade;

    public BarberoManagedBean() {
    }

    private String nombre = "";

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    private List<Barbero> barberoList;

    public List<Barbero> getBarberoList() { return barberoList; }
    public void setBarberoList(List<Barbero> barberoList) { 
        this.barberoList = barberoList; 
    }

    public List<Barbero> getListByName() {
        if (barberoList == null) {
            barberoList = barberoFacade.findByName(nombre);
        }
        return barberoList;
    }

    public void nombreChangeListener(AjaxBehaviorEvent event) {
        barberoList = barberoFacade.findByName(nombre);
    }
}