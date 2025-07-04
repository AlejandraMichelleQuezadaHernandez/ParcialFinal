
package com.mycompany.parcialfinal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class ManejadorCliente implements Runnable{
    private Socket socket; 

    public ManejadorCliente(Socket socket) {
        this.socket = socket;
    }
    @Override
    public void run(){
        String nombre = "Desconocido";
        try{
            BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);
            nombre = entrada.readLine();
            System.out.println("Cliente " + nombre + "conectado.");
            int numero = Integer.parseInt(entrada.readLine());
            int cuadrado = numero * numero;
            String fecha_hora = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            salida.println("¡Bienvenido, " + nombre + "!");
            salida.println("El cuadrado del número recibido: " + cuadrado);
            salida.println("La fecha y la hora actual del servidor: " + fecha_hora);
        
        }catch(IOException | NumberFormatException e){
            System.out.println("Error con cliente: " + e.getMessage());
        }finally{
            System.out.println("Cliente " + nombre + "desconectado.");
            try{
                socket.close();
            }catch(IOException e){
                System.out.println("Error al cerrar socket: " + e.getMessage());
            }
        }
    }
}
