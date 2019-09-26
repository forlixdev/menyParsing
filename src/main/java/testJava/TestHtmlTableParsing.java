package testJava;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class TestHtmlTableParsing {

	private static final Logger log = LogManager.getLogger(TestHtmlTableParsing.class.getName());

	public static Map<String, String> getMapFromHtmlTable(String html) {
		Map<String, String> map = new HashMap<String, String>();
		Document doc = org.jsoup.Jsoup.parse(html);
		Element table = doc.select("table").get(0);
		for (Element row : table.select("tr")) {
			Elements tds = row.select("td");
			map.put(tds.text().split("\\s")[0],
					tds.text().replaceAll(tds.text().split("\\s")[0], "").replaceAll("^\\s+", ""));
		}
		// map.forEach((k, v) -> System.out.println("Html result table :" + k + " --> "
		// + v));
		return map;
	}

	public static void main(String[] args) {

		String html = "<html xmlns=\"http://www.w3.org/1999/xhtml\"><head>\n" + "    <title>Signicat James</title>\n"
				+ "    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n"
				+ "    <link rel=\"stylesheet\" href=\"css/main20.css\" type=\"text/css\" />\n" + "</head>\n" + "\n"
				+ "<body>\n" + "\n" + "    <h3>SAML Response Attributes</h3>\n" + "    <table class=\"table-list\">\n"
				+ "        \n" + "            <tbody><tr>\n" + "                <td class=\"label\">error</td>\n"
				+ "                <td>urn:signicat:error; Unspecified error</td>\n" + "            </tr>\n"
				+ "        \n" + "            <tr>\n" + "                <td class=\"label\">exception</td>\n"
				+ "                <td></td>\n" + "            </tr>\n" + "        \n" + "    </tbody></table>\n" + "\n"
				+ "    <br />\n" + "    <h3>SAML Response XML</h3>\n"
				+ "    <p>&lt;Response xmlns=\"urn:oasis:names:tc:SAML:1.0:protocol\" xmlns:saml=\"urn:oasis:names:tc:SAML:1.0:assertion\" xmlns:samlp=\"urn:oasis:names:tc:SAML:1.0:protocol\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" IssueInstant=\"2019-02-12T14:16:33.165Z\" MajorVersion=\"1\" MinorVersion=\"1\" Recipient=\"https://qa.signicat.com/james/response\" ResponseID=\"_bbdb39a12b303bb4e0a2c8d5ee51c274\"&gt;&lt;ds:Signature xmlns:ds=\"http://www.w3.org/2000/09/xmldsig#\"&gt;\n"
				+ "&lt;ds:SignedInfo&gt;\n"
				+ "&lt;ds:CanonicalizationMethod Algorithm=\"http://www.w3.org/2001/10/xml-exc-c14n#\"&gt;&lt;/ds:CanonicalizationMethod&gt;\n"
				+ "&lt;ds:SignatureMethod Algorithm=\"http://www.w3.org/2000/09/xmldsig#rsa-sha1\"&gt;&lt;/ds:SignatureMethod&gt;\n"
				+ "&lt;ds:Reference URI=\"#_bbdb39a12b303bb4e0a2c8d5ee51c274\"&gt;\n" + "&lt;ds:Transforms&gt;\n"
				+ "&lt;ds:Transform Algorithm=\"http://www.w3.org/2000/09/xmldsig#enveloped-signature\"&gt;&lt;/ds:Transform&gt;\n"
				+ "&lt;ds:Transform Algorithm=\"http://www.w3.org/2001/10/xml-exc-c14n#\"&gt;&lt;ec:InclusiveNamespaces xmlns:ec=\"http://www.w3.org/2001/10/xml-exc-c14n#\" PrefixList=\"code ds kind rw saml samlp typens #default xsd xsi\"&gt;&lt;/ec:InclusiveNamespaces&gt;&lt;/ds:Transform&gt;\n"
				+ "&lt;/ds:Transforms&gt;\n"
				+ "&lt;ds:DigestMethod Algorithm=\"http://www.w3.org/2000/09/xmldsig#sha1\"&gt;&lt;/ds:DigestMethod&gt;\n"
				+ "&lt;ds:DigestValue&gt;DaVkPel4nRvM4eHKGbuSXsCgMrA=&lt;/ds:DigestValue&gt;\n"
				+ "&lt;/ds:Reference&gt;\n" + "&lt;/ds:SignedInfo&gt;\n" + "&lt;ds:SignatureValue&gt;\n"
				+ "ha5+6GvOoR+BMqUhSeV7Qd7ZnmNgq9hoPc6ULXE3JsrIcioYs/oUA5TvvkmKefqTZUoVnjVyKpmj\n"
				+ "PrSAG65OjaN3rITITSsQE8FSy17qluS8UyyEWejU2ArvDnocNR3FREEUoaRLt+LgNf0OCnGahd7d\n"
				+ "d2Z/gGoz70KQNEmBXxmyZ5XEVGaGUuv2zyEovwWbZE5F+Uab71mXbwM1yZsT1tzw5HW8XjhYoZI+\n"
				+ "5tIMAPmQBcHftw83X0YpiXFiZzunGS/87cOcaRU0+Ts5HzuDM2iQF9ub3nXbQcX7PUqCTILr45Pk\n"
				+ "oQ6w1Z/3/OeY9XVvGFSvShEYNyZR6nxP7TDFMw==\n" + "&lt;/ds:SignatureValue&gt;\n" + "&lt;ds:KeyInfo&gt;\n"
				+ "&lt;ds:X509Data&gt;\n" + "&lt;ds:X509Certificate&gt;\n"
				+ "MIIDuzCCAqOgAwIBAgIBFDANBgkqhkiG9w0BAQsFADBJMQswCQYDVQQGEwJOTzEUMBIGA1UEChML\n"
				+ "U2lnbmljYXQgQVMxJDAiBgNVBAMTG1NpZ25pY2F0IEV4dGVybmFsIENBICgyMDQ4KTAeFw0xNzA5\n"
				+ "MjUxMDA4MDVaFw0xOTA5MjUxMDA4MDVaMHgxCzAJBgNVBAYTAk5PMQ8wDQYDVQQIDAZOb3J3YXkx\n"
				+ "EjAQBgNVBAcMCVRyb25kaGVpbTERMA8GA1UECgwIU2lnbmljYXQxETAPBgNVBAsMCFNpZ25pY2F0\n"
				+ "MR4wHAYDVQQDDBViZXRhLnNpZ25pY2F0LmNvbS9zdGQwggEiMA0GCSqGSIb3DQEBAQUAA4IBDwAw\n"
				+ "ggEKAoIBAQCXZorbsojIT6lf29ejt0rjLW7DvLfUFvWHWyy5rUbCFUB4wgutWmaGY6C+NVe/kgng\n"
				+ "/z9T3TBWySiBCsVFLV2i9d/67bw/rIlrvQCcUnQ2/sqKRVW7MMni7Wb3XHjD/wLeCSSKmnKcsQ/9\n"
				+ "gEOsNqZjOT5pBcmF75a6b8dn4+3M8abg7zgrMfx6E3JEyZ2azNIuoYT9wHKrDKXkKvxn1y43k4xN\n"
				+ "kzz50QMQMemAs32SO6iU5MBYYxKh+pMYX7Cc7VTJ9BRsod0zLFoDKXJiyGiH4OeeC45t35be/mxZ\n"
				+ "Rlo6X51XHGdklaMgfhDOZEOAhYY+94mS9r0bOBlKrJ5SLi1RAgMBAAGjfzB9MAkGA1UdEwQCMAAw\n"
				+ "CwYDVR0PBAQDAgXgMCMGCWCGSAGG+EIBDQQWFhRTaWduaWNhdCBDZXJ0aWZpY2F0ZTAdBgNVHQ4E\n"
				+ "FgQUB1OBDCpi5BvRXLsgChdMm73szEkwHwYDVR0jBBgwFoAUstl+DZ605NwX3br661U41SHRS/Yw\n"
				+ "DQYJKoZIhvcNAQELBQADggEBAHlLPdOpeKiWqmtcUs0GVEllyP8gGweqWf+13FEoSzPEt+aWFFjj\n"
				+ "aQm2sXaK3XET9U//cXf5plWGWUufXP1JD5VUUhRG1tRzBhe7q8EkuFL2xd8c2ofGMXGWvgaWdstE\n"
				+ "oljkk/CLuft9kVgtC+tplZhKtroEbNJGjbnazxfxe9D/P7OgZGFFQRpK5lNOFRRU36SpS3LPo/FA\n"
				+ "rhQako7zBpRW0IisREqe5gVNxU7BqMvU+WgecbOhlQTirDgBMbfeN6wpVgYsMXyssNL/bBhc0+AP\n"
				+ "UxQ9BVf2Irsa2xQixnqX5q+AAAlNGbgiapdb9NVXK0gmvS/xg5ngnz4buAv716w=\n" + "&lt;/ds:X509Certificate&gt;\n"
				+ "&lt;/ds:X509Data&gt;\n"
				+ "&lt;/ds:KeyInfo&gt;&lt;/ds:Signature&gt;&lt;Status&gt;&lt;StatusCode Value=\"samlp:Responder\"&gt;&lt;/StatusCode&gt;&lt;StatusMessage&gt;urn:signicat:error; Unspecified error&lt;/StatusMessage&gt;&lt;/Status&gt;&lt;/Response&gt;</p>\n"
				+ "\n" + "    <h3>HTTP Response Parameters</h3>\n" + "    <table class=\"table-list\">\n" + "        \n"
				+ "                <tbody><tr>\n" + "                    <td class=\"label\">TARGET</td>\n"
				+ "                    <td>https://qa.signicat.com/james/response</td>\n" + "                </tr>\n"
				+ "        \n" + "                <tr>\n"
				+ "                    <td class=\"label\">SAMLResponse</td>\n"
				+ "                    <td>PFJlc3BvbnNlIHhtbG5zPSJ1cm46b2FzaXM6bmFtZXM6dGM6U0FNTDoxLjA6cHJvdG9jb2wiIHht\n"
				+ "bG5zOnNhbWw9InVybjpvYXNpczpuYW1lczp0YzpTQU1MOjEuMDphc3NlcnRpb24iIHhtbG5zOnNh\n"
				+ "bWxwPSJ1cm46b2FzaXM6bmFtZXM6dGM6U0FNTDoxLjA6cHJvdG9jb2wiIHhtbG5zOnhzZD0iaHR0\n"
				+ "cDovL3d3dy53My5vcmcvMjAwMS9YTUxTY2hlbWEiIHhtbG5zOnhzaT0iaHR0cDovL3d3dy53My5v\n"
				+ "cmcvMjAwMS9YTUxTY2hlbWEtaW5zdGFuY2UiIElzc3VlSW5zdGFudD0iMjAxOS0wMi0xMlQxNDox\n"
				+ "NjozMy4xNjVaIiBNYWpvclZlcnNpb249IjEiIE1pbm9yVmVyc2lvbj0iMSIgUmVjaXBpZW50PSJo\n"
				+ "dHRwczovL3FhLnNpZ25pY2F0LmNvbS9qYW1lcy9yZXNwb25zZSIgUmVzcG9uc2VJRD0iX2JiZGIz\n"
				+ "OWExMmIzMDNiYjRlMGEyYzhkNWVlNTFjMjc0Ij48ZHM6U2lnbmF0dXJlIHhtbG5zOmRzPSJodHRw\n"
				+ "Oi8vd3d3LnczLm9yZy8yMDAwLzA5L3htbGRzaWcjIj4KPGRzOlNpZ25lZEluZm8+CjxkczpDYW5v\n"
				+ "bmljYWxpemF0aW9uTWV0aG9kIEFsZ29yaXRobT0iaHR0cDovL3d3dy53My5vcmcvMjAwMS8xMC94\n"
				+ "bWwtZXhjLWMxNG4jIj48L2RzOkNhbm9uaWNhbGl6YXRpb25NZXRob2Q+CjxkczpTaWduYXR1cmVN\n"
				+ "ZXRob2QgQWxnb3JpdGhtPSJodHRwOi8vd3d3LnczLm9yZy8yMDAwLzA5L3htbGRzaWcjcnNhLXNo\n"
				+ "YTEiPjwvZHM6U2lnbmF0dXJlTWV0aG9kPgo8ZHM6UmVmZXJlbmNlIFVSST0iI19iYmRiMzlhMTJi\n"
				+ "MzAzYmI0ZTBhMmM4ZDVlZTUxYzI3NCI+CjxkczpUcmFuc2Zvcm1zPgo8ZHM6VHJhbnNmb3JtIEFs\n"
				+ "Z29yaXRobT0iaHR0cDovL3d3dy53My5vcmcvMjAwMC8wOS94bWxkc2lnI2VudmVsb3BlZC1zaWdu\n"
				+ "YXR1cmUiPjwvZHM6VHJhbnNmb3JtPgo8ZHM6VHJhbnNmb3JtIEFsZ29yaXRobT0iaHR0cDovL3d3\n"
				+ "dy53My5vcmcvMjAwMS8xMC94bWwtZXhjLWMxNG4jIj48ZWM6SW5jbHVzaXZlTmFtZXNwYWNlcyB4\n"
				+ "bWxuczplYz0iaHR0cDovL3d3dy53My5vcmcvMjAwMS8xMC94bWwtZXhjLWMxNG4jIiBQcmVmaXhM\n"
				+ "aXN0PSJjb2RlIGRzIGtpbmQgcncgc2FtbCBzYW1scCB0eXBlbnMgI2RlZmF1bHQgeHNkIHhzaSI+\n"
				+ "PC9lYzpJbmNsdXNpdmVOYW1lc3BhY2VzPjwvZHM6VHJhbnNmb3JtPgo8L2RzOlRyYW5zZm9ybXM+\n"
				+ "CjxkczpEaWdlc3RNZXRob2QgQWxnb3JpdGhtPSJodHRwOi8vd3d3LnczLm9yZy8yMDAwLzA5L3ht\n"
				+ "bGRzaWcjc2hhMSI+PC9kczpEaWdlc3RNZXRob2Q+CjxkczpEaWdlc3RWYWx1ZT5EYVZrUGVsNG5S\n"
				+ "dk00ZUhLR2J1U1hzQ2dNckE9PC9kczpEaWdlc3RWYWx1ZT4KPC9kczpSZWZlcmVuY2U+CjwvZHM6\n"
				+ "U2lnbmVkSW5mbz4KPGRzOlNpZ25hdHVyZVZhbHVlPgpoYTUrNkd2T29SK0JNcVVoU2VWN1FkN1pu\n"
				+ "bU5ncTlob1BjNlVMWEUzSnNySWNpb1lzL29VQTVUdnZrbUtlZnFUWlVvVm5qVnlLcG1qClByU0FH\n"
				+ "NjVPamFOM3JJVElUU3NRRThGU3kxN3FsdVM4VXl5RVdlalUyQXJ2RG5vY05SM0ZSRUVVb2FSTHQr\n"
				+ "TGdOZjBPQ25HYWhkN2QKZDJaL2dHb3o3MEtRTkVtQlh4bXlaNVhFVkdhR1V1djJ6eUVvdndXYlpF\n"
				+ "NUYrVWFiNzFtWGJ3TTF5WnNUMXR6dzVIVzhYamhZb1pJKwo1dElNQVBtUUJjSGZ0dzgzWDBZcGlY\n"
				+ "RmlaenVuR1MvODdjT2NhUlUwK1RzNUh6dURNMmlRRjl1YjNuWGJRY1g3UFVxQ1RJTHI0NVBrCm9R\n"
				+ "NncxWi8zL09lWTlYVnZHRlN2U2hFWU55WlI2bnhQN1RERk13PT0KPC9kczpTaWduYXR1cmVWYWx1\n"
				+ "ZT4KPGRzOktleUluZm8+CjxkczpYNTA5RGF0YT4KPGRzOlg1MDlDZXJ0aWZpY2F0ZT4KTUlJRHV6\n"
				+ "Q0NBcU9nQXdJQkFnSUJGREFOQmdrcWhraUc5dzBCQVFzRkFEQkpNUXN3Q1FZRFZRUUdFd0pPVHpF\n"
				+ "VU1CSUdBMVVFQ2hNTApVMmxuYm1sallYUWdRVk14SkRBaUJnTlZCQU1URzFOcFoyNXBZMkYwSUVW\n"
				+ "NGRHVnlibUZzSUVOQklDZ3lNRFE0S1RBZUZ3MHhOekE1Ck1qVXhNREE0TURWYUZ3MHhPVEE1TWpV\n"
				+ "eE1EQTRNRFZhTUhneEN6QUpCZ05WQkFZVEFrNVBNUTh3RFFZRFZRUUlEQVpPYjNKM1lYa3gKRWpB\n"
				+ "UUJnTlZCQWNNQ1ZSeWIyNWthR1ZwYlRFUk1BOEdBMVVFQ2d3SVUybG5ibWxqWVhReEVUQVBCZ05W\n"
				+ "QkFzTUNGTnBaMjVwWTJGMApNUjR3SEFZRFZRUUREQlZpWlhSaExuTnBaMjVwWTJGMExtTnZiUzl6\n"
				+ "ZEdRd2dnRWlNQTBHQ1NxR1NJYjNEUUVCQVFVQUE0SUJEd0F3CmdnRUtBb0lCQVFDWFpvcmJzb2pJ\n"
				+ "VDZsZjI5ZWp0MHJqTFc3RHZMZlVGdldIV3l5NXJVYkNGVUI0d2d1dFdtYUdZNkMrTlZlL2tnbmcK\n"
				+ "L3o5VDNUQld5U2lCQ3NWRkxWMmk5ZC82N2J3L3JJbHJ2UUNjVW5RMi9zcUtSVlc3TU1uaTdXYjNY\n"
				+ "SGpEL3dMZUNTU0ttbktjc1EvOQpnRU9zTnFaak9UNXBCY21GNzVhNmI4ZG40KzNNOGFiZzd6Z3JN\n"
				+ "Zng2RTNKRXlaMmF6Tkl1b1lUOXdIS3JES1hrS3Z4bjF5NDNrNHhOCmt6ejUwUU1RTWVtQXMzMlNP\n"
				+ "NmlVNU1CWVl4S2grcE1ZWDdDYzdWVEo5QlJzb2QwekxGb0RLWEppeUdpSDRPZWVDNDV0MzViZS9t\n"
				+ "eFoKUmxvNlg1MVhIR2RrbGFNZ2ZoRE9aRU9BaFlZKzk0bVM5cjBiT0JsS3JKNVNMaTFSQWdNQkFB\n"
				+ "R2pmekI5TUFrR0ExVWRFd1FDTUFBdwpDd1lEVlIwUEJBUURBZ1hnTUNNR0NXQ0dTQUdHK0VJQkRR\n"
				+ "UVdGaFJUYVdkdWFXTmhkQ0JEWlhKMGFXWnBZMkYwWlRBZEJnTlZIUTRFCkZnUVVCMU9CRENwaTVC\n"
				+ "dlJYTHNnQ2hkTW03M3N6RWt3SHdZRFZSMGpCQmd3Rm9BVXN0bCtEWjYwNU53WDNicjY2MVU0MVNI\n"
				+ "UlMvWXcKRFFZSktvWklodmNOQVFFTEJRQURnZ0VCQUhsTFBkT3BlS2lXcW10Y1VzMEdWRWxseVA4\n"
				+ "Z0d3ZXFXZisxM0ZFb1N6UEV0K2FXRkZqagphUW0yc1hhSzNYRVQ5VS8vY1hmNXBsV0dXVXVmWFAx\n"
				+ "SkQ1VlVVaFJHMXRSekJoZTdxOEVrdUZMMnhkOGMyb2ZHTVhHV3ZnYVdkc3RFCm9samtrL0NMdWZ0\n"
				+ "OWtWZ3RDK3RwbFpoS3Ryb0ViTkpHamJuYXp4ZnhlOUQvUDdPZ1pHRkZRUnBLNWxOT0ZSUlUzNlNw\n"
				+ "UzNMUG8vRkEKcmhRYWtvN3pCcFJXMElpc1JFcWU1Z1ZOeFU3QnFNdlUrV2dlY2JPaGxRVGlyRGdC\n"
				+ "TWJmZU42d3BWZ1lzTVh5c3NOTC9iQmhjMCtBUApVeFE5QlZmMklyc2EyeFFpeG5xWDVxK0FBQWxO\n"
				+ "R2JnaWFwZGI5TlZYSzBnbXZTL3hnNW5nbno0YnVBdjcxNnc9CjwvZHM6WDUwOUNlcnRpZmljYXRl\n"
				+ "Pgo8L2RzOlg1MDlEYXRhPgo8L2RzOktleUluZm8+PC9kczpTaWduYXR1cmU+PFN0YXR1cz48U3Rh\n"
				+ "dHVzQ29kZSBWYWx1ZT0ic2FtbHA6UmVzcG9uZGVyIj48L1N0YXR1c0NvZGU+PFN0YXR1c01lc3Nh\n"
				+ "Z2U+dXJuOnNpZ25pY2F0OmVycm9yOyBVbnNwZWNpZmllZCBlcnJvcjwvU3RhdHVzTWVzc2FnZT48\n"
				+ "L1N0YXR1cz48L1Jlc3BvbnNlPg==\n" + "</td>\n" + "                </tr>\n" + "        \n"
				+ "    </tbody></table>";

		Document doc = Jsoup.parse(html);
		Element table = doc.select("table").get(0);
		for (Element row : table.select("tr")) {
			Elements tds = row.select("td");
			if (tds.text().contains("error")) {
				tds.next().text();
				log.debug(tds.next().text()); // .split("\\s+")[1];

			}

		}

	}
}
