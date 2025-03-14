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
    
}
