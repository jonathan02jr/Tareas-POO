package B2_P2_BASE_DATOS;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Ingreso_Estudia extends JFrame {
    private JPanel panel3;
    private JTextField codigo1;
    private JTextField nombre1;
    private JTextField edad1;
    private JTextField direccion1;
    private JButton guardar;
    private JButton volver;

    public Ingreso_Estudia(){
        super("Registro de estudiante");
        setContentPane(panel3);

        guardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String url = "jdbc:mysql://localhost:3306/curso";
                String user = "root";
                String password = "";

                try (Connection conecta = DriverManager.getConnection(url,user,password)){
                    JOptionPane.showMessageDialog(null,"Conectado a la base de datos","Éxito",JOptionPane.INFORMATION_MESSAGE);

                    String codigo0 = codigo1.getText();
                    String nombre0 = nombre1.getText();
                    String direccion0 = direccion1.getText();
                    String edad0 = edad1.getText();

                    String sql = "insert into estudiantes(codigo_matricula, nombre_apellido_estu,direccion,edad) values(?,?,?,?)";

                    PreparedStatement pst = conecta.prepareStatement(sql);
                    pst.setInt(1,Integer.parseInt(codigo0));
                    pst.setString(2,nombre0);
                    pst.setString(3,direccion0);
                    pst.setInt(4,Integer.parseInt(edad0));

                    int afectar_filas = pst.executeUpdate();
                    if (afectar_filas > 0){
                        JOptionPane.showMessageDialog(null,"REGISTRO INSERTADO CORRECTAMENTE","ÉXITO",JOptionPane.INFORMATION_MESSAGE);
                        codigo1.setText("");
                        nombre1.setText("");
                        direccion1.setText("");
                        edad1.setText("");
                    }
                    else {
                        JOptionPane.showMessageDialog(null,"FALLO LA INSERCION DE DATOS","ERROR",JOptionPane.ERROR_MESSAGE);
                    }
                    pst.close();;
                    conecta.close();
                }
                catch (SQLException ex){
                    throw new RuntimeException(ex);

                }
            }
        });
        volver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Menu_Admi menu = new Menu_Admi();
                menu.iniciar();
                dispose();
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
