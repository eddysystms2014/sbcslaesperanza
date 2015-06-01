/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
 * @author JC-PC
 */
@Entity
@Table(name = "localizacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Localizacion.findAll", query = "SELECT l FROM Localizacion l"),
    @NamedQuery(name = "Localizacion.findById", query = "SELECT l FROM Localizacion l WHERE l.id = :id"),
    @NamedQuery(name = "Localizacion.findByPais", query = "SELECT l FROM Localizacion l WHERE l.pais = :pais"),
    @NamedQuery(name = "Localizacion.findByIdprovincia", query = "SELECT l FROM Localizacion l WHERE l.idprovincia = :idprovincia"),
    @NamedQuery(name = "Localizacion.findByProvincia", query = "SELECT l FROM Localizacion l WHERE l.provincia = :provincia"),
    @NamedQuery(name = "Localizacion.findByIdcanton", query = "SELECT l FROM Localizacion l WHERE l.idcanton = :idcanton"),
    @NamedQuery(name = "Localizacion.findByCanton", query = "SELECT l FROM Localizacion l WHERE l.canton = :canton"),
    @NamedQuery(name = "Localizacion.findByIdparroquia", query = "SELECT l FROM Localizacion l WHERE l.idparroquia = :idparroquia"),
    @NamedQuery(name = "Localizacion.findByParroquia", query = "SELECT l FROM Localizacion l WHERE l.parroquia = :parroquia")})
public class Localizacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "PAIS")
    private String pais;
    @Column(name = "IDPROVINCIA")
    private Integer idprovincia;
    @Column(name = "PROVINCIA")
    private String provincia;
    @Column(name = "IDCANTON")
    private Integer idcanton;
    @Column(name = "CANTON")
    private String canton;
    @Column(name = "IDPARROQUIA")
    private Integer idparroquia;
    @Column(name = "PARROQUIA")
    private String parroquia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idlocalizacion")
    private List<Institucion> institucionList;

    public Localizacion() {
    }

    public Localizacion(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Integer getIdprovincia() {
        return idprovincia;
    }

    public void setIdprovincia(Integer idprovincia) {
        this.idprovincia = idprovincia;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public Integer getIdcanton() {
        return idcanton;
    }

    public void setIdcanton(Integer idcanton) {
        this.idcanton = idcanton;
    }

    public String getCanton() {
        return canton;
    }

    public void setCanton(String canton) {
        this.canton = canton;
    }

    public Integer getIdparroquia() {
        return idparroquia;
    }

    public void setIdparroquia(Integer idparroquia) {
        this.idparroquia = idparroquia;
    }

    public String getParroquia() {
        return parroquia;
    }

    public void setParroquia(String parroquia) {
        this.parroquia = parroquia;
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Localizacion)) {
            return false;
        }
        Localizacion other = (Localizacion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.entidades.Localizacion[ id=" + id + " ]";
    }
    
}
