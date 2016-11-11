package utilsGabLib.config;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

import utilsGabLib.exceptions.UtilsGabLibException;

public abstract class ConfigManager {

	protected ResourceBundle prop = null;
	protected boolean bundleExportable = false;
	protected final static String DEFAULT_FILENAME = "config.properties";
	protected ConfigFileProtector configProtector = null;

	public ConfigManager() throws IOException, FileNotFoundException {
		init(DEFAULT_FILENAME, false);
	}

	public ConfigManager(String propFileName) throws IOException,
			FileNotFoundException {
		init(propFileName, false);
	}

	public ConfigManager(String propFileName, ConfigFileProtector cfgProtector)
			throws IOException, FileNotFoundException {
		init(propFileName, false, cfgProtector);
	}

	public ConfigManager(String propFileName, boolean exportable)
			throws IOException, FileNotFoundException {
		init(propFileName, exportable);
	}

	public ConfigManager(String propFileName, boolean exportable,
			ConfigFileProtector cfgProtector) throws IOException,
			FileNotFoundException {
		init(propFileName, exportable, cfgProtector);
	}

	protected void init(String propFileName, boolean bundleExportable)
			throws IOException, FileNotFoundException {
		this.bundleExportable = bundleExportable;
		prop = PropertyResourceBundle.getBundle(propFileName);
	}

	protected void init(String propFileName, boolean bundleExportable,
			ConfigFileProtector protector) throws IOException,
			FileNotFoundException {
		this.bundleExportable = bundleExportable;
		prop = PropertyResourceBundle.getBundle(propFileName);
		this.configProtector = protector;
	}

	public ResourceBundle getConfig() {
		return prop;
	}

	public String getStringValue(String configItemName) {
		return prop.getString(configItemName);
	}

	public String getProtectedStringValue(String configItemName) throws UtilsGabLibException{
		if ( this.configProtector == null){
			throw new UtilsGabLibException("No se ha proporcionado un desdencriptador para obtener una propiedad encriptada");
		}
		String result = null;
		try{
			result = this.configProtector.decrypt(prop.getString(configItemName));
		}catch(IOException e){
			throw new UtilsGabLibException(e);
		}catch (GeneralSecurityException e1) {
			throw new UtilsGabLibException(e1);
		}
		
		return result;
	}

	public String[] getStringArrayValue(String configItemName) {
		return prop.getStringArray(configItemName);
	}

	public Object getObjectValue(String configItemName) {
		return prop.getObject(configItemName);
	}

	public ResourceBundle getBundle() throws UtilsGabLibException {
		if (this.bundleExportable) {
			return prop;
		} else {
			throw new UtilsGabLibException(
					"Las propiedades no se definieron como exportables");
		}
	}
}
