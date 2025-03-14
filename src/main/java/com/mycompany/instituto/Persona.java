/**
 * Representa una persona en el sistema del instituto, identificada por su NIF, nombre, género y fecha de nacimiento.
 * Implementa la interfaz Comparable para ordenar personas por su NIF.
 * 
 * @author ProfDiurno
 * @version 1.0
 */
package com.mycompany.instituto;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

public class Persona implements Comparable<Persona> {

    /** NIF de la persona. */
    private Nif nif;
    
    /** Nombre completo de la persona. */
    private String nombre;
    
    /** Género de la persona. Se representa con un carácter ('M' para masculino, 'F' para femenino, etc.). */
    private char genero;
    
    /** Fecha de nacimiento de la persona. */
    private LocalDate nacimiento;

    /**
     * Constructor por defecto que inicializa la persona con valores predeterminados.
     */
    public Persona() {
        nif = new Nif();
        nombre = "";
        genero = ' ';
        nacimiento = LocalDate.of(1990, 1, 1);
    }

    /**
     * Constructor que crea una persona con el NIF especificado y valores predeterminados para el resto de atributos.
     * 
     * @param nif Número de Identificación Fiscal de la persona.
     */
    public Persona(int nif) {
        this();
        this.nif = new Nif(nif);
    }

    /**
     * Constructor que crea una persona con todos los atributos especificados.
     * 
     * @param nif Número de Identificación Fiscal de la persona.
     * @param nombre Nombre completo de la persona.
     * @param genero Género de la persona.
     * @param dia Día de nacimiento.
     * @param mes Mes de nacimiento.
     * @param ano Año de nacimiento.
     */
    public Persona(int nif, String nombre, char genero, int dia, int mes, int ano) {
        this.nif = new Nif(nif);
        this.nombre = nombre;
        this.genero = genero;
        this.nacimiento = LocalDate.of(ano, mes, dia);
    }

    /**
     * Obtiene el NIF de la persona.
     * 
     * @return El NIF de la persona.
     */
    public Nif getNif() {
        return nif;
    }

    /**
     * Establece el NIF de la persona.
     * 
     * @param nif Nuevo NIF de la persona.
     */
    public void setNif(Nif nif) {
        this.nif = nif;
    }

    /**
     * Obtiene el nombre completo de la persona.
     * 
     * @return El nombre de la persona.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre completo de la persona.
     * 
     * @param nombre Nuevo nombre de la persona.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el género de la persona.
     * 
     * @return El género de la persona.
     */
    public char getGenero() {
        return genero;
    }

    /**
     * Establece el género de la persona.
     * 
     * @param genero Nuevo género de la persona.
     */
    public void setGenero(char genero) {
        this.genero = genero;
    }

    /**
     * Obtiene la fecha de nacimiento de la persona.
     * 
     * @return La fecha de nacimiento de la persona.
     */
    public LocalDate getNacimiento() {
        return nacimiento;
    }

    /**
     * Establece la fecha de nacimiento de la persona.
     * 
     * @param nacimiento Nueva fecha de nacimiento de la persona.
     */
    public void setNacimiento(LocalDate nacimiento) {
        this.nacimiento = nacimiento;
    }

    /**
     * Calcula y devuelve la edad actual de la persona en años.
     * 
     * @return La edad de la persona.
     */
    public int getEdad() {
        return Period.between(nacimiento, LocalDate.now()).getYears();
    }

    /**
     * Devuelve una representación en cadena de la persona con su NIF, nombre y edad.
     * Si el nombre tiene más de una palabra, separa nombre y apellidos.
     * 
     * @return Una cadena que representa la persona.
     */
    @Override
    public String toString() {
        if (nombre.split(" ").length > 1) {
            return nif + "\t" + nombre.split(" ")[0] + '\t' + nombre.split(" ")[1] + "\t\t" + getEdad();
        } else {
            return nif + "\t" + nombre + "\t\t\t" + getEdad();
        }
    }

    /**
     * Compara si dos personas son iguales basándose en su NIF.
     * 
     * @param a Persona a comparar.
     * @return true si los NIF son iguales, false en caso contrario.
     */
    public boolean equals(Persona a) {
        if (a == null) {
            return false;
        }
        return a.nif.toString().equals(this.nif.toString());
    }

    /**
     * Compara si dos objetos son iguales basándose en su NIF.
     * 
     * @param obj Objeto a comparar.
     * @return true si los objetos son iguales, false en caso contrario.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Persona other = (Persona) obj;
        return Objects.equals(this.nif, other.nif);
    }

    /**
     * Compara dos personas por su NIF en orden natural.
     * 
     * @param o Persona a comparar.
     * @return Un valor negativo, cero o positivo según el NIF de esta persona sea menor, igual o mayor que el de la persona especificada.
     */
    @Override
    public int compareTo(Persona o) {
        return this.nif.toString().compareTo(o.nif.toString());
    }
}
