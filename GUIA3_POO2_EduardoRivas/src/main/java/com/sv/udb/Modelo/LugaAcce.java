/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.Modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author aerc
 * @version 1.0
 * @since 25 de agosto de 2016
 */
@Entity
@Table(name = "luga_acce", catalog = "rceron_poo", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LugaAcce.findAll", query = "SELECT l FROM LugaAcce l Where l.esta = 1"),
    @NamedQuery(name = "LugaAcce.findByCodiLugaAcce", query = "SELECT l FROM LugaAcce l WHERE l.codiLugaAcce = :codiLugaAcce"),
    @NamedQuery(name = "LugaAcce.findByNombLugaAcce", query = "SELECT l FROM LugaAcce l WHERE l.nombLugaAcce = :nombLugaAcce"),
    @NamedQuery(name = "LugaAcce.findByFechAlta", query = "SELECT l FROM LugaAcce l WHERE l.fechAlta = :fechAlta"),
    @NamedQuery(name = "LugaAcce.findByFechBaja", query = "SELECT l FROM LugaAcce l WHERE l.fechBaja = :fechBaja"),
    @NamedQuery(name = "LugaAcce.findByEsta", query = "SELECT l FROM LugaAcce l WHERE l.esta = :esta")})
public class LugaAcce implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codi_luga_acce")
    private Long codiLugaAcce;
    @Size(max = 100)
    @Column(name = "nomb_luga_acce")
    private String nombLugaAcce;
    @Column(name = "fech_alta")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechAlta;
    @Column(name = "fech_baja")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechBaja;
    @Column(name = "esta")
    private Integer esta;

    /**
     * Metodo constructor de la clase LugaAcce
     */
    public LugaAcce() {
    }

    
    public LugaAcce(Long codiLugaAcce) {
        this.codiLugaAcce = codiLugaAcce;
    }

    /**
     * Metodo que devuelve el valor del atributo codilugaacce
     * @return codiLugaAcce
     */
    public Long getCodiLugaAcce() {
        return codiLugaAcce;
    }

    /**
     * Metodo para darle un valor al atributo
     * @param codiLugaAcce 
     */
    public void setCodiLugaAcce(Long codiLugaAcce) {
        this.codiLugaAcce = codiLugaAcce;
    }

    /**
     * Metodo que devuelve el valor del atributo NombLugaAcce
     * @return codiLugaAcce
     */
    public String getNombLugaAcce() {
        return nombLugaAcce;
    }

    /**
     * Metodo para darle un valor al atributo
     * @param nombLugaAcce 
     */
    public void setNombLugaAcce(String nombLugaAcce) {
        this.nombLugaAcce = nombLugaAcce;
    }

    /**
     * Metodo que devuelve el valor del atributo FechaAlta
     * @return fechAlta de tipo Date
     */
    public Date getFechAlta() {
        return fechAlta;
    }

    /**
     * Recibe y asigna un valor de tipo date a el atributo
     * @param fechAlta 
     */
    public void setFechAlta(Date fechAlta) {
        this.fechAlta = fechAlta;
    }

    /**
     * Metodo que devuelve el valor del atributo FechBaja
     * @return fechBaja de tipo Date
     */
    public Date getFechBaja() {
        return fechBaja;
    }

    /**
     * Recibe una fecha y la asigna al atributo fechBaja
     * @param fechBaja 
     */
    public void setFechBaja(Date fechBaja) {
        this.fechBaja = fechBaja;
    }

    /**
     * Metodo que devuelve el valor del atributo Estado
     * @return esta de tipo entero
     */
    public Integer getEsta() {
        return esta;
    }

    /**
     * Recibe un valor entero que asigna al atributo Esta
     * @param esta 
     */
    public void setEsta(Integer esta) {
        this.esta = esta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codiLugaAcce != null ? codiLugaAcce.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LugaAcce)) {
            return false;
        }
        LugaAcce other = (LugaAcce) object;
        if ((this.codiLugaAcce == null && other.codiLugaAcce != null) || (this.codiLugaAcce != null && !this.codiLugaAcce.equals(other.codiLugaAcce))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sv.udb.Modelo.LugaAcce[ codiLugaAcce=" + codiLugaAcce + " ]";
    }
    
}
