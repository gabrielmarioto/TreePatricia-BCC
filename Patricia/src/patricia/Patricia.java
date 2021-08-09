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
public class Patricia
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        triePatricia pat = new triePatricia();
        pat.insertTrie("bolso");
        pat.showTrie("", pat.getRaiz(), 0);
    }
    
}
