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
public class No extends Define
{

    private String info;
    private No vLig[];
    private boolean Fim;
    private int tl;

    public No(String info)
    {
        this.info = info;
        this.vLig = new No[N];
        this.tl = 1;
        this.Fim = false;
    }

    public No()
    {
        this.vLig = new No[N];
        this.tl = 0;
        this.Fim = false;
        this.info = "";
    }

    public String getInfo()
    {
        return this.info;
    }

    public void setInfo(String info)
    {
        this.info = info;
    }

    public No getvLig(int pos)
    {
        return vLig[pos];
    }

    public void setvLig(int pos, No no)
    {
        vLig[pos] = no;
    }

    public int getTl()
    {
        return tl;
    }

    public void setTl(int tl)
    {
        this.tl = tl;
    }

    public boolean isFim()
    {
        return Fim == true;
    }

    public void setFim(boolean p)
    {
        this.Fim = p;
    }

    public boolean getFim()
    {
        return this.Fim;
    }

    public int getPos(String info)
    {
        int i = 0;
        while (i < tl && info.charAt(0) > vLig[i].getInfo().charAt(0))
        {
            i++;
        }

        return i;
    }

    public int getLengthPalavras(String src)
    {
        int i = 0;
        while (i < src.length() && src.charAt(i) == info.charAt(i))
        {
            i++;
        }

        return i;
    }

    public void remanejarTrie(int pos)
    {
        vLig[tl + 1] = vLig[tl];
        for (int i = tl; i > pos; i--)
        {            
            vLig[i] = vLig[i - 1];
        }
    }
}
