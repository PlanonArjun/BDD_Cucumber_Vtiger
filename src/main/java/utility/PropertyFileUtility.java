package utility;

import constants.FrameworkConstants;
import enums.ConfigProperties;
import exceptions.PropertyFileUsageException;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

@SuppressWarnings("ALL")
public class PropertyFileUtility {

	private static final Properties property = new Properties();
	private static final Map<String, String> CONFIGMAP = new HashMap<>();

	/**
	 * Private constructor to avoid external instantiation
	 */
	private PropertyFileUtility() {
	}

	static {
		try (FileInputStream fis = new FileInputStream(FrameworkConstants.getConfigFilePath())) {
			property.load(fis);
			for (Map.Entry<Object, Object> entry : property.entrySet()) {
				CONFIGMAP.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()).trim());
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(0);
		}
	}

	public static String get(ConfigProperties key) {
		if (Objects.isNull(key) || Objects.isNull(CONFIGMAP.get(key.name().toLowerCase()))) {
			throw new PropertyFileUsageException(
					"Property name " + key + " is not found. Please check config.properties");
		}
		return CONFIGMAP.get(key.name().toLowerCase());
	}
}
