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
import javax.swing.JFrame;

public class Principal
{
    public static void main(String[] args)
    {
        JFrame jf = new JFrame();
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setSize(600,400);
        jf.add(new Panel());
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);
    }
}
