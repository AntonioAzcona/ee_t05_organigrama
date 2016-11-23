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
import java.util.ArrayList;

public class NodoGeneral<T> implements Elemento<T>
{
    private T elemento;
    private NodoGeneral<T> padre;
    private ArrayList<NodoGeneral<T>> hijos;

    public NodoGeneral(){};
    public NodoGeneral(T elemento,NodoGeneral<T>padre)
    {
        this.elemento = elemento;
        this.padre = padre;
        this.hijos = new ArrayList<NodoGeneral<T>>();
    }

    public T getElemento()
    {
        return elemento;
    }

    public void setElemento(T elemento)
    {
        this.elemento = elemento;
    }

    public NodoGeneral<T> getPadre()
    {
        return padre;
    }

    public void setPadre(NodoGeneral<T> padre)
    {
        this.padre = padre;
    }

    protected NodoGeneral<T> getHijo(int posicion)
    {
        return hijos.get(posicion);
    }

    protected void setHijos(int posicion,T elemento)
    {
        hijos.get(posicion).setElemento(elemento);
    }

    public void insertarHijo(NodoGeneral<T> elemento)
    {
        hijos.add(elemento);

    }

    public int cantHijos()
    {
      return hijos.size();
    }

    public ArrayList<Elemento<T>> hijos()
    {
        return new ArrayList<Elemento<T>>(hijos);
    }

    public String toString()
    {
        return getElemento().toString();
    }
}
