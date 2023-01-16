package es32;

import java.io.File;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class Percorso {

    ArrayList<Posizione> posizioni = new ArrayList<>();

    public void caricaDaXML(String file) {
        try {
            File fXmlFile = new File(file);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("posizione");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    double latitudine = Double.parseDouble(eElement.getElementsByTagName("latitudine").item(0).getTextContent());
                    double longitudine = Double.parseDouble(eElement.getElementsByTagName("longitudine").item(0).getTextContent());
                    double altitudine = Double.parseDouble(eElement.getElementsByTagName("altitudine").item(0).getTextContent());
                    String dataOra = eElement.getElementsByTagName("dataOra").item(0).getTextContent();
                    Posizione p = new Posizione(latitudine, longitudine, altitudine, dataOra);
                    posizioni.add(p);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    public void calcolaLatitudineMinMax() {
        double latitudineMin = Double.MAX_VALUE;
        double latitudineMax = Double.MIN_VALUE;
        double longitudineMin = Double.MAX_VALUE;
        double longitudineMax = Double.MIN_VALUE;
        for (Posizione p : posizioni) {
            latitudineMin = Math.min(latitudineMin, p.getLatitudine());
            latitudineMax = Math.max(latitudineMax, p.getLatitudine());
            longitudineMin = Math.min(longitudineMin, p.getLongitudine());
            longitudineMax = Math.max(longitudineMax, p.getLongitudine());
        }
        System.out.println("Latitudine minima: " + latitudineMin);
        System.out.println("Latitudine massima: " + latitudineMax);
        System.out.println("Longitudine minima: " + longitudineMin);
        System.out.println("Longitudine massima: " + longitudineMax);
    }
}