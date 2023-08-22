package servidorbasico.Servidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Esta clase se encarga de recibir los mensajes de los clientes
 * y mostrarlos en pantalla
 * 
 */

public class Recibiendo extends Thread{

    Socket referenciaSocket = null;
    InputStream entrada = null;
    DataInputStream flujoEntrada = null;
    OutputStream salida = null;
    DataOutputStream flujoSalida = null;
    Recibiendo siguenteClienteRecibido = null;

    public void imprimir() {
        try {
            System.out.println("Cliente: " + referenciaSocket.getInetAddress().getHostName() + " dice: " + flujoEntrada.readUTF());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Recibiendo(Socket referenciaSocket) {
        try{
            this.referenciaSocket = referenciaSocket;
            entrada = referenciaSocket.getInputStream();
            flujoEntrada = new DataInputStream(entrada);
            salida = referenciaSocket.getOutputStream();
            flujoSalida = new DataOutputStream(salida);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void enviar(String mensaje) {
        try {
            flujoSalida.writeUTF(mensaje);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void run () {
        try {
            // Leemos el mensaje que envia el cliente
            String mensajeLeido = flujoEntrada.readUTF();
            // Mostramos el mensaje en pantalla
            System.out.println("Cliente: " + referenciaSocket.getInetAddress().getHostName() + " dice: " + mensajeLeido);
            // Enviamos el mensaje a todos los clientes conectados
            Servidor.objLista.enviar(mensajeLeido);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
        
}
