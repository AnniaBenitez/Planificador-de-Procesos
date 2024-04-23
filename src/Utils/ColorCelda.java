package Utils;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 * Crea una instancia de JTable, pero ya configurada para representar colores segun resultados de procesos
 * @author Annia Benítez
 */
public class ColorCelda extends JTable /*implements TableCellRenderer*/{

    @Override
    public Component prepareRenderer(TableCellRenderer renderer, int rowIndex, int columnIndex) {
        
        Component componente = super.prepareRenderer(renderer, rowIndex, columnIndex);

        Object value = getValueAt(rowIndex, columnIndex);
        if (null != value && value.getClass().equals(String.class)) {
            char valor = value.toString().charAt(1);            
            switch (valor) {
                case '0' -> {
                    componente.setBackground(Color.WHITE);
                    componente.setForeground(Color.WHITE);
                }
                case '1' -> {
                    componente.setBackground(Color.YELLOW);
                    componente.setForeground(Color.YELLOW);
                }
                case 'w', 'W' -> {
                    componente.setBackground(Color.GRAY);
                    componente.setForeground(Color.GRAY);
                }
                default -> {
                }
            }
        } else {
            componente.setBackground(Color.RED);
            componente.setForeground(Color.red);
            
        }
        return componente;
    }
}
