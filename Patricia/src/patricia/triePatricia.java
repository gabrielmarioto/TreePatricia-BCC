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
public class triePatricia
{

    private No raiz;

    public triePatricia()
    {

    }

    public No getRaiz()
    {
        return raiz;
    }

    public void showTrie(String palavra, No arvore, int pos)
    {
        while(pos < arvore.getTl() && !arvore.isFim())
        {
            palavra += arvore.getInfo();
            showTrie(palavra, arvore.getvLig(pos),0);
        }
        if(arvore.isFim())
            System.out.println(palavra);
    }  

    public No localizarPai(No folha, String info)
    {
        No aux = raiz, pai = aux;
        int i;
        while (aux != folha)
        {
            i = 0;
            while (i < aux.getTl() && aux.getInfo().compareToIgnoreCase(info) > 0)
            {
                i++;
            }
            pai = aux;
            aux = aux.getvLig(i);
        }
        return pai;
    }

    public void insertTrie(String info)
    {
        No aux = raiz, ant = null;
        No novo = new No(info);
        int pos = 0, i = 0, temp = 0;

        if (aux == null)
        {
            aux = new No();
            raiz.setvLig(0, novo);
            raiz.setTl(raiz.getTl() + 1);
        } else
        {
            while (i < info.length())
            {
                if (aux.getTl() > 0)
                {
                    pos = aux.getPos(info.substring(i));
                    if (pos < aux.getTl() && info.substring(i).charAt(0) == aux.getvLig(pos).getInfo().charAt(0))
                    {
                        ant = aux;
                        aux = aux.getvLig(pos);
                        temp = aux.getLengthPalavras(info.substring(i));
                        if (temp < aux.getInfo().length() && !info.substring(i, i + temp).equals(aux.getInfo()))
                        {
                            ant.setvLig(pos, new No(info.substring(i, i + temp)));
                            ant.getvLig(pos).setvLig(0, aux);
                            ant.getvLig(pos).setTl(ant.getvLig(pos).getTl() + 1);
                            aux.setInfo(aux.getInfo().substring(temp));
                            aux = ant.getvLig(pos);
                            if (i + temp == info.length())                            
                                ant.getvLig(pos).setFim(true);                            
                        }
                        i += temp - 1;
                    } else
                    {
                        aux.remanejarTrie(pos);
                        aux.setvLig(pos, new No(info.substring(i)));
                        aux.getvLig(pos).setFim(true);
                        aux.setTl(aux.getTl() + 1);
                        i = info.length();
                    }
                } else
                {
                    aux.setvLig(0, new No(info.substring(i)));
                    i = info.length();
                    aux.getvLig(0).setTl(aux.getvLig(0).getTl() + 1);
                    aux.getvLig(0).setFim(true);
                }
                i++;
            }
        }
        showNivel();
    }
    
    public void showNivel()
    {
        Fila fila = new Fila();
        No aux = raiz;
        int i = 0;
        
        while(aux.getvLig(0) != null)
        {
            i = 0;
            while(aux.getvLig(i) != null)
            {
                fila.insert(aux.getvLig(i));
                i++;
            }
            aux = fila.removerFila();
            System.out.println(aux.getInfo());
        }
    }
}
