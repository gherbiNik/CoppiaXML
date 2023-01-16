/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package es32;

/**
 *
 * @author FRANCESCODELROSSO
 */
public class Es32 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Percorso p = new Percorso();
        p.caricaDaXML("C:\\Users\\FRANCESCODELROSSO\\OneDrive - IIS Marco Polo\\Documenti\\NetBeansProjects\\Es32\\src\\es32\\percorso.xml");
        p.calcolaLatitudineMinMax();

    }

}


