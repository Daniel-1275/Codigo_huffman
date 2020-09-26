package tabla;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class GestionEncabezadoTabla implements TableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
       JLabel jcomponent = null;

       if (value instanceof String){
           jcomponent = new JLabel((String) value);
           jcomponent.setHorizontalAlignment(SwingConstants.CENTER);
           jcomponent.setSize(80, 30);
           jcomponent.setPreferredSize(new Dimension(80, jcomponent.getHeight()));
       }
        if (jcomponent != null) {
            jcomponent.setBorder(BorderFactory.createMatteBorder(1,0,1,1, Color.pink));
            jcomponent.setOpaque(true);
            jcomponent.setBackground(new Color(236,84,89));
            jcomponent.setToolTipText("Tabla seguimiento");
            jcomponent.setForeground(Color.white);
        }


       return jcomponent;
    }
}
