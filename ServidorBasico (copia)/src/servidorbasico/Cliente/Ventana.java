package servidorbasico.Cliente;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Ventana {
    JFrame venanita = null;
    public static JTextField caja = null;
    public static JButton boton = null;
    JPanel panel = null;
    eventoClick objEventoClick = null;
    
    public Ventana(){
        venanita = new JFrame();
        panel = new JPanel();
        objEventoClick = new eventoClick();
        caja = new JTextField(10);
        boton = new JButton("Enviar");
        boton.addActionListener(objEventoClick);
        venanita.setSize(300, 300);
        venanita.setVisible(true);
        venanita.pack();        
        venanita.setSize(300, 300);
        
        // Colocamos los objetos
        venanita.add(panel);
        panel.add(caja);
        panel.add(boton);
    }
    
   
}
