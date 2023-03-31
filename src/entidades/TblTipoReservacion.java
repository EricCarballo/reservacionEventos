/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author shask
 */
@Entity
@Table(name = "tblTipoReservacion", catalog = "reservacionEventos", schema = "dbo")
@NamedQueries({
    @NamedQuery(name = "TblTipoReservacion.findAll", query = "SELECT t FROM TblTipoReservacion t")})
public class TblTipoReservacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTipoReservacion", nullable = false)
    private Integer idTipoReservacion;
    @Basic(optional = false)
    @Column(name = "tipoReservacion", nullable = false, length = 50)
    private String tipoReservacion;
    @Basic(optional = false)
    @Lob
    @Column(name = "Descripcion", nullable = false, length = 2147483647)
    private String descripcion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "Precio", nullable = false, precision = 19, scale = 4)
    private BigDecimal precio;
    @Basic(optional = false)
    @Column(name = "Disponible", nullable = false)
    private boolean disponible;

    public TblTipoReservacion() {
    }

    public TblTipoReservacion(Integer idTipoReservacion) {
        this.idTipoReservacion = idTipoReservacion;
    }

    public TblTipoReservacion(Integer idTipoReservacion, String tipoReservacion, String descripcion, BigDecimal precio, boolean disponible) {
        this.idTipoReservacion = idTipoReservacion;
        this.tipoReservacion = tipoReservacion;
        this.descripcion = descripcion;
        this.precio = precio;
        this.disponible = disponible;
    }

    public Integer getIdTipoReservacion() {
        return idTipoReservacion;
    }

    public void setIdTipoReservacion(Integer idTipoReservacion) {
        this.idTipoReservacion = idTipoReservacion;
    }

    public String getTipoReservacion() {
        return tipoReservacion;
    }

    public void setTipoReservacion(String tipoReservacion) {
        this.tipoReservacion = tipoReservacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoReservacion != null ? idTipoReservacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblTipoReservacion)) {
            return false;
        }
        TblTipoReservacion other = (TblTipoReservacion) object;
        if ((this.idTipoReservacion == null && other.idTipoReservacion != null) || (this.idTipoReservacion != null && !this.idTipoReservacion.equals(other.idTipoReservacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.TblTipoReservacion[ idTipoReservacion=" + idTipoReservacion + " ]";
    }
    
}
