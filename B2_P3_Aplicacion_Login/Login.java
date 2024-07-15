package B2_P3_Aplicacion_Login;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame{
    private JPanel panel1;
    private JTextField usuario1;
    private JButton inicio_sesion;
    private JPasswordField contrasena1;

    public Login(){
        super("Inicio de Sesión");
        setContentPane(panel1);


        inicio_sesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String usuario0 = usuario1.getText();
                String contrasena0 = new String(contrasena1.getPassword());

                String usuario_ingreso = "jonathan@epn.edu.ec";
                String contrasena_ingreso = "12345";

                if(usuario0.equals(usuario_ingreso) && contrasena0.equals(contrasena_ingreso)){
                    JOptionPane.showMessageDialog(null,"Ingreso Exitoso","Éxito",JOptionPane.INFORMATION_MESSAGE);

                    Biografia principal = new Biografia();
                    principal.iniciar();
                    dispose();
                }
                else {
                    JOptionPane.showMessageDialog(null,"Usuario o Contraseña incorrectos. Intenta de nuevo","Error",JOptionPane.ERROR_MESSAGE);
                    usuario1.setText("");
                    contrasena1.setText("");
                }
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
