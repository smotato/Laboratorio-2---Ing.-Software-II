/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author stive
 */
@Entity
@Table(name = "BARBERO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Barbero.findAll", query = "SELECT b FROM Barbero b")
    , @NamedQuery(name = "Barbero.findByIdBarbero", query = "SELECT b FROM Barbero b WHERE b.idBarbero = :idBarbero")
    , @NamedQuery(name = "Barbero.findByNombres", query = "SELECT b FROM Barbero b WHERE b.nombres = :nombres")
    , @NamedQuery(name = "Barbero.findByApellidos", query = "SELECT b FROM Barbero b WHERE b.apellidos = :apellidos")
    , @NamedQuery(name = "Barbero.findByTelefono", query = "SELECT b FROM Barbero b WHERE b.telefono = :telefono")
    , @NamedQuery(name = "Barbero.findByCorreo", query = "SELECT b FROM Barbero b WHERE b.correo = :correo")
    , @NamedQuery(name = "Barbero.findByDireccion", query = "SELECT b FROM Barbero b WHERE b.direccion = :direccion")
    , @NamedQuery(name = "Barbero.findByEstado", query = "SELECT b FROM Barbero b WHERE b.estado = :estado")
    , @NamedQuery(name = "Barbero.findByBalance", query = "SELECT b FROM Barbero b WHERE b.balance = :balance")})
public class Barbero implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_BARBERO")
    private Long idBarbero;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NOMBRES")
    private String nombres;
    @Size(max = 100)
    @Column(name = "APELLIDOS")
    private String apellidos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "TELEFONO")
    private String telefono;
    @Size(max = 50)
    @Column(name = "CORREO")
    private String correo;
    @Size(max = 50)
    @Column(name = "DIRECCION")
    private String direccion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ESTADO")
    private Boolean estado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "BALANCE")
    private double balance;

    public Barbero() {
    }

    public Barbero(Long idBarbero) {
        this.idBarbero = idBarbero;
    }

    public Barbero(Long idBarbero, String nombres, String telefono, Boolean estado, double balance) {
        this.idBarbero = idBarbero;
        this.nombres = nombres;
        this.telefono = telefono;
        this.estado = estado;
        this.balance = balance;
    }

    public Long getIdBarbero() {
        return idBarbero;
    }

    public void setIdBarbero(Long idBarbero) {
        this.idBarbero = idBarbero;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBarbero != null ? idBarbero.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Barbero)) {
            return false;
        }
        Barbero other = (Barbero) object;
        if ((this.idBarbero == null && other.idBarbero != null) || (this.idBarbero != null && !this.idBarbero.equals(other.idBarbero))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Barbero[ idBarbero=" + idBarbero + " ]";
    }
    
}
