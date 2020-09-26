package tabla;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class GestionCeldaTabla extends DefaultTableCellRenderer {
    private String tipo ="text";
    private final Font normal = new Font("Verdana",  Font.PLAIN, 12);


    public GestionCeldaTabla(){

    }
    public GestionCeldaTabla(String tipo){
        this.tipo = tipo;
    }


    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Color colorFondo = null;
        Color colorFondoPorDefecto = new Color(192,192,192);
        Color colorFondoSeleccionado = new Color(140,140,140);

        if (isSelected){
            this.setBackground(colorFondoPorDefecto);
        }else{
            this.setBackground(Color.white);
        }
        if (tipo.equals("texto")) {
            if (hasFocus) {
                colorFondo = colorFondoSeleccionado;
            } else {
                colorFondo = colorFondoPorDefecto;
            }
            this.setHorizontalAlignment(JLabel.CENTER);
            this.setText((String) value);
            this.setBackground((isSelected) ? colorFondo: Color.white);
            this.setFont(normal);
            return this;
        }

        return this;
    }
}
