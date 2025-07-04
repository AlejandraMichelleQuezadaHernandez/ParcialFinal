package com.mycompany.parcialfinal;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorCuadrado {
    
    public static void main(String[] args) {
        int puerto = 5000;
        try{
            ServerSocket servidor = new ServerSocket(puerto);
            System.out.println("Esperando Conexion..." + puerto);
            
            while(true){
                Socket socketCliente = servidor.accept();
                Thread Hilo = new Thread(new ManejadorCliente(socketCliente));
                Hilo.start();
            }
        }catch(IOException e){
            System.out.println("Error en el servidor: " + e.getMessage());
        }
    }
    
}
