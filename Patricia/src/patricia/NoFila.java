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
public class NoFila
{

    private No info;
    private NoFila prox;
    private NoFila ant;  

    public NoFila (No no)
    {
        this.info = no;
        this.ant = this.prox = null;
    }
    public NoFila()
    {

    }

    public NoFila getAnt()
    {
        return ant;
    }

    public void setAnt(NoFila ant)
    {
        this.ant = ant;
    }   

    public No getInfo()
    {
        return info;
    }

    public void setInfo(No info)
    {
        this.info = info;
    }

    public NoFila getProx()
    {
        return prox;
    }

    public void setProx(NoFila prox)
    {
        this.prox = prox;
    }

}
