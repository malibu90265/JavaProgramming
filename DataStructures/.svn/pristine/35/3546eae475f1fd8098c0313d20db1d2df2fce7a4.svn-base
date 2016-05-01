import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

class UserXmlOpen
{
   XMLReader userXml;
   Node userModeNode;
   Node userNode;
   Node gameStageNode;
   Node createBlockNode;
   
   NodeList userNodeList;
   NodeList gameStageNodeList;
   NodeList createBlockNodeList;
   ArrayList<LoadDownBlock> createDownBlockList = null; //선택된 떨어지는 것 리스트
   ArrayList<Stage> StageList = null; // 스테이지 리스트
   
   public UserXmlOpen(String xmlName)
   {
      userXml = new XMLReader(xmlName);
      userModeNode = userXml.getUserModeElement();
      gameStageNode = XMLReader.getNode(userModeNode, XMLReader.E_GAMESTAGE);
      createBlockNode = XMLReader.getNode(userModeNode, XMLReader.E_SELECTBLOCK);
      gameStageNodeList = gameStageNode.getChildNodes();
      createBlockNodeList =createBlockNode.getChildNodes();
   }
   public ArrayList<Stage> StageReader() {
      StageList = new ArrayList<Stage>();

      for (int i = 0; i < gameStageNodeList.getLength(); i++) {
         Node node = gameStageNodeList.item(i);
         
         if (node.getNodeType() != Node.ELEMENT_NODE)
            continue;
         if (node.getNodeName().equals(XMLReader.E_STAGE)) {
            
            int time = Integer.parseInt(XMLReader.getAttr(node,"time"));
            int speed= Integer.parseInt(XMLReader.getAttr(node,"speed"));
            int blockNum= Integer.parseInt(XMLReader.getAttr(node,"blockNum"));
            int GKcal = Integer.parseInt(XMLReader.getAttr(node,"GKcal"));
            boolean item = Boolean.valueOf(XMLReader.getAttr(node,"item"));
            StageList.add(new Stage(time,speed,blockNum,GKcal,item));

         }

      }
      return StageList;

   }
   public ArrayList<LoadDownBlock> createBlockReader() {
      createDownBlockList = new ArrayList<LoadDownBlock>();

      for (int i = 0; i < createBlockNodeList.getLength(); i++) {
         Node node = createBlockNodeList.item(i);
         
         if (node.getNodeType() != Node.ELEMENT_NODE)
            continue;
         if (node.getNodeName().equals(XMLReader.E_block)) {
            
            int kcal = Integer.parseInt(XMLReader.getAttr(node, "kcal")); // 칼로리
            String blockType = XMLReader.getAttr(node, "blockType"); // 타입
            ImageIcon imgIcon = new ImageIcon(XMLReader.getAttr(node, "img"));
            Image img = imgIcon.getImage();
            String imgName = XMLReader.getAttr(node, "img");
            LoadDownBlock en = new LoadDownBlock(img, kcal, blockType,imgName);
            createDownBlockList.add(en);

         }

      }
      return createDownBlockList;

   }
   
}
class XmlOpen {
   XMLReader gameXml;
   XMLReader scoreXml;
   
   Node blockGameNode;
   Node scoreModeNode;

   Node blockNode;
   Node gameItemNode;
   Node panelNode;
   Node gameSoundNode;

   NodeList blockNodeList;
   NodeList gameItemNodeList;
   NodeList panelNodeList;
   NodeList gameSoundNodeList;
   NodeList scoreNodeList;   

   ArrayList<LoadDownBlock> LoadDownBlockList = null; // 떨어지는 것 리스트
   ArrayList<GameItem> gameItemList = null; // 게임 아이템 이미지 리스트
   ArrayList<Panel> panelList = null; // 판넬 리스트
   ArrayList<Score> scoreList = null;//스코어 리스트 

   public XmlOpen() {
      gameXml = new XMLReader("block.xml"); // Xml파일을 열고 객체 생성
      scoreXml = new XMLReader("score.xml");
      
      
      blockGameNode = gameXml.getBlockGameElement();
      scoreModeNode = scoreXml.getScoreModeElement();
      
      
      
      
      blockNode = XMLReader.getNode(blockGameNode, XMLReader.E_BLOCK);
      gameItemNode = XMLReader.getNode(blockGameNode, XMLReader.E_GAMEITEM);
      panelNode = XMLReader.getNode(blockGameNode, XMLReader.E_PANEL); 
      
      
      
      
      
      
                                                            
      scoreNodeList= scoreModeNode.getChildNodes();
      blockNodeList = blockNode.getChildNodes();
      gameItemNodeList = gameItemNode.getChildNodes();
      panelNodeList = panelNode.getChildNodes();
   
   }
   
