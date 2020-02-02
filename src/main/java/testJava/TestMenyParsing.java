package testJava;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class TestMenyParsing {

    private static final Logger log = LogManager.getLogger(TestMenyParsing.class.getName());

    public static void main(String[] args) throws UnsupportedEncodingException {

		RestAssured.baseURI = "https://meny.no/Varer/Tilbud/";


		Response resp = RestAssured
				.given()
				.get();

		Document doc = Jsoup.parse(resp.getBody().asString());

        System.out.println("product name;description;previous price;actual price;end of the offer;url");
		Elements offerList = doc.select("#cw-products-promotionpage > ul > li");
		for (Element el : offerList) {
            for (Element el1 : el.getElementsByClass("cw-product__details")) {
                String productName = el1.getElementsByClass("cw-product__title").text().trim();
                String description = java.net.URLDecoder.decode(el1.getElementsByClass("cw-product__variant").text().trim(),"UTF8");
                String previousPrice = el1.getElementsByClass("cw-product__price-former").text().replaceAll("Før kr", "").trim();
                String integerActualPrice = el1.getElementsByClass("cw-product__price__main").text().trim();
				String decimalActualPrice = el1.getElementsByClass("cw-product__price__cents").text().trim();
                String actualPrice = integerActualPrice+","+decimalActualPrice;
                String endDate = el1.getElementsByClass("cw-product__promotion").text().replaceAll("Tilbud t.o.m.","").trim();
                String urlProduct = el1.getElementsByAttributeValue("itemprop", "url ").attr("content").trim();
                System.out.println(productName +";"+ description +";"+ previousPrice +";"+ actualPrice +";"+ endDate +";"+ urlProduct);
            }
        }
    }
}
