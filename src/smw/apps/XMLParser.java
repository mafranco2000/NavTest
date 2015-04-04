package smw.apps;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.FactoryConfigurationError;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import android.content.res.Resources;

public class XMLParser {
	Document doc;
	NodeList mapDesc, nodes, nearby;
	
	public XMLParser(Resources res){
		try {
			InputStream is = res.openRawResource(R.raw.map);
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			doc = db.parse(is);
			mapDesc = doc.getElementsByTagName("mapDescription");
			nodes = doc.getElementsByTagName("node");
			nearby = doc.getElementsByTagName("nearby");
		} catch (SAXException e1) {
			e1.printStackTrace();
        } catch (IOException e1) {
        	e1.printStackTrace();
        } catch (ParserConfigurationException e1) {
        	e1.printStackTrace();
        } catch (FactoryConfigurationError e1) {
        	e1.printStackTrace();
        } 
	}
	
	public String getMapDescription(){
		return ((Element)mapDesc.item(0)).getAttribute("desc");
	}
	
	public ArrayList<Destination> getTerminalNodes(){
		ArrayList<Destination> places = new ArrayList<Destination>();
		for (int i=0; i<nearby.getLength(); i++){
			places.add(new Destination(((Element)nearby.item(i)).getAttribute("name"), (Integer.parseInt(((Element)((Element)nearby.item(i)).getParentNode()).getAttribute("code")))));
		}
		Collections.sort(places, new Comparator<Destination>(){
			public int compare(Destination d1, Destination d2){
				return (d1.getName()).compareTo(d2.getName());
			}
		});
		return places;
	}
	
	public int getNextHop(int current, int destination){
		NodeList nextHops = null;
		int j = 0;
		for (int i=0; i<nodes.getLength(); i++){
			if (Integer.parseInt(((Element)nodes.item(i)).getAttribute("code")) == current){
				nextHops = ((Element)nodes.item(i)).getElementsByTagName("nextHop");
			}
		}
		for (int i=0; i<nextHops.getLength(); i++){
			if (Integer.parseInt(((Element)nextHops.item(i)).getAttribute("dest")) == destination){
				j = i;
			}
		}
		return Integer.parseInt(((Element)nextHops.item(j)).getAttribute("next"));
	}
	
}