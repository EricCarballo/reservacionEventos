/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author EJCL
 */
@Entity
@Table(name = "tblReservacion", catalog = "reservacionEventos", schema = "dbo")
@NamedQueries({
    @NamedQuery(name = "TblReservacion.findAll", query = "SELECT t FROM TblReservacion t")})
public class TblReservacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idReservacion", nullable = false)
    private Integer idReservacion;
    @Basic(optional = false)
    @Column(name = "idTipoReservacion", nullable = false)
    private int idTipoReservacion;
    @Basic(optional = false)
    @Column(name = "nombreCliente", nullable = false, length = 50)
    private String nombreCliente;
    @Basic(optional = false)
    @Column(name = "fechaReservacion", nullable = false, length = 50)
    private String fechaReservacion;
    @Basic(optional = false)
    @Column(name = "Disponible", nullable = false)
    private boolean disponible;

    public TblReservacion() {
    }

    public TblReservacion(Integer idReservacion) {
        this.idReservacion = idReservacion;
    }

    public TblReservacion(Integer idReservacion, int idTipoReservacion, String nombreCliente, String fechaReservacion, boolean disponible) {
        this.idReservacion = idReservacion;
        this.idTipoReservacion = idTipoReservacion;
        this.nombreCliente = nombreCliente;
        this.fechaReservacion = fechaReservacion;
        this.disponible = disponible;
    }

    public Integer getIdReservacion() {
        return idReservacion;
    }

    public void setIdReservacion(Integer idReservacion) {
        this.idReservacion = idReservacion;
    }

    public int getIdTipoReservacion() {
        return idTipoReservacion;
    }

    public void setIdTipoReservacion(int idTipoReservacion) {
        this.idTipoReservacion = idTipoReservacion;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getFechaReservacion() {
        return fechaReservacion;
    }

    public void setFechaReservacion(String fechaReservacion) {
        this.fechaReservacion = fechaReservacion;
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
        hash += (idReservacion != null ? idReservacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblReservacion)) {
            return false;
        }
        TblReservacion other = (TblReservacion) object;
        if ((this.idReservacion == null && other.idReservacion != null) || (this.idReservacion != null && !this.idReservacion.equals(other.idReservacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.TblReservacion[ idReservacion=" + idReservacion + " ]";
    }
    
}
