package servidorbasico.Servidor;

import java.net.ServerSocket;
import java.net.Socket;
/**
 * @author juanbaucl
 */

public class Servidor {

    public static Lista objLista = null;
    public ServerSocket objServidor = null;
    
   public Servidor () {
         try {

            objLista = new Lista();
            objServidor = new ServerSocket(6980);
            System.out.println("Servidor iniciado");
            while (true) {
                // Espera a que un cliente se conecte
                Socket clienteSocket = objServidor.accept();
                System.out.println("Cliente conectado");
                // Cuando llega un cliente, se crea un hilo para atenderlo (Recibiendo.java)
                Recibiendo hiloCliente = new Recibiendo(clienteSocket);
                // Ahora añadimos el cliente a una lista de clientes conectados al servidor
                objLista.anadir(hiloCliente);
                // Luego Arrancamos el proceso de atencion al cliente
                hiloCliente.start();
                // por ultimo mostramos la lista de Procesos que estan atendiendo a los clientes
                objLista.mostrar();
            }
              
         } catch (Exception e) {
              e.printStackTrace();
         }
   }

    public static void main(String[] args) {
          new Servidor();
    }

}
