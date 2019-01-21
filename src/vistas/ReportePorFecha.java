/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import controladores.ControladorAlumno;
import controladores.ControladorMateria;

import entidades.Asistencia;
import java.awt.Desktop;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 *
 * @author jafetandresgalvezquezada
 */
public class ReportePorFecha extends javax.swing.JInternalFrame {

    ControladorAlumno controladorAlumno = new ControladorAlumno();
    ControladorMateria controladorMateria = new ControladorMateria();
    String nombreDocente;

    public ReportePorFecha(String nombreDocente) {
        this.nombreDocente = nombreDocente;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        cmbMaterias = new javax.swing.JComboBox<>();
        btnGenerarReporte = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        calendario = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();

        setTitle("Reportes Por Fecha");

        jLabel1.setText("Materia:");

        cmbMaterias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbMateriasActionPerformed(evt);
            }
        });

        btnGenerarReporte.setText("Generar Reporte");
        btnGenerarReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarReporteActionPerformed(evt);
            }
        });

        btnSalir.setText("Salir");

        jLabel2.setText("Fecha");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbMaterias, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(calendario, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(87, 87, 87))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGenerarReporte)
                .addGap(78, 78, 78)
                .addComponent(btnSalir)
                .addGap(188, 188, 188))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cmbMaterias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(calendario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGenerarReporte)
                    .addComponent(btnSalir))
                .addGap(57, 57, 57))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbMateriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbMateriasActionPerformed


    }//GEN-LAST:event_cmbMateriasActionPerformed

    private void btnGenerarReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarReporteActionPerformed

        File directorioActual = new File("");

        String urlActual = "";
        try {
            urlActual = directorioActual.getCanonicalPath();
        } catch (IOException ex) {
            System.out.println("error directorio" + ex);
        }

        List resultados = new ArrayList();

        Asistencia asistencia;

        resultados.clear();
        int ano1 = calendario.getCalendar().get(Calendar.YEAR);
        int mes1 = calendario.getCalendar().get(Calendar.MONTH) + 1;
        int dia1 = calendario.getCalendar().get(Calendar.DAY_OF_MONTH);

        String fechaGuardar = "" + ano1 + "-" + mes1 + "-" + dia1;

        Map map = new HashMap();
        JasperPrint jprint;

        map.put("materia", cmbMaterias.getSelectedItem());
        map.put("docente", nombreDocente);

        try {

            jprint = JasperFillManager.fillReport(urlActual + "/src/reportes/ReportePorFecha.jasper", map, new JRBeanCollectionDataSource(controladorAlumno.listaReportePorFecha(fechaGuardar, controladorMateria.buscarCodigoMateria("" + cmbMaterias.getSelectedItem()))));

            JasperExportManager.exportReportToPdfFile(jprint, urlActual + "/src/reportes/rep1.pdf");
            String fileLocal = new String(urlActual + "/src/reportes/rep1.pdf");

            File path = new File(fileLocal);
            Desktop.getDesktop().open(path);
        } catch (JRException ex) {
            System.out.println("erro ireport" + ex);
        } catch (IOException ex) {
            Logger.getLogger(ReportePorFecha.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnGenerarReporteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGenerarReporte;
    private javax.swing.JButton btnSalir;
    private com.toedter.calendar.JDateChooser calendario;
    public static javax.swing.JComboBox<String> cmbMaterias;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
