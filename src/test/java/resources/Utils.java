package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class Utils {
	public static RequestSpecification res;

	public RequestSpecification RequestSpecification() throws IOException {
		if (res == null) {

			PrintStream stream = new PrintStream(new FileOutputStream("Logging.txt"));

			res = new RequestSpecBuilder().setBaseUri(getGlobalvalue("baseurl")).addQueryParam("key", "qaclick123")
					.addFilter(RequestLoggingFilter.logRequestTo(stream))
					.addFilter(ResponseLoggingFilter.logResponseTo(stream)).setContentType(ContentType.JSON).build();
		}

		return res;
	}

	public static String getGlobalvalue(String key) throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"E:\\Automation_Workspace\\Api_Framework\\src\\test\\java\\resources\\global.properties");
		prop.load(fis);
		return prop.getProperty(key);
	}

}
