/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package VehiculoDiegoLeon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Vibexz
 */
public class MenuAutos extends javax.swing.JFrame {

    COLACARROS l = new COLACARROS();

    public class COLACARROS {

        private NodoVehiculo head;
        private NodoVehiculo tail;

        public COLACARROS(NodoVehiculo head, NodoVehiculo tail) {
            this.head = head;
            this.tail = tail;
        }

        public COLACARROS() {

        }

        public void agregar(NodoVehiculo c) {

            if (head == null) {
                head = c;
                tail = c;
            } else {
                tail.setNext(c);
                tail = c;
            }

        }

        public void mostrar() {
            NodoVehiculo aux = head;

            if (head != null) {
                while (aux != null) {

                    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

                    String data[] = {aux.getPlaca(), aux.getCilindro(), aux.getMarcaAutomovil(), aux.getCombustible(), aux.getModelo(), String.valueOf(aux.getCapacidad()), String.valueOf(aux.getAño()), String.valueOf(aux.getAlquiler()), aux.getColor(), aux.getExtras()};

                    model.addRow(data);
                    aux = aux.getNext();
                }

            }
        }

        public void guardarTXT() {
            NodoVehiculo aux = head;

            if (head != null) {
                while (aux != null) {

                    // String data[] = {aux.getPLACA(), aux.getCilindraje(), aux.getMarca(), aux.getCombustion(), aux.getModelo(), String.valueOf(aux.getCapacidad()), String.valueOf(aux.getAno()), String.valueOf(aux.getAlquiler()), aux.getColor(), aux.getExtras()};
                    try {

                        FileWriter fw = new FileWriter("CA.txt", true);
                        BufferedWriter bw = new BufferedWriter(fw);
                        PrintWriter pw = new PrintWriter(bw);
                        pw.print(aux.getPlaca());
                        pw.print("-" + aux.getCilindro());
                        pw.print("-" + aux.getMarcaAutomovil());
                        pw.print("-" + aux.getCombustible());
                        pw.print("-" + aux.getModelo());
                        pw.print("-" + String.valueOf(aux.getCapacidad()));
                        pw.print("-" + String.valueOf(aux.getAño()));
                        pw.print("-" + String.valueOf(aux.getAlquiler()));
                        pw.print("-" + aux.getColor());
                        pw.print("-" + aux.getExtras() + "\n");
                        pw.close();
                        JOptionPane.showMessageDialog(null, "DATOS GUARDADOS EN BASE DE DATOS");
                    } catch (IOException e) {

                        System.out.print("ARCHIVO NO EXISTE");
                    }

                    aux = aux.getNext();
                }

            }
        }

        public void eliminar(String placa) {

            NodoVehiculo aux = new NodoVehiculo();

            aux.setPlaca(placa);

            if (head != null) {
                if (head == tail && placa.equalsIgnoreCase(head.getPlaca())) {

                    head = tail = null;

                } else if (aux.getPlaca().equalsIgnoreCase(head.getPlaca())) {

                    head = head.getNext();

                } else {
                    NodoVehiculo temporal = new NodoVehiculo();
                    NodoVehiculo anterior = new NodoVehiculo();
                    anterior = head;
                    temporal = head.getNext();
                    while (temporal != null && !temporal.getPlaca().equalsIgnoreCase(aux.getPlaca())) {

                        anterior = anterior.getNext();
                        temporal = temporal.getNext();

                    }
                    if (temporal != null) {
                        anterior.setNext(temporal.getNext());

                        if (temporal == tail) {

                            tail = anterior;

                        }

                    }

                }

            }

        }

        public void modificar(NodoVehiculo c) {

            NodoVehiculo aux = new NodoVehiculo();

            aux = head;
            boolean encontrado = false;

            if (head != null) {

                while (aux != null && encontrado != true) {

                    if (aux.getPlaca().equals(c.getPlaca())) {

                        JOptionPane.showMessageDialog(null, "REGISTRO ENCONTRADO");
                        aux.setCilindro(c.getCilindro());
                        aux.setMarcaAutomovil(c.getMarcaAutomovil());
                        aux.setCombustible(c.getCombustible());
                        aux.setModelo(c.getModelo());
                        aux.setCapacidad(c.getCapacidad());
                        aux.setAño(c.getAño());
                        aux.setAlquiler(c.getAlquiler());
                        aux.setColor(c.getColor());

                        encontrado = true;

                    }
                    aux = aux.getNext();

                }

            }

        }

