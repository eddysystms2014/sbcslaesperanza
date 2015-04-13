/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.entidades;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author EddyA
 */
@Entity
@Table(name = "historias")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Historia.findAll", query = "SELECT h FROM Historia h"),
    @NamedQuery(name = "Historia.findByIdhistoria", query = "SELECT h FROM Historia h WHERE h.idhistoria = :idhistoria"),
    @NamedQuery(name = "Historia.findByFechahistoria", query = "SELECT h FROM Historia h WHERE h.fechahistoria = :fechahistoria"),
    @NamedQuery(name = "Historia.findByEdadhistoria", query = "SELECT h FROM Historia h WHERE h.edadhistoria = :edadhistoria"),
    @NamedQuery(name = "Historia.findByReferidohistoria", query = "SELECT h FROM Historia h WHERE h.referidohistoria = :referidohistoria"),
    @NamedQuery(name = "Historia.findByTipohistoria", query = "SELECT h FROM Historia h WHERE h.tipohistoria = :tipohistoria"),
    @NamedQuery(name = "Historia.findByCodadmisionista", query = "SELECT h FROM Historia h WHERE h.codadmisionista = :codadmisionista"),
    @NamedQuery(name = "Historia.findByEstadohistoria", query = "SELECT h FROM Historia h WHERE h.estadohistoria = :estadohistoria")})
public class Historia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDHISTORIA")
    private Integer idhistoria;
    @Column(name = "FECHAHISTORIA")
    private String fechahistoria;
    @Column(name = "EDADHISTORIA")
    private Integer edadhistoria;
    @Column(name = "REFERIDOHISTORIA")
    private String referidohistoria;
    @Column(name = "TIPOHISTORIA")
    private Character tipohistoria;
    @Column(name = "CODADMISIONISTA")
    private String codadmisionista;
    @Lob
    @Column(name = "ADJUNTOHISTORIA")
    private byte[] adjuntohistoria;
    @Column(name = "ESTADOHISTORIA")
    private String estadohistoria;
    @JoinColumn(name = "IDPACIENTE", referencedColumnName = "IDPACIENTE")
    @ManyToOne
    private Paciente idpaciente;

    public Historia() {
    }

    public Historia(Integer idhistoria) {
        this.idhistoria = idhistoria;
    }

    public Integer getIdhistoria() {
        return idhistoria;
    }

    public void setIdhistoria(Integer idhistoria) {
        this.idhistoria = idhistoria;
    }

    public String getFechahistoria() {
        return fechahistoria;
    }

    public void setFechahistoria(String fechahistoria) {
        this.fechahistoria = fechahistoria;
    }

    public Integer getEdadhistoria() {
        return edadhistoria;
    }

    public void setEdadhistoria(Integer edadhistoria) {
        this.edadhistoria = edadhistoria;
    }

    public String getReferidohistoria() {
        return referidohistoria;
    }

    public void setReferidohistoria(String referidohistoria) {
        this.referidohistoria = referidohistoria;
    }

    public Character getTipohistoria() {
        return tipohistoria;
    }

    public void setTipohistoria(Character tipohistoria) {
        this.tipohistoria = tipohistoria;
    }

    public String getCodadmisionista() {
        return codadmisionista;
    }

    public void setCodadmisionista(String codadmisionista) {
        this.codadmisionista = codadmisionista;
    }

    public byte[] getAdjuntohistoria() {
        return adjuntohistoria;
    }

    public void setAdjuntohistoria(byte[] adjuntohistoria) {
        this.adjuntohistoria = adjuntohistoria;
    }

    public String getEstadohistoria() {
        return estadohistoria;
    }

    public void setEstadohistoria(String estadohistoria) {
        this.estadohistoria = estadohistoria;
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
        hash += (idhistoria != null ? idhistoria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Historia)) {
            return false;
        }
        Historia other = (Historia) object;
        if ((this.idhistoria == null && other.idhistoria != null) || (this.idhistoria != null && !this.idhistoria.equals(other.idhistoria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.entidades.Historia[ idhistoria=" + idhistoria + " ]";
    }
    
}
