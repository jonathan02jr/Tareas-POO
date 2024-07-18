package B2_P4_CORRECION_PRUEBA;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Login extends JFrame{

    private JTextField usuario1;
    private JPasswordField contrasenia1;
    private JButton inicio_sesion;
    private JPanel panel1;

    public Login(){
        super("Inicio de sesión");
        setContentPane(panel1);


        inicio_sesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String url = "jdbc:mysql://uceiprz5lnyxwcun:2MEuIBNxrt0DUkvVbQaE@bi7ej80dgemnxzfdcj4h-mysql.services.clever-cloud.com:3306/bi7ej80dgemnxzfdcj4h";
                String user = "uceiprz5lnyxwcun";
                String password = "2MEuIBNxrt0DUkvVbQaE";

                try (Connection conecta = DriverManager.getConnection(url,user,password)){
                    System.out.println("Conectado a la base de datos");

                    String usuario0 = usuario1.getText();
                    String contrasenia0 = new String(contrasenia1.getPassword());

                    // Consulta de la base de datos
                    String sql = "select * from acceso where usuario=? and password =?";
                    PreparedStatement pst = conecta.prepareStatement(sql);
                    pst.setString(1, usuario0);
                    pst.setString(2, contrasenia0);

                    ResultSet resultado = pst.executeQuery();

                    if (resultado.next()){
                        System.out.println("Inicio exitosoo");
                        JOptionPane.showMessageDialog(null,"Inicio exitoso", "Exito", JOptionPane.INFORMATION_MESSAGE);

                        Menu opciones = new Menu();
                        opciones.iniciar();
                        dispose();
                    }
                    else{
                        System.out.println("Usuario o contrasela incorrectos. Intente de nuevo");
                        JOptionPane.showMessageDialog(null,"Usuario o contraseña incorrectos. Intente de nuevo", "Error", JOptionPane.ERROR_MESSAGE);
                        usuario1.setText("");
                        contrasenia1.setText("");
                    }
                }
                catch (SQLException ex){
                    JOptionPane.showMessageDialog(null, "No se conectdo a la base de datos","ERROR",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
    public void iniciar(){
        setVisible(true);
        setLocationRelativeTo(null);
        setSize(600,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
