/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author EddyA
 */
@Entity
@Table(name = "especialidades")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Especialidad.findAll", query = "SELECT e FROM Especialidad e"),
    @NamedQuery(name = "Especialidad.findByIdespecialidad", query = "SELECT e FROM Especialidad e WHERE e.idespecialidad = :idespecialidad"),
    @NamedQuery(name = "Especialidad.findByNombreespecialidad", query = "SELECT e FROM Especialidad e WHERE e.nombreespecialidad = :nombreespecialidad")})
public class Especialidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDESPECIALIDAD")
    private Integer idespecialidad;
    @Column(name = "NOMBREESPECIALIDAD")
    private String nombreespecialidad;
    @OneToMany(mappedBy = "idespecialidad")
    private List<Medico> medicoList;

    public Especialidad() {
    }

    public Especialidad(Integer idespecialidad) {
        this.idespecialidad = idespecialidad;
    }

    public Integer getIdespecialidad() {
        return idespecialidad;
    }

    public void setIdespecialidad(Integer idespecialidad) {
        this.idespecialidad = idespecialidad;
    }

    public String getNombreespecialidad() {
        return nombreespecialidad;
    }

    public void setNombreespecialidad(String nombreespecialidad) {
        this.nombreespecialidad = nombreespecialidad;
    }

    @XmlTransient
    public List<Medico> getMedicoList() {
        return medicoList;
    }

    public void setMedicoList(List<Medico> medicoList) {
        this.medicoList = medicoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idespecialidad != null ? idespecialidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Especialidad)) {
            return false;
        }
        Especialidad other = (Especialidad) object;
        if ((this.idespecialidad == null && other.idespecialidad != null) || (this.idespecialidad != null && !this.idespecialidad.equals(other.idespecialidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.entidades.Especialidad[ idespecialidad=" + idespecialidad + " ]";
    }
    public String toString1() {
        return "ID" + idespecialidad + "  Nombre especialidad ;"+nombreespecialidad;
    }

    public boolean empiezaPor(String inicio) {
        if (inicio.isEmpty() || inicio.length() > nombreespecialidad.length()) {
            return false;
        }
        for (int i = 0; i < inicio.length(); ++i) {
            if (inicio.charAt(i) != nombreespecialidad.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
