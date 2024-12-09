package org.example;

import java.util.Scanner;
import java.util.ArrayList;

public class Supermercado {

    public void Supermercado(){

    }
    protected static void imprimirMenu(){

        System.out.println(" ");
        System.out.println("Introduzca el numero de la opcion que quiere elegir");

        //Opciones en array sin numeros para posibles aumentos de opciones
        String[] opciones= {"Crear producto","Crear trabajador","Modificar producto","Modificar trabajdor","Mostrar todos los productos","Mostrar todos los trabajadores","Eliminar producto","Eliminar trabajador","Buscar trabajador por","Buscar productos con precio mayor a "};
        int numero=1;
        for (String opcion : opciones) {
            System.out.println(numero+". "+opcion);
            numero++;
        }
        System.out.println("0. Salir");
    }




    public static void crearProducto() {
        Scanner scanner = new Scanner(System.in);
        //
        System.out.print("Introduce el ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); //
        System.out.print("Introduce el nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Introduce la cantidad: ");
        int cantidad = scanner.nextInt();
        scanner.nextLine(); //
        System.out.print("Introduce el pasillo: ");
        String pasillo = scanner.nextLine();
        System.out.print("Introduce la estantería: ");
        String estanteria = scanner.nextLine();

        Seccion seccion = new Seccion(pasillo, estanteria);
        Producto producto = new Producto(id, nombre, cantidad, seccion);
        ProductoDAO.crear(producto);
    }

    public static void crearTrabajador() {
        Scanner scanner = new Scanner(System.in);
        //
        System.out.print("Introduce el ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); //
        System.out.print("Introduce el nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Introduce el correo: ");
        String correo = scanner.nextLine();
        System.out.print("Introduce la edad: ");
        int edad = scanner.nextInt();
        System.out.print("Introduce los años de experiencia: ");
        int añosExperiencia = scanner.nextInt();
        System.out.print("Introduce la nómina: ");
        double nomina = scanner.nextDouble();
        scanner.nextLine(); //
        System.out.print("Introduce el código del puesto: ");
        String codigo = scanner.nextLine();
        System.out.print("Introduce el departamento: ");
        String departamento = scanner.nextLine();
        System.out.print("Introduce la sección: ");
        String seccion = scanner.nextLine();
        System.out.print("Introduce el nivel académico: ");
        String nivelAcademico = scanner.nextLine();

        PuestoTrabajo puesto = new PuestoTrabajo(codigo, departamento, seccion, nivelAcademico);
        Trabajador trabajador = new Trabajador(id, nombre, correo, edad, añosExperiencia, nomina, puesto);
        TrabajadorDAO.insertarTrabajador(trabajador);
    }

    public static void mostrarTodosProductos(ArrayList<Producto> coleccionProductos) {
        //
        for (Producto producto : coleccionProductos) {
            System.out.println(producto);
        }
    }

    public static void mostrarTodosTrabajadores(ArrayList<Trabajador> coleccionTrabajadores) {
        //
        for (Trabajador trabajador : coleccionTrabajadores) {
            System.out.println(trabajador);
        }
    }

    public static void eliminarProducto() {
        Scanner scanner = new Scanner(System.in);
        //
        System.out.print("Introduce el ID del producto a eliminar: ");
        int id = scanner.nextInt();
        ProductoDAO.delete(id);
    }

    public static void eliminarTrabajador() {
        Scanner scanner = new Scanner(System.in);
        //
        System.out.print("Introduce el ID del trabajador a eliminar: ");
        int id = scanner.nextInt();
        TrabajadorDAO.delete(id);
    }

    public static void buscarTrabajadorPorEdad() {
        Scanner scanner = new Scanner(System.in);
        //
        System.out.print("Introduce la edad a buscar: ");
        int edad = scanner.nextInt();
        ArrayList<Trabajador> trabajadores = TrabajadorDAO.buscarEdad(edad);
        for (Trabajador trabajador : trabajadores) {
            System.out.println(trabajador);
        }
    }

    public static void buscarProductoPorPrecioMayor() {
        Scanner scanner = new Scanner(System.in);
        //
        System.out.print("Introduce el precio mínimo a buscar: ");
        double precio = scanner.nextDouble();
        ArrayList<Producto> productos = ProductoDAO.buscarPrecioMayor(precio);
        for (Producto producto : productos) {
            System.out.println(producto);
        }
    }

    protected static String pedirString(){
        try {
            Scanner sc = new Scanner(System.in);
            return sc.nextLine();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}


public static void main(String[] args) {
    try {
        Supermercado.leerDatos(coleccionProductos,coleccionTrabajadores);
    }
    catch (RuntimeException e) {
    }


    boolean bucle=true;
    while(bucle){
        Supermercado.imprimirMenu();

        String numero="";
        try {
            numero = Supermercado.pedirString();
        } catch (Exception e) {
        }


        switch (numero) {
            case "1":
                Supermercado.crearProducto();
                break;
            case "2":
                Supermercado.crearTrabajador();
                break;
            case "3":
                Supermercado.mostrarTodosProductos(coleccionProductos);
                break;
            case "4":
                Supermercado.mostrarTodosTrabajadores(coleccionTrabajadores);
                break;
            case "5":
                Supermercado.eliminarProducto();
                break;
            case "6":
                Supermercado.eliminarTrabajador();
                break;
            case "7":
                Supermercado.buscarTrabajadorPorEdad();
                break;
            case "8":
                Supermercado.buscarProductoPorPrecioMayor();
                break;
            case "0":
                try {
                    Supermercado.guardarDatos(coleccionProductos,coleccionTrabajadores);
                } catch (Exception e) {
                    System.err.println("Error al guardar datos");
                }
                System.out.println("Programa cerrado");
                bucle=false;
            default:
                System.out.println("Opción no válida. Por favor, selecciona una opción válida.");
                break;
        }
    }
}