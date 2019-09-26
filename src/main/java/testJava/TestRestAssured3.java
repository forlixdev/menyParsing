package testJava;

import java.net.URISyntaxException;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URIBuilder;
import static com.google.common.collect.MoreCollectors.onlyElement;

public class TestRestAssured3 {

	public static void main(String[] args) throws URISyntaxException {
//
//		RestAssured.baseURI = "https://qa.signicat.com";
//		RequestSpecification req = RestAssured
//			.given().log().all()
//			.param("response_type", "code")
//			.param("scope", "openid profile signicat.national_id")
//			.param("redirect_uri", "https://example.com/redirect")
//			.param("acr_values", "urn:signicat:oidc:method:dummy-auth-poc")
//			.param("client_id", "test.signicat.oidctest")
//			.param("state", "myState");
//
//		String resp = req.get("/oidc/authorize").getBody().asString();
//		System.out.println(resp);
//		
//		XmlPath html= req.get("/oidc/authorize").getBody().htmlPath();
//		System.out.println("found: "+ html.getString("html.body.form.find{it.@name == 'dummyFormSuccess'}.@action"));
//		String regex = "[\\.a-zA-Z0-9:\\/]+\\/std\\/method\\/signicat\\/[0-9a-z]+\\/success";
//		Pattern pattern = Pattern.compile(regex);
//		System.out.println(pattern.matcher(resp).matches());
//		System.out.println(pattern.matcher(resp).group(1));
		
		
		String location="https://example.com/redirect?code=ftxVu8S4MJ18JW6kVeEJlhOGF3bCyaro&state=myState&session_state=06309b79e6148708f83c8674d871f0e3b54374fccb3fb714c988cf3270763f7c.Bz6WHXB7z7Vr6CY8";
		String regex = ".*code=([_0-9a-zA-Z\\-]+).*";                 
		Pattern pattern = Pattern.compile(regex);
		System.out.println(pattern.matcher(location).matches());
		
		List<NameValuePair> lista = new URIBuilder(location).getQueryParams();	
		System.out.println(lista.stream().filter(x->x.getName().equalsIgnoreCase("code")).collect(onlyElement()).getValue());
	}

}
