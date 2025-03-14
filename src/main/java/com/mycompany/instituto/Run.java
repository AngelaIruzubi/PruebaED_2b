package com.mycompany.instituto;

import java.util.Scanner;

public class Run {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Curso curso = new Curso("Programación Java");

        System.out.println("--- Añadir Alumnos ---");
        boolean continuar = true;

        while (continuar) {
            System.out.print("Introduce el NIF (sin letra): ");
            int nif = sc.nextInt();
            sc.nextLine(); // Limpiar buffer

            System.out.print("Introduce el nombre completo: ");
            String nombre = sc.nextLine();

            System.out.print("Introduce el género (M/F): ");
            char genero = sc.next().charAt(0);

            System.out.print("Introduce la fecha de nacimiento (dd mm yyyy): ");
            int dia = sc.nextInt();
            int mes = sc.nextInt();
            int ano = sc.nextInt();

            Persona nuevaPersona = new Persona(nif, nombre, genero, dia, mes, ano);
            curso.aniadirAlumno(nuevaPersona);

            System.out.print("¿Quieres añadir otro alumno? (S/N): ");
            char respuesta = sc.next().charAt(0);
            if (respuesta == 'N' || respuesta == 'n') {
                continuar = false;
            }
        }

        System.out.println(curso);
        sc.close();
    }
}
