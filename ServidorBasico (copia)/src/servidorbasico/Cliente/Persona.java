
package servidorbasico.Cliente;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Persona {

    public static String nombre = null;
    public static int edad = 0;
    public static String sexo = null;


    public Socket objSocket = null;
    public static OutputStream mensaje = null;
    public static DataOutputStream mensajeSaliente = null;
    public static String mensajeEnviado = null;
 

    public Persona() {

        try {
            // Creamos el socket para conectarnos al servidor
            objSocket = new Socket("localhost", 6980); // como el servidor esta en la misma maquina, usamos localhost como ip y 6980 como puerto
            nombre = objSocket.getInetAddress().getHostName(); // obtenemos el nombre del cliente
            mensaje = objSocket.getOutputStream(); // obtenemos el flujo de salida del socket del cliente
            mensajeSaliente = new DataOutputStream(mensaje); // obtenemos el flujo de salida de datos del socket del cliente
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void enviar(String mensaje) {
        try {
            mensajeSaliente.writeUTF(mensaje);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public String getMensajeEnviado() {
        return mensajeEnviado;
    }
    
     public static void main(String[] args) {
        Persona objPersona = new Persona();
        Ventana objVentana = new Ventana();     
    }
  
}
