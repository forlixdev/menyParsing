package testJava;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.restassured.path.xml.XmlPath;

public class TestXmlPath {

	   private static final Logger log = LogManager.getLogger(TestXmlPath.class.getName());
	
	public static void main(String[] args) {
		
		String xmlResponse = "<soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">\n" + 
				"   <soap:Body>\n" + 
				"      <get-status-response xmlns=\"https://id.signicat.com/definitions/wsdl/Document-v2\">\n" + 
				"         <task-status-info>\n" + 
				"            <request-id>060220192p4riz4xe75rw8pomf00vau32d5b5by6eg3i0k6l1ho5wnkhal</request-id>\n" + 
				"            <task-id>1</task-id>\n" + 
				"            <task-status>completed</task-status>\n" + 
				"            <document-status id=\"d1\">\n" + 
				"               <original-uri>https://qa.signicat.com/doc/signicat/order/060220192p4riz4xe75rw8pomf00vau32d5b5by6eg3i0k6l1ho5wnkhal/1/d1/original</original-uri>\n" + 
				"               <result-uri>https://qa.signicat.com/doc/signicat/archive/060220192af59flh957iy6u6hc2zxmet38pud2aslfvva1oo7p831o8dhd</result-uri>\n" + 
				"            </document-status>\n" + 
				"         </task-status-info>\n" + 
				"      </get-status-response>\n" + 
				"   </soap:Body>\n" + 
				"</soap:Envelope>";
		
		XmlPath xmlPath = new XmlPath(xmlResponse);
		System.out.println(xmlPath.getString("Envelope.Body.get-status-response.task-status-info.task-status"));
		
		
		String xmlResponse2="<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" + 
				"<soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">\n" + 
				"  <soap:Body>\n" + 
				"    <list-pending-accounts-response xmlns=\"https://id.signicat.com/definitions/wsdl/Scid-v2\">\n" + 
				"      <accountnames>\n" + 
				"        <accountnamestate>\n" + 
				"          <external_reference>beepbop</external_reference>\n" + 
				"          <state>PENDING</state>\n" + 
				"        </accountnamestate>\n" + 
				"        <accountnamestate>\n" + 
				"          <external_reference>stinortor</external_reference>\n" + 
				"          <state>PENDING</state>\n" + 
				"        </accountnamestate>\n" + 
				"        <accountnamestate>\n" + 
				"          <external_reference>giggity</external_reference>\n" + 
				"          <state>PENDING</state>\n" + 
				"        </accountnamestate>\n" + 
				"        <accountnamestate>\n" + 
				"          <external_reference>pendingAccountTest</external_reference>\n" + 
				"          <state>PENDING</state>\n" + 
				"        </accountnamestate>\n" + 
				"      </accountnames>\n" + 
				"    </list-pending-accounts-response>\n" + 
				"  </soap:Body>\n" + 
				"</soap:Envelope>";
		
		
		   xmlPath = XmlPath.with(xmlResponse2);
		   List<String> ls = xmlPath.get("**.findAll { it.name() == 'accountnamestate' }.external_reference");
		   int latestListEntry = ls.size()-1;
		   System.out.println(ls.get(latestListEntry));	  
		   
		   
		
	}
	
}
