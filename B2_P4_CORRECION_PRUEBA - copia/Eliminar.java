package B2_P4_CORRECION_PRUEBA;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Eliminar extends JFrame{
    private JPanel panel5;
    private JTextField cedula1_eliminar;
    private JButton volverButton;
    private JButton salirButton;
    private JButton eliminarButton;

    public Eliminar() {
        super("Eliminar");
        setContentPane(panel5);


        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String url = "jdbc:mysql://localhost:3306/sistema_hospitalario";
                String user = "root";
                String password = "";

                try (Connection conecta = DriverManager.getConnection(url,user,password)){
                    System.out.println("Conectado a la base de datos");

                    String cedula0_borrar= cedula1_eliminar.getText();


                    String sql = "DELETE FROM paciente WHERE cedula = ?;";
                    PreparedStatement pst = conecta.prepareStatement(sql);
                    pst.setString(1, cedula0_borrar);

                    int afectar_filas = pst.executeUpdate();

                    if (afectar_filas >0){
                        System.out.println("Paciente Eliminado");
                        JOptionPane.showMessageDialog(null,"Paciente Eliminado", "Exito", JOptionPane.INFORMATION_MESSAGE);

                        Menu opciones = new Menu();
                        opciones.iniciar();
                        dispose();
                    }
                    else{
                        System.out.println("No se encontro al paciente indicado");
                        JOptionPane.showMessageDialog(null,"No existen registros a eliminar", "Error", JOptionPane.ERROR_MESSAGE);
                        cedula1_eliminar.setText("");
                    }
                }
                catch (SQLException ex){
                    JOptionPane.showMessageDialog(null, "No se conectdo a la base de datos","ERROR",JOptionPane.ERROR_MESSAGE);
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
    }
    public void iniciar(){
        setVisible(true);
        setLocationRelativeTo(null);
        setSize(600,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
