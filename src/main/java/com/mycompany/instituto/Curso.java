/**
 * Representa un curso dentro del instituto, que contiene una lista de alumnos.
 * Los alumnos se almacenan en un TreeSet para mantener un orden natural.
 * 
 * @author ProfDiurno
 * @version 1.0
 */
package com.mycompany.instituto;

import java.util.TreeSet;

public class Curso {

    /** Nombre del curso. */
    private String nombre;
    
    /** Conjunto de alumnos inscritos en el curso. */
    private TreeSet<Persona> listaAlumnos;

    /**
     * Obtiene el nombre del curso.
     * 
     * @return el nombre del curso.
     */
    protected String getNombre() {
        return nombre;
    }

    /**
     * Constructor que crea un curso con el nombre especificado.
     * Inicializa la lista de alumnos como un TreeSet.
     * 
     * @param nombre el nombre del curso.
     */
    public Curso(String nombre) {
        this.nombre = nombre;
        listaAlumnos = new TreeSet<>();
    }

    /**
     * Devuelve una representación en cadena del curso y su lista de alumnos.
     * 
     * @return una cadena que representa el curso y los alumnos inscritos.
     */
    @Override
    public String toString() {
        String s = "--------------------" + nombre + "-----------------\n";
        s += "NumExp\tNIF\t\tNombre\t\tApellidos\n";
        s += "-------------------------------------------------\n";
        for (Persona listaAlumno : listaAlumnos) {
            s += listaAlumno + "\n";
        }
        return s;
    }

    /**
     * Añade un alumno al curso.
     * 
     * @param p la persona que se añadirá al curso.
     */
    public void aniadirAlumno(Persona p) {
        listaAlumnos.add(p);
    }
}

