package examlefinal.loginwsm.util;

import java.util.Properties;

public class Setting {
	private static Properties setting = FileUtil.loadProperties("setting.properties");

	public static final String WEBDRIVER = "webdriver";
	public static final String PAGE_PATH = "webdriver-path";
	public static final String DATA_FILE = "data-file";
	public static final String WEB_GECKO_DRIVER = "webdriver.gecko.driver";
	public static final String GECKO_DRIVER = "lib/geckodriver";

	public static String getSetting(String key) {
		return setting.getProperty(key);
	}
}
