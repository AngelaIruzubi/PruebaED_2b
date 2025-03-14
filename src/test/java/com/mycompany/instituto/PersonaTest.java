/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.instituto;

import java.time.LocalDate;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author PC
 */
public class PersonaTest {
    
    public PersonaTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

     @Test
    public void testGetEdad() {
        // Creo una persona con fecha de nacimiento hace 20 años
        LocalDate fechaNacimiento = LocalDate.now().minusYears(20);
        Persona persona = new Persona(12345678, "Juan", 'H', 
                                      fechaNacimiento.getDayOfMonth(), 
                                      fechaNacimiento.getMonthValue(), 
                                      fechaNacimiento.getYear());

        // Verificar que la edad calculada es 20
        assertEquals(20, persona.getEdad(), "La edad calculada no es correcta");
    }
    
    @Test
    public void testEquals() {
        // Crear dos personas con el mismo NIF
        Persona persona1 = new Persona(12345678, "Juan", 'H', 1, 1, 2000);
        Persona persona2 = new Persona(12345678, "Ana", 'M', 2, 2, 2001);

        // Verificar que las personas son iguales (mismo NIF)
        assertTrue(persona1.equals(persona2), "Las personas con el mismo NIF deben ser iguales");

        // Crear una tercera persona con un NIF diferente
        Persona persona3 = new Persona(87654321, "Carlos", 'H', 3, 3, 2002);

        // Verificar que las personas no son iguales (NIF diferente)
        assertFalse(persona1.equals(persona3), "Las personas con NIF diferente no deben ser iguales");
    }
    
        @Test
    public void testCompareTo() {
        // Crear dos personas con NIFs diferentes
        Persona persona1 = new Persona(12345678, "Juan", 'H', 1, 1, 2000);
        Persona persona2 = new Persona(87654321, "Ana", 'M', 2, 2, 2001);

        // Verificar que persona1 es "menor" que persona2 (comparación por NIF)
        assertTrue(persona1.compareTo(persona2) < 0, "persona1 debe ser menor que persona2 según el NIF");

        // Crear una tercera persona con un NIF mayor que persona2
        Persona persona3 = new Persona(98765432, "Carlos", 'H', 3, 3, 2002);

        // Verificar que persona2 es "menor" que persona3 (comparación por NIF)
        assertTrue(persona2.compareTo(persona3) < 0, "persona2 debe ser menor que persona3 según el NIF");
    }
    
    
        @Test
    public void testToString() {
        // Crear una persona con nombre y apellidos
        Persona persona = new Persona(12345678, "Juan Perez", 'H', 1, 1, 2000);

        // Verificar que el método toString devuelve el formato esperado
        String expected = "12345678-T\tJuan\tPerez\t\t" + persona.getEdad();
        assertEquals(expected, persona.toString(), "El formato de toString no es correcto");

        // Crear una persona con un solo nombre
        Persona persona2 = new Persona(87654321, "Ana", 'M', 2, 2, 2001);

        // Verificar que el método toString devuelve el formato esperado
        String expected2 = "87654321-W\tAna\t\t\t" + persona2.getEdad();
        assertEquals(expected2, persona2.toString(), "El formato de toString no es correcto");
    }
    
}
