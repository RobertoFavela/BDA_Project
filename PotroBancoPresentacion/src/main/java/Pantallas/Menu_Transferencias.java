/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Pantallas;

import ConexionBD.ConexionBD;
import DAOs.CuentaDAO;
import dominio.Cliente;
import dominio.Cuenta;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import Negocio.Operaciones;

/**
 * La clase Menu_Transferencias proporciona una interfaz de usuario para
 * realizar transferencias de saldo entre cuentas.
 *
 * @author favel
 */
public class Menu_Transferencias extends javax.swing.JFrame {

    Cliente cliente;
    ConexionBD con = new ConexionBD();
    Operaciones op = new Operaciones();
    private int Saldo = 0;

    /**
     * Creates new form Menu_Transferencias
     */
    public Menu_Transferencias(Cliente cliente) {
        try {
            initComponents();
            this.cliente = cliente;
            TextoSaldo.setText(String.valueOf(Saldo));
            CuentaDAO c = new CuentaDAO(con);
            List<Cuenta> cuentas = c.consultar();
            for (Cuenta cuenta : cuentas) {
                if (cuenta.getID_Cliente() == cliente.getId() && cuenta.getEstado().equals("Activa")) {
                    OpcionesCuentas.addItem(Integer.toString(cuenta.getNum_Cuenta()));
                }
            }
        } catch (Exception e) {
            Logger.getLogger(Menu_EliminarCuenta.class.getName()).log(Level.SEVERE, null, e);
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

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        TextoSaldo = new javax.swing.JTextField();
        BotonTransferir = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        BotonRegresar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        CuentaDestino = new javax.swing.JTextField();
        OpcionesCuentas = new javax.swing.JComboBox<>();
        AgregarSaldo = new javax.swing.JButton();
        QuitarSaldo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Saldo a trasnferir:");

        jLabel3.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Cuenta:");

        BotonTransferir.setBackground(new java.awt.Color(51, 153, 255));
        BotonTransferir.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        BotonTransferir.setForeground(new java.awt.Color(255, 255, 255));
        BotonTransferir.setText("Transferir");
        BotonTransferir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonTransferirActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(51, 153, 255));

        jLabel9.setFont(new java.awt.Font("Arial Black", 3, 60)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Potro Banco");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 455, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
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

        jLabel4.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Cuenta destino:");

        AgregarSaldo.setText("+");
        AgregarSaldo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarSaldoActionPerformed(evt);
            }
        });

        QuitarSaldo.setText("-");
        QuitarSaldo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QuitarSaldoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BotonTransferir, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(237, 237, 237))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(BotonRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel4)
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(111, 111, 111)
                                .addComponent(jLabel3)))
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(OpcionesCuentas, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CuentaDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(TextoSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(AgregarSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(QuitarSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(OpcionesCuentas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(CuentaDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(AgregarSaldo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(QuitarSaldo))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(TextoSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(BotonTransferir, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(BotonRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Este método se ejecuta cuando se hace clic en el botón "Transferir".
     * Obtiene la fecha y hora actuales y convierte la selección de cuenta
     * origen y destino a números enteros. Luego llama al método Transferir de
     * la clase Operaciones para realizar la transferencia de saldo entre las
     * cuentas seleccionadas. Si la transferencia es exitosa, cierra la ventana
     * actual y abre el menú principal.
     *
     * @param evt El evento que desencadena esta acción, en este caso, el clic
     * en el botón "Transferir".
     */
    private void BotonTransferirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonTransferirActionPerformed
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String fechaApertura = dateFormat.format(new Date());
        String seleccionString = (String) OpcionesCuentas.getSelectedItem();
        int seleccion = Integer.parseInt(seleccionString);

        String seleccionDestino = (String) CuentaDestino.getText();
        int destino = Integer.parseInt(seleccionDestino);

        if (op.Transferir(Saldo, seleccion, destino)) {
            dispose();
            new Menu_Principal(cliente).setVisible(true);
        }
    }//GEN-LAST:event_BotonTransferirActionPerformed

    /**
     * Este método se ejecuta cuando se hace clic en el botón "Regresar". Cierra
     * la ventana actual y abre el menú principal.
     *
     * @param evt El evento que desencadena esta acción, en este caso, el clic
     * en el botón "Regresar".
     */
    private void BotonRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonRegresarActionPerformed
        // TODO add your handling code here:
        dispose();
        new Menu_Principal(cliente).setVisible(true);
    }//GEN-LAST:event_BotonRegresarActionPerformed

    /**
     * Este método se ejecuta cuando se hace clic en el botón "Sumar".
     * Incrementa el saldo en 100 unidades y actualiza el campo de texto que
     * muestra el saldo actual.
     *
     * @param evt El evento que desencadena esta acción, en este caso, el clic
     * en el botón "Sumar".
     */
    private void AgregarSaldoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarSaldoActionPerformed
        Saldo += 100;
        TextoSaldo.setText(String.valueOf(Saldo));
    }//GEN-LAST:event_AgregarSaldoActionPerformed

    /**
     * Este método se ejecuta cuando se hace clic en el botón "Restar". Verifica
     * si el saldo actual es mayor o igual a 100 unidades. Si es así, decrementa
     * el saldo en 100 unidades y actualiza el campo de texto que muestra el
     * saldo actual.
     *
     * @param evt El evento que desencadena esta acción, en este caso, el clic
     * en el botón "Restar".
     */
    private void QuitarSaldoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QuitarSaldoActionPerformed
        if (Saldo >= 100) {
            Saldo -= 100;
            TextoSaldo.setText(String.valueOf(Saldo));
        }
    }//GEN-LAST:event_QuitarSaldoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AgregarSaldo;
    private javax.swing.JButton BotonRegresar;
    private javax.swing.JButton BotonTransferir;
    private javax.swing.JTextField CuentaDestino;
    private javax.swing.JComboBox<String> OpcionesCuentas;
    private javax.swing.JButton QuitarSaldo;
    private javax.swing.JTextField TextoSaldo;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
