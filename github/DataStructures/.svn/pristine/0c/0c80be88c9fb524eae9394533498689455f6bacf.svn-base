import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;

import org.w3c.dom.*;

public class makeUserXml {
	
	makeUserXml(ArrayList<Menu> menuList, String xmlName) {

		try {

			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

			// root elements
			Document doc = docBuilder.newDocument();
			Element rootElement = doc.createElement("UserMenu");
			doc.appendChild(rootElement);

			for (int i = 0; i < 10; i++) {
				Element Recipe = doc.createElement("Recipe");
				rootElement.appendChild(Recipe);
				Recipe.setAttribute("name", menuList.get(i).name);
				Recipe.setAttribute("type",Integer.toString(menuList.get(i).type));
				Recipe.setAttribute("ingrN",menuList.get(i).ingrN);
				Recipe.setAttribute("ingrW",menuList.get(i).ingrW);
				Recipe.setAttribute("m",menuList.get(i).m);
			}

			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(xmlName));

			transformer.transform(source, result);

			System.out.println("xml파일 저장 !");

		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (TransformerException tfe) {
			tfe.printStackTrace();
		}
	}
}
class Menu{
	String name;
	int type;
	String ingrN;
	String ingrW;
	String m;
	
	Menu(String name, int type, String ingrN, String ingrW, String m){
		this.name = name;
		this.type = type;
		this.ingrN = ingrN;
		this.ingrW = ingrW;
		this.m = m;
	}
}

