package servidorbasico.Cliente;

import java.io.DataInputStream;
import java.io.InputStream;
import java.net.Socket;

public class escuchandoServer {
    
    InputStream entrada = null;
    DataInputStream flujoEntrada = null;
    Socket referenciaSocket = null;

    public escuchandoServer(Socket rSocket) {
        try {
            referenciaSocket = rSocket; // referencia al socket del cliente
            entrada = referenciaSocket.getInputStream(); // flujo de entrada del socket del cliente
            flujoEntrada = new DataInputStream(entrada); // flujo de entrada de datos del socket del cliente
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void run () {
        try {
            while (true) {
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
