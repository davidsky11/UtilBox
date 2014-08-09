package com.kn.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.junit.Test;

public class ConfigUtils {

	private static ConfigUtils instance = null;

	private static final String SERVICES_PROPERTIES_FILE = "services.properties";
	private static final String SERVICE_URL = "SERVICE_URL";
	private static final String APK_UPDATE_URL = "APK_UPDATE_URL";
	private static final String APK_NAME_MAIN = "APK_NAME_MAIN";
	private static final String APK_NAME_SAOMIAO = "APK_NAME_SAOMIAO";
	private static final String NETWORK_TEST_DOMAIN = "NETWORK_TEST_DOMAIN";

	String serviceUrl = null;
	String apkUpdateUrl = null;
	String apkNameMain = null;
	String apkNameSaomiao = null;
	String networkTestDomain = null;

	public static ConfigUtils getInstance() {
		if (instance == null) {
			instance = new ConfigUtils();
		}
		return instance;
	}

	public ConfigUtils() {
		InputStream inputStream = null;
		Properties properties = new Properties();

		try {
			inputStream = new FileInputStream(SERVICES_PROPERTIES_FILE);
			properties.load(inputStream);
			setServiceUrl(properties.getProperty(SERVICE_URL,
					"http://10.0.2.2:8080/KnService/apk/KnSoft.apk"));
			setApkUpdateUrl(properties.getProperty(APK_UPDATE_URL,
					"http://10.0.2.2:8080/KnService/apk/KnSoft.apk"));
			setApkNameMain(properties.getProperty(APK_NAME_MAIN, "KnSoft.apk"));
			setApkNameSaomiao(properties.getProperty(APK_NAME_SAOMIAO,
					"ZXing.apk"));
			setNetworkTestDomain(properties.getProperty(NETWORK_TEST_DOMAIN,
					"www.csdn.net"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getServiceUrl() {
		return serviceUrl;
	}

	public void setServiceUrl(String serviceUrl) {
		this.serviceUrl = serviceUrl;
	}

	public String getApkUpdateUrl() {
		return apkUpdateUrl;
	}

	public void setApkUpdateUrl(String apkUpdateUrl) {
		this.apkUpdateUrl = apkUpdateUrl;
	}

	public String getApkNameMain() {
		return apkNameMain;
	}

	public void setApkNameMain(String apkNameMain) {
		this.apkNameMain = apkNameMain;
	}

	public String getApkNameSaomiao() {
		return apkNameSaomiao;
	}

	public void setApkNameSaomiao(String apkNameSaomiao) {
		this.apkNameSaomiao = apkNameSaomiao;
	}

	public String getNetworkTestDomain() {
		return networkTestDomain;
	}

	public void setNetworkTestDomain(String networkTestDomain) {
		this.networkTestDomain = networkTestDomain;
	}
	
	@Test
	public static void main(String[] args) {
		System.out.println(ConfigUtils.getInstance().getApkUpdateUrl());
	}
}
