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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author JC-PC
 */
@Entity
@Table(name = "institucion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Institucion.findAll", query = "SELECT i FROM Institucion i"),
    @NamedQuery(name = "Institucion.findByIdinstitucion", query = "SELECT i FROM Institucion i WHERE i.idinstitucion = :idinstitucion"),
    @NamedQuery(name = "Institucion.findByDefault1", query = "SELECT i FROM Institucion i WHERE i.default1 = :default1"),
    @NamedQuery(name = "Institucion.findByInstitucionsistema", query = "SELECT i FROM Institucion i WHERE i.institucionsistema = :institucionsistema"),
    @NamedQuery(name = "Institucion.findByUnidadsistema", query = "SELECT i FROM Institucion i WHERE i.unidadsistema = :unidadsistema"),
    @NamedQuery(name = "Institucion.findByCoduo", query = "SELECT i FROM Institucion i WHERE i.coduo = :coduo")})
public class Institucion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDINSTITUCION")
    private Integer idinstitucion;
    @Basic(optional = false)
    @Column(name = "DEFAULT1")
    private String default1;
    @Basic(optional = false)
    @Column(name = "INSTITUCIONSISTEMA")
    private String institucionsistema;
    @Basic(optional = false)
    @Column(name = "UNIDADSISTEMA")
    private String unidadsistema;
    @Basic(optional = false)
    @Column(name = "CODUO")
    private String coduo;
    @JoinColumn(name = "IDLOCALIZACION", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Localizacion idlocalizacion;

    public Institucion() {
    }

    public Institucion(Integer idinstitucion) {
        this.idinstitucion = idinstitucion;
    }

    public Institucion(Integer idinstitucion, String default1, String institucionsistema, String unidadsistema, String coduo) {
        this.idinstitucion = idinstitucion;
        this.default1 = default1;
        this.institucionsistema = institucionsistema;
        this.unidadsistema = unidadsistema;
        this.coduo = coduo;
    }

    public Integer getIdinstitucion() {
        return idinstitucion;
    }

    public void setIdinstitucion(Integer idinstitucion) {
        this.idinstitucion = idinstitucion;
    }

    public String getDefault1() {
        return default1;
    }

    public void setDefault1(String default1) {
        this.default1 = default1;
    }

    public String getInstitucionsistema() {
        return institucionsistema;
    }

    public void setInstitucionsistema(String institucionsistema) {
        this.institucionsistema = institucionsistema;
    }

    public String getUnidadsistema() {
        return unidadsistema;
    }

    public void setUnidadsistema(String unidadsistema) {
        this.unidadsistema = unidadsistema;
    }

    public String getCoduo() {
        return coduo;
    }

    public void setCoduo(String coduo) {
        this.coduo = coduo;
    }

    public Localizacion getIdlocalizacion() {
        return idlocalizacion;
    }

    public void setIdlocalizacion(Localizacion idlocalizacion) {
        this.idlocalizacion = idlocalizacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idinstitucion != null ? idinstitucion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Institucion)) {
            return false;
        }
        Institucion other = (Institucion) object;
        if ((this.idinstitucion == null && other.idinstitucion != null) || (this.idinstitucion != null && !this.idinstitucion.equals(other.idinstitucion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.entidades.Institucion[ idinstitucion=" + idinstitucion + " ]";
    }
    
}
