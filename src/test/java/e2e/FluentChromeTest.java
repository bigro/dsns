package e2e;

import com.ninja_squad.dbsetup.destination.DriverManagerDestination;
import org.fluentlenium.adapter.junit.FluentTest;
import org.fluentlenium.core.hook.wait.Wait;

import java.io.File;

@Wait
public class FluentChromeTest extends FluentTest {
    private final String JDBC_URL = "jdbc:mysql://localhost/electronix";
    private final String DB_USER = "electronix";
    private final String DB_PASSWORD = "pass";
    private final DriverManagerDestination driverManagerDestination = new DriverManagerDestination(JDBC_URL, DB_USER, DB_PASSWORD);
    private String driverPath;

    protected DriverManagerDestination getDriverManagerDestination() {
        return driverManagerDestination;
    }

    @Override
    public String getWebDriver() {
        driverPath = "src/test/driver/chromedriver";
        File file = new File(driverPath);
        System.setProperty("webdriver.chrome.driver", file.getPath());
        return "chrome";
    }
}