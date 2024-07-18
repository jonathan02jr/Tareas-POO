package B2_P4_CORRECION_PRUEBA;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Busqueda extends JFrame{
    private JPanel panel3;
    private JTextField cedula1_busca;
    private JButton volverButton;
    private JButton salirButton;
    private JButton buscarButton;
    private JLabel visualiza_datos;

    public Busqueda(){
        super("Busqueda");
        setContentPane(panel3);

        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String url = "jdbc:mysql://uceiprz5lnyxwcun:2MEuIBNxrt0DUkvVbQaE@bi7ej80dgemnxzfdcj4h-mysql.services.clever-cloud.com:3306/bi7ej80dgemnxzfdcj4h";
                String user = "uceiprz5lnyxwcun";
                String password = "2MEuIBNxrt0DUkvVbQaE";

                try (Connection conecta = DriverManager.getConnection(url,user,password)){
                    System.out.println("Conectado a la base de datos");

                    String cedula_buscar0 = cedula1_busca.getText();

                    // Consulta de la base de datos
                    String sql = "select * from PACIENTE where cedula=?";
                    PreparedStatement pst = conecta.prepareStatement(sql);
                    pst.setString(1, cedula_buscar0);
                    ResultSet rs = pst.executeQuery();

                    StringBuilder datos = new StringBuilder("<html>");


                    if (rs.next()){
                        System.out.println("Paciente encontrado");
                        JOptionPane.showMessageDialog(null,"Paciente Encontrado", "Exito", JOptionPane.INFORMATION_MESSAGE);

                        datos.append("Cédula: ").append(rs.getString("cedula")).append("<br>");
                        datos.append("N° Historial Clinico: ").append(rs.getString("n_historial_clinico")).append("<br>");
                        datos.append("Nombre: ").append(rs.getString("nombre")).append("<br>");
                        datos.append("Apellido: ").append(rs.getString("apellido")).append("<br>");
                        datos.append("Teléfono: ").append(rs.getString("telefono")).append("<br>");
                        datos.append("Edad: ").append(rs.getString("edad")).append("<br>");
                        datos.append("Descripciond de Enfermedad: ").append(rs.getString("descripcion_enfermedad")).append("<br>");

                        datos.append("</html>");
                        visualiza_datos.setText(datos.toString());
                        cedula1_busca.setText("");

                    }
                    else{
                        JOptionPane.showMessageDialog(null, "No existen registros","ERROR",JOptionPane.ERROR_MESSAGE);
                        cedula1_busca.setText("");
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
