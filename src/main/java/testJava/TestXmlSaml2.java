package testJava;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.restassured.path.xml.XmlPath;

public class TestXmlSaml2 {

	   private static final Logger log = LogManager.getLogger(TestXmlSaml2.class.getName());
	
	public static void main(String[] args) {
		
		String xmlResponse = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" + 
				"<saml2p:Response xmlns:saml2p=\"urn:oasis:names:tc:SAML:2.0:protocol\" xmlns:xs=\"http://www.w3.org/2001/XMLSchema\" Destination=\"http://toolbox.signicat.net:3000/assert\" ID=\"ID3tbuqfzljdmzt0caau4r9uot9vekrkkketfjm7silzzo8fqtlz\" InResponseTo=\"_71789a4e0fab182711c04a4fe5ba754d5a93af0af1\" IssueInstant=\"2019-02-11T10:40:41.083Z\" Version=\"2.0\">\n" + 
				"  <saml2:Issuer xmlns:saml2=\"urn:oasis:names:tc:SAML:2.0:assertion\">https://qa.signicat.com/gateway/signicat/saml2/metadata</saml2:Issuer>\n" + 
				"  <ds:Signature xmlns:ds=\"http://www.w3.org/2000/09/xmldsig#\">\n" + 
				"    <ds:SignedInfo>\n" + 
				"      <ds:CanonicalizationMethod Algorithm=\"http://www.w3.org/2001/10/xml-exc-c14n#\" />\n" + 
				"      <ds:SignatureMethod Algorithm=\"http://www.w3.org/2001/04/xmldsig-more#rsa-sha256\" />\n" + 
				"      <ds:Reference URI=\"#ID3tbuqfzljdmzt0caau4r9uot9vekrkkketfjm7silzzo8fqtlz\">\n" + 
				"        <ds:Transforms>\n" + 
				"          <ds:Transform Algorithm=\"http://www.w3.org/2000/09/xmldsig#enveloped-signature\" />\n" + 
				"          <ds:Transform Algorithm=\"http://www.w3.org/2001/10/xml-exc-c14n#\">\n" + 
				"            <ec:InclusiveNamespaces xmlns:ec=\"http://www.w3.org/2001/10/xml-exc-c14n#\" PrefixList=\"xs\" />\n" + 
				"          </ds:Transform>\n" + 
				"        </ds:Transforms>\n" + 
				"        <ds:DigestMethod Algorithm=\"http://www.w3.org/2000/09/xmldsig#sha1\" />\n" + 
				"        <ds:DigestValue>bkpaCUnBO9WnWRSrTZiUrhflQuU=</ds:DigestValue>\n" + 
				"      </ds:Reference>\n" + 
				"    </ds:SignedInfo>\n" + 
				"    <ds:SignatureValue>XBNxflMSslKrUtWnu/3uFMXK+Fu8XEGwaZvMvfSBJp4vPwp36X76MbCdqpNzVWR1XbLBrOQntqGuVCs1rYpIFtO8e6GgcwZC1HC1jpp14txoxdUc6s5/1C6FjrM7IO98JRkueSewktLsLrKEif470aOQG8mOLOzArnOV/Q/F4iUq+TWrNGet4kBCVZbkUi6mA2/QGn9SLFH06gB6aWHgmw/kp2I07tkns/HrxIrJ9FzV5c9msZsCUTlXLSZ4TYgot2kEKFqIarL3gQ+ciONmSxSNHmZ8HkA/WUvfI0X2g7ZDTSJjSixtLeCATEcNDnUI+NyLUSnzrWDQDnKtbuH1Yg==</ds:SignatureValue>\n" + 
				"    <ds:KeyInfo>\n" + 
				"      <ds:X509Data>\n" + 
				"        <ds:X509Certificate>MIIDuzCCAqOgAwIBAgIBFDANBgkqhkiG9w0BAQsFADBJMQswCQYDVQQGEwJOTzEUMBIGA1UEChML\n" + 
				"U2lnbmljYXQgQVMxJDAiBgNVBAMTG1NpZ25pY2F0IEV4dGVybmFsIENBICgyMDQ4KTAeFw0xNzA5\n" + 
				"MjUxMDA4MDVaFw0xOTA5MjUxMDA4MDVaMHgxCzAJBgNVBAYTAk5PMQ8wDQYDVQQIDAZOb3J3YXkx\n" + 
				"EjAQBgNVBAcMCVRyb25kaGVpbTERMA8GA1UECgwIU2lnbmljYXQxETAPBgNVBAsMCFNpZ25pY2F0\n" + 
				"MR4wHAYDVQQDDBViZXRhLnNpZ25pY2F0LmNvbS9zdGQwggEiMA0GCSqGSIb3DQEBAQUAA4IBDwAw\n" + 
				"ggEKAoIBAQCXZorbsojIT6lf29ejt0rjLW7DvLfUFvWHWyy5rUbCFUB4wgutWmaGY6C+NVe/kgng\n" + 
				"/z9T3TBWySiBCsVFLV2i9d/67bw/rIlrvQCcUnQ2/sqKRVW7MMni7Wb3XHjD/wLeCSSKmnKcsQ/9\n" + 
				"gEOsNqZjOT5pBcmF75a6b8dn4+3M8abg7zgrMfx6E3JEyZ2azNIuoYT9wHKrDKXkKvxn1y43k4xN\n" + 
				"kzz50QMQMemAs32SO6iU5MBYYxKh+pMYX7Cc7VTJ9BRsod0zLFoDKXJiyGiH4OeeC45t35be/mxZ\n" + 
				"Rlo6X51XHGdklaMgfhDOZEOAhYY+94mS9r0bOBlKrJ5SLi1RAgMBAAGjfzB9MAkGA1UdEwQCMAAw\n" + 
				"CwYDVR0PBAQDAgXgMCMGCWCGSAGG+EIBDQQWFhRTaWduaWNhdCBDZXJ0aWZpY2F0ZTAdBgNVHQ4E\n" + 
				"FgQUB1OBDCpi5BvRXLsgChdMm73szEkwHwYDVR0jBBgwFoAUstl+DZ605NwX3br661U41SHRS/Yw\n" + 
				"DQYJKoZIhvcNAQELBQADggEBAHlLPdOpeKiWqmtcUs0GVEllyP8gGweqWf+13FEoSzPEt+aWFFjj\n" + 
				"aQm2sXaK3XET9U//cXf5plWGWUufXP1JD5VUUhRG1tRzBhe7q8EkuFL2xd8c2ofGMXGWvgaWdstE\n" + 
				"oljkk/CLuft9kVgtC+tplZhKtroEbNJGjbnazxfxe9D/P7OgZGFFQRpK5lNOFRRU36SpS3LPo/FA\n" + 
				"rhQako7zBpRW0IisREqe5gVNxU7BqMvU+WgecbOhlQTirDgBMbfeN6wpVgYsMXyssNL/bBhc0+AP\n" + 
				"UxQ9BVf2Irsa2xQixnqX5q+AAAlNGbgiapdb9NVXK0gmvS/xg5ngnz4buAv716w=</ds:X509Certificate>\n" + 
				"      </ds:X509Data>\n" + 
				"    </ds:KeyInfo>\n" + 
				"  </ds:Signature>\n" + 
				"  <saml2p:Status>\n" + 
				"    <saml2p:StatusCode Value=\"urn:oasis:names:tc:SAML:2.0:status:Success\" />\n" + 
				"  </saml2p:Status>\n" + 
				"  <saml2:Assertion xmlns:saml2=\"urn:oasis:names:tc:SAML:2.0:assertion\" ID=\"IDrv0tj0mvv15mc3w50oxerhzcw4rj3b35h86gy6es2eedyt2dw\" IssueInstant=\"2019-02-11T10:40:44.306Z\" Version=\"2.0\">\n" + 
				"    <saml2:Issuer>https://qa.signicat.com/gateway/signicat/saml2/metadata</saml2:Issuer>\n" + 
				"    <saml2:Subject>\n" + 
				"      <saml2:NameID Format=\"urn:oasis:names:tc:SAML:1.1:nameid-format:unspecified\" NameQualifier=\"BANKID-NO\">9578-6000-4-112851</saml2:NameID>\n" + 
				"      <saml2:SubjectConfirmation Method=\"urn:oasis:names:tc:SAML:2.0:cm:bearer\">\n" + 
				"        <saml2:SubjectConfirmationData InResponseTo=\"_71789a4e0fab182711c04a4fe5ba754d5a93af0af1\" NotOnOrAfter=\"2019-02-11T10:41:14.306Z\" Recipient=\"http://toolbox.signicat.net:3000/assert\" />\n" + 
				"      </saml2:SubjectConfirmation>\n" + 
				"    </saml2:Subject>\n" + 
				"    <saml2:Conditions NotOnOrAfter=\"2019-02-11T10:41:14.306Z\">\n" + 
				"      <saml2:AudienceRestriction>\n" + 
				"        <saml2:Audience>https://toolboxnode.net</saml2:Audience>\n" + 
				"      </saml2:AudienceRestriction>\n" + 
				"    </saml2:Conditions>\n" + 
				"    <saml2:AuthnStatement AuthnInstant=\"2019-02-11T10:40:40.401Z\" SessionIndex=\"34f6zfhhailnnm58xq7o6hs7oasimpjnj1z7opi4e2sb6orshc\">\n" + 
				"      <saml2:AuthnContext>\n" + 
				"        <saml2:AuthnContextClassRef>urn:oasis:names:tc:SAML:2.0:ac:classes:SoftwarePKI</saml2:AuthnContextClassRef>\n" + 
				"        <saml2:AuthnContextDeclRef>urn:signicat:SAML:2.0:ac:ref:signicat:nbid-js</saml2:AuthnContextDeclRef>\n" + 
				"      </saml2:AuthnContext>\n" + 
				"    </saml2:AuthnStatement>\n" + 
				"    <saml2:AttributeStatement>\n" + 
				"      <saml2:Attribute Name=\"salesforce\" NameFormat=\"urn:oasis:names:tc:SAML:2.0:attrname-format:basic\">\n" + 
				"        <saml2:AttributeValue xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:type=\"xs:string\">marcus.almgren@signicat.com</saml2:AttributeValue>\n" + 
				"      </saml2:Attribute>\n" + 
				"      <saml2:Attribute Name=\"surname\" NameFormat=\"urn:oasis:names:tc:SAML:2.0:attrname-format:basic\">\n" + 
				"        <saml2:AttributeValue xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:type=\"xs:string\">Ødegård</saml2:AttributeValue>\n" + 
				"      </saml2:Attribute>\n" + 
				"      <saml2:Attribute Name=\"national-identity\" NameFormat=\"urn:oasis:names:tc:SAML:2.0:attrname-format:basic\">\n" + 
				"        <saml2:AttributeValue xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:type=\"xs:string\">10109001886</saml2:AttributeValue>\n" + 
				"      </saml2:Attribute>\n" + 
				"      <saml2:Attribute Name=\"given-name\" NameFormat=\"urn:oasis:names:tc:SAML:2.0:attrname-format:basic\">\n" + 
				"        <saml2:AttributeValue xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:type=\"xs:string\">Synnøve Ærøy</saml2:AttributeValue>\n" + 
				"      </saml2:Attribute>\n" + 
				"      <saml2:Attribute Name=\"signicat.national-id\" NameFormat=\"urn:oasis:names:tc:SAML:2.0:attrname-format:basic\">\n" + 
				"        <saml2:AttributeValue xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:type=\"xs:string\">10109001886</saml2:AttributeValue>\n" + 
				"      </saml2:Attribute>\n" + 
				"      <saml2:Attribute Name=\"email\" NameFormat=\"urn:oasis:names:tc:SAML:2.0:attrname-format:basic\">\n" + 
				"        <saml2:AttributeValue xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:type=\"xs:string\" />\n" + 
				"      </saml2:Attribute>\n" + 
				"      <saml2:Attribute Name=\"national-identity-country\" NameFormat=\"urn:oasis:names:tc:SAML:2.0:attrname-format:basic\">\n" + 
				"        <saml2:AttributeValue xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:type=\"xs:string\">NO</saml2:AttributeValue>\n" + 
				"      </saml2:Attribute>\n" + 
				"      <saml2:Attribute Name=\"common-name\" NameFormat=\"urn:oasis:names:tc:SAML:2.0:attrname-format:basic\">\n" + 
				"        <saml2:AttributeValue xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:type=\"xs:string\">Ødegård, Synnøve Ærøy</saml2:AttributeValue>\n" + 
				"      </saml2:Attribute>\n" + 
				"      <saml2:Attribute Name=\"signicat.unique-id\" NameFormat=\"urn:oasis:names:tc:SAML:2.0:attrname-format:basic\">\n" + 
				"        <saml2:AttributeValue xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:type=\"xs:string\">9578-6000-4-112851</saml2:AttributeValue>\n" + 
				"      </saml2:Attribute>\n" + 
				"    </saml2:AttributeStatement>\n" + 
				"  </saml2:Assertion>\n" + 
				"</saml2p:Response>";
		XmlPath xmlPath = new XmlPath(xmlResponse);
		System.out.println(xmlPath.getString("Response.Issuer"));
//		
//		
//		String xmlResponse2="<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" + 
//				"<soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">\n" + 
//				"  <soap:Body>\n" + 
//				"    <list-pending-accounts-response xmlns=\"https://id.signicat.com/definitions/wsdl/Scid-v2\">\n" + 
//				"      <accountnames>\n" + 
//				"        <accountnamestate>\n" + 
//				"          <external_reference>beepbop</external_reference>\n" + 
//				"          <state>PENDING</state>\n" + 
//				"        </accountnamestate>\n" + 
//				"        <accountnamestate>\n" + 
//				"          <external_reference>stinortor</external_reference>\n" + 
//				"          <state>PENDING</state>\n" + 
//				"        </accountnamestate>\n" + 
//				"        <accountnamestate>\n" + 
//				"          <external_reference>giggity</external_reference>\n" + 
//				"          <state>PENDING</state>\n" + 
//				"        </accountnamestate>\n" + 
//				"        <accountnamestate>\n" + 
//				"          <external_reference>pendingAccountTest</external_reference>\n" + 
//				"          <state>PENDING</state>\n" + 
//				"        </accountnamestate>\n" + 
//				"      </accountnames>\n" + 
//				"    </list-pending-accounts-response>\n" + 
//				"  </soap:Body>\n" + 
//				"</soap:Envelope>";
//		
//		
//		   xmlPath = XmlPath.with(xmlResponse2);
//		   List<String> ls = xmlPath.get("**.findAll { it.name() == 'accountnamestate' }.external_reference");
//		   int latestListEntry = ls.size()-1;
//		   System.out.println(ls.get(latestListEntry));	  
		   
		   
		
	}
	
}
