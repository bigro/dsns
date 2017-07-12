package e2e;

import com.example.dsns.Post;
import e2e.page.PostPage;
import org.fluentlenium.adapter.junit.FluentTest;
import org.fluentlenium.core.annotation.Page;
import org.fluentlenium.core.hook.wait.Wait;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static org.assertj.core.api.Assertions.assertThat;

@Wait
public class PostTest extends FluentTest {
    private String driverPath;

    @Page
    PostPage postPage;

    @Before
    public void setUp() throws Exception {
        goTo(postPage);
    }

    @Test
    public void 記事を投稿できること() {
        postPage.fillAuthor("Unknown").fillTitle("Title").fillContents("Dummy Dummy").post();
        postPage.isAt();
    }

    @Override
    public String getWebDriver() {
        driverPath = "src/test/driver/chromedriver.exe";
        File file = new File(driverPath);
        System.setProperty("webdriver.chrome.driver", file.getPath());
        return "chrome";
    }
}