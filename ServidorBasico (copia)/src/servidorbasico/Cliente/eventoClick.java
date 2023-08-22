package servidorbasico.Cliente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class eventoClick implements ActionListener {
    
    public eventoClick(){   
    }


    public void actionPerformed(ActionEvent e) {
        try {
            Persona.mensajeSaliente.writeUTF(Ventana.caja.getText());
        } catch (Exception err) {
            
        }
    }
    
}
