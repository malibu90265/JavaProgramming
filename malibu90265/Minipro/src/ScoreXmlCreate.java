

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
 

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
 
public class ScoreXmlCreate {
 
   
   ScoreXmlCreate(ArrayList<Score> scoreList)
   {
 
     try {
 
      DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
      DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
 
      // root elements
      Document doc = docBuilder.newDocument();
      Element rootElement = doc.createElement("ScoreMode");
      doc.appendChild(rootElement);
 
      
      for(int i=0;i< scoreList.size() ;i++)
      {
         Element score= doc.createElement("score");
         rootElement.appendChild(score);
         score.setAttribute("name",scoreList.get(i).name);
         score.setAttribute("stage",Integer.toString(scoreList.get(i).stage));
         score.setAttribute("totalScore",Integer.toString(scoreList.get(i).totalScore));
         
      }   
 
      
      
      
      TransformerFactory transformerFactory = TransformerFactory.newInstance();
      Transformer transformer = transformerFactory.newTransformer();
      DOMSource source = new DOMSource(doc);
      StreamResult result = new StreamResult(new File("score.xml"));
 
 
      transformer.transform(source, result);
 
      System.out.println("File saved!");
 
     } catch (ParserConfigurationException pce) {
      pce.printStackTrace();
     } catch (TransformerException tfe) {
      tfe.printStackTrace();
     }
   }
}

class Score
{
   String name;
   int stage;
   int totalScore;
   Score(String name, int stage, int totalScore)
   {
      this.name= name;
      this.stage = stage;
      this.totalScore = totalScore;
   
   }

}

