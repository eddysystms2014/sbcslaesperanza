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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author JC-PC
 */
@Entity
@Table(name = "divisionpolitica")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Divisionpolitica.findAll", query = "SELECT d FROM Divisionpolitica d"),
    @NamedQuery(name = "Divisionpolitica.findByCodloc", query = "SELECT d FROM Divisionpolitica d WHERE d.codloc = :codloc"),
    @NamedQuery(name = "Divisionpolitica.findByDescripcion", query = "SELECT d FROM Divisionpolitica d WHERE d.descripcion = :descripcion"),
    @NamedQuery(name = "Divisionpolitica.findByNivel", query = "SELECT d FROM Divisionpolitica d WHERE d.nivel = :nivel"),
    @NamedQuery(name = "Divisionpolitica.findByUltimonivel", query = "SELECT d FROM Divisionpolitica d WHERE d.ultimonivel = :ultimonivel")})
public class Divisionpolitica implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODLOC")
    private Integer codloc;
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Column(name = "NIVEL")
    private Integer nivel;
    @Column(name = "ULTIMONIVEL")
    private String ultimonivel;
    @OneToMany(mappedBy = "divCodloc")
    private List<Divisionpolitica> divisionpoliticaList;
    @JoinColumn(name = "DIV_CODLOC", referencedColumnName = "CODLOC")
    @ManyToOne
    private Divisionpolitica divCodloc;
    @OneToMany(mappedBy = "idlocalizacion")
    private List<Institucion> institucionList;

    public Divisionpolitica() {
    }

    public Divisionpolitica(Integer codloc) {
        this.codloc = codloc;
    }

    public Integer getCodloc() {
        return codloc;
    }

    public void setCodloc(Integer codloc) {
        this.codloc = codloc;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }

    public String getUltimonivel() {
        return ultimonivel;
    }

    public void setUltimonivel(String ultimonivel) {
        this.ultimonivel = ultimonivel;
    }

    @XmlTransient
    public List<Divisionpolitica> getDivisionpoliticaList() {
        return divisionpoliticaList;
    }

    public void setDivisionpoliticaList(List<Divisionpolitica> divisionpoliticaList) {
        this.divisionpoliticaList = divisionpoliticaList;
    }

    public Divisionpolitica getDivCodloc() {
        return divCodloc;
    }

    public void setDivCodloc(Divisionpolitica divCodloc) {
        this.divCodloc = divCodloc;
    }

    @XmlTransient
    public List<Institucion> getInstitucionList() {
        return institucionList;
    }

    public void setInstitucionList(List<Institucion> institucionList) {
        this.institucionList = institucionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codloc != null ? codloc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Divisionpolitica)) {
            return false;
        }
        Divisionpolitica other = (Divisionpolitica) object;
        if ((this.codloc == null && other.codloc != null) || (this.codloc != null && !this.codloc.equals(other.codloc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.entidades.Divisionpolitica[ codloc=" + codloc + " ]";
    }
    
}
