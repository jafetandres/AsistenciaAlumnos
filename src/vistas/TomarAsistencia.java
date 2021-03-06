/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import controladores.ControladorAdministrador;
import controladores.ControladorAlumno;
import controladores.ControladorDocente;
import controladores.ControladorMateria;
import entidades.Alumno;
import entidades.Asistencia;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanArrayDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.swing.JRViewer;

/**
 *
 * @author jafetandresgalvezquezada
 */
public class TomarAsistencia extends javax.swing.JInternalFrame {

    ControladorAlumno controladorAlumno = new ControladorAlumno();
    ControladorMateria controladorMateria = new ControladorMateria();
    ControladorDocente controladorDocente = new ControladorDocente();
    static String nombresDocente;
    static String apellidosDocente;
    int contadorPresentes = 0;
    int contadorFaltantes = 0;
    int totalAsistencia = 0;
    int porcentajeAlumnos = 0;

    public TomarAsistencia(String nombresDocente, String apellidosDocente) {

        this.nombresDocente = nombresDocente;
        this.apellidosDocente = apellidosDocente;
        initComponents();
    }

    public TomarAsistencia() {

        initComponents();
    }

    public void llenarTablaAlumnos(JTable tablaAlumnos) {
        DefaultTableModel model = new DefaultTableModel() {
            public Class<?> getColumnClass(int column) {
                switch (column) {
                    case 0:
                        return String.class;
                    case 1:
                        return String.class;
                    case 2:
                        return String.class;
                    case 3:
                        return Boolean.class;
                    case 4:
                        return String.class;

                    default:
                        return String.class;
                }
            }
        };

        //ASSIGN THE MODEL TO TABLE
        tablaAlumnos.setModel(model);
        model.addColumn("Codigo");
        model.addColumn("Apellidos");
        model.addColumn("Nombres");
        model.addColumn("Asistencia");

        List<Alumno> lista = new ArrayList<>();
        lista = controladorAlumno.listarAlumnos("" + cmbMaterias.getSelectedItem());

        //THE ROW
        for (int i = 0; i <= lista.size() - 1; i++) {

            model.addRow(new Object[0]);
            model.setValueAt(lista.get(i).codigo, i, 0);
            model.setValueAt(lista.get(i).apellidos, i, 1);
            model.setValueAt(lista.get(i).nombres, i, 2);
            model.setValueAt(false, i, 3);

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

        btnTomarAsistencia = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtDocente = new javax.swing.JTextField();
        cmbMaterias = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaAlumnos = new javax.swing.JTable();

        setTitle("Tomar Asistencia");

        btnTomarAsistencia.setText("Tomar Asistencia");
        btnTomarAsistencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTomarAsistenciaActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        jLabel1.setText("ASIES");

        jLabel2.setText("Materia:");

        jLabel3.setText("Fecha:");

        txtFecha.setEditable(false);

        jLabel4.setText("Docente:");

        txtDocente.setEditable(false);
        txtDocente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDocenteActionPerformed(evt);
            }
        });

        cmbMaterias.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbMateriasItemStateChanged(evt);
            }
        });
        cmbMaterias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbMateriasActionPerformed(evt);
            }
        });

        tablaAlumnos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tablaAlumnos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(168, 168, 168)
                        .addComponent(btnTomarAsistencia)
                        .addGap(39, 39, 39)
                        .addComponent(btnCancelar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbMaterias, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDocente, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(141, 141, 141))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(311, 311, 311))
            .addGroup(layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbMaterias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtDocente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTomarAsistencia)
                    .addComponent(btnCancelar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtDocenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDocenteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDocenteActionPerformed

    private void cmbMateriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbMateriasActionPerformed

    }//GEN-LAST:event_cmbMateriasActionPerformed

    private void cmbMateriasItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbMateriasItemStateChanged
        llenarTablaAlumnos(tablaAlumnos);
    }//GEN-LAST:event_cmbMateriasItemStateChanged

    private void btnTomarAsistenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTomarAsistenciaActionPerformed

        File directorioActual = new File("");

        String urlActual = "";
        try {
            urlActual = directorioActual.getCanonicalPath();
        } catch (IOException ex) {
            System.out.println("error directorio" + ex);
        }

        ControladorAdministrador controladorAdministrador = new ControladorAdministrador();

        String estado = "";

        for (int i = 0; i < tablaAlumnos.getRowCount(); i++) {
            int codigoAsistencia = controladorAdministrador.ultimoCodigo("Asistencia") + 1;
            if (tablaAlumnos.getValueAt(i, 3).equals(true)) {
                estado = "PRESENTE";

            } else if (tablaAlumnos.getValueAt(i, 3).equals(false)) {
                estado = "FALTA";
            }

            controladorAdministrador.registrarAsistencia(codigoAsistencia, txtFecha.getText(),
                    controladorMateria.buscarCodigoMateria("" + cmbMaterias.getSelectedItem()),
                    controladorDocente.buscarCodigoDocente(nombresDocente, apellidosDocente), Integer.parseInt("" + tablaAlumnos.getValueAt(i, 0)), estado);

        }

        List resultados = new ArrayList();

        Asistencia asistencia;

        resultados.clear();

        for (int i = 0; i < tablaAlumnos.getRowCount(); i++) {

            if (tablaAlumnos.getValueAt(i, 3).equals(true)) {
                contadorPresentes++;
                estado = "PRESENTE";

            } else if (tablaAlumnos.getValueAt(i, 3).equals(false)) {
                contadorFaltantes++;
                estado = "FALTA";
            }

            System.out.println("PRESENTES: " + contadorPresentes);
            System.out.println("FALTANTES: " + contadorFaltantes);

            calcularPorcentajeAlumnosAsistentes(contadorPresentes, contadorFaltantes);
            System.out.println("total: " + calcularPorcentajeAlumnosAsistentes(contadorPresentes, contadorFaltantes));
            asistencia = new Asistencia();
            asistencia.setApellidosAlumnos(tablaAlumnos.getValueAt(i, 1).toString());
            asistencia.setNombresAlumnos(tablaAlumnos.getValueAt(i, 2).toString());
            asistencia.setEstado(estado);

            resultados.add(asistencia);

        }

        Map map = new HashMap();
        JasperPrint jprint;

        map.put("materia", cmbMaterias.getSelectedItem());
        map.put("docente", txtDocente.getText());
        map.put("fecha", txtFecha.getText());

        try {

            jprint = JasperFillManager.fillReport(urlActual + "/src/reportes/ReporteAsistencia.jasper", map, new JRBeanCollectionDataSource(resultados));

            JasperExportManager.exportReportToPdfFile(jprint, urlActual + "/src/reportes/rep1.pdf");
        } catch (JRException ex) {
            System.out.println("erro ireport" + ex);
        }

        try {

            Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.setProperty("mail.smtp.starttls.enable", "true");
            props.setProperty("mail.smtp.port", "587");
            props.setProperty("mail.smtp.user", "reportesasistenciaups@gmail.com");
            props.setProperty("mail.smtp.auth", "true");

            Session session = Session.getDefaultInstance(props, null);
            session.setDebug(true);

            String[] correosRepresentantes = new String[tablaAlumnos.getRowCount()];
            for (int i = 0; i < correosRepresentantes.length; i++) {

                correosRepresentantes[i] = controladorAlumno.listarCorreos(Integer.parseInt("" + tablaAlumnos.getValueAt(i, 0)));

                BodyPart texto = new MimeBodyPart();
                texto.setText("Reporte Asistencia UPS");
                BodyPart adjunto = new MimeBodyPart();
                adjunto.setDataHandler(new DataHandler(new FileDataSource(urlActual + "/src/reportes/rep1.pdf")));
                adjunto.setFileName("rep1.pdf");
                MimeMultipart multiParte = new MimeMultipart();
                multiParte.addBodyPart(adjunto);
                multiParte.addBodyPart(texto);
                MimeMessage message = new MimeMessage(session);

                message.setFrom(new InternetAddress("reportesasistenciaups@gmail.com"));

                message.addRecipient(Message.RecipientType.TO, new InternetAddress(correosRepresentantes[i]));

                message.setSubject("Reporte Asistencia UPS");
                message.setContent(multiParte);

                Transport t = session.getTransport("smtp");
                System.out.println("reporte enviado");
                t.connect("reportesasistenciaups@gmail.com", "prueba123");

                t.sendMessage(message, message.getAllRecipients());
                t.close();

            }
        } catch (NoSuchProviderException ex) {
            System.out.println("error compruebe su conexion1" + ex);
        } catch (MessagingException ex) {
            System.out.println("error compruebe su conexion2" + ex);
        }

    }//GEN-LAST:event_btnTomarAsistenciaActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    public int calcularPorcentajeAlumnosAsistentes(int contadorPresentes, int contadorFaltantes) {
        totalAsistencia = contadorFaltantes + contadorPresentes;
        porcentajeAlumnos = (contadorPresentes * 100) / totalAsistencia;
        return porcentajeAlumnos;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnTomarAsistencia;
    public static javax.swing.JComboBox<String> cmbMaterias;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JTable tablaAlumnos;
    public static javax.swing.JTextField txtDocente;
    public static javax.swing.JTextField txtFecha;
    // End of variables declaration//GEN-END:variables
}
