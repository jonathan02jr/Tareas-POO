package B2_P4_CORRECION_PRUEBA;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame{
    private JRadioButton registrarPacienteRadioButton;
    private JRadioButton buscarPacienteRadioButton;
    private JRadioButton actualizarPacienteRadioButton;
    private JRadioButton eliminarPacienteRadioButton;
    private JPanel panel4;

    public Menu() {
        super("Menu Principal");
        setContentPane(panel4);

        registrarPacienteRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Registro registrar = new Registro();
                registrar.iniciar();
                dispose();
            }
        });
        buscarPacienteRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Busqueda buscar = new Busqueda();
                buscar.iniciar();
                dispose();
            }
        });
        actualizarPacienteRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Actualizar cambiar = new Actualizar();
                cambiar.iniciar();
                dispose();
            }
        });
        eliminarPacienteRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Eliminar borrar = new Eliminar();
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
