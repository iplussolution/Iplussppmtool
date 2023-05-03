package Slicer;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import jdk.internal.org.xml.sax.InputSource;
/*import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element; */
import java.io.File;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
// add
import org.jsoup.select.Elements;

import java.io.IOException;
import java.io.StringReader;

public class MessageSlicer {


    public static void main(String argv[]) throws IOException {

        File input = new File("BatchedForms.txt");
        Document doc = Jsoup.parse(input, "UTF-8");
        //select all address tags; returns a list of Elements
        Elements FormM = doc.getElementsByTag("ns1:formMsAlreadyDownloaded");
        for (Element formM : FormM) {
            System.out.println("Form M MF number : "+formM.getElementsByTag("ns1:SER"));
            System.out.println(formM);
            System.out.println("------------");
        }
    }
}

         /*   try {
                File inputFile = new File("BatchedForms.txt");

                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                Document doc = dBuilder.parse(inputFile);
                doc.getDocumentElement().normalize();
                System.out.print("Root element: ");
                //System.out.println(doc.getDocumentElement().getNodeName());
                NodeList nList = doc.getElementsByTagName("ns1:formMsAlreadyDownloaded");
                System.out.println("----------------------------");

                for (int temp = 0; temp < nList.getLength(); temp++) {
                    Node nNode = nList.item(temp);
                    System.out.println("\nCurrent Form :");
                    System.out.print(nNode.getChildNodes().toString()); */

              /*      if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                        Element eElement = (Element) nNode;
                        System.out.print("company : ");
                        System.out.println(eElement.getAttribute("company"));
                        NodeList carNameList = eElement.getElementsByTagName("carname");

                        for (int count = 0; count < carNameList.getLength(); count++) {
                            Node node1 = carNameList.item(count);

                            if (node1.getNodeType() == node1.ELEMENT_NODE) {
                                Element car = (Element) node1;
                                System.out.print("car name : ");
                                System.out.println(car.getTextContent());
                                System.out.print("car type : ");
                                System.out.println(car.getAttribute("type"));
                            }
                        }
                    } */
        /*        }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    } */

