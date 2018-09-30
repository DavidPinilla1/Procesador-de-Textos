package graficos;
import javax.swing.*;
import javax.swing.text.StyledEditorKit;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.url.*;

public class ProcesadorTexto {
    public static void main(String[] args){
        MarcoProcesador2 mimarco=new MarcoProcesador2();
        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
class MarcoProcesador2 extends JFrame{
    public MarcoProcesador2(){
        setBounds(200, 100, 800, 580);
        add(new LaminaProcesador2());
        setTitle("Procesador Textos");
        setVisible(true);
    }
}
class LaminaProcesador2 extends JPanel {
    public LaminaProcesador2() {//metodo constructor de la lámina
        setLayout(new BorderLayout());
        JPanel laminamenu=new JPanel();
        JMenuBar mibarra=new JMenuBar();
        URL ruta=LaminaProcesador2.class.getResource("N.png");
        //----------------------------------------------
        fuente=new JMenu("Fuente");
        estilo=new JMenu("Estilo");
        tamagno=new JMenu("Tamaño");
        configura_menu("Arial", "fuente", "Arial", 9,miarea.getFont().getSize(),"" );
        configura_menu("Courier", "fuente", "Courier", 9,miarea.getFont().getSize(),"" );
        configura_menu("Verdana", "fuente", "Verdana", 9,miarea.getFont().getSize(),"" );
        configura_menu("Negrita", "estilo", "Negrita", 1,miarea.getFont().getSize(),ruta );
        configura_menu("Cursiva", "estilo", "Cursiva", 2,miarea.getFont().getSize(),"src/k.png" );
        /*JCheckBoxMenuItem negrita=new JCheckBoxMenuItem("Negrita",new ImageIcon("src/graficos/N.png"));
        JCheckBoxMenuItem cursiva=new JCheckBoxMenuItem("Cursiva", new ImageIcon("src/graficos/N.png"));
        negrita.addActionListener(new StyledEditorKit.BoldAction());
        cursiva.addActionListener(new StyledEditorKit.ItalicAction());
        estilo.add(negrita);
        estilo.add(cursiva);*/
        ButtonGroup tamagnoLetra=new ButtonGroup();
        JRadioButtonMenuItem doce=new JRadioButtonMenuItem("12");
        JRadioButtonMenuItem diezyseis=new JRadioButtonMenuItem("16");
        JRadioButtonMenuItem veinte=new JRadioButtonMenuItem("20");
        JRadioButtonMenuItem veinticuatro=new JRadioButtonMenuItem("24");
        //veinticuatro.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.CTRL_DOWN_MASK));
        tamagnoLetra.add(doce);
        tamagnoLetra.add(diezyseis);
        tamagnoLetra.add(veinte);
        tamagnoLetra.add(veinticuatro);
        doce.addActionListener(new StyledEditorKit.FontSizeAction("cambia_tamaño",12 ));
        diezyseis.addActionListener(new StyledEditorKit.FontSizeAction("cambia_tamaño",16 ));
        veinte.addActionListener(new StyledEditorKit.FontSizeAction("cambia_tamaño",20 ));
        veinticuatro.addActionListener(new StyledEditorKit.FontSizeAction("cambia_tamaño",24 ));
        tamagno.add(doce);
        tamagno.add(diezyseis);
        tamagno.add(veinte);
        tamagno.add(veinticuatro);
        mibarra.add(fuente);
        mibarra.add(estilo);
        mibarra.add(tamagno);
        laminamenu.add(mibarra);
        add(laminamenu,BorderLayout.NORTH);
        add(miarea,BorderLayout.CENTER);
        JPopupMenu emergente=new JPopupMenu();
        JMenuItem NegritaE=new JMenuItem("Negrita");
        JMenuItem CursivaE=new JMenuItem("Cursiva");
        emergente.add(NegritaE);
        emergente.add(CursivaE);
        NegritaE.addActionListener(new StyledEditorKit.BoldAction());
        CursivaE.addActionListener(new StyledEditorKit.ItalicAction());
        miarea.setComponentPopupMenu(emergente);
        barra=new JToolBar();
        configuraBarra("src/N.png").addActionListener(new StyledEditorKit.BoldAction());
        configuraBarra("src/K.png").addActionListener(new StyledEditorKit.ItalicAction());
        configuraBarra("src/U.png").addActionListener(new StyledEditorKit.UnderlineAction());
        barra.addSeparator();
        configuraBarra("src/blue.png").addActionListener(new StyledEditorKit.ForegroundAction("",Color.BLUE));
        configuraBarra("src/red.png").addActionListener(new StyledEditorKit.ForegroundAction("",Color.RED));
        configuraBarra("src/yellow.png").addActionListener(new StyledEditorKit.ForegroundAction("",Color.YELLOW));
        barra.addSeparator();
        configuraBarra("src/left.png").addActionListener(new StyledEditorKit.AlignmentAction("",0));
        configuraBarra("src/center.png").addActionListener(new StyledEditorKit.AlignmentAction("",1));
        configuraBarra("src/right.png").addActionListener(new StyledEditorKit.AlignmentAction("",2));
        configuraBarra("src/justified.png").addActionListener(new StyledEditorKit.AlignmentAction("",3));
        barra.setOrientation(SwingConstants.VERTICAL);
        add(barra,BorderLayout.WEST);
    }
    public JButton configuraBarra(String ruta){
            JButton boton=new JButton(new ImageIcon(ruta));
            barra.add(boton);
            return boton;
    }
    public void configura_menu(String rotulo, String menu,String tipo_letra,int estilos, int tam, String rutaIcono){//metodo setter
        JMenuItem elem_menu=new JMenuItem(rotulo,new ImageIcon(rutaIcono));
        if(menu=="fuente"){
            fuente.add(elem_menu);
            if(tipo_letra=="Arial") elem_menu.addActionListener(new StyledEditorKit.FontFamilyAction("cambia_letra", "Arial"));
            if(tipo_letra=="Courier") elem_menu.addActionListener(new StyledEditorKit.FontFamilyAction("cambia_letra", "Courier"));
            if(tipo_letra=="Verdana") elem_menu.addActionListener(new StyledEditorKit.FontFamilyAction("cambia_letra", "Verdana"));

        }
        else if(menu=="estilo") {
            estilo.add(elem_menu);
            if(estilos==1){
                elem_menu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,InputEvent.CTRL_DOWN_MASK));
                elem_menu.addActionListener(new StyledEditorKit.BoldAction());
            }
            else if(estilos==2){
                elem_menu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_K,InputEvent.CTRL_DOWN_MASK));
                elem_menu.addActionListener(new StyledEditorKit.ItalicAction());
            }
        }
        else if(menu=="tamaño") {
            tamagno.add(elem_menu);
            elem_menu.addActionListener(new StyledEditorKit.FontSizeAction("cambia_tamaño",tam));
        }
    }

    JTextPane miarea=new JTextPane();
    JMenu fuente, estilo, tamagno;
    Font letras;
    JToolBar barra;
}
