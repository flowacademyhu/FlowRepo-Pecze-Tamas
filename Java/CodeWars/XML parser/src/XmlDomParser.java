import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class XmlDomParser {
        public static void loadXml() throws Exception {

            DocumentBuilder docBuilder = DocumentBuilderFactory.newDefaultInstance().newDocumentBuilder();
            try(InputStream in = XmlDomParser.class.getResourceAsStream("cats.xml")) {
                Document doc = docBuilder.parse(in);
                Element cat = doc.getDocumentElement();

                NodeList catNodeList = cat.getElementsByTagName("cat");
                var catList = new ArrayList<Element>();
                for (int i = 0; i < catNodeList.getLength(); ++i) {
                    catList.add((Element)catNodeList.item(i));
                }
                var x = catList.stream()
                        .map(e-> {
                            return new Cat(
                                    Integer.parseInt(e.getAttribute("id")),
                                    e.getElementsByTagName("name").item(0).getTextContent(),
                                    e.getElementsByTagName("color").item(0).getTextContent(),
                                    Integer.parseInt(e.getElementsByTagName("age").item(0).getTextContent())
                                    );
                        });
                List<Cat> cats = new ArrayList<>();
                x.forEach(o -> cats.add(o));
                System.out.println(cats.toString());

        }
    }

    public static void main(String[] args) throws Exception {
        loadXml();
    }

}
