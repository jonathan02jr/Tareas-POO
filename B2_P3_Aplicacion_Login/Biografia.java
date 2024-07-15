package B2_P3_Aplicacion_Login;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Biografia extends JFrame{


    private JPanel panel2;
    private JButton verFotos;

    public Biografia() {
        super("Biografia");
        setContentPane(panel2);

        verFotos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Hobbies mostrar = new Hobbies();
                mostrar.iniciar();
                dispose();
            }
        });
    }

    public void iniciar(){
        setVisible(true);
        setLocationRelativeTo(null);
        setSize(500,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
