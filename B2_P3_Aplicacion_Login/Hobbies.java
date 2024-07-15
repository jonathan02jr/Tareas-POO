package B2_P3_Aplicacion_Login;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Hobbies extends JFrame{


    private JButton volverButton;
    private JButton mostrarButton;
    private JLabel foto1;
    private JLabel musica1;
    private JLabel dibujo0;
    private JPanel panel3;

    public Hobbies() {
        super("Hobbies");
        setContentPane(panel3);

        mostrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ImageIcon icon = new ImageIcon(getClass().getResource("img/dibujo1(5).jpg"));
                dibujo0.setIcon(icon);
            }
        });
        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Biografia info = new Biografia();
                info.iniciar();
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
