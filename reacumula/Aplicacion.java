package reacumula;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Aplicacion {

    private JPanel panPrincipal;
    private JPanel panSuperior;
    private JPanel panMedio;
    private JPanel panInferior;
    private JButton btnSalir;                
    private JPanel panMedioIzq;
    private JPanel panMedioDer;
    private JPanel panIzSuper;
    private JPanel panIzInfer;
    private JButton btnCopiar1;
    private JButton btnCopiarX;
    private JButton btnBorrar;
    private JButton btnContar;
    private JPanel panSepara1;
    private JPanel panSepara2;
    private JLabel txtTitulo;
    private JTextArea tarAcumulador;
    private JTextArea tarEscritura;
    private JLabel titOrigen;
    private JPanel panVeces;
    private JLabel titVeces;
    private JTextField tflVeces;
    private JLabel txtResultado;


    public Aplicacion() {

        btnSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                System.exit(0);
            }
        });

        btnBorrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                tarAcumulador.setText("");
            }
        });

        btnCopiar1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                copiaTexto1();
            }
        });

        btnCopiarX.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                copiaTextoX();
            }
        });

        btnContar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                cuentaTexto();
            }
        });
    }

    public void copiaTexto1() {

        String tt = tarEscritura.getText();
        tarAcumulador.append("\n" + tt);
        tarEscritura.setText("");
        txtResultado.setText("Puedes seguir probando.");
    }

    public void copiaTextoX() {

        String tt = tarEscritura.getText();         // Lee el texto tt actual en Escritura
        String numStr = tflVeces.getText();         // Lee el numero de veces

        Comprobar cpb = new Comprobar();            // Comprobar valor Veces
        boolean esEntPos = cpb.esEnteroPositivo(numStr);

        if (esEntPos) {
            int n = Integer.parseInt((numStr));         // Lo convierte en int
            for (int i = 1; i <= n; i = i + 1) {        // Añade tt  n veces
                tarAcumulador.append("\n" + tt);
            }
            tarEscritura.setText("");                   // Vacia Escritura
            txtResultado.setText("Puedes seguir probando.");
        } else {
            txtResultado.setText(numStr + " no es válido. Corrígelo y vuelve a intentarlo.");
        }
    }

    public void cuentaTexto() {

        int longitud = tarAcumulador.getText().length();        // Cunta longitud de tar
        txtResultado.setText("El texto copiado contiene " + longitud +
                " caracteres. Puedes seguir añadiendo más.");
    }


    public static void main(String[] args) {
        javax.swing.JFrame frame = new javax.swing.JFrame("Resumen");
        frame.setContentPane(new Aplicacion().panPrincipal);
        frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
