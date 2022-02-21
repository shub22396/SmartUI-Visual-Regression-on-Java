import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Hashtable;

public class visualui {
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        RemoteWebDriver driver = null;


        Hashtable<String, Integer> errorColor= new Hashtable<>();
        errorColor.put("red",200);
        errorColor.put("green",0);
        errorColor.put("blue",255);



        HashMap<String,Object> output= new HashMap<String, Object>();
        output.put("errorColor",errorColor);//Output Difference error color
        output.put("errorType","movement");//Flat Differences/Movement
        output.put("transparency",0.1);// Set transparency of Output
        output.put("largeImageThreshold",1200);// the granularity to which the comparison happens(the scale or level of detail in a set of data.)Range-100-1200
        output.put("useCrossOrigin",false);//source -localmachine
        output.put("outputDiff",true);//don't want to comparison set as false



        HashMap<String, Object> sm=new HashMap<String, Object>();
        sm.put("output",output);
        sm.put("scaleToSameSize",true);//scale to same size
        sm.put("ignore","antialiasing");//remove picture grouping




        String username = System.getenv("LT_USERNAME");
        String access_key = System.getenv("LT_ACCESS_KEY");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("build", "VisualUI");
        capabilities.setCapability("name", "Visual Ui Testing");
        capabilities.setCapability("platform", "Windows 10");
        capabilities.setCapability("browserName", "chrome");
        capabilities.setCapability("version","latest");
        capabilities.setCapability("visual",true);
        capabilities.setCapability("smartUI.project","lambdatest1");
       // capabilities.setCapability("smartUI.build","Base");
        capabilities.setCapability("smartUI.options",sm);










        // capabilities.setCapability("geoLocation","US");
        // capabilities.setCapability("fixedIP","23.105.164.143");
        //  capabilities.setCapability("region","eu");
       driver = new RemoteWebDriver(new URL("http://" + username + ":" + access_key + "@beta-smartui-hub.lambdatest.com/wd/hub"), capabilities);
      // driver = new RemoteWebDriver(new URL("https://webhook.site/82791797-a7cb-4d56-ad59-2f1fdc857b4b"), capabilities);

         driver.get("https://www.lambdatest.com/");

       //Thread.sleep(5000);

        driver.executeScript("smartui.takeScreenshot");


        driver.executeScript("lambda-status=passed");
        driver.quit();



    }
}
