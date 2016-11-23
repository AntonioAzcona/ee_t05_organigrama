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
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JPanel;

public class PanelArbol<T> extends JPanel
{
    private int radio=15;
    private int espacioVertical=50;
    private ArbolGeneral<T> arbolGeneral;
    private HashMap<Elemento<T>,Point> coordenadas;

    public PanelArbol(ArbolGeneral<T> arbolGeneral)
    {
        this.arbolGeneral = arbolGeneral;
        this.coordenadas=new HashMap<Elemento<T>, Point>();
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        if(!arbolGeneral.estaVacia())
        {
            dibujar(g,arbolGeneral.getRaiz(),getWidth()/2,30,getWidth()/5);
        }
    }

    private void dibujar(Graphics g, Elemento<T> raiz, int x, int y, int espacioH)
    {
        g.drawOval(x-radio,y-radio,2*radio,2*radio);
        g.drawString(raiz.getElemento() + "", x - 6, y + 4);
        ArrayList<Elemento<T>>hijos=arbolGeneral.obtenerHijos(raiz);
        coordenadas.put(raiz,new Point(x,y));
        for(Elemento<T> hijo:hijos)
        {
            Point punto=coordenadas.get(arbolGeneral.obtenerPadre(hijo));
            dibujarLinea(g,x-espacioH,y+espacioVertical,punto.x,punto.y);
            dibujar(g,hijo,x-espacioH,y+espacioVertical,espacioH/hijos.size());
            x+=espacioH;
        }
    }

    private void dibujarLinea(Graphics g, int x1, int y1, int x2, int y2)
    {
        double  d=Math.sqrt(espacioVertical*espacioVertical+(x2-x1)*(x2-x1));
        int xx1=(int)(x1-radio*(x1-x2)/d);
        int yy1=(int)(y1-radio*(y1-y2)/d);
        int xx2=(int)(x2+radio*(x1-x2)/d);
        int yy2=(int)(y2+radio*(y1-y2)/d);

        g.drawLine(xx1,yy1,xx2,yy2);
    }
}
