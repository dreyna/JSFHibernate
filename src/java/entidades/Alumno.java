package entidades;
// Generated 19/10/2015 06:30:40 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Alumno generated by hbm2java
 */
@Entity
@Table(name="alumno"
    ,catalog="bd_prueba"
)
public class Alumno  implements java.io.Serializable {


     private Integer idAlumno;
     private String nombres;
     private String apellidos;
     private String correo;
     private String direccion;
     private Set<DetalleCurso> detalleCursos = new HashSet<DetalleCurso>(0);

    public Alumno() {
    }

    public Alumno(String nombres, String apellidos, String correo, String direccion, Set<DetalleCurso> detalleCursos) {
       this.nombres = nombres;
       this.apellidos = apellidos;
       this.correo = correo;
       this.direccion = direccion;
       this.detalleCursos = detalleCursos;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="idAlumno", unique=true, nullable=false)
    public Integer getIdAlumno() {
        return this.idAlumno;
    }
    
    public void setIdAlumno(Integer idAlumno) {
        this.idAlumno = idAlumno;
    }

    
    @Column(name="nombres", length=45)
    public String getNombres() {
        return this.nombres;
    }
    
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    
    @Column(name="apellidos", length=45)
    public String getApellidos() {
        return this.apellidos;
    }
    
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    
    @Column(name="correo", length=45)
    public String getCorreo() {
        return this.correo;
    }
    
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    
    @Column(name="direccion", length=45)
    public String getDireccion() {
        return this.direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="alumno")
    public Set<DetalleCurso> getDetalleCursos() {
        return this.detalleCursos;
    }
    
    public void setDetalleCursos(Set<DetalleCurso> detalleCursos) {
        this.detalleCursos = detalleCursos;
    }




}


