package com.space.starwalkerplatform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@SpringBootApplication
public class StarwalkerplatformApplication {

	public static void main(String[] args) {

		Properties properties = loadProperties();

		String apiKey = properties.getProperty("n2yo.api.key");
		String baseUrl = properties.getProperty("n2yo.api.base-url");
		String latitude = properties.getProperty("n2yo.observer.latitude");
		String longitude = properties.getProperty("n2yo.observer.longitude");

		System.out.println("=== Loading Configuration from application.properties ===");
		System.out.println("API Base URL: " + baseUrl);
		System.out.println("API Key: " + (apiKey != null && !apiKey.equals("YOUR_API_KEY_HERE") ? "****" : "NOT CONFIGURED"));
		System.out.println("Observer Location: " + latitude + ", " + longitude);
		System.out.println("========================================================");

		SpringApplication.run(StarwalkerplatformApplication.class, args);

	}

	private static Properties loadProperties() {
		Properties properties = new Properties();
		try(InputStream input = StarwalkerplatformApplication.class.getClassLoader().getResourceAsStream("application.properties")) {
			if(input == null) {
				System.err.println("Unable to find application.properties");
				return properties;
			}

			properties.load(input);

		} catch(IOException e) {
			System.err.println("Error loading application.properties: " + e.getMessage());
			e.printStackTrace();
		}

		return properties;

	}
}
