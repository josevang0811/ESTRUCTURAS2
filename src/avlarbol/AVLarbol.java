/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package avlarbol;

/**
 *
 * @author sncardenas
 */
public class AVLarbol {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        arbol ar=new arbol();
        ar.insetar(20);
        ar.insetar(30);
        ar.insetar(40);
        ar.insetar(35);
        ar.insetar(15);
        ar.insetar(50);
        ar.insetar(55);
        ar.insetar(56);
        ar.insetar(57);
        ar.insetar(58);
        ar.TreePrinter();
        
        
    }
    
}
