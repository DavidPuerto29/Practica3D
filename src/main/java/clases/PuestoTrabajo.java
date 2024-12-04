package clases;

import javax.persistence.Embeddable;

@Embeddable
public class PuestoTrabajo {

    private String codigo;  //Codigo de puesto de trabajo.
    private String departamento; //Por ejemplo informatica
    private String seccion; //Por ejemplo 2B
    private String nivelAcademico; //El nivel requerido para acceder al puesto. (Uiversitarios etc..)

    public PuestoTrabajo(String codigo, String departamento, String seccion, String nivelAcademico) {
        this.codigo = codigo;
        this.departamento = departamento;
        this.seccion = seccion;
        this.nivelAcademico = nivelAcademico;
    }

}
