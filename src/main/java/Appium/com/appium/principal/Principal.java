package Appium.com.appium.principal;

import java.net.MalformedURLException;

import org.apache.log4j.Logger;

import Appium.com.appium.utilities.Configuration;

public class Principal {

	final static Logger logger = Logger.getLogger(Principal.class);
	
	public static void main(String[] args) {
		try {
			Configuration.initConfiguration();
		} catch (MalformedURLException e) {
			logger.error(e);
		}
	}

}
