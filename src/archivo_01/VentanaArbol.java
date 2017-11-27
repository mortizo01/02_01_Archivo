/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivo_01;

import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/**
 *
 * @author Mauricio Ortiz Ochoa
 */

public class VentanaArbol extends JFrame
{

    private JScrollPane scroll;
    private DefaultTreeModel modeloArbol;
    private JTree arbol;
    private JPanel panelInicial;
    private DefaultMutableTreeNode raiz;
    
    
    public VentanaArbol(String title) throws HeadlessException {
        super(title);
        this.setSize(800,600);
        
        this.iniciaComponentes();
    }

    private void iniciaComponentes() 
    {
        this.panelInicial= new JPanel(new GridLayout(1,1));
        this.raiz = new DefaultMutableTreeNode("C:/prueba/");
        this.modeloArbol= new DefaultTreeModel(raiz);
        
        File f = new File("C:/prueba/");
        File [] rutas = f.listFiles();
        this.cargaArbol(rutas, raiz);
        
        this.arbol = new JTree(this.modeloArbol);
        this.scroll = new JScrollPane(this.arbol);
        this.panelInicial.add(this.scroll);
        this.add(this.panelInicial);
        
    }
    
    public void metodoSuma(int a, int b)
    {
        System.out.println(a+b);
    }

    private void cargaArbol(File [] rutas, DefaultMutableTreeNode top) 
    {
        for(File f1: rutas)
        {
            int i=0;
            if(f1.isDirectory())
            {
                File f2 = new File(f1.getAbsolutePath());
                DefaultMutableTreeNode nodo = new DefaultMutableTreeNode(f2.getAbsolutePath());
                this.modeloArbol.insertNodeInto(nodo,top,i);
                this.cargaArbol(f2.listFiles(), nodo);
            }
            
            if(f1.isFile()){
                DefaultMutableTreeNode nodo = new DefaultMutableTreeNode(f1.getName());
                this.modeloArbol.insertNodeInto(nodo,top,i);
                i++;
            }
            
        }
    }
    
}
