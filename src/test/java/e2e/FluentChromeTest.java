package e2e;

import com.ninja_squad.dbsetup.destination.DriverManagerDestination;
import org.fluentlenium.adapter.junit.FluentTest;
import org.fluentlenium.core.hook.wait.Wait;

import java.io.File;

@Wait
public class FluentChromeTest extends FluentTest {
    private final String JDBC_URL = "jdbc:h2:tcp://localhost:9092/mem:testdb";
    private final String DB_USER = "sa";
    private final String DB_PASSWORD = "";
    private String driverPath;

    protected DriverManagerDestination getDriverManagerDestination() {
        return new DriverManagerDestination(JDBC_URL, DB_USER, DB_PASSWORD);
    }

    @Override
    public String getWebDriver() {
        driverPath = "src/test/driver/chromedriver.exe";
        File file = new File(driverPath);
        System.setProperty("webdriver.chrome.driver", file.getPath());
        return "chrome";
    }
}