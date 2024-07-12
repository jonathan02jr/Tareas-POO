package B2_P2_BASE_DATOS;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Busqueda extends JFrame{
    private JPanel panel4;
    private JButton buscar;
    private JTextField codigo_respu;
    private JLabel ver_dato;
    private JButton volver;

    public Busqueda(){
        super("Busqueda por matricula");
        setContentPane(panel4);


        buscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String url = "jdbc:mysql://localhost:3306/curso";
                String user = "root";
                String password = "";

                try (Connection conecta = DriverManager.getConnection(url,user,password)){

                    String codigoBuscar = codigo_respu.getText();
                    String sql = "select * from estudiantes where codigo_matricula=?";

                    PreparedStatement pst = conecta.prepareStatement(sql);
                    pst.setString(1,codigoBuscar);
                    ResultSet rs = pst.executeQuery();

                    StringBuilder datos = new StringBuilder("<html>");

                    if (rs.next()){
                        JOptionPane.showMessageDialog(null,"Estudiante Encontrado","EXITO",JOptionPane.INFORMATION_MESSAGE);
                        codigo_respu.setText("");

                        datos.append("<b>Codigo Unico:</b> ").append(rs.getString("codigo_matricula")).append("<br>");
                        datos.append("<b>Nombre:</b> ").append(rs.getString("nombre_apellido_estu")).append("<br");
                        datos.append("<b>Dirección:</b> ").append(rs.getString("direccion")).append("<br>");
                        datos.append("<b>Edad:</b> ").append(rs.getString("edad")).append("<br><br>");

                        datos.append("</html>");
                        ver_dato.setText(datos.toString());
                    }
                    else {
                        JOptionPane.showMessageDialog(null,"No se encontro al estudiante","ERROR",JOptionPane.ERROR_MESSAGE);
                    }


                    rs.close();
                    pst.close();;
                    conecta.close();
                }
                catch (SQLException ex){
                    ver_dato.setText("Error: "+ex.getMessage());

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
