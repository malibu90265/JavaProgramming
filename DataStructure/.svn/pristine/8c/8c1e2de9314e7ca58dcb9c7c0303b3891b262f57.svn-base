import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;

import org.w3c.dom.*;

public class UserXmlList {
	
	UserXmlList(ArrayList<UserMakeXml> UserMakeXmlList) {
		  try {
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
 
		// root elements
		Document doc = docBuilder.newDocument();
		Element rootElement = doc.createElement("XmlList");
		doc.appendChild(rootElement);
 
		
		for(int i=0;i< UserMakeXmlList.size() ;i++)
		{
			Element xmlName= doc.createElement("xmlName");
			rootElement.appendChild(xmlName);
			xmlName.setAttribute("name",UserMakeXmlList.get(i).xmlName);
			
			
		}	
 

			TransformerFactory transformerFactory = TransformerFactory
					.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File("userMakeXmlList.xml"));

			transformer.transform(source, result);

			System.out.println("xml파일 저장 !");

		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (TransformerException tfe) {
			tfe.printStackTrace();
		}
	}

}

class UserMakeXml{
	String xmlName;
	
	UserMakeXml(String xmlName)
	{
		this.xmlName =xmlName;
	}
}
