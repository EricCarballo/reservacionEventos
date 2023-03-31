package interfaz;

import com.sun.org.apache.bcel.internal.generic.AALOAD;
import com.toedter.calendar.JDateChooser;
import static control.EmpleadoControlador.entityManager;
import control.ReservacionControlador;
import control.TipoReservacionControlador;
import entidades.TblReservacion;
import entidades.TblTipoReservacion;
import java.awt.Color;
import java.awt.Image;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class frmSolicitudRes extends javax.swing.JFrame {

    int xMouse, yMouse;

    public frmSolicitudRes() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Reservaciones de Eventos");
        Image icon = new ImageIcon(getClass().getResource("/img/logo.png")).getImage();
        setIconImage(icon);
        setSize(950, 730);
        cargarImg();
        listarDescripcion();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnReturn = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        header = new javax.swing.JPanel();
        Cerrar = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        cmbEvento = new javax.swing.JComboBox<>();
        Fecha = new com.toedter.calendar.JDateChooser();
        btnReservar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNombreCliente = new javax.swing.JTextField();
        imagenCargada = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnReturn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReturn.setOpaque(false);
        btnReturn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnReturnMouseClicked(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/flecha-izquierda.png"))); // NOI18N

        javax.swing.GroupLayout btnReturnLayout = new javax.swing.GroupLayout(btnReturn);
        btnReturn.setLayout(btnReturnLayout);
        btnReturnLayout.setHorizontalGroup(
            btnReturnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnReturnLayout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 8, Short.MAX_VALUE))
        );
        btnReturnLayout.setVerticalGroup(
            btnReturnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnReturnLayout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 8, Short.MAX_VALUE))
        );

        jPanel1.add(btnReturn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 40, 40));

        header.setOpaque(false);
        header.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                headerMouseDragged(evt);
            }
        });
        header.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                headerMousePressed(evt);
            }
        });

        Cerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Cerrar.setOpaque(false);
        Cerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CerrarMouseClicked(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/eliminar.png"))); // NOI18N

        javax.swing.GroupLayout CerrarLayout = new javax.swing.GroupLayout(Cerrar);
        Cerrar.setLayout(CerrarLayout);
        CerrarLayout.setHorizontalGroup(
            CerrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CerrarLayout.createSequentialGroup()
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        CerrarLayout.setVerticalGroup(
            CerrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CerrarLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerLayout.createSequentialGroup()
                .addContainerGap(901, Short.MAX_VALUE)
                .addComponent(Cerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(188, 188, 188))
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Cerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, Short.MAX_VALUE)
        );

        jPanel1.add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1130, 40));

        cmbEvento.setFont(new java.awt.Font("Roboto", 2, 14)); // NOI18N
        cmbEvento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Quinceaños", "Cumpleaños", "Boda", "Graduación", "Fiesta" }));
        cmbEvento.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cmbEvento.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                cmbEventoPropertyChange(evt);
            }
        });

        Fecha.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        Fecha.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                FechaPropertyChange(evt);
            }
        });

        btnReservar.setBackground(new java.awt.Color(204, 102, 255));
        btnReservar.setFont(new java.awt.Font("Roboto", 3, 18)); // NOI18N
        btnReservar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/aceptar.png"))); // NOI18N
        btnReservar.setText("Reservar");
        btnReservar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReservar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReservarActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel3.setText("Seleccione su fecha:");

        jLabel5.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel5.setText("Nombre del cliente:");

        txtNombreCliente.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLabel7.setText("Descripcion:");

        txtDescripcion.setColumns(20);
        txtDescripcion.setRows(5);
        jScrollPane2.setViewportView(txtDescripcion);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addGap(8, 8, 8)
                .addComponent(Fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(204, 204, 204))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(300, 300, 300)
                        .addComponent(cmbEvento, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addComponent(jLabel5)
                        .addGap(10, 10, 10)
                        .addComponent(txtNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addComponent(jLabel7))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(131, 131, 131)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(imagenCargada, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(283, 283, 283)
                        .addComponent(btnReservar)))
                .addGap(138, 138, 138))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(cmbEvento, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jLabel7)
                .addGap(2, 2, 2)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(imagenCargada, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(txtNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jLabel5)))
                .addGap(76, 76, 76)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel3)))
                .addGap(57, 57, 57)
                .addComponent(btnReservar)
                .addContainerGap())
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, 710, 530));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/quinceañosFiesta.png"))); // NOI18N
        jLabel4.setText("jLabel4");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        jPanel1.add(txtFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 250, 61, 31));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 750, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public String idTipoReservacion() {
        String idTipoReservacion = cmbEvento.getSelectedItem().toString();

        switch (idTipoReservacion) {
            case "Quinceaños":
                idTipoReservacion = "1";
                break;

            case "Cumpleaños":
                idTipoReservacion = "3";
                break;

            case "Boda":
                idTipoReservacion = "4";
                break;

            case "Graduación":
                idTipoReservacion = "6";
                break;

            case "Fiesta":
                idTipoReservacion = "8";
                break;
        }

        return idTipoReservacion;
    }

    public void listarDescripcion() {
        TipoReservacionControlador RC = new TipoReservacionControlador();
        
        String TipoReservacion = cmbEvento.getSelectedItem().toString();
        
        switch (TipoReservacion) {
            case "Quinceaños":
                TipoReservacion = "1";
                break;

            case "Cumpleaños":
                TipoReservacion = "3";
                break;

            case "Boda":
                TipoReservacion = "4";
                break;

            case "Graduación":
                TipoReservacion = "6";
                break;

            case "Fiesta":
                TipoReservacion = "8";
                break;
        }
        
        int id = Integer.parseInt(TipoReservacion);
        List<TblTipoReservacion> t = RC.buscarId(id);

        String desc = t.get(id - 1).getDescripcion();
        txtDescripcion.setText(desc);
    }
    
    public void cargarImg() {

        String evento = cmbEvento.getSelectedItem().toString();

        switch (evento) {
            case "Quinceaños":
                ImageIcon iconXV = new ImageIcon(getClass().getResource("/img/quinceañosFiesta.png"));
                Image fotoXV = iconXV.getImage().getScaledInstance(120, 120, 0);
                imagenCargada.setIcon(new ImageIcon(fotoXV));
                break;

            case "Cumpleaños":
                ImageIcon iconCumple = new ImageIcon(getClass().getResource("/img/cumpleaños.jpeg"));
                Image fotoCumple = iconCumple.getImage().getScaledInstance(224, 167, 0);
                imagenCargada.setIcon(new ImageIcon(fotoCumple));
                break;

            case "Boda":
                ImageIcon iconBoda = new ImageIcon(getClass().getResource("/img/Principal2.png"));
                Image fotoBoda = iconBoda.getImage().getScaledInstance(224, 167, 0);
                imagenCargada.setIcon(new ImageIcon(fotoBoda));
                break;

            case "Graduación":
                ImageIcon iconGra = new ImageIcon(getClass().getResource("/img/graduacionFiestasa.png"));
                Image fotoGra = iconGra.getImage().getScaledInstance(224, 167, 0);
                imagenCargada.setIcon(new ImageIcon(fotoGra));
                break;
            case "Fiesta":
                ImageIcon iconFiesta = new ImageIcon(getClass().getResource("/img/Fiestaclaro.png"));
                Image fotoFiesta = iconFiesta.getImage().getScaledInstance(224, 167, 0);
                imagenCargada.setIcon(new ImageIcon(fotoFiesta));
                break;
        }

    }

    DefaultTableModel modelo = new DefaultTableModel();
    private void btnReturnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReturnMouseClicked
        FrmPrincipal form = new FrmPrincipal();
        form.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnReturnMouseClicked

    private void headerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_headerMousePressed

    private void headerMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();

        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_headerMouseDragged

    private void btnReservarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReservarActionPerformed

        EntityManager em = entityManager();

        String idTipoReservacion = idTipoReservacion();
        int id = Integer.parseInt(idTipoReservacion);
        String nombreCliente = txtNombreCliente.getText();
        String fecha = txtFecha.getText();

        if (nombreCliente.isEmpty() || fecha.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Todos Los Campos Deben De Estár Llenos");
        } else {
            ReservacionControlador RC = new ReservacionControlador();
            TblReservacion nuevaReservacin = new TblReservacion(null, id, nombreCliente, fecha, true);
            RC.Crear(nuevaReservacin);
            int otroRegistro = JOptionPane.showConfirmDialog(null, "Evento Guardado, ¿Deseas Guardar Otro Evento?", "Reservar Evento", JOptionPane.INFORMATION_MESSAGE);
            if (otroRegistro != 1) {
                listarDescripcion();
                txtFecha.setText("");
                txtNombreCliente.setText("");
            } else {
                this.dispose();
                FrmPrincipal principal = new FrmPrincipal();
                principal.setVisible(true);
            }
        }
    }//GEN-LAST:event_btnReservarActionPerformed

    private void CerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CerrarMouseClicked
        System.exit(0);
    }//GEN-LAST:event_CerrarMouseClicked

    private void FechaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_FechaPropertyChange

        if ("date".equals(evt.getPropertyName())) {
            Date date = (Date) evt.getNewValue();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            String dateString = sdf.format(date);
            txtFecha.setText(dateString);
        }

    }//GEN-LAST:event_FechaPropertyChange

    private void cmbEventoPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_cmbEventoPropertyChange
        
        String tipoReservacion = cmbEvento.getSelectedItem().toString();
        
        switch(tipoReservacion){
            case "Quinceaños":
                ImageIcon quinceIcon = new ImageIcon(getClass().getResource("/img/quinceañosFiesta.png"));
                Image imgQuince = quinceIcon.getImage().getScaledInstance(120, 120, 0);
                imagenCargada.setIcon(new ImageIcon(imgQuince));
                break;
            case "Cumpleaños":
                ImageIcon cumpleIcon = new ImageIcon(getClass().getResource("/img/cumpleaños.jpeg"));
                Image imgcumple = cumpleIcon.getImage().getScaledInstance(120, 120, 0);
                imagenCargada.setIcon(new ImageIcon(imgcumple));
                break;
            case "Boda":
                ImageIcon bodaIcon = new ImageIcon(getClass().getResource("/img/Principal2.png"));
                Image imgboda = bodaIcon.getImage().getScaledInstance(120, 120, 0);
                imagenCargada.setIcon(new ImageIcon(imgboda));
                break;
            case "Graduación":
                ImageIcon iconBoda = new ImageIcon(getClass().getResource("/img/graduacionFiestasa.png"));
                Image imgBoda = iconBoda.getImage().getScaledInstance(120, 120, 0);
                imagenCargada.setIcon(new ImageIcon(imgBoda));
                break;
            case "Fiesta":
                ImageIcon iconFiesta = new ImageIcon(getClass().getResource("/img/Fiestaclaro.png"));
                Image imgFiesta = iconFiesta.getImage().getScaledInstance(120, 120, 0);
                imagenCargada.setIcon(new ImageIcon(imgFiesta));
                break;
        }
        
    }//GEN-LAST:event_cmbEventoPropertyChange

    public static void main(String args[]) {

        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmSolicitudRes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmSolicitudRes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmSolicitudRes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmSolicitudRes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmSolicitudRes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Cerrar;
    private com.toedter.calendar.JDateChooser Fecha;
    private javax.swing.JButton btnReservar;
    private javax.swing.JPanel btnReturn;
    private javax.swing.JComboBox<String> cmbEvento;
    private javax.swing.JPanel header;
    private javax.swing.JLabel imagenCargada;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JLabel txtFecha;
    private javax.swing.JTextField txtNombreCliente;
    // End of variables declaration//GEN-END:variables
}
