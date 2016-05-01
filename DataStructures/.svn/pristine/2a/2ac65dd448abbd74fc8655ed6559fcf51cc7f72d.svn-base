import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

class XmlOpen {
	XMLReader menuXml;
	Node menuModeNode;
	NodeList menuNodeList;

	ArrayList<Menu> menuList = null;
	public XmlOpen(String xmlName){
		menuXml = new XMLReader(xmlName);
		menuModeNode = menuXml.getuserMenuElement();
		menuNodeList = menuModeNode.getChildNodes();
	}
	public ArrayList<Menu> menuReader() {
		menuList = new ArrayList<Menu>();
		for (int i = 0; i < menuNodeList.getLength(); i++) {
			Node node = menuNodeList.item(i);
			if (node.getNodeType() != Node.ELEMENT_NODE)
				continue;
			if (node.getNodeName().equals(XMLReader.E_RECIPE)) {
				String name = XMLReader.getAttr(node, "name");
				int type = Integer.parseInt(XMLReader.getAttr(node, "type"));
				String ingrN = XMLReader.getAttr(node, "ingrN");
				String ingrW = XMLReader.getAttr(node, "ingrW");
				String m = XMLReader.getAttr(node, "m");
				menuList.add(new Menu(name, type, ingrN, ingrW, m));
			}
		}
		return menuList;
		}


}

class UserXmlListOpen {

	XMLReader xmlNameListXml;
	Node userMakeXmlNode;
	NodeList userMakeXmlNodeList;

	ArrayList<UserMakeXml> userMakeXmlList = null;

	UserXmlListOpen() {

		xmlNameListXml = new XMLReader("userMakeXmlList.xml");
		userMakeXmlNode = xmlNameListXml.getXmlListElement();
		userMakeXmlNodeList = userMakeXmlNode.getChildNodes();
	}

	public ArrayList<UserMakeXml> userMakeXmlReader() {

		userMakeXmlList = new ArrayList<UserMakeXml>();

		for (int i = 0; i < userMakeXmlNodeList.getLength(); i++) {
			Node node = userMakeXmlNodeList.item(i);
			if (node.getNodeType() != Node.ELEMENT_NODE)
				continue;
			if (node.getNodeName().equals(XMLReader.E_XMLNAME)) {
				String xmlName = XMLReader.getAttr(node, "name");
				UserMakeXml umx = new UserMakeXml(xmlName);
				userMakeXmlList.add(umx);
			}

		}
		return userMakeXmlList;

	}

}

/*
class UserXmlOpen {
	XMLReader userXml;
	Node userMenuNode;
	NodeList userMenuNodeList;
	ArrayList<Menu> userMenuList = null;

	public UserXmlOpen(String xmlName) {
		userXml = new XMLReader(xmlName);
		userMenuNode = userXml.getuserMenuElement();
		userMenuNode = XMLReader.getNode(userMenuNode, XMLReader.E_USERMENU);
		userMenuNodeList = userMenuNode.getChildNodes();

	}

	public ArrayList<Menu> MenuReader() {
		userMenuList = new ArrayList<Menu>();

		for (int i = 0; i < userMenuNodeList.getLength(); i++) {
			Node node = userMenuNodeList.item(i);

			if (node.getNodeType() != Node.ELEMENT_NODE)
				continue;
			if (node.getNodeName().equals(XMLReader.E_USERMENU)) {

				String name = XMLReader.getAttr(node, "name");
				int type = Integer.parseInt(XMLReader.getAttr(node, "type"));
				String ingrN = XMLReader.getAttr(node, "ingrN");
				String ingrW = XMLReader.getAttr(node, "ingrW");
				String m = XMLReader.getAttr(node, "m");

				userMenuList.add(new Menu(name, type, ingrN, ingrW, m));

			}

		}
		return userMenuList;
	}

}
*/