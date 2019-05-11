/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.util.Scanner;

/**
 *
 * @author franz
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         // Declaracion de variables
        System.out.println("Bienvenido al Programa de Ventas");
        Scanner s = new Scanner(System.in);
        Scanner i = new Scanner(System.in);
        boolean repeticion;
        boolean grande = true;
        String respuesta = "";
        repeticion = true;
        int cont = 0;
        int k=0;
        int inventario=0;
        float ganancias=0;
        boolean veces= true;
        String[] Productos = new String[100];
        int[] CantidadProductos = new int[100];
        float [] PrecioProductos = new float[100];
        do
        {
            System.out.println("¿Desea registrar un producto?");
            respuesta = s.nextLine();
            String minuscula = respuesta.toLowerCase();
            minuscula= minuscula.trim();
            if (minuscula.equals("si"))
                repeticion = true ;
            else
                repeticion = false ;
            // Registro de producto
            while (repeticion == true) 
            {
                System.out.println("Ingrese el nombre del producto: ");
                Productos[cont] = s.nextLine();
                Productos[cont] = Productos[cont].trim();
                Productos[cont] = Productos[cont].toLowerCase();
                System.out.println("Ingreso el producto : "+Productos[cont]);
                System.out.println("Ingrese la cantidad de productos que quiere registrar");
                CantidadProductos[cont] = i.nextInt();
                if (CantidadProductos[cont] <0)
                    while (CantidadProductos[cont] <0)
                    {
                        System.out.println("Por favor ingrese un numero positivo");
                        CantidadProductos[cont] = i.nextInt();
                    }
                System.out.println("Ingrese el precio del producto en Bolivianos : ");
                PrecioProductos[cont] = i.nextFloat();
                if (PrecioProductos[cont] <0)
                    while (PrecioProductos[cont] <0)
                    {
                        System.out.println("Por favor ingrese un numero positivo");
                        PrecioProductos[cont] = i.nextInt();
                    }
                System.out.println("¿Desea registrar otro producto?");
                respuesta = s.nextLine();
                if (respuesta.equals("si")|| respuesta.equals("Si") || respuesta.equals("SI"))
                    repeticion = true ;
                 else
                    repeticion = false ; 
                cont++;
            }
            // Vender producto
            System.out.println("¿Desea vender alguno de sus productos?");
            respuesta = s.nextLine();
            if (respuesta.equals("si")|| respuesta.equals("Si") || respuesta.equals("SI"))
            {    
                while (veces==true )
                {
                    System.out.println("¿Que producto desea vender?");
                    String vender = s.nextLine();
                    for (int f = 0; f< Productos.length; f++) 
                    {   
                        if (Productos[f]!=null&&Productos[f].equals(vender)) 
                        {
                            System.out.print("Tiene "+CantidadProductos[f]+" del producto seleccionado ");
                            System.out.println("¿Cuantos Desea Vender? ");
                            int menos= i.nextInt();
                            ganancias= ganancias + (menos*PrecioProductos[f]);
                            CantidadProductos[f]=CantidadProductos[f]-menos;
                            System.out.println("Le quedan: "+CantidadProductos[f]+" unidades de este producto: "+Productos[f]);
                            System.out.println("Ha recibido : "+(menos*PrecioProductos[f])+" Bs.");
                        }
                    }   
                    System.out.println("¿Desea vender otro producto?");
                    respuesta = s.nextLine();
                    if (respuesta.equals("si")|| respuesta.equals("Si") || respuesta.equals("SI"))
                            veces = true ;
                    else
                            veces = false;
                }   
            }
            //INVENTARIO
            System.out.println("¿Desea ver su inventario?");
            respuesta=s.nextLine();
            inventario = cont;
            inventario-- ;
            if (respuesta.equals("si")|| respuesta.equals("Si") || respuesta.equals("SI") )
            {
                if (inventario<0)
                    System.out.println("Su inventario esta vacio");
                else
                {
                    while(k<=inventario)
                    { 
                        System.out.println("Tiene el producto: " + Productos[k] + " " + CantidadProductos[k] + " unidades");
                        k++;
                    }
                }
            }
            System.out.println("¿Desea ver sus ganancias?");
            respuesta=s.nextLine();
            if (respuesta.equals("si")|| respuesta.equals("Si") || respuesta.equals("SI") )
            {
                System.out.println("Sus ganancias son :"+ganancias+" Bs.");
            }
                
            System.out.println("¿Desea seguir corriendo el programa?");
            respuesta = s.nextLine();
            if(respuesta.equals("si") || respuesta.equals("Si") || respuesta.equals("SI"))
                grande = true ;
            else
                grande = false ;
        }
        while(grande == true);
        System.out.println("Gracias por utilizar nuestro programa, que tenga buen dia");
    }
    
}
