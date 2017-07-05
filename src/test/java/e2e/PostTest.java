package e2e;

import org.fluentlenium.adapter.junit.FluentTest;
import org.fluentlenium.core.hook.wait.Wait;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static org.assertj.core.api.Assertions.assertThat;

@Wait
public class PostTest extends FluentTest {
    private String driverPath;

    @Before
    public void setUp() throws Exception {
        goTo("http://localhost:8080/");
    }

    @Test
    public void 記事を投稿できること() {
        assertThat(window().title()).contains("記事投稿");
    }

    @Override
    public String getWebDriver() {
        driverPath = "src/test/driver/chromedriver.exe";
        File file = new File(driverPath);
        System.setProperty("webdriver.chrome.driver", file.getPath());
        return "chrome";
    }
}