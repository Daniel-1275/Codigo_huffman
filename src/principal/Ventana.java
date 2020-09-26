package principal;

import huffman.Letra;
import tabla.GestionCeldaTabla;
import tabla.GestionEncabezadoTabla;
import tabla.ModeloTabla;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Ventana extends JFrame {

    private JPanel panel;
    private JLabel titulo;
    private JScrollPane scrollPaneTabla;
    private JTable tablaHuffman;
    private List<Letra> letras;
    private JLabel contadorBits;
    private JButton boton;
    ModeloTabla modelo;


    public Ventana(List<Letra> letraList){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Codigo Huffman");
        setSize(700,550);
        setLocationRelativeTo(null);

        setResizable(false);
        this.letras = letraList;
        initComponentes();

    }
    private void initComponentes(){
        iniciandoPanel();
        iniciandoLabels();
        iniciandoTabla_scroll();
        iniciandoBoton();
    }

    private void iniciandoBoton() {

        boton = new JButton("Regresar");
        boton.setBounds(60, 470, 150, 30);
        boton.setOpaque(true);
        boton.setFocusPainted(false);
        boton.setFont(new Font("Arial", Font.PLAIN, 18));
        boton.setForeground(new Color(0xEAE6E6));
        boton.setBackground(new Color(0x457b9d));
        panel.add(boton);
    }

    private void iniciandoTabla_scroll(){
        scrollPaneTabla = new JScrollPane();
        scrollPaneTabla.setBounds(100,140,500, 300);
        this.panel.add(scrollPaneTabla);

        tablaHuffman = new JTable();
        tablaHuffman.setBackground(Color.white);
        tablaHuffman.setOpaque(false);
        tablaHuffman.setLayout(new FlowLayout());
        tablaHuffman.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,null,null));
        construirTabla();
    }
    private void construirTabla() {
        ArrayList<String> tituloList = new ArrayList<>();
        tituloList.add("Letra");
        tituloList.add("Contador");
        tituloList.add("Huffman");

        String[] encabezados = new String[tituloList.size()];
        for (int i = 0; i < encabezados.length; i++){
            encabezados[i] = tituloList.get(i);
        }

        Object[][] data = new Object[this.letras.size()][encabezados.length];

        for (int i = 0; i < data.length; i++){
            data[i][0] = String.valueOf(letras.get(i).getLetra());
            data[i][1] = String.valueOf(letras.get(i).getContador());
            data[i][2] = letras.get(i).getBinarioOptimo().toString();
        }
        construirTabla(encabezados, data);
    }
    private void construirTabla(String[] encabezados, Object[][] data){
        modelo = new ModeloTabla(data, encabezados);

        tablaHuffman.setModel(modelo);



        tablaHuffman.getColumnModel().getColumn(0).setCellRenderer(new GestionCeldaTabla("texto"));
        tablaHuffman.getColumnModel().getColumn(1).setCellRenderer(new GestionCeldaTabla("texto"));
        tablaHuffman.getColumnModel().getColumn(2).setCellRenderer(new GestionCeldaTabla("texto"));

        tablaHuffman.getTableHeader().setReorderingAllowed(false);
        tablaHuffman.setRowHeight(25);
        tablaHuffman.setGridColor(new Color(0,0,0));

        tablaHuffman.getColumnModel().getColumn(0).setPreferredWidth(80);
        tablaHuffman.getColumnModel().getColumn(0).setPreferredWidth(80);
        tablaHuffman.getColumnModel().getColumn(0).setPreferredWidth(130);
        tablaHuffman.setBounds(10,10,20,20);
        JTableHeader jTableHeader = tablaHuffman.getTableHeader();
        jTableHeader.setDefaultRenderer(new GestionEncabezadoTabla());
        tablaHuffman.setTableHeader(jTableHeader);

        scrollPaneTabla.setViewportView(tablaHuffman);

    }

    private void iniciandoPanel(){
        panel = new JPanel();
        panel.setBackground(new Color(168, 218, 220));
        panel.setBorder(new EmptyBorder(5,5,5,5 ));
        panel.setLayout(null);
        getContentPane().add(panel);

    }
    private void iniciandoLabels(){
        titulo = new JLabel("Codigo Huffman");
        titulo.setFont(new Font("Avenir Next LT Pro Light", Font.BOLD, 24));
        titulo.setBounds(90,60, 200, 30);

        int total = 0;
        for (Letra letra: letras){
            total += (letra.getContador()) * letra.getBinarioOptimo().size();
        }

        contadorBits = new JLabel("Total de bits: " + total);
        contadorBits.setFont(new Font("Arial", Font.BOLD, 18));
        contadorBits.setBounds(500, 470, 300, 30);

        panel.add(titulo);
        panel.add(contadorBits);

    }

    public JButton getBoton() {
        return boton;
    }
}
