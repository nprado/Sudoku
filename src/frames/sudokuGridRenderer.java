/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package frames;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import frames.SudokuGUI;
/**
 *
 * @author daniel
 */


public class sudokuGridRenderer extends DefaultTableCellRenderer {
    

    public sudokuGridRenderer(){
        super();
        
    }
    

    // O desenho da tabela sera modificado , ficando com a cara de um Sudoku Grid
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,  boolean isSelected, boolean hasFocus , int row, int column){
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column );
        if ( ( (row > 5  || row < 3 ) && (column < 3 || column > 5 ) ) || ( (column > 2 && column < 6) && (row > 2 && row < 6) ))  {
            setBackground(Color.LIGHT_GRAY);
        } else{
            setBackground(Color.WHITE);
        }
        
        return this;
    }

}
