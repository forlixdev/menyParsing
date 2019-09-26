package testJava;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.JsonObject;
import com.nimbusds.jose.EncryptionMethod;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWEAlgorithm;
import com.nimbusds.jose.JWEEncrypter;
import com.nimbusds.jose.JWEHeader;
import com.nimbusds.jose.JWEObject;
import com.nimbusds.jose.Payload;
import com.nimbusds.jose.crypto.RSAEncrypter;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jwt.JWTClaimsSet;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.minidev.json.JSONObject;

public class TestVarious {

	private static final Logger log = LogManager.getLogger(TestVarious.class.getName());

	private static String jwk = "{\"kty\":\"RSA\",\"e\":\"AQAB\",\"use\":\"enc\",\"kid\":\"any.encryption.test.jwk.v.1\",\"alg\":\"RSA-OAEP\",\"n\":\"su_J9PYiT848VDvGlPIsuHTaybSg5tJOj6__fMrLOiC9VeZaEmdVkKB4TRacHNkdiDszKBDL7N70D4743xxwH4Jf-UVamCOVU3yGlqUENlkU7VcRHsBrTjSTlAE4IZMsjqe6rnnu9eD6IErLemrOOqnwHdZkhF0ovYXZVxtntODC0CJsfyfiz_px3ZNZX67FJg_nJ90Qs9iMqb0XD-4neE8NC0LaMuuLMm42tx4iwNFEb-wgt2pkTy51CxgdXJo_3WvJdqkbnxgrlAl7fbD7VG00YfG6xGnnQ04_9qBJxyNkaewUwRTNMUl-NCN7repgviJn7cMX5xCnM6_neYB4lQ\"}";

	public static String encryptRequest(String jwk, String json) throws ParseException, JOSEException {
		RSAKey jwkey = RSAKey.parse(jwk);
		Payload payload = new Payload(json);
		JWEEncrypter encrypter = new RSAEncrypter(jwkey.toPublicJWK());
		JWEHeader header = new JWEHeader.Builder(JWEAlgorithm.parse(jwkey.getAlgorithm().getName()),
				EncryptionMethod.A128CBC_HS256).keyID(jwkey.getKeyID()).build();
		JWEObject jwe = new JWEObject(header, payload);
		jwe.encrypt(encrypter);
		return jwe.serialize();
	}

	public static void main(String[] args) throws JOSEException, ParseException {

		RSAKey jwkey = RSAKey.parse(jwk);

		String json ="{\n" + 
				"  \"response_type\":\"code\",\n" + 
				"  \"scope\":\"openid profile signicat.national_id\",\n" + 
				"  \"client_id\":\"test.signicat.oidctest\",\n" + 
				"  \"state\":\"wwww\",\n" + 
				"  \"redirect_uri\":\"https://example.com/redirect\",\n" + 
				"  \"acr_values\":\"urn:signicat:oidc:method:dummy-auth\"\n" + 
				"}";		
		
		
		String req = encryptRequest(jwk,json);
		
//		JWTClaimsSet.Builder requestClaims = new JWTClaimsSet.Builder().claim("response_type", "code")
//				.claim("scope", "openid profile signicat.national_id").claim("client_id", "test.signicat.oidctest")
//				.claim("state", "wwww").claim("redirect_uri", "https://example.com/redirect")
//				.claim("acr_values", "urn:signicat:oidc:method:dummy-auth");
//
//		Payload payload = new Payload(requestClaims.build().toJSONObject());
//		JWEEncrypter encrypter = new RSAEncrypter(jwkey.toPublicJWK());
//		JWEHeader header = new JWEHeader.Builder(JWEAlgorithm.parse(jwkey.getAlgorithm().getName()),
//				EncryptionMethod.A128CBC_HS256).keyID(jwkey.getKeyID()).build();
//		JWEObject jwe = new JWEObject(header, payload);
//		log.debug("sdakfhlawdskfhqwelihfweqluirf");
//		jwe.encrypt(encrypter);

		String regex = "[\\.a-zA-Z0-9:\\/]+\\/std\\/method\\/signicat\\/[0-9a-z]+\\/success";
		Pattern pattern = Pattern.compile(regex);
		
		RestAssured.baseURI = "https://qa.signicat.com/oidc";
		Response resp = RestAssured.given().log().all().contentType("application/x-seid-sdo")
				.param("request", req).accept(ContentType.HTML).get("/authorize");

		log.debug("status code: {}", resp.getStatusCode());
		assert (resp.getStatusCode() == 200);
		log.debug("response: {}", resp.asString());
		assert (pattern.matcher(resp.getBody().asString()).matches());

	}

}
