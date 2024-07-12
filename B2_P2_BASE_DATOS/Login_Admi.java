package B2_P2_BASE_DATOS;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Login_Admi extends JFrame {
    private JTextField usuario_admi;
    private JPasswordField contra_admi;
    private JButton iniciarSesionButton;
    private JPanel panel1;


    public Login_Admi(){
        super("Inicio de sesión");
        setContentPane(panel1);


        iniciarSesionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String url = "jdbc:mysql://localhost:3306/curso";
                String user= "root";
                String password= "";

                try(Connection connection = DriverManager.getConnection(url, user,password)){
                    System.out.println("Conectando a la base de datos");

                    String usuario = usuario_admi.getText();
                    String contrasena = new String(contra_admi.getPassword());

                    // Usar una consulta preparada para evitar SQL Injection
                    String sql = "SELECT * FROM acceso WHERE usuario= ? AND password = ?";
                    PreparedStatement pst = connection.prepareStatement(sql);
                    pst.setString(1, usuario);
                    pst.setString(2, contrasena);

                    ResultSet resultSet = pst.executeQuery();

                    if(resultSet.next()){
                        System.out.println("Inicio exitosoo");
                        JOptionPane.showMessageDialog(panel1,"Inicio exitoso", "Exito", JOptionPane.INFORMATION_MESSAGE);

                        //se dirije al menu
                        Menu_Admi menu = new Menu_Admi();
                        menu.iniciar();
                        dispose();
                    }
                    else{
                        System.out.println("Usuario o contrasela incorrectos. Intente de nuevo");
                        JOptionPane.showMessageDialog(panel1,"Usuario o contraseña incorrectos. Intente de nuevo", "Error", JOptionPane.ERROR_MESSAGE);
                        usuario_admi.setText("");
                        contra_admi.setText("");
                    }

                } catch (SQLException ex){
                    JOptionPane.showMessageDialog(panel1, "Error de conexion: "+ex.getMessage(), "Error",JOptionPane.ERROR_MESSAGE);
                }

            }
        });
    }
    public void iniciar(){
        setVisible(true);
        setLocationRelativeTo(null);
        setSize(600,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
