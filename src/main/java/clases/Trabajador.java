package clases;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Trabajador {
    @Id private int id;
    private String nombre;
    private String correo;
    private int edad;
    private int añosExperiencia;
    private double nomina;
    @Embedded private PuestoTrabajo puesto; //La clase embebida.

    public Trabajador(int id, String nombre, String correo, int edad, int añosExperiencia, double nomina, PuestoTrabajo puesto) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.edad = edad;
        this.añosExperiencia = añosExperiencia;
        this.nomina = nomina;
        this.puesto = puesto;
    }

    @Override
    public String toString() {
        return "Id: " + id +
                " Nombre: '" + nombre +
                " Correo: '" + correo +
                " Edad:" + edad +
                " Años de experiencia: " + añosExperiencia +
                " Nomina: " + nomina +
                " Puesto: " + puesto ;
    }
}
