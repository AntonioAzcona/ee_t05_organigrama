/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PaqueteAntonio;

import java.util.ArrayList;

/**
 *
 * @author Antonio
 */
public class ArbolGeneral<T>
{
    private NodoGeneral<T> raiz;
    private int cantidad;

    public ArbolGeneral()
    {
        this.cantidad = 0;
    }

    public Elemento<T> getRaiz()
    {
        return raiz;
    }

    public int getCantidad()
    {
        return cantidad;
    }

    private NodoGeneral<T> crearNodo(T dato, NodoGeneral<T> padre)
    {
        return new NodoGeneral<T>(dato,padre);
    }

    private NodoGeneral<T> validar(Elemento<T> elemento)
    {
        if(!(elemento instanceof NodoGeneral))
        {
            return null;
        }
        NodoGeneral<T> nodoGeneral = (NodoGeneral<T>)elemento;
        return nodoGeneral.getPadre() == nodoGeneral ? null : nodoGeneral;
    }

    public boolean esRaiz(Elemento<T> elemento)
    {
        return elemento == getRaiz();
    }

    public boolean estaVacia()
    {
        return getCantidad() == 0;
    }

    public Elemento<T>obtenerPadre(Elemento<T> elemento)
    {
        return validar(elemento).getPadre();
    }

    public int cantidadHijos(Elemento<T> elemento)
    {
        NodoGeneral<T> nodoGeneral = validar(elemento);
        return nodoGeneral.cantHijos();
    }

    public int cantidadNiveles(Elemento<T> elemento)
    {
        if(esRaiz(elemento))
        {
            return 0;
        }
        else {
            return 1 + cantidadNiveles(obtenerPadre(elemento));
        }
    }

    public int alto(Elemento<T> elemento)
    {
        int alto = 0;
        for (Elemento<T> hijo:obtenerHijos(elemento))
        {
            alto = Math.max(alto,1+alto(hijo));
        }
        return alto;
    }

    public ArrayList<Elemento<T>> obtenerHijos(Elemento<T> elemento)
    {
        NodoGeneral<T> nodoGeneral = validar(elemento);
        return nodoGeneral.hijos();
    }

    public Elemento<T> obtenerElemento(T elemento)
    {
        NodoGeneral<Elemento<T>> nodoGeneral = new NodoGeneral<Elemento<T>>();
        buscar(elemento,getRaiz(),nodoGeneral);
        return nodoGeneral.getElemento();
    }

    private void buscar(T elemento, Elemento<T> raiz, NodoGeneral<Elemento<T>> nodoGeneral)
    {
        if(elemento.equals(raiz.getElemento()))
        {
            nodoGeneral.setElemento(raiz);
        }

        for(Elemento<T> x:obtenerHijos(raiz))
        {
            buscar(elemento,x,nodoGeneral);
        }
    }

    public Elemento<T> insertarRaiz(T info)
    {
        if(!estaVacia())
        {
            return null;
        }
        raiz = crearNodo(info,null);
        cantidad = 1;
        return raiz;
    }

    public Elemento<T> insertarHijo(Elemento<T> elemento,T info)
    {
        NodoGeneral<T> nodoGeneral = validar(elemento);

        if(nodoGeneral == null)
        {
            return null;
        }

        NodoGeneral<T> hijo = crearNodo(info, nodoGeneral);
        nodoGeneral.insertarHijo(hijo);
        cantidad++;
        return hijo;
    }

    public Iterable<Elemento<T>> recorridoPreOrden()
    {
        ArrayList<Elemento<T>> pos = new ArrayList<Elemento<T>>();
        if(!estaVacia())
        {
            recorridoPreOrden(getRaiz(),pos);
        }
        return pos;
    }

    private void recorridoPreOrden(Elemento<T> raiz, ArrayList<Elemento<T>> pos)
    {
        pos.add(raiz);
        for(Elemento<T> hijo:obtenerHijos(raiz))
        {
            recorridoPreOrden(hijo,pos);
        }
    }


    public Iterable<Elemento<T>> recorridoInOrden()
    {
        ArrayList<Elemento<T>> pos = new ArrayList<Elemento<T>>();
        if(!estaVacia())
        {
            recorridoInOrden(getRaiz(), pos);
        }
        return pos;
    }

    private void recorridoInOrden(Elemento<T> raiz, ArrayList<Elemento<T>> pos)
    {
        if(cantidadHijos(raiz) == 0)
        {
            pos.add(raiz);
        }
        else
        {
            recorridoInOrden(obtenerHijos(raiz).get(0),pos);
            pos.add(raiz);
            for(int i = 1; i < cantidadHijos(raiz); i++)
            {
                recorridoInOrden(obtenerHijos(raiz).get(i),pos);
            }
        }
    }

    public Iterable<Elemento<T>> recorridoPosOrden()
    {
        ArrayList<Elemento<T>> pos = new ArrayList<Elemento<T>>();
        if(!estaVacia())
        {
            recorridoPosOrden(getRaiz(), pos);
        }
        return pos;
    }

    private void recorridoPosOrden(Elemento<T> raiz, ArrayList<Elemento<T>> pos)
    {
        for(Elemento<T>hijo:obtenerHijos(raiz))
        {
            recorridoPosOrden(hijo,pos);
        }
        pos.add(raiz);
    }
}
