package B2_P5_CONEC_NUBE;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Registro1 extends JFrame{
    private JPanel panel2;
    private JTextField nombre1;
    private JTextField apellido1;
    private JButton guardar_info;
    private JTextField codigo1;
    private JButton volverButton;

    public Registro1(){
        super("Registro");
        setContentPane(panel2);

        guardar_info.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String url = "jdbc:mysql://u2qpn7yz95j6wbhy:b4dtcv5rsu8iwiir6knr-mysql.services.clever-cloud.com:3306/b4dtcv5rsu8iwiir6knr";
                String user = "u2qpn7yz95j6wbhy";
                String password = "pLrGc4nM66TVKiQzS34d";

                try (Connection conecta = DriverManager.getConnection(url,user,password)){
                    System.out.println("Conectado a la base de datos");

                    String codigo0 = codigo1.getText();
                    String nombre0 = nombre1.getText();
                    String apellido0 = apellido1.getText();

                    String sql = "insert into registroj(codigo,nombre,apellido) values(?,?,?)";

                    PreparedStatement pst = conecta.prepareStatement(sql);
                    pst.setInt(1,Integer.parseInt(codigo0));
                    pst.setString(2,nombre0);
                    pst.setString(3,apellido0);

                    int afectar_filas = pst.executeUpdate();
                    if (afectar_filas > 0){
                        JOptionPane.showMessageDialog(null,"REGISTRO INSERTADO CORRECTAMENTE","ÉXITO",JOptionPane.INFORMATION_MESSAGE);
                        codigo1.setText("");
                        nombre1.setText("");
                        apellido1.setText("");
                    }
                    else {
                        JOptionPane.showMessageDialog(null,"FALLO LA INSERCION DE DATOS","ERROR",JOptionPane.ERROR_MESSAGE);
                    }
                    pst.close();;
                    conecta.close();
                }
                catch (SQLException ex) {
                    throw new RuntimeException(ex);
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
    }

    public void iniciar(){
        setVisible(true);
        setLocationRelativeTo(null);
        setSize(600,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
