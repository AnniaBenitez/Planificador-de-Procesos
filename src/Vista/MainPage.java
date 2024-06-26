package Vista;

import Controlador.ControladorExcel;
import Modelo.ModeloBCP;
import Modelo.ModeloExcel;
import java.util.List;
import java.util.ArrayList;
import Algoritmos.FCFS;
import Modelo.Resultado;
import Algoritmos.Prioridad;
import Algoritmos.RR;
import Algoritmos.HRRN;
import Algoritmos.SJFDesalojo;
import Algoritmos.SJFNoDesalojo;
import Utils.Utils;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Vista.Tablas;

/**
 * P�gina principal para visualizacion del programa
 * @author Annia Ben�tez
 */
public class MainPage extends javax.swing.JFrame {

    //Variables 
    List<ModeloBCP> procesos = new ArrayList<>();
    int tiempoTotal;
    String titulo[];
    private List<Tablas> tablas;
    
    /**
     * Creates new form MainPage
     */
    public MainPage() {
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

        jCheckBox1 = new javax.swing.JCheckBox();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        panelMenu = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        TablaPanel = new javax.swing.JPanel();
        btnImportar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtDatos = new javax.swing.JTable();
        labelProcesos = new javax.swing.JLabel();
        OperationPanel = new javax.swing.JPanel();
        cbFCFS = new javax.swing.JCheckBox();
        labelAlgoritmos = new javax.swing.JLabel();
        cbSJFNoDesalojo = new javax.swing.JCheckBox();
        cbSJFDesalojo = new javax.swing.JCheckBox();
        cbPrioridad = new javax.swing.JCheckBox();
        cbRR = new javax.swing.JCheckBox();
        cbHRRN = new javax.swing.JCheckBox();
        quantums = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        CalcularProcesos = new javax.swing.JButton();
        panelTablas = new javax.swing.JScrollPane();
        panelInterior = new javax.swing.JPanel();

        jCheckBox1.setText("jCheckBox1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("mainPage");

        jLabel1.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        jLabel1.setText("Planificador de procesos");

        TablaPanel.setBackground(new java.awt.Color(204, 204, 204));
        TablaPanel.setForeground(new java.awt.Color(204, 204, 204));

        btnImportar.setText("IMPORTAR");
        btnImportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImportarActionPerformed(evt);
            }
        });

        jtDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtDatos.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jtDatos);
        if (jtDatos.getColumnModel().getColumnCount() > 0) {
            jtDatos.getColumnModel().getColumn(0).setResizable(false);
            jtDatos.getColumnModel().getColumn(1).setResizable(false);
            jtDatos.getColumnModel().getColumn(2).setResizable(false);
            jtDatos.getColumnModel().getColumn(3).setResizable(false);
        }

        labelProcesos.setText("Importar Procesos a leer");

        javax.swing.GroupLayout TablaPanelLayout = new javax.swing.GroupLayout(TablaPanel);
        TablaPanel.setLayout(TablaPanelLayout);
        TablaPanelLayout.setHorizontalGroup(
            TablaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TablaPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(TablaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1027, Short.MAX_VALUE)
                    .addGroup(TablaPanelLayout.createSequentialGroup()
                        .addComponent(btnImportar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelProcesos, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        TablaPanelLayout.setVerticalGroup(
            TablaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TablaPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(TablaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(TablaPanelLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(labelProcesos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(btnImportar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        OperationPanel.setBackground(new java.awt.Color(204, 204, 204));
        OperationPanel.setForeground(new java.awt.Color(204, 204, 204));

        cbFCFS.setText("FCFS");

        labelAlgoritmos.setText("Seleccionar Algoritmos");

        cbSJFNoDesalojo.setText("SJF sin desalojo");
        cbSJFNoDesalojo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSJFNoDesalojoActionPerformed(evt);
            }
        });

        cbSJFDesalojo.setText("SJF con desalojo");
        cbSJFDesalojo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSJFDesalojoActionPerformed(evt);
            }
        });

        cbPrioridad.setText("Prioridad");

        cbRR.setText("RR");
        cbRR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbRRActionPerformed(evt);
            }
        });

        cbHRRN.setText("HRRN");

        quantums.setText("8");
        quantums.setEnabled(false);
        quantums.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quantumsActionPerformed(evt);
            }
        });

        jLabel2.setText("Q =");

        javax.swing.GroupLayout OperationPanelLayout = new javax.swing.GroupLayout(OperationPanel);
        OperationPanel.setLayout(OperationPanelLayout);
        OperationPanelLayout.setHorizontalGroup(
            OperationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OperationPanelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(OperationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(OperationPanelLayout.createSequentialGroup()
                        .addGroup(OperationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(OperationPanelLayout.createSequentialGroup()
                                .addComponent(cbSJFNoDesalojo, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, OperationPanelLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel2)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(quantums, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(OperationPanelLayout.createSequentialGroup()
                        .addGroup(OperationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelAlgoritmos)
                            .addComponent(cbSJFDesalojo)
                            .addGroup(OperationPanelLayout.createSequentialGroup()
                                .addGroup(OperationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbFCFS, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbPrioridad, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(44, 44, 44)
                                .addGroup(OperationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(cbRR, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbHRRN, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(84, Short.MAX_VALUE))))
        );
        OperationPanelLayout.setVerticalGroup(
            OperationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OperationPanelLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(labelAlgoritmos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(OperationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbFCFS)
                    .addComponent(cbRR))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(OperationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbHRRN)
                    .addComponent(cbPrioridad))
                .addGroup(OperationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(OperationPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbSJFDesalojo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbSJFNoDesalojo)
                        .addContainerGap(91, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, OperationPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(OperationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(quantums, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(17, 17, 17))))
        );

        CalcularProcesos.setText("Calcular Procesos");
        CalcularProcesos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CalcularProcesosActionPerformed(evt);
            }
        });

        panelInterior.setLayout(new java.awt.GridLayout(0, 1));
        panelTablas.setViewportView(panelInterior);

        javax.swing.GroupLayout panelMenuLayout = new javax.swing.GroupLayout(panelMenu);
        panelMenu.setLayout(panelMenuLayout);
        panelMenuLayout.setHorizontalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMenuLayout.createSequentialGroup()
                .addGroup(panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelMenuLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(CalcularProcesos, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelMenuLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelTablas)
                            .addGroup(panelMenuLayout.createSequentialGroup()
                                .addComponent(TablaPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(OperationPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(31, 31, 31))
            .addGroup(panelMenuLayout.createSequentialGroup()
                .addGap(586, 586, 586)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelMenuLayout.setVerticalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMenuLayout.createSequentialGroup()
                .addGroup(panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelMenuLayout.createSequentialGroup()
                        .addContainerGap(45, Short.MAX_VALUE)
                        .addComponent(OperationPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelMenuLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TablaPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CalcularProcesos)
                .addGap(12, 12, 12)
                .addComponent(panelTablas, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Boton que se encarga del evento importar, para importar el excel con procesos
     * @param evt 
     */
    private void btnImportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImportarActionPerformed
        // Crear una instancia del controlador
        ControladorExcel controlador = new ControladorExcel(this, new ModeloExcel(), procesos);

        // Llamar al m�todo de importaci�n del controlador
        controlador.actionPerformed(evt);

        //calcular el tiempo total del excel
        tiempoTotal = Utils.obtenerTiempoTotal(procesos);
        
        /*cargamos un titulo para la matriz*/
        titulo = new String[tiempoTotal];
        for (int i = 0; i < tiempoTotal; i++) {
            titulo[i] = "T" + i;
        }
        
        //Inicializamos la lista de tablas
        tablas = new ArrayList<>();

    }//GEN-LAST:event_btnImportarActionPerformed

    private void cbSJFNoDesalojoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSJFNoDesalojoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbSJFNoDesalojoActionPerformed

    private void cbSJFDesalojoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSJFDesalojoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbSJFDesalojoActionPerformed

    private void quantumsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quantumsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_quantumsActionPerformed

    private void cbRRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbRRActionPerformed
        if (cbRR.isSelected()) { // Si el JCheckBox est� seleccionado (activo)
            quantums.setEnabled(true); // Habilitar el JTextField
        } else {
            quantums.setEnabled(false); // Si no, deshabilitarlo
        }
    }//GEN-LAST:event_cbRRActionPerformed

    /**
     * Evento para el boton de calcular, que permite ejecutar todos los procesos marcados
     * @param evt 
     */
    private void CalcularProcesosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CalcularProcesosActionPerformed
        // Limpiar el panelInterior antes de agregar nuevas tablas
        limpiarPanelInterior();
        Resultado panel;
        //Imprimimos los nuevos graficos
        if (cbFCFS.isSelected()) {
            Utils.reiniciarRafagasEjecutadas(procesos);
            panel = FCFS.ejecutar(procesos);
            agregarTabla(panel.grafico, panel.promedioEspera, panel.promedioRespuesta, "FCFS");
        }
        if (cbPrioridad.isSelected()) {
            Utils.reiniciarRafagasEjecutadas(procesos);
            panel = Prioridad.ejecutar(procesos);
            agregarTabla(panel.grafico, panel.promedioEspera, panel.promedioRespuesta, "Prioridad");
        }
        if (cbSJFDesalojo.isSelected()) {
            Utils.reiniciarRafagasEjecutadas(procesos);
            panel = SJFDesalojo.ejecutar(procesos);
            agregarTabla(panel.grafico, panel.promedioEspera, panel.promedioRespuesta, "SJF con Desalojo");
        }
        if (cbSJFNoDesalojo.isSelected()) {
            Utils.reiniciarRafagasEjecutadas(procesos);
            panel = SJFNoDesalojo.ejecutar(procesos);
            agregarTabla(panel.grafico, panel.promedioEspera, panel.promedioRespuesta, "SJF sin desalojo");
        }
        if (cbRR.isSelected()) {
            int quantum = verificarQuantums();
            if (quantum> 0) {
                Utils.reiniciarRafagasEjecutadas(procesos);
                panel = RR.ejecutar(procesos,quantum);
                agregarTabla(panel.grafico, panel.promedioEspera, panel.promedioRespuesta, "RR");
            } else {
                JOptionPane.showMessageDialog(null, "Elija un n�mero de quantums v�lido!!");
            }
        }
        if (cbHRRN.isSelected()) {
            Utils.reiniciarRafagasEjecutadas(procesos);
            panel = HRRN.ejecutar(procesos);
            agregarTabla(panel.grafico, panel.promedioEspera, panel.promedioRespuesta, "HRRN");
        }

    }//GEN-LAST:event_CalcularProcesosActionPerformed
    /**
     * Verifica que el n�mero de quantums sea v�lido
     *
     * @return 0 si no es v�lido, otro n�mero si s� lo es
     */
    private int verificarQuantums() {
        String quantumsText = quantums.getText();
        if (!quantumsText.isEmpty()) {
            try {
                int quantumValue = Integer.parseInt(quantumsText);
                return quantumValue;
            } catch (NumberFormatException e) {
                System.err.println("Error: El valor ingresado en quantums no es un n�mero v�lido");
                return 0;
            }
        }
        return 0;
    }

    /**
     * Agrega la matriz resultante del proceso al Frame
     * @param panel 
     */
    private void agregarTabla(String[][] panel, double espera, double respuesta, String proceso) {        
        Tablas contenedorTablas = new Tablas();
        // Obtener el modelo de la tabla en contenedorTablas
        DefaultTableModel model = (DefaultTableModel) contenedorTablas.getTablaParaAlgoritmo().getModel();

        // Limpiar la tabla antes de cargar nuevos datos
        model.setRowCount(0);

        // Cargar los datos de la nueva tabla en la tabla en contenedorTablas
        contenedorTablas.cargarDatosEjercicio(panel, titulo, espera, respuesta, proceso);
        
        panelInterior.add(contenedorTablas);
        tablas.add(contenedorTablas);
        panelInterior.updateUI();
    }
    
    /**
     * M�todo para limpiar el panelInterior
     */
    private void limpiarPanelInterior() {
        tablas.clear();
        panelInterior.removeAll();
        panelInterior.revalidate();
        panelInterior.repaint();
    }

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
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton CalcularProcesos;
    private javax.swing.JPanel OperationPanel;
    public javax.swing.JPanel TablaPanel;
    public javax.swing.JButton btnImportar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    public javax.swing.JCheckBox cbFCFS;
    public javax.swing.JCheckBox cbHRRN;
    public javax.swing.JCheckBox cbPrioridad;
    public javax.swing.JCheckBox cbRR;
    public javax.swing.JCheckBox cbSJFDesalojo;
    public javax.swing.JCheckBox cbSJFNoDesalojo;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable jtDatos;
    private javax.swing.JLabel labelAlgoritmos;
    private javax.swing.JLabel labelProcesos;
    public javax.swing.JPanel panelInterior;
    public javax.swing.JPanel panelMenu;
    public javax.swing.JScrollPane panelTablas;
    public javax.swing.JTextField quantums;
    // End of variables declaration//GEN-END:variables
 
}
