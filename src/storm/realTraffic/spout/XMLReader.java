package storm.realTraffic.spout;


import java.io.IOException; 
//import org.dom4j.DocumentException; 
import org.w3c.dom.*; 
import org.xml.sax.*; 
import javax.xml.parsers.*; 

public class XMLReader { 
	public static void main(String arge[]) throws DOMException { 
		// ʵ����һ���ĵ����������� 
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance(); 
		try { 
			// ͨ���ĵ�������������ȡһ���ĵ������� 
			DocumentBuilder db = dbf.newDocumentBuilder(); 
			// ͨ���ĵ�ͨ���ĵ�����������һ���ĵ�ʵ�� 
			Document doc = db.parse("tupleinfo.xml"); 
			// ��ȡ��������Ϊ ��TURNOS�� �Ľڵ� 
			NodeList nl1 = doc.getElementsByTagName("TURNOS"); 
			int size1 = nl1.getLength(); 
			for (int i = 0; i < size1; i++) { 
				Node n = nl1.item(i); 
				// ��ȡ n �ڵ������е��ӽڵ㡣�˴�ֵ��ע�⣬��DOM����ʱ�Ὣ���лس�����Ϊ n �ڵ���ӽڵ㡣 
				NodeList nl2 = n.getChildNodes(); 
				// ��Ϊ�����ԭ���ڴ����е�һ�� n �ڵ��� 2 ���ӽڵ㣬���ڶ��� n �ڵ����� 5 ���ӽڵ㣨��Ϊ����3���س����� 
				int size2 = nl2.getLength(); 
				for (int j = 0; j < size2; j++) { 
					Node n2 = nl2.item(j); 
					// ������Ϊ�����ԭ�򣬹ʴ�Ҫ���жϵ� n2 �ڵ����ӽڵ��ʱ������� 
					if (n2.hasChildNodes()) { 
						System.out.println(n2.getNodeName() + " = " 
								+ n2.getFirstChild().getNodeValue()); 
					} 
				} 
			} 
		} catch (ParserConfigurationException ex) { 
			ex.printStackTrace(); 
		} catch (IOException ex) { 
			ex.printStackTrace(); 
		} catch (SAXException ex) { 
			ex.printStackTrace(); 
		} 

	} 
} 