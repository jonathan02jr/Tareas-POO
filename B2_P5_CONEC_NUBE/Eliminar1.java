package B2_P5_CONEC_NUBE;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Eliminar1 extends JFrame{
    private JPanel panel5;
    private JTextField codigo_eliminar;
    private JButton volverButton;
    private JButton salirButton;
    private JButton eliminarButton;

    public Eliminar1() {
        super("Eliminar");
        setContentPane(panel5);


        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String url = "jdbc:mysql://u2qpn7yz95j6wbhy:b4dtcv5rsu8iwiir6knr-mysql.services.clever-cloud.com:3306/b4dtcv5rsu8iwiir6knr";
                String user = "u2qpn7yz95j6wbhy";
                String password = "pLrGc4nM66TVKiQzS34d";

                try (Connection conecta = DriverManager.getConnection(url,user,password)){
                    System.out.println("Conectado a la base de datos");

                    String codigo0_borrar= codigo_eliminar.getText();


                    String sql = "DELETE FROM registroj WHERE codigo = ?;";
                    PreparedStatement pst = conecta.prepareStatement(sql);
                    pst.setInt(1, Integer.parseInt(codigo0_borrar));

                    int afectar_filas = pst.executeUpdate();

                    if (afectar_filas >0){
                        System.out.println("Registro Eliminado");
                        JOptionPane.showMessageDialog(null,"Registro Eliminado", "Exito", JOptionPane.INFORMATION_MESSAGE);

                        Menu opciones = new Menu();
                        opciones.iniciar();
                        dispose();
                    }
                    else{
                        System.out.println("No se encontro el registro indicado");
                        JOptionPane.showMessageDialog(null,"No existen registros a eliminar", "Error", JOptionPane.ERROR_MESSAGE);
                        codigo_eliminar.setText("");
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
                Menu salir = new Menu();
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
