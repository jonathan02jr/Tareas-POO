package B2_P1_CONCATENAR;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class formulario extends JFrame {
    private JTextField nom;
    private JTextField ape;
    private JButton bt1;
    private JPanel JPanel1;

    //funcion con el nombre del formulario
    public formulario(){
        super( "OPERACIONES");
        setContentPane(JPanel1);


        bt1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre=nom.getText();
                String apellido=ape.getText();
                JOptionPane.showMessageDialog(null,"La union de los datos es: "+ " "+ nombre+" "+apellido);


            }
        });
    }


}
