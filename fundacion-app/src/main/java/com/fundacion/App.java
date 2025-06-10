package com.fundacion;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import com.fundacion.dao.PadrinoDAO;

public class App {
    public static void main(String[] args) throws SQLException {
        Connection conec = DriverM.conectar();
        PadrinoDAO connect = new PadrinoDAO(conec);
        Scanner scanner = new Scanner(System.in);

        int opcion;

        do {
            System.out.println("====== MENÚ ======");
            System.out.println("1. listar padrinos con programas");
            System.out.println("2. insertar padrino");
            System.out.println("3. eliminar donante");
            System.out.println("4. salir");
            System.out.print("elige una opción: ");

            while (!scanner.hasNextInt()) {
                System.out.println("entrada invalida.");
                scanner.next();
            }

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    connect.listarPadrinosConProgramas();
                    break;
                case 2:
                    connect.insertarPadrino(new Padrino());
                    break;
                case 3:
                System.out.println("Ingresa el dni del donante a eliminar.");
                    int dni = scanner.nextInt();
                    boolean res = connect.eliminarPorDni(dni);
                    if(res){
                      System.out.println("donante dado de baja con exito.");
                     } else {
                      System.out.println("no se pudo dar de baja el donante.");
                    }
            }

        } while (opcion != 4);

        scanner.close();
    }
    }
