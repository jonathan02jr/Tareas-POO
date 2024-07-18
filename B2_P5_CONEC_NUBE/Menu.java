package B2_P5_CONEC_NUBE;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame{
    private JRadioButton registrarPacienteRadioButton;
    private JRadioButton actualizarPacienteRadioButton;
    private JRadioButton eliminarPacienteRadioButton;
    private JPanel panel4;

    public Menu() {
        super("Menu Principal");
        setContentPane(panel4);

        registrarPacienteRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Registro1 registrar = new Registro1();
                registrar.iniciar();
                dispose();
            }
        });

        actualizarPacienteRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Actualizar1 cambiar = new Actualizar1();
                cambiar.iniciar();
                dispose();
            }
        });
        eliminarPacienteRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Eliminar1 borrar = new Eliminar1();
                borrar.iniciar();
                dispose();
            }
        });
    }

    public void iniciar(){
        setVisible(true);
        setLocationRelativeTo(null);
        setSize(300,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
