package constants;


public class FrameworkConstants {

	private FrameworkConstants() {
	}

	private static final String RESOURCESPATH = System.getProperty("user.dir") + "/src/test/resources";
	private static final String CONFIGFILEPATH = RESOURCESPATH + "/commonData.properties";


	public static String getConfigFilePath() {
		return CONFIGFILEPATH;
	}




}
