/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Pantallas;

import ConexionBD.ConexionBD;
import DAOs.CuentaDAO;
import Exepciones.PersistenciaException;
import Negocio.Operaciones;
import dominio.Cliente;
import dominio.Cuenta;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author favel
 */
public class Menu_GenerarFolio extends javax.swing.JFrame {

    private Cliente cliente;
    ConexionBD con = new ConexionBD();
    Operaciones op = new Operaciones();
    private int Saldo = 0;

    /**
     * Creates new form Menu_GenerarFolio
     */
    public Menu_GenerarFolio(Cliente cliente) {
        try {
            initComponents();
            TextoSaldo.setText(String.valueOf(Saldo));
            this.cliente = cliente;
            CuentaDAO c = new CuentaDAO(con);
            List<Cuenta> cuentas = c.consultar();
            for (Cuenta cuenta : cuentas) {
                if (cuenta.getID_Cliente() == cliente.getId() && cuenta.getEstado().equals("Activa")) {
                    OpcionesCuentas.addItem(Integer.toString(cuenta.getNum_Cuenta()));
                }
            }
        } catch (PersistenciaException ex) {
            Logger.getLogger(Menu_AgregarSaldo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        OpcionesCuentas = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        TextoSaldo = new javax.swing.JTextField();
        BotonConfirmar = new javax.swing.JButton();
        QuitarSaldo = new javax.swing.JButton();
        AgregarSaldo = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        BotonRegresar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Arial Black", 3, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Ingrese saldo:");

        TextoSaldo.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        BotonConfirmar.setBackground(new java.awt.Color(51, 153, 255));
        BotonConfirmar.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        BotonConfirmar.setForeground(new java.awt.Color(255, 255, 255));
        BotonConfirmar.setText("Confirmar");
        BotonConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonConfirmarActionPerformed(evt);
            }
        });

        QuitarSaldo.setBackground(new java.awt.Color(51, 153, 255));
        QuitarSaldo.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        QuitarSaldo.setForeground(new java.awt.Color(255, 255, 255));
        QuitarSaldo.setText("-");
        QuitarSaldo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QuitarSaldoActionPerformed(evt);
            }
        });

        AgregarSaldo.setBackground(new java.awt.Color(51, 153, 255));
        AgregarSaldo.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        AgregarSaldo.setForeground(new java.awt.Color(255, 255, 255));
        AgregarSaldo.setText("+");
        AgregarSaldo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarSaldoActionPerformed(evt);
            }
        });

        jPanel8.setBackground(new java.awt.Color(51, 153, 255));

        jLabel9.setFont(new java.awt.Font("Arial Black", 3, 60)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Potro Banco");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 455, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(229, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                .addContainerGap())
        );

        BotonRegresar.setBackground(new java.awt.Color(255, 0, 51));
        BotonRegresar.setForeground(new java.awt.Color(255, 255, 255));
        BotonRegresar.setText("<--");
        BotonRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonRegresarActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial Black", 3, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Seleccione cuenta:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(235, 235, 235)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(261, 261, 261)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(OpcionesCuentas, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(BotonRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(176, 176, 176)
                                .addComponent(BotonConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(QuitarSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TextoSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addComponent(AgregarSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(OpcionesCuentas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TextoSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AgregarSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(QuitarSaldo))
                        .addGap(69, 69, 69)
                        .addComponent(BotonConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(BotonRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotonConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonConfirmarActionPerformed
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String fechaApertura = dateFormat.format(new Date());
        String seleccionString = (String) OpcionesCuentas.getSelectedItem();
        int seleccion = Integer.parseInt(seleccionString);

        try {
            if (op.generarFolio(Saldo, fechaApertura, seleccion)) {
                dispose();
                new Menu_Principal(cliente).setVisible(true);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Menu_GenerarFolio.class.getName()).log(Level.SEVERE, "Saldo insuficiente", ex);

        } catch (PersistenciaException ex) {
            Logger.getLogger(Menu_GenerarFolio.class.getName()).log(Level.SEVERE, "Saldo insuficiente", ex);
            JOptionPane.showMessageDialog(null, "Saldo insuficiente.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_BotonConfirmarActionPerformed

    private void QuitarSaldoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QuitarSaldoActionPerformed
        if (Saldo >= 100) {
            Saldo -= 100;
            TextoSaldo.setText(String.valueOf(Saldo));
        }
    }//GEN-LAST:event_QuitarSaldoActionPerformed

    private void AgregarSaldoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarSaldoActionPerformed
        Saldo += 100;
        TextoSaldo.setText(String.valueOf(Saldo));
    }//GEN-LAST:event_AgregarSaldoActionPerformed

    private void BotonRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonRegresarActionPerformed
        // TODO add your handling code here:
        dispose();
        new Menu_Principal(cliente).setVisible(true);
    }//GEN-LAST:event_BotonRegresarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AgregarSaldo;
    private javax.swing.JButton BotonConfirmar;
    private javax.swing.JButton BotonRegresar;
    private javax.swing.JComboBox<String> OpcionesCuentas;
    private javax.swing.JButton QuitarSaldo;
    private javax.swing.JTextField TextoSaldo;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel8;
    // End of variables declaration//GEN-END:variables
}
