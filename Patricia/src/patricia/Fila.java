/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patricia;

/**
 *
 * @author Gabriel
 */
public class Fila
{
    private NoFila inicio;
    private int tl;
    
    public Fila ()
    {
        this.tl = 0;
    }
    public void insert(No No)
    {
        NoFila aux = inicio;
        NoFila nova = new NoFila(No);
        if(inicio == null)
            aux = nova;
        else
        {
            while(aux.getProx() != null)
                aux = aux.getProx();
            nova.setAnt(aux);
            aux.setProx(nova);
        }
        setTL(getTL()+1);
    }
    public void exibir()
    {
        NoFila aux = inicio;
        while(aux != null)
        {
            System.out.println(aux.getInfo());
            aux = aux.getProx();
        }
    }
    public No removerFila()
    {
        NoFila aux = null;        
        if(inicio != null)
        {
            aux = getInicio();
            inicio = inicio.getProx();
            inicio.setAnt(null);
            setTL(getTL()-1);
        }
        return aux.getInfo();
    }
    public NoFila getInicio()
    {
        return inicio;
    }
    public void setTL(int num)
    {
        this.tl += num;
    }
    public int getTL()
    {
        return tl;
    }
}