        public void llenarCola() {

            String linea = "";

            String delimitante = "\n";
            FileReader fw;
            BufferedReader bw;
            try {
                //File file = new File("carros.txt");
                fw = new FileReader("CA.txt");
                bw = new BufferedReader(fw);
                String l = "";
                while ((linea = bw.readLine()) != null) {
                    l += linea + "\n";

                }

                String[] campo = l.split(delimitante);
                String Carros[][] = new String[campo.length][10];
                for (int i = 0; i < campo.length; i++) {

                    String[] carro = campo[i].split("-");

                    for (int b = 0; b < 10; b++) {
                        Carros[i][b] = carro[b];

                    }

                    NodoVehiculo aux1 = new NodoVehiculo();

                    aux1.setPlaca(Carros[i][0]);
                    aux1.setCilindro(Carros[i][1]);
                    aux1.setMarcaAutomovil(Carros[i][2]);
                    aux1.setCombustible(Carros[i][3]);
                    aux1.setModelo(Carros[i][4]);
                    aux1.setCapacidad(Integer.parseInt(Carros[i][5]));
                    aux1.setAño(Integer.parseInt(Carros[i][6]));
                    aux1.setAlquiler(Integer.parseInt(Carros[i][7]));
                    aux1.setColor(Carros[i][8]);
                    aux1.setExtras(Carros[i][9]);

                    if (head == null) {

                        head = aux1;
                        tail = aux1;

                    } else {

                        tail.setNext(aux1);
                        tail = aux1;

                    }

                }

            } catch (FileNotFoundException e) {
                System.out.print("ERROR" + e.getMessage());

            } catch (IOException ex) {
                Logger.getLogger(Cola.class.getName()).log(Level.SEVERE, null, ex);

            }

        }

    }

    public MenuAutos() {
        initComponents();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 102, 153));
        setForeground(new java.awt.Color(102, 102, 255));

        jButton1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton1.setText("AGREGAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jTable1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "PLACA", "CILINDRAJE", "MARCA", "COMBUSTION", "MODELO", "CAPACIDAD", "AÑO", "COSTO DE ALQUILER", "COLOR", "EXTRAS"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton2.setText("VER TABLA");
        jButton2.setPreferredSize(new java.awt.Dimension(130, 33));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton3.setText("ELIMINAR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton4.setText("MODIFICAR");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setText("                 MENU DE VEHICULOS - RENT A CAR");

        jButton5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton5.setText("GUARDAR DATOS");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton6.setText("VOLVER MENU");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 516, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(349, 349, 349))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1262, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addGap(45, 45, 45)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        InterfazAgregarVehiculo v = new InterfazAgregarVehiculo(this, true);
        v.setVisible(true);
        l.agregar(new NodoVehiculo(v.getPlaca(), v.getCilindraje(), v.getMarca(), v.getCombustion(), v.getModelo(), v.getCapacidad(), v.getAno(), v.getAlquiler(), v.getColor(), v.getExtras()));
        System.out.print(v.getExtras());
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        int fila = jTable1.getRowCount();

        for (int i = fila - 1; i >= 0; i--) {
            model.removeRow(i);
        }

        l.mostrar();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        InterfazEliminarVehiculo k = new InterfazEliminarVehiculo(this, true);
        k.setVisible(true);
        l.eliminar(k.getPlaca());
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        InterfazAgregarVehiculo v = new InterfazAgregarVehiculo(this, true);
        v.setVisible(true);
        l.modificar(new NodoVehiculo(v.getPlaca(), v.getCilindraje(), v.getMarca(), v.getCombustion(), v.getModelo(), v.getCapacidad(), v.getAno(), v.getAlquiler(), v.getColor(), v.getExtras()));
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        l.guardarTXT();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        this.setVisible(false);
        new InterfazPrincipal().setVisible(true);
    }//GEN-LAST:event_jButton6ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuAutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuAutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuAutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuAutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuAutos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
