package tabla;

import javax.swing.table.DefaultTableModel;

public class ModeloTabla extends DefaultTableModel {
    String[] titulos;
    Object[][] datos;
    /**
     * Determina el modelo con el que se va a construir la tabla
     * @param datos
     * @param titulos
     */
    public ModeloTabla(Object[][] datos, String[] titulos){
        super();
        this.titulos = titulos;
        this.datos = datos;
        setDataVector(datos, titulos);
    }
    public ModeloTabla(){

    }

    public boolean isCellEditable(int row, int column) {
        return false;
    }
}
