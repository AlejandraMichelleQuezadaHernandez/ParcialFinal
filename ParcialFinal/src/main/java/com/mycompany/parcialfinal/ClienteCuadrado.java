
package com.mycompany.parcialfinal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.Buffer;
import java.util.Scanner;

public class ClienteCuadrado {

    public static void main(String[] args) {
        String Host = "localHost";
        int puerto = 5000;
        try{
            Socket socket = new Socket(Host, puerto);
            PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            Scanner scanner = new Scanner(System.in);
            System.out.println("Ingresa tu nombre: ");
            String nombre = scanner.nextLine();
            System.out.println("Ingresa un numero entero: ");
            int numero = scanner.nextInt();
            salida.println(nombre);
            salida.println(numero);
            for(int i = 0; i < 3; i++){
                String respuesta = entrada.readLine();
                System.out.println(respuesta);
            }
        }catch(IOException e){
            System.out.println("El error es: " + e.getMessage());
        }
    }  
}
