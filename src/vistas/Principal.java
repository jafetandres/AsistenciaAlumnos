/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import controladores.ControladorAlumno;
import controladores.ControladorMateria;
import entidades.Administrador;
import entidades.Alumno;
import entidades.Materia;
import java.awt.Dimension;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jafetandresgalvezquezada
 */
public class Principal extends javax.swing.JFrame {
    
    ControladorMateria controladorMateria = new ControladorMateria();
    ControladorAlumno controladorAlumno = new ControladorAlumno();
    
    public Principal() {
        this.setLocationRelativeTo(null);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        initComponents();
        
    }
    
    public void llenarTablaMaterias(JTable tablaMaterias) {
        DefaultTableModel model = new DefaultTableModel() {
            public Class<?> getColumnClass(int column) {
                switch (column) {
                    case 0:
                        return Boolean.class;
                    case 1:
                        return String.class;
                    case 2:
                        return String.class;
                    case 3:
                        return String.class;
                    case 4:
                        return String.class;
                    
                    default:
                        return String.class;
                }
            }
        };

        //ASSIGN THE MODEL TO TABLE
        tablaMaterias.setModel(model);
        
        model.addColumn("Seleccionar");
        model.addColumn("Codigo");
        model.addColumn("Nombre");
        model.addColumn("Numero de Creditos");
        
        List<Materia> lista = new ArrayList<>();
        lista = controladorMateria.listarMaterias();

        //THE ROW
        for (int i = 0; i <= lista.size() - 1; i++) {
            
            model.addRow(new Object[0]);
            model.setValueAt(false, i, 0);
            model.setValueAt(lista.get(i).codigo, i, 1);
            model.setValueAt(lista.get(i).nombre, i, 2);
            model.setValueAt(lista.get(i).numCreditos, i, 3);
            
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

        panel = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuHerramientas = new javax.swing.JMenu();
        menuMateria = new javax.swing.JMenu();
        submenuRegistrarMateria = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        menuAlumno = new javax.swing.JMenu();
        submenuRegistarAlumno = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        menuDocente = new javax.swing.JMenu();
        submenuRegistrarDocente = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        submenuTomarAsistencia = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        menuHerramientas.setText("Herramientas");

        menuMateria.setText("Materia");

        submenuRegistrarMateria.setText("Registrar Materia");
        submenuRegistrarMateria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submenuRegistrarMateriaActionPerformed(evt);
            }
        });
        menuMateria.add(submenuRegistrarMateria);

        jMenuItem3.setText("Modificar Materia");
        menuMateria.add(jMenuItem3);

        jMenuItem4.setText("Eliminar Materia");
        menuMateria.add(jMenuItem4);

        menuHerramientas.add(menuMateria);

        menuAlumno.setText("Alumno");

        submenuRegistarAlumno.setText("Registrar Alumno");
        submenuRegistarAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submenuRegistarAlumnoActionPerformed(evt);
            }
        });
        menuAlumno.add(submenuRegistarAlumno);

        jMenuItem5.setText("Modificar Alumno");
        menuAlumno.add(jMenuItem5);

        jMenuItem6.setText("Eliminar Alumno");
        menuAlumno.add(jMenuItem6);

        menuHerramientas.add(menuAlumno);

        menuDocente.setText("Docente");

        submenuRegistrarDocente.setText("Registrar Docente");
        submenuRegistrarDocente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submenuRegistrarDocenteActionPerformed(evt);
            }
        });
        menuDocente.add(submenuRegistrarDocente);

        jMenuItem7.setText("Modificar Docente");
        menuDocente.add(jMenuItem7);

        jMenuItem8.setText("Eliminar Docente");
        menuDocente.add(jMenuItem8);

        menuHerramientas.add(menuDocente);

        jMenuBar1.add(menuHerramientas);

        jMenu4.setText("Procesos");

        submenuTomarAsistencia.setText("Tomar Asistencia");
        submenuTomarAsistencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submenuTomarAsistenciaActionPerformed(evt);
            }
        });
        jMenu4.add(submenuTomarAsistencia);

        jMenu1.setText("Generar Reportes");

        jMenuItem1.setText("Reporte por Alumno");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Reporte por Fecha");
        jMenu1.add(jMenuItem2);

        jMenu4.add(jMenu1);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void submenuRegistarAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submenuRegistarAlumnoActionPerformed
        RegistrarAlumno registrarAlumno = new RegistrarAlumno();
        panel.add(registrarAlumno);
        Dimension desktopSize = Principal.panel.getSize();
        Dimension FrameSize = registrarAlumno.getSize();
        registrarAlumno.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
        llenarTablaMaterias(RegistrarAlumno.tablaMaterias);
        registrarAlumno.setVisible(true);

    }//GEN-LAST:event_submenuRegistarAlumnoActionPerformed

    private void submenuRegistrarDocenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submenuRegistrarDocenteActionPerformed
        RegistrarDocente registrarDocente = new RegistrarDocente();
        panel.add(registrarDocente);
        Dimension desktopSize = Principal.panel.getSize();
        Dimension FrameSize = registrarDocente.getSize();
        registrarDocente.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
        llenarTablaMaterias(RegistrarDocente.tablaMaterias);
        registrarDocente.setVisible(true);
    }//GEN-LAST:event_submenuRegistrarDocenteActionPerformed

    private void submenuRegistrarMateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submenuRegistrarMateriaActionPerformed
        RegistrarMateria registrarMateria = new RegistrarMateria();
        panel.add(registrarMateria);
        Dimension desktopSize = Principal.panel.getSize();
        Dimension FrameSize = registrarMateria.getSize();
        registrarMateria.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
        registrarMateria.setVisible(true);
    }//GEN-LAST:event_submenuRegistrarMateriaActionPerformed

    private void submenuTomarAsistenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submenuTomarAsistenciaActionPerformed
        
        TomarAsistencia tomarAsistencia = new TomarAsistencia();
        panel.add(tomarAsistencia);
        Dimension desktopSize = Principal.panel.getSize();
        Dimension FrameSize = tomarAsistencia.getSize();
        tomarAsistencia.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
       
  
        TomarAsistencia.txtFecha.setText("" + dateFormat.format(date));
  
        List<Materia> lista = new ArrayList<>();
        lista = controladorMateria.listarMaterias();
        
        for (int i = 0; i <= lista.size() - 1; i++) {
            
            TomarAsistencia.cmbMaterias.addItem(lista.get(i).nombre);
            
        }
        
        tomarAsistencia.setVisible(true);
    }//GEN-LAST:event_submenuTomarAsistenciaActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenu menuAlumno;
    private javax.swing.JMenu menuDocente;
    public static javax.swing.JMenu menuHerramientas;
    private javax.swing.JMenu menuMateria;
    public static javax.swing.JDesktopPane panel;
    private javax.swing.JMenuItem submenuRegistarAlumno;
    private javax.swing.JMenuItem submenuRegistrarDocente;
    private javax.swing.JMenuItem submenuRegistrarMateria;
    private javax.swing.JMenuItem submenuTomarAsistencia;
    // End of variables declaration//GEN-END:variables
}
