/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PaqueteAntonio;

/**
 *
 * @author Antonio
 */
import java.awt.BorderLayout;
import javax.swing.JPanel;

public class Panel extends JPanel
{
    private ArbolGeneral<Character> arbolGeneral;
    private PanelArbol<Character> vista;
    public Panel()
    {
        this.arbolGeneral = new ArbolGeneral<Character>();
        Elemento<Character> elemento = arbolGeneral.insertarRaiz('A');
        elemento = arbolGeneral.insertarHijo(elemento,'B');
        arbolGeneral.insertarHijo(elemento,'C');
        arbolGeneral.insertarHijo(elemento,'D');
        elemento = arbolGeneral.insertarHijo(elemento,'E');
        arbolGeneral.insertarHijo(elemento,'F');
        elemento = arbolGeneral.insertarHijo(arbolGeneral.getRaiz(),'X');
        arbolGeneral.insertarHijo(elemento,'Y');
        elemento = arbolGeneral.insertarHijo(arbolGeneral.getRaiz(),'H');
        arbolGeneral.insertarHijo(elemento,'L');
        elemento = arbolGeneral.insertarHijo(elemento,'P');
        elemento = arbolGeneral.insertarHijo(elemento,'J');
        arbolGeneral.insertarHijo(elemento,'S');
        elemento = arbolGeneral.insertarHijo(arbolGeneral.getRaiz(),'O');
        arbolGeneral.insertarHijo(elemento,'M');
        arbolGeneral.insertarHijo(elemento,'K');
        this.vista = new PanelArbol<Character>(arbolGeneral);
        this.setLayout(new BorderLayout());
        add(vista,BorderLayout.CENTER);
    }
}
