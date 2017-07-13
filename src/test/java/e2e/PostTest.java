package e2e;

import e2e.page.PostPage;
import e2e.page.SearchPage;
import org.assertj.core.api.SoftAssertions;
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
        SearchPage searchPage = postPage.fillAuthor("Unknown").fillTitle("Title").fillContents("Dummy Dummy").post();

        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(searchPage.author(0)).isEqualTo("Unknown");
        softAssertions.assertThat(searchPage.title(0)).isEqualTo("Title");
        softAssertions.assertThat(searchPage.contents(0)).isEqualTo("Dummy Dummy");
        softAssertions.assertAll();
    }

    @Override
    public String getWebDriver() {
        driverPath = "src/test/driver/chromedriver.exe";
        File file = new File(driverPath);
        System.setProperty("webdriver.chrome.driver", file.getPath());
        return "chrome";
    }
}