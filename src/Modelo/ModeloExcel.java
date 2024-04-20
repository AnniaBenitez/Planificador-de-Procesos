package Modelo;

import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

/**
 * Clase modelo Excel
 * @author Annia Benítez 
 */
public class ModeloExcel {
    Workbook wb;
    
    /**
     * Permite importar o subir un archivo excel o csv al programa
     * @param archivo
     * @param tablaD
     * @return respuesta exitosa o no mediante string
     */
    public String Importar(File archivo, JTable tablaD){
        String respuesta = "No se pudo importar :(";
        DefaultTableModel modeloTabla = new DefaultTableModel();
        tablaD.setModel(modeloTabla);
        try{
            wb = WorkbookFactory.create(new FileInputStream(archivo));
            Sheet hoja = wb.getSheetAt(0);
            Iterator filaIterator = hoja.rowIterator();
            int indiceFila = -1;
            while(filaIterator.hasNext()){
                indiceFila++;
                Row fila = (Row) filaIterator.next();
                Iterator columnaIterator = fila.cellIterator();
                Object[] listaColumna = new Object[5];
                int indiceColumna = -1;
                while(columnaIterator.hasNext()){
                    indiceColumna++;
                    Cell celda = (Cell) columnaIterator.next();
                    if(indiceFila == 0){
                        modeloTabla.addColumn(celda.getStringCellValue());
                    }
                    else{
                        if(celda != null){
                            switch(celda.getCellType()){
                                case Cell.CELL_TYPE_NUMERIC:
                                    listaColumna[indiceColumna] = (int) Math.round(celda.getNumericCellValue());
                                    break;
                                case Cell.CELL_TYPE_STRING:
                                    listaColumna[indiceColumna] = celda.getStringCellValue();
                                    break;
                                case Cell.CELL_TYPE_BOOLEAN:
                                    listaColumna[indiceColumna] = celda.getBooleanCellValue();
                                    break;
                                default:
                                    listaColumna[indiceColumna] = celda.getDateCellValue();
                                    break;
                            }
                        }
                    }
                }
                if(indiceFila != 0) modeloTabla.addRow(listaColumna);
            }
            respuesta = "Importación Exitosa :D";
        }
        catch(Exception e){}        
        return respuesta;
    }
    
    /**
     * Permite exportar un archivo excel o csv 
     * @param archivo
     * @param tablaD
     * @return mensaje de exito o fracaso
     */
    public String Exportar(File archivo, JTable tablaD){
        String respuesta = "Exportación sin exito :(";
        int numeroFila = tablaD.getRowCount(), 
            numeroColumna = tablaD.getColumnCount();
        if(archivo.getName().endsWith("xls")){
            wb = new HSSFWorkbook();
        }
        else{
            wb = new XSSFWorkbook();
        }
        Sheet hoja = wb.createSheet("Nueva Hoja");
        try{
            for(int i = -1; i < numeroFila; i++){
                Row fila = hoja.createRow(i+1);
                for(int j=0; j<numeroColumna; j++){
                    Cell celda = fila.createCell(i);
                    if(i == -1){
                        celda.setCellValue(String.valueOf(tablaD.getColumnName(j)));
                    }
                    else{
                        celda.setCellValue(String.valueOf(tablaD.getValueAt(i,j)));
                    }
                    wb.write(new FileOutputStream(archivo));
                }
            }
            respuesta = "Se exportó con exito :D";
        }
        catch(Exception e){}
        return respuesta;
    }
}
