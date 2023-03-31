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

@Entity
@Table(name = "tblEmpleados", catalog = "reservacionEventos", schema = "dbo")
@NamedQueries({
    @NamedQuery(name = "TblEmpleados.findAll", query = "SELECT t FROM TblEmpleados t")})
public class TblEmpleados implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idEmpleado", nullable = false)
    private Integer idEmpleado;
    @Basic(optional = false)
    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "sueldo", nullable = false, precision = 19, scale = 4)
    private BigDecimal sueldo;
    @Basic(optional = false)
    @Column(name = "edad", nullable = false)
    private int edad;
    @Basic(optional = false)
    @Column(name = "telefono", nullable = false, length = 50)
    private String telefono;
    @Basic(optional = false)
    @Column(name = "direccion", nullable = false, length = 50)
    private String direccion;
    @Basic(optional = false)
    @Column(name = "usuario", nullable = false, length = 20)
    private String usuario;
    @Basic(optional = false)
    @Column(name = "contrasenia", nullable = false, length = 30)
    private String contrasenia;
    @Basic(optional = false)
    @Lob
    @Column(name = "fotoEmpleado", nullable = false)
    private byte[] fotoEmpleado;
    @Basic(optional = false)
    @Column(name = "activo", nullable = false)
    private boolean activo;

    public TblEmpleados() {
    }

    public TblEmpleados(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public TblEmpleados(Integer idEmpleado, String nombre, BigDecimal sueldo, int edad, String telefono, String direccion, String usuario, String contrasenia, byte[] fotoEmpleado, boolean activo) {
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.sueldo = sueldo;
        this.edad = edad;
        this.telefono = telefono;
        this.direccion = direccion;
        this.usuario = usuario;
        this.contrasenia = contrasenia;
        this.fotoEmpleado = fotoEmpleado;
        this.activo = activo;
    }

    public Integer getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigDecimal getSueldo() {
        return sueldo;
    }

    public void setSueldo(BigDecimal sueldo) {
        this.sueldo = sueldo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public byte[] getFotoEmpleado() {
        return fotoEmpleado;
    }

    public void setFotoEmpleado(byte[] fotoEmpleado) {
        this.fotoEmpleado = fotoEmpleado;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEmpleado != null ? idEmpleado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblEmpleados)) {
            return false;
        }
        TblEmpleados other = (TblEmpleados) object;
        if ((this.idEmpleado == null && other.idEmpleado != null) || (this.idEmpleado != null && !this.idEmpleado.equals(other.idEmpleado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.TblEmpleados[ idEmpleado=" + idEmpleado + " ]";
    }
    
}
