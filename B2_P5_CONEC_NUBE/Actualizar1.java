package B2_P5_CONEC_NUBE;

import B2_P4_CORRECION_PRUEBA.Login;
import B2_P4_CORRECION_PRUEBA.Menu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Actualizar1 extends JFrame{
    private JPanel panel6;
    private JTextField nombre1;
    private JTextField apellido1;
    private JTextField cedu1_actualizar;
    private JButton volverButton;
    private JButton salirButton;
    private JButton actualizarButton;
    private JButton mostrarButton;


    public Actualizar1() {
        super("Actualizar Datos");
        setContentPane(panel6);

        actualizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String url = "jdbc:mysql://u2qpn7yz95j6wbhy:b4dtcv5rsu8iwiir6knr-mysql.services.clever-cloud.com:3306/b4dtcv5rsu8iwiir6knr";
                String user = "u2qpn7yz95j6wbhy";
                String password = "pLrGc4nM66TVKiQzS34d";

                try (Connection conecta = DriverManager.getConnection(url,user,password)){
                    System.out.println("Conectado a la base de datos");

                    String cod0_actualizar = cedu1_actualizar.getText();
                    String nombre0 = nombre1.getText();
                    String apellido0 = apellido1.getText();


                    String sql = "UPDATE registroj SET nombre = ?, apellido = ? WHERE codigo = ?";
                    PreparedStatement pst = conecta.prepareStatement(sql);
                    pst.setString(1,nombre0);
                    pst.setString(2,apellido0);
                    pst.setString(3, cod0_actualizar);


                    int afectar_filas = pst.executeUpdate();
                    if (afectar_filas > 0){
                        JOptionPane.showMessageDialog(null,"Actualizacion Registrada","ÉXITO",JOptionPane.INFORMATION_MESSAGE);

                        cedu1_actualizar.setText("");

                        nombre1.setText("");
                        apellido1.setText("");
                    }
                    else {
                        JOptionPane.showMessageDialog(null,"Fallo la actualizacion","ERROR",JOptionPane.ERROR_MESSAGE);
                    }
                    pst.close();;
                    conecta.close();
                }
                catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error con el código","ERROR",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Menu opciones = new Menu();
                opciones.iniciar();
                dispose();
            }
        });
        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Login salir = new Login();
                salir.iniciar();
                dispose();
            }
        });
        mostrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){

                String url = "jdbc:mysql://u2qpn7yz95j6wbhy:b4dtcv5rsu8iwiir6knr-mysql.services.clever-cloud.com:3306/b4dtcv5rsu8iwiir6knr";
                String user = "u2qpn7yz95j6wbhy";
                String password = "pLrGc4nM66TVKiQzS34d";

                try (Connection conecta = DriverManager.getConnection(url,user,password)){
                    System.out.println("Conectado a la base de datos");

                    String cod0_mostrar = cedu1_actualizar.getText();

                    String sql = "select * from registroj where codigo=?";
                    PreparedStatement pst = conecta.prepareStatement(sql);
                    pst.setString(1, cod0_mostrar);
                    ResultSet rs = pst.executeQuery();

                    if (rs.next()){
                        System.out.println("Registro Encontrado");
                        JOptionPane.showMessageDialog(null,"Registro Encontrado", "Exito", JOptionPane.INFORMATION_MESSAGE);

                        nombre1.setText(rs.getString("nombre"));
                        apellido1.setText(rs.getString("apellido"));

                    }
                    else{
                        System.out.println("No se encontraron registros");
                        JOptionPane.showMessageDialog(null,"No se encontraron registros", "Error", JOptionPane.ERROR_MESSAGE);
                        cedu1_actualizar.setText("");
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
