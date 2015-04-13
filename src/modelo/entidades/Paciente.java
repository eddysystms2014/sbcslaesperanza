/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author EddyA
 */
@Entity
@Table(name = "paciente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Paciente.findAll", query = "SELECT p FROM Paciente p"),
    @NamedQuery(name = "Paciente.findByInstpaciente", query = "SELECT p FROM Paciente p WHERE p.instpaciente = :instpaciente"),
    @NamedQuery(name = "Paciente.findByUnidadepaciente", query = "SELECT p FROM Paciente p WHERE p.unidadepaciente = :unidadepaciente"),
    @NamedQuery(name = "Paciente.findByCoduopaciente", query = "SELECT p FROM Paciente p WHERE p.coduopaciente = :coduopaciente"),
    @NamedQuery(name = "Paciente.findByParropaciente", query = "SELECT p FROM Paciente p WHERE p.parropaciente = :parropaciente"),
    @NamedQuery(name = "Paciente.findByCantpaciente", query = "SELECT p FROM Paciente p WHERE p.cantpaciente = :cantpaciente"),
    @NamedQuery(name = "Paciente.findByProvinpaciente", query = "SELECT p FROM Paciente p WHERE p.provinpaciente = :provinpaciente"),
    @NamedQuery(name = "Paciente.findByIdpaciente", query = "SELECT p FROM Paciente p WHERE p.idpaciente = :idpaciente"),
    @NamedQuery(name = "Paciente.findByCedpaciente", query = "SELECT p FROM Paciente p WHERE p.cedpaciente = :cedpaciente"),
    @NamedQuery(name = "Paciente.findByApeppaciente", query = "SELECT p FROM Paciente p WHERE p.apeppaciente = :apeppaciente"),
    @NamedQuery(name = "Paciente.findByApempaciente", query = "SELECT p FROM Paciente p WHERE p.apempaciente = :apempaciente"),
    @NamedQuery(name = "Paciente.findByNom1paciente", query = "SELECT p FROM Paciente p WHERE p.nom1paciente = :nom1paciente"),
    @NamedQuery(name = "Paciente.findByNom2paciente", query = "SELECT p FROM Paciente p WHERE p.nom2paciente = :nom2paciente"),
    @NamedQuery(name = "Paciente.findByDirpaciente", query = "SELECT p FROM Paciente p WHERE p.dirpaciente = :dirpaciente"),
    @NamedQuery(name = "Paciente.findByBarriopaciente", query = "SELECT p FROM Paciente p WHERE p.barriopaciente = :barriopaciente"),
    @NamedQuery(name = "Paciente.findByParrpaciente", query = "SELECT p FROM Paciente p WHERE p.parrpaciente = :parrpaciente"),
    @NamedQuery(name = "Paciente.findByCanpaciente", query = "SELECT p FROM Paciente p WHERE p.canpaciente = :canpaciente"),
    @NamedQuery(name = "Paciente.findByProvpaciente", query = "SELECT p FROM Paciente p WHERE p.provpaciente = :provpaciente"),
    @NamedQuery(name = "Paciente.findByZonapaciente", query = "SELECT p FROM Paciente p WHERE p.zonapaciente = :zonapaciente"),
    @NamedQuery(name = "Paciente.findByTelfpaciente", query = "SELECT p FROM Paciente p WHERE p.telfpaciente = :telfpaciente"),
    @NamedQuery(name = "Paciente.findByFenacpaciente", query = "SELECT p FROM Paciente p WHERE p.fenacpaciente = :fenacpaciente"),
    @NamedQuery(name = "Paciente.findByLugarnacpaciente", query = "SELECT p FROM Paciente p WHERE p.lugarnacpaciente = :lugarnacpaciente"),
    @NamedQuery(name = "Paciente.findByNaciopaciente", query = "SELECT p FROM Paciente p WHERE p.naciopaciente = :naciopaciente"),
    @NamedQuery(name = "Paciente.findByGruppaciente", query = "SELECT p FROM Paciente p WHERE p.gruppaciente = :gruppaciente"),
    @NamedQuery(name = "Paciente.findByEdadpaciente", query = "SELECT p FROM Paciente p WHERE p.edadpaciente = :edadpaciente"),
    @NamedQuery(name = "Paciente.findByGenpaciente", query = "SELECT p FROM Paciente p WHERE p.genpaciente = :genpaciente"),
    @NamedQuery(name = "Paciente.findByEcpaciente", query = "SELECT p FROM Paciente p WHERE p.ecpaciente = :ecpaciente"),
    @NamedQuery(name = "Paciente.findByInstrpaciente", query = "SELECT p FROM Paciente p WHERE p.instrpaciente = :instrpaciente"),
    @NamedQuery(name = "Paciente.findByFecadpaciente", query = "SELECT p FROM Paciente p WHERE p.fecadpaciente = :fecadpaciente"),
    @NamedQuery(name = "Paciente.findByOcuppaciente", query = "SELECT p FROM Paciente p WHERE p.ocuppaciente = :ocuppaciente"),
    @NamedQuery(name = "Paciente.findByEmpaciente", query = "SELECT p FROM Paciente p WHERE p.empaciente = :empaciente"),
    @NamedQuery(name = "Paciente.findBySegpaciente", query = "SELECT p FROM Paciente p WHERE p.segpaciente = :segpaciente"),
    @NamedQuery(name = "Paciente.findByRefpaciente", query = "SELECT p FROM Paciente p WHERE p.refpaciente = :refpaciente"),
    @NamedQuery(name = "Paciente.findByLlamarpaciente", query = "SELECT p FROM Paciente p WHERE p.llamarpaciente = :llamarpaciente"),
    @NamedQuery(name = "Paciente.findByParenpaciente", query = "SELECT p FROM Paciente p WHERE p.parenpaciente = :parenpaciente"),
    @NamedQuery(name = "Paciente.findByDirecpaciente", query = "SELECT p FROM Paciente p WHERE p.direcpaciente = :direcpaciente"),
    @NamedQuery(name = "Paciente.findByNrotelpaciente", query = "SELECT p FROM Paciente p WHERE p.nrotelpaciente = :nrotelpaciente"),
    @NamedQuery(name = "Paciente.findByCodadmisionista", query = "SELECT p FROM Paciente p WHERE p.codadmisionista = :codadmisionista"),
    @NamedQuery(name = "Paciente.findByEstadopaciente", query = "SELECT p FROM Paciente p WHERE p.estadopaciente = :estadopaciente")})
