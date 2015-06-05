/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.entidades;

import java.io.FileInputStream;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
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
@Table(name = "medicos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Medico.findAll", query = "SELECT m FROM Medico m"),
    @NamedQuery(name = "Medico.findByIdmedico", query = "SELECT m FROM Medico m WHERE m.idmedico = :idmedico"),
    @NamedQuery(name = "Medico.findByNombremedico", query = "SELECT m FROM Medico m WHERE m.nombremedico = :nombremedico"),
    @NamedQuery(name = "Medico.findByDomiciliomedico", query = "SELECT m FROM Medico m WHERE m.domiciliomedico = :domiciliomedico"),
    @NamedQuery(name = "Medico.findByTelefonomedico", query = "SELECT m FROM Medico m WHERE m.telefonomedico = :telefonomedico"),
    @NamedQuery(name = "Medico.findByEstadomedico", query = "SELECT m FROM Medico m WHERE m.estadomedico = :estadomedico")})
public class Medico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDMEDICO")
    private Integer idmedico;
    @Column(name = "NOMBREMEDICO")
    private String nombremedico;
    @Column(name = "DOMICILIOMEDICO")
    private String domiciliomedico;
    @Column(name = "TELEFONOMEDICO")
    private String telefonomedico;
    @Lob
    @Column(name = "IMAGENMEDICO")
    private byte[] imagenmedico;
    @Column(name = "ESTADOMEDICO")
    private String estadomedico;
    @JoinColumn(name = "IDESPECIALIDAD", referencedColumnName = "IDESPECIALIDAD")
    @ManyToOne
    private Especialidad idespecialidad;
    @OneToMany(mappedBy = "idmedico")
    private List<Turno> turnoList;

    public Medico() {
    }

    public Medico(Integer idmedico) {
        this.idmedico = idmedico;
    }

    public Integer getIdmedico() {
        return idmedico;
    }

    public void setIdmedico(Integer idmedico) {
        this.idmedico = idmedico;
    }

    public String getNombremedico() {
        return nombremedico;
    }

    public void setNombremedico(String nombremedico) {
        this.nombremedico = nombremedico;
    }

    public String getDomiciliomedico() {
        return domiciliomedico;
    }

    public void setDomiciliomedico(String domiciliomedico) {
        this.domiciliomedico = domiciliomedico;
    }

    public String getTelefonomedico() {
        return telefonomedico;
    }

    public void setTelefonomedico(String telefonomedico) {
        this.telefonomedico = telefonomedico;
    }

    public byte[] getImagenmedico() {
        return imagenmedico;
    }

    public void setImagenmedico(byte[] imagenmedico) {
        this.imagenmedico = imagenmedico;
    }

    public String getEstadomedico() {
        return estadomedico;
    }

    public void setEstadomedico(String estadomedico) {
        this.estadomedico = estadomedico;
    }

    public Especialidad getIdespecialidad() {
        return idespecialidad;
    }

    public void setIdespecialidad(Especialidad idespecialidad) {
        this.idespecialidad = idespecialidad;
    }

    @XmlTransient
    public List<Turno> getTurnoList() {
        return turnoList;
    }

    public void setTurnoList(List<Turno> turnoList) {
        this.turnoList = turnoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmedico != null ? idmedico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Medico)) {
            return false;
        }
        Medico other = (Medico) object;
        if ((this.idmedico == null && other.idmedico != null) || (this.idmedico != null && !this.idmedico.equals(other.idmedico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.entidades.Medico[ idmedico=" + idmedico + " ]";
    }

    public String elimiEspacio(String m) {
        String a[] = m.split(" ");
        String s = "";
        for (int i = 0; i < a.length; i++) {
            if (a[i] != " ") {
                s += a[i];
            }
        }
        return s;
    }

    public boolean prueba(String inicio) {

        if (inicio.isEmpty() || inicio.length() > (nombremedico.length())) {
            return false;
        }
        for (int i = 0; i < inicio.length(); ++i) {
            String r = elimiEspacio(nombremedico);
            if (inicio.charAt(i) != (r.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public boolean cedula(String inicio) {

        if (inicio.isEmpty() || inicio.length() > (domiciliomedico.length())) {
            return false;
        }
        for (int i = 0; i < inicio.length(); ++i) {
            String r = elimiEspacio(domiciliomedico);
            if (inicio.charAt(i) != (r.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
