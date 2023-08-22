
package servidorbasico.Servidor;

public class Lista {
    
    public Recibiendo primerCliente = null;
    public Recibiendo ultimoCliente = null;

    public void anadir (Recibiendo nuevoNodo) {
        if (primerCliente == null) {
            primerCliente = nuevoNodo;
            ultimoCliente = primerCliente;
        } else {
            // Si ya hay clientes conectados, entonces añadimos el nuevo cliente al final de la lista
            ultimoCliente.siguenteClienteRecibido = nuevoNodo;
            ultimoCliente = nuevoNodo;
        }
    }

    public void enviar (String mensaje) {
        Recibiendo auxiliar = primerCliente;
        while (auxiliar != null) {
            auxiliar.enviar(mensaje);
            auxiliar = auxiliar.siguenteClienteRecibido;
        }
    }

    public void mostrar () {
        Recibiendo auxiliar = primerCliente;
        while (auxiliar != null) {
            System.out.println(auxiliar.referenciaSocket.getInetAddress().getHostName());
            auxiliar = auxiliar.siguenteClienteRecibido;
        }
    }
    
}