public class Paciente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "INSTPACIENTE")
    private String instpaciente;
    @Column(name = "UNIDADEPACIENTE")
    private String unidadepaciente;
    @Column(name = "CODUOPACIENTE")
    private String coduopaciente;
    @Column(name = "PARROPACIENTE")
    private String parropaciente;
    @Column(name = "CANTPACIENTE")
    private String cantpaciente;
    @Column(name = "PROVINPACIENTE")
    private String provinpaciente;
    @Id
    @Basic(optional = false)
    @Column(name = "IDPACIENTE")
    private Integer idpaciente;
    @Column(name = "CEDPACIENTE")
    private String cedpaciente;
    @Column(name = "APEPPACIENTE")
    private String apeppaciente;
    @Column(name = "APEMPACIENTE")
    private String apempaciente;
    @Column(name = "NOM1PACIENTE")
    private String nom1paciente;
    @Column(name = "NOM2PACIENTE")
    private String nom2paciente;
    @Column(name = "DIRPACIENTE")
    private String dirpaciente;
    @Column(name = "BARRIOPACIENTE")
    private String barriopaciente;
    @Column(name = "PARRPACIENTE")
    private String parrpaciente;
    @Column(name = "CANPACIENTE")
    private String canpaciente;
    @Column(name = "PROVPACIENTE")
    private String provpaciente;
    @Column(name = "ZONAPACIENTE")
    private String zonapaciente;
    @Column(name = "TELFPACIENTE")
    private String telfpaciente;
    @Column(name = "FENACPACIENTE")
    @Temporal(TemporalType.DATE)
    private Date fenacpaciente;
    @Column(name = "LUGARNACPACIENTE")
    private String lugarnacpaciente;
    @Column(name = "NACIOPACIENTE")
    private String naciopaciente;
    @Column(name = "GRUPPACIENTE")
    private String gruppaciente;
    @Column(name = "EDADPACIENTE")
    private Integer edadpaciente;
    @Column(name = "GENPACIENTE")
    private String genpaciente;
    @Column(name = "ECPACIENTE")
    private String ecpaciente;
    @Column(name = "INSTRPACIENTE")
    private String instrpaciente;
    @Column(name = "FECADPACIENTE")
    @Temporal(TemporalType.DATE)
    private Date fecadpaciente;
    @Column(name = "OCUPPACIENTE")
    private String ocuppaciente;
    @Column(name = "EMPACIENTE")
    private String empaciente;
    @Column(name = "SEGPACIENTE")
    private String segpaciente;
    @Column(name = "REFPACIENTE")
    private String refpaciente;
    @Column(name = "LLAMARPACIENTE")
    private String llamarpaciente;
    @Column(name = "PARENPACIENTE")
    private String parenpaciente;
    @Column(name = "DIRECPACIENTE")
    private String direcpaciente;
    @Column(name = "NROTELPACIENTE")
    private String nrotelpaciente;
    @Column(name = "CODADMISIONISTA")
    private String codadmisionista;
    @Lob
    @Column(name = "IMAGENPACIENTE")
    private byte[] imagenpaciente;
    @Column(name = "ESTADOPACIENTE")
    private String estadopaciente;
    @OneToMany(mappedBy = "idpaciente")
    private List<Turno> turnoList;
    @OneToMany(mappedBy = "idpaciente")
    private List<Historia> historiaList;

    public Paciente() {
    }

    public Paciente(Integer idpaciente) {
        this.idpaciente = idpaciente;
    }

    public String getInstpaciente() {
        return instpaciente;
    }

    public void setInstpaciente(String instpaciente) {
        this.instpaciente = instpaciente;
    }

    public String getUnidadepaciente() {
        return unidadepaciente;
    }

    public void setUnidadepaciente(String unidadepaciente) {
        this.unidadepaciente = unidadepaciente;
    }

    public String getCoduopaciente() {
        return coduopaciente;
    }

    public void setCoduopaciente(String coduopaciente) {
        this.coduopaciente = coduopaciente;
    }

    public String getParropaciente() {
        return parropaciente;
    }

    public void setParropaciente(String parropaciente) {
        this.parropaciente = parropaciente;
    }

    public String getCantpaciente() {
        return cantpaciente;
    }

    public void setCantpaciente(String cantpaciente) {
        this.cantpaciente = cantpaciente;
    }

    public String getProvinpaciente() {
        return provinpaciente;
    }

    public void setProvinpaciente(String provinpaciente) {
        this.provinpaciente = provinpaciente;
    }

    public Integer getIdpaciente() {
        return idpaciente;
    }

    public void setIdpaciente(Integer idpaciente) {
        this.idpaciente = idpaciente;
    }

    public String getCedpaciente() {
        return cedpaciente;
    }

    public void setCedpaciente(String cedpaciente) {
        this.cedpaciente = cedpaciente;
    }

    public String getApeppaciente() {
        return apeppaciente;
    }

    public void setApeppaciente(String apeppaciente) {
        this.apeppaciente = apeppaciente;
    }

    public String getApempaciente() {
        return apempaciente;
    }

    public void setApempaciente(String apempaciente) {
        this.apempaciente = apempaciente;
    }

    public String getNom1paciente() {
        return nom1paciente;
    }

    public void setNom1paciente(String nom1paciente) {
        this.nom1paciente = nom1paciente;
    }

    public String getNom2paciente() {
        return nom2paciente;
    }

    public void setNom2paciente(String nom2paciente) {
        this.nom2paciente = nom2paciente;
    }

    public String getDirpaciente() {
        return dirpaciente;
    }

    public void setDirpaciente(String dirpaciente) {
        this.dirpaciente = dirpaciente;
    }

    public String getBarriopaciente() {
        return barriopaciente;
    }

    public void setBarriopaciente(String barriopaciente) {
        this.barriopaciente = barriopaciente;
    }

    public String getParrpaciente() {
        return parrpaciente;
    }

    public void setParrpaciente(String parrpaciente) {
        this.parrpaciente = parrpaciente;
    }

    public String getCanpaciente() {
        return canpaciente;
    }

    public void setCanpaciente(String canpaciente) {
        this.canpaciente = canpaciente;
    }

    public String getProvpaciente() {
        return provpaciente;
    }

    public void setProvpaciente(String provpaciente) {
        this.provpaciente = provpaciente;
    }

    public String getZonapaciente() {
        return zonapaciente;
    }

    public void setZonapaciente(String zonapaciente) {
        this.zonapaciente = zonapaciente;
    }

    public String getTelfpaciente() {
        return telfpaciente;
    }

    public void setTelfpaciente(String telfpaciente) {
        this.telfpaciente = telfpaciente;
    }

    public Date getFenacpaciente() {
        return fenacpaciente;
    }

    public void setFenacpaciente(Date fenacpaciente) {
        this.fenacpaciente = fenacpaciente;
    }

    public String getLugarnacpaciente() {
        return lugarnacpaciente;
    }

    public void setLugarnacpaciente(String lugarnacpaciente) {
        this.lugarnacpaciente = lugarnacpaciente;
    }

    public String getNaciopaciente() {
        return naciopaciente;
    }

    public void setNaciopaciente(String naciopaciente) {
        this.naciopaciente = naciopaciente;
    }

    public String getGruppaciente() {
        return gruppaciente;
    }

    public void setGruppaciente(String gruppaciente) {
        this.gruppaciente = gruppaciente;
    }

    public Integer getEdadpaciente() {
        return edadpaciente;
    }

    public void setEdadpaciente(Integer edadpaciente) {
        this.edadpaciente = edadpaciente;
    }

    public String getGenpaciente() {
        return genpaciente;
    }

    public void setGenpaciente(String genpaciente) {
        this.genpaciente = genpaciente;
    }

    public String getEcpaciente() {
        return ecpaciente;
    }

    public void setEcpaciente(String ecpaciente) {
        this.ecpaciente = ecpaciente;
    }

    public String getInstrpaciente() {
        return instrpaciente;
    }

    public void setInstrpaciente(String instrpaciente) {
        this.instrpaciente = instrpaciente;
    }

    public Date getFecadpaciente() {
        return fecadpaciente;
    }

    public void setFecadpaciente(Date fecadpaciente) {
        this.fecadpaciente = fecadpaciente;
    }

    public String getOcuppaciente() {
        return ocuppaciente;
    }

    public void setOcuppaciente(String ocuppaciente) {
        this.ocuppaciente = ocuppaciente;
    }

    public String getEmpaciente() {
        return empaciente;
    }

    public void setEmpaciente(String empaciente) {
        this.empaciente = empaciente;
    }

    public String getSegpaciente() {
        return segpaciente;
    }

    public void setSegpaciente(String segpaciente) {
        this.segpaciente = segpaciente;
    }

    public String getRefpaciente() {
        return refpaciente;
    }

    public void setRefpaciente(String refpaciente) {
        this.refpaciente = refpaciente;
    }

    public String getLlamarpaciente() {
        return llamarpaciente;
    }

    public void setLlamarpaciente(String llamarpaciente) {
        this.llamarpaciente = llamarpaciente;
    }

    public String getParenpaciente() {
        return parenpaciente;
    }

    public void setParenpaciente(String parenpaciente) {
        this.parenpaciente = parenpaciente;
    }

    public String getDirecpaciente() {
        return direcpaciente;
    }

    public void setDirecpaciente(String direcpaciente) {
        this.direcpaciente = direcpaciente;
    }

    public String getNrotelpaciente() {
        return nrotelpaciente;
    }

    public void setNrotelpaciente(String nrotelpaciente) {
        this.nrotelpaciente = nrotelpaciente;
    }

    public String getCodadmisionista() {
        return codadmisionista;
    }

    public void setCodadmisionista(String codadmisionista) {
        this.codadmisionista = codadmisionista;
    }

    public byte[] getImagenpaciente() {
        return imagenpaciente;
    }

    public void setImagenpaciente(byte[] imagenpaciente) {
        this.imagenpaciente = imagenpaciente;
    }

    public String getEstadopaciente() {
        return estadopaciente;
    }

    public void setEstadopaciente(String estadopaciente) {
        this.estadopaciente = estadopaciente;
    }

    @XmlTransient
    public List<Turno> getTurnoList() {
        return turnoList;
    }

    public void setTurnoList(List<Turno> turnoList) {
        this.turnoList = turnoList;
    }

    @XmlTransient
    public List<Historia> getHistoriaList() {
        return historiaList;
    }

    public void setHistoriaList(List<Historia> historiaList) {
        this.historiaList = historiaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpaciente != null ? idpaciente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Paciente)) {
            return false;
        }
        Paciente other = (Paciente) object;
        if ((this.idpaciente == null && other.idpaciente != null) || (this.idpaciente != null && !this.idpaciente.equals(other.idpaciente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.entidades.Paciente[ idpaciente=" + idpaciente + " ]";
    }
    
}
