package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import Vista.MainPage;
import Modelo.ModeloExcel;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * Clase controladora con controladores de eventos
 * @author Annia Benítez
 */
public class ControladorExcel implements ActionListener{
    
    
    
    ModeloExcel modeloExcel = new ModeloExcel();
    MainPage vistaExcel = new MainPage();
    
    JFileChooser seleccionarArchivo = new JFileChooser();
    File archivo;
    int contAccion;
    
    public ControladorExcel(MainPage vistaE, ModeloExcel modeloE){
        this.vistaExcel = vistaE;
        this.modeloExcel = modeloE;
        this.vistaExcel.btnImportar.addActionListener(this);
    }
    
    public void AgregarFiltro(){
        seleccionarArchivo.setFileFilter(new FileNameExtensionFilter("Excel (.xls)","xls"));
        seleccionarArchivo.setFileFilter(new FileNameExtensionFilter("Excel (.xlsx)","xlsx"));
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        contAccion++;
        if(contAccion == 1) AgregarFiltro();
        
        if(e.getSource() == vistaExcel.btnImportar){
            if(seleccionarArchivo.showDialog(null, "Seleccionar archivo") == JFileChooser.APPROVE_OPTION){
                archivo = seleccionarArchivo.getSelectedFile();
                if(archivo.getName().endsWith("xls") || archivo.getName().endsWith("xlsx")){
                    JOptionPane.showMessageDialog(null, modeloExcel.Importar(archivo, vistaExcel.jtDatos));
                }
                else{
                    JOptionPane.showMessageDialog(null, "Elija un formato válido!!");
                }
            }
        }
    }
}
