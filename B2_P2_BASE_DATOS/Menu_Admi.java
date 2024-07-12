package B2_P2_BASE_DATOS;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Menu_Admi extends JFrame {
    private JPanel panel2;
    private JRadioButton ingreso_estu;
    private JRadioButton busqueda_matricula;
    private JButton mostrar_registro;
    private JLabel verDatos;
    private JButton VOLVERButton;

    public Menu_Admi(){
        super("Menu principal");
        setContentPane(panel2);


        ingreso_estu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Ingreso_Estudia ingresar = new Ingreso_Estudia();
                ingresar.iniciar();
                dispose();
            }
        });
        busqueda_matricula.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Busqueda encontrar = new Busqueda();
                encontrar.iniciar();
                dispose();
            }
        });
        mostrar_registro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String url = "jdbc:mysql://localhost:3306/curso";
                String user = "root";
                String password = "";

                try (Connection conecta = DriverManager.getConnection(url,user,password)){
                    System.out.println("Conectado a la base de datos");
                    String sql = "select * from estudiantes";

                    Statement statement = conecta.createStatement();
                    ResultSet resultado = statement.executeQuery(sql);

                    StringBuilder datos = new StringBuilder("<html>");

                    while (resultado.next()){
                        datos.append("<b>Codigo Unico:</b> ").append(resultado.getString("codigo_matricula")).append("<br>");
                        datos.append("<b>Nombre:</b> ").append(resultado.getString("nombre_apellido_estu")).append("<br>");
                        datos.append("<b>Dirección:</b> ").append(resultado.getString("direccion")).append("<br>");
                        datos.append("<b>Edad:</b> ").append(resultado.getString("edad")).append("<br><br>");
                    }
                    datos.append("</html>");
                    verDatos.setText(datos.toString());
                }
                catch (SQLException ex){
                    verDatos.setText("Error: "+ex.getMessage());
                }

            }
        });
        VOLVERButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Login_Admi inicio = new Login_Admi();
                inicio.iniciar();
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
