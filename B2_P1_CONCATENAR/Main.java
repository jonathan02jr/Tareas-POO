package B2_P1_CONCATENAR;

import javax.swing.*;


public class Main {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

                JFrame frame=new formulario();
                frame.setSize(500,400);
                frame.setVisible(true);

            }
        });


    }
}