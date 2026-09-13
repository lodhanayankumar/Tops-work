/*1.Create a Singleton class called AppConfig in Java that stores a single instance of your 
 * app's configuration (e.g., app name, version). Write a main() method to get the instance 
 * twice and print whether both references point to the same object.<br><br><em><strong>
 * Hint:</strong> Use a private static AppConfig instance and a public static getInstance() 
 * method.</em>
 */

package Task1;

public class AppConfig {

    private static AppConfig instance;

    private String appName;
    private String version;

    private AppConfig() {
        appName = "My App";
        version = "1.0.0";
    }
    
    public static synchronized AppConfig getInstance() {
        if (instance == null) {
            instance = new AppConfig();
        }
        return instance;
    }

    public String getAppName() {
        return appName;
    }

    public String getVersion() {
        return version;
    }

    // Main method-singleton
    public static void main(String[] args) {
        
    	AppConfig config1 = AppConfig.getInstance();
        AppConfig config2 = AppConfig.getInstance();

        System.out.println("App Name: " + config1.getAppName());
        System.out.println("App Version: " + config1.getVersion());
    }
}
