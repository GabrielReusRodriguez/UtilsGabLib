package utilsGabLib.config;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

public abstract class ConfigManager {

	protected ResourceBundle prop = null;

	public void init() throws IOException,FileNotFoundException{		
		init("config.properties");
	}
	
	public void init(String propFileName){
		prop = PropertyResourceBundle.getBundle(propFileName);
	}

	public ResourceBundle getConfig() {
		return prop;
	}
}
