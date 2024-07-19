package B2_P4_CORRECION_PRUEBA;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Actualizar extends JFrame{
    private JPanel panel6;
    private JTextField nombre1;
    private JTextField apellido1;
    private JTextField edad1;
    private JTextField telefono1;
    private JTextField descripcion1;
    private JTextField cedu1_actualizar;
    private JButton volverButton;
    private JButton salirButton;
    private JButton actualizarButton;
    private JButton mostrarButton;


    public Actualizar() {
        super("Actualizar Datos");
        setContentPane(panel6);

        actualizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String url = "jdbc:mysql://localhost:3306/sistema_hospitalario";
                String user = "root";
                String password = "";

                try (Connection conecta = DriverManager.getConnection(url,user,password)){
                    System.out.println("Conectado a la base de datos");

                    String cedu0_actualizar = cedu1_actualizar.getText();
                    String nombre0 = nombre1.getText();
                    String apellido0 = apellido1.getText();
                    String edad0 = edad1.getText();
                    String telefono0 = telefono1.getText();
                    String descripcion0 = descripcion1.getText();

                    String sql = "UPDATE paciente SET nombre = ?, apellido = ?, edad = ?, telefono = ?, descripcion_enfermedad = ? WHERE cedula = ?";
                    PreparedStatement pst = conecta.prepareStatement(sql);
                    pst.setString(1,nombre0);
                    pst.setString(2,apellido0);
                    pst.setInt(3,Integer.parseInt(edad0));
                    pst.setString(4,telefono0);
                    pst.setString(5,descripcion0);
                    pst.setString(6, cedu0_actualizar);


                    int afectar_filas = pst.executeUpdate();
                    if (afectar_filas > 0){
                        JOptionPane.showMessageDialog(null,"Actualizacion Registrada","ÉXITO",JOptionPane.INFORMATION_MESSAGE);

                        cedu1_actualizar.setText("");

                        nombre1.setText("");
                        apellido1.setText("");
                        telefono1.setText("");
                        edad1.setText("");
                        descripcion1.setText("");

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

                String url = "jdbc:mysql://localhost:3306/sistema_hospitalario";
                String user = "root";
                String password = "";

                try (Connection conecta = DriverManager.getConnection(url,user,password)){
                    System.out.println("Conectado a la base de datos");

                    String cedula0_mostrar = cedu1_actualizar.getText();

                    String sql = "select * from paciente where cedula=?";
                    PreparedStatement pst = conecta.prepareStatement(sql);
                    pst.setString(1, cedula0_mostrar);
                    ResultSet rs = pst.executeQuery();

                    if (rs.next()){
                        System.out.println("Paciente Encontrado");
                        JOptionPane.showMessageDialog(null,"Paciente Encontrado", "Exito", JOptionPane.INFORMATION_MESSAGE);

                        nombre1.setText(rs.getString("nombre"));
                        apellido1.setText(rs.getString("apellido"));
                        edad1.setText(rs.getString("edad"));
                        telefono1.setText(rs.getString("telefono"));
                        descripcion1.setText(rs.getString("descripcion_enfermedad"));
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
