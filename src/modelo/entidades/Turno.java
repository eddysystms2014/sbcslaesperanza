/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author EddyA
 */
@Entity
@Table(name = "turnos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Turno.findAll", query = "SELECT t FROM Turno t"),
    @NamedQuery(name = "Turno.findByIdturno", query = "SELECT t FROM Turno t WHERE t.idturno = :idturno"),
    @NamedQuery(name = "Turno.findByHorarioatencion", query = "SELECT t FROM Turno t WHERE t.horarioatencion = :horarioatencion"),
    @NamedQuery(name = "Turno.findByEstadoturno", query = "SELECT t FROM Turno t WHERE t.estadoturno = :estadoturno")})
public class Turno implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDTURNO")
    private Integer idturno;
    @Column(name = "HORARIOATENCION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date horarioatencion;
    @Column(name = "ESTADOTURNO")
    private String estadoturno;
    @JoinColumn(name = "IDMEDICO", referencedColumnName = "IDMEDICO")
    @ManyToOne
    private Medico idmedico;
    @JoinColumn(name = "IDPACIENTE", referencedColumnName = "IDPACIENTE")
    @ManyToOne
    private Paciente idpaciente;

    public Turno() {
    }

    public Turno(Integer idturno) {
        this.idturno = idturno;
    }

    public Integer getIdturno() {
        return idturno;
    }

    public void setIdturno(Integer idturno) {
        this.idturno = idturno;
    }

    public Date getHorarioatencion() {
        return horarioatencion;
    }

    public void setHorarioatencion(Date horarioatencion) {
        this.horarioatencion = horarioatencion;
    }

    public String getEstadoturno() {
        return estadoturno;
    }

    public void setEstadoturno(String estadoturno) {
        this.estadoturno = estadoturno;
    }

    public Medico getIdmedico() {
        return idmedico;
    }

    public void setIdmedico(Medico idmedico) {
        this.idmedico = idmedico;
    }

    public Paciente getIdpaciente() {
        return idpaciente;
    }

    public void setIdpaciente(Paciente idpaciente) {
        this.idpaciente = idpaciente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idturno != null ? idturno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Turno)) {
            return false;
        }
        Turno other = (Turno) object;
        if ((this.idturno == null && other.idturno != null) || (this.idturno != null && !this.idturno.equals(other.idturno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.entidades.Turno[ idturno=" + idturno + " ]";
    }
    
}
