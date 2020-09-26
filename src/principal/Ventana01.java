package principal;



import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;


public class Ventana01 extends JFrame {
    private JPanel panel;

    private JButton boton;
    private TextArea areaTexto;


    public Ventana01(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Codigo Huffman");
        setSize(700,550);
        setLocationRelativeTo(null);

        setResizable(false);

        initComponentes();

    }
    private void initComponentes(){
        iniciandoPanel();
        iniciandoAreaTexto();
        iniciandoLabels();
        iniciandoBoton();
    }

    private void iniciandoBoton() {
        boton = new JButton("Obtener codigo optimo");
        boton.setBounds(200, 420, 280, 30);
        boton.setOpaque(true);
        boton.setFocusPainted(false);
        boton.setFont(new Font("Arial Black", Font.PLAIN, 18));
        boton.setForeground(new Color(0xEAE6E6));
        boton.setBackground(new Color(0x457b9d));

        panel.add(boton);
    }

    private void iniciandoAreaTexto() {
        areaTexto = new TextArea();
        areaTexto.setBounds(90, 180, 500,200);
        areaTexto.setFont(new Font("Californian FB", Font.PLAIN, 18));
        panel.add(areaTexto);
    }

    private void iniciandoPanel(){
        panel = new JPanel();
        panel.setBackground(new Color(168, 218, 220));
        panel.setBorder(new EmptyBorder(5,5,5,5 ));
        panel.setLayout(null);
        getContentPane().add(panel);
    }
    private void iniciandoLabels(){
        JLabel titulo = new JLabel("Bienvenido a la app");
        titulo.setFont(new Font("Avenir Next LT Pro Light", Font.BOLD, 24));
        titulo.setBounds(90,60, 300, 30);

        JLabel subtitulo = new JLabel("Escriba un texto: ");
        subtitulo.setFont(new Font("Bookman Old Style", Font.BOLD, 16));
        subtitulo.setBounds(90,120, 200, 30);

        panel.add(titulo);
        panel.add(subtitulo);

    }



    public JButton getBoton() {
        return boton;
    }

    public TextArea getAreaTexto() {
        return areaTexto;
    }
}
