package com.learnautomation.utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider {

	public Properties pro;

	public ConfigDataProvider() {

		File src = new File("./Config/Config.properties");

		try {
			FileInputStream fis = new FileInputStream(src);

			pro = new Properties();

			pro.load(fis);

		} catch (Exception e) {

			System.out.println("Config file reading error:" + e.getMessage());
		}

	}

	public String getDatafromConfig(String keytoSearch) {

		return pro.getProperty(keytoSearch);
	}

	public String getBrowser() {

		return pro.getProperty("Browser");
	}

	public String getURL() {

		return pro.getProperty("qaUrl");
	}

}