   public ArrayList<Score> scoreReader() {

      scoreList = new ArrayList<Score>();

      for (int i = 0; i < scoreNodeList.getLength(); i++) {
         Node node = scoreNodeList.item(i);
         if (node.getNodeType() != Node.ELEMENT_NODE)
            continue;
         if (node.getNodeName().equals(XMLReader.E_SCORE)) {

            String name = XMLReader.getAttr(node, "name"); //name
                                                            // 정보랑
            int stage = Integer.parseInt(XMLReader.getAttr(node, "stage"));
            int totalScore = Integer.parseInt(XMLReader.getAttr(node, "totalScore")); // 타입
            Score s = new Score(name,stage,totalScore);
            scoreList.add(s);

         }

      }
      return scoreList;

   }



   

   public ArrayList<LoadDownBlock> blockReader() {

      LoadDownBlockList = new ArrayList<LoadDownBlock>();

      for (int i = 0; i < blockNodeList.getLength(); i++) {
         Node node = blockNodeList.item(i);
         if (node.getNodeType() != Node.ELEMENT_NODE)
            continue;
         if (node.getNodeName().equals(XMLReader.E_block)) {

            int kcal = Integer.parseInt(XMLReader.getAttr(node, "kcal")); // 칼로리
                                                            // 정보랑
            String blockType = XMLReader.getAttr(node, "blockType"); // 타입
            ImageIcon imgIcon = new ImageIcon(
                  XMLReader.getAttr(node, "img"));
            Image img = imgIcon.getImage();
            String imgName = XMLReader.getAttr(node, "img");
            LoadDownBlock en = new LoadDownBlock(img, kcal, blockType,imgName);
            LoadDownBlockList.add(en);

         }

      }
      return LoadDownBlockList;

   }

   public ArrayList<GameItem> gameItemReader() {
      gameItemList = new ArrayList<GameItem>();

      for (int i = 0; i < gameItemNodeList.getLength(); i++) {
         Node node = gameItemNodeList.item(i);
         if (node.getNodeType() != Node.ELEMENT_NODE)
            continue;
         if (node.getNodeName().equals(XMLReader.E_ITEM)) {

            ImageIcon imgIcon = new ImageIcon(
                  XMLReader.getAttr(node, "img"));

            String itemType = XMLReader.getAttr(node, "itemType");
            Image img = imgIcon.getImage();

            gameItemList.add(new GameItem(img, itemType));
         }

      }

      return gameItemList;

   }

   public ArrayList<Panel> panelReader() {

      panelList = new ArrayList<Panel>();

      for (int i = 0; i < panelNodeList.getLength(); i++) {
         Node node = panelNodeList.item(i);
         if (node.getNodeType() != Node.ELEMENT_NODE)
            continue;
         if (node.getNodeName().equals(XMLReader.E_OBJ)) {

            ImageIcon imgIcon = new ImageIcon(
                  XMLReader.getAttr(node, "img"));
            Image img = imgIcon.getImage();
            int x = Integer.parseInt(XMLReader.getAttr(node, "x"));
            int y = Integer.parseInt(XMLReader.getAttr(node, "y"));
            int w = Integer.parseInt(XMLReader.getAttr(node, "w"));
            int h = Integer.parseInt(XMLReader.getAttr(node, "h"));

            panelList.add(new Panel(x, y, w, h, img));

         }

      }

      return panelList;

   }



}

class UserXmlListOpen
{
   
   XMLReader xmlNameListXml;
   Node userMakeXmlNode;
   NodeList userMakeXmlNodeList;   

   
   ArrayList<UserMakeXml> userMakeXmlList = null; 
   UserXmlListOpen()
   {
      
      xmlNameListXml = new XMLReader("userMakeXmlList.xml");
      userMakeXmlNode = xmlNameListXml.getXmlListElement();
      userMakeXmlNodeList= userMakeXmlNode.getChildNodes();
   }
   
   public ArrayList<UserMakeXml> userMakeXmlReader() {

      userMakeXmlList = new ArrayList<UserMakeXml>();

      for (int i = 0; i < userMakeXmlNodeList.getLength(); i++) {
         Node node = userMakeXmlNodeList.item(i);
         if (node.getNodeType() != Node.ELEMENT_NODE)
            continue;
         if (node.getNodeName().equals(XMLReader.E_XMLNAME)) {

            String xmlName = XMLReader.getAttr(node, "name"); //name
                                                            // 정보랑
            
            UserMakeXml umx= new UserMakeXml(xmlName);
            userMakeXmlList.add(umx);

         }

      }
      return userMakeXmlList;

   }
   
   
}