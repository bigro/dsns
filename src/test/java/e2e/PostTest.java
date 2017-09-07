package e2e;

import com.ninja_squad.dbsetup.DbSetup;
import com.ninja_squad.dbsetup.operation.Operation;
import e2e.page.PostPage;
import e2e.page.SearchPage;
import org.assertj.core.api.SoftAssertions;
import org.fluentlenium.core.annotation.Page;
import org.fluentlenium.core.hook.wait.Wait;
import org.junit.Before;
import org.junit.Test;

import static com.ninja_squad.dbsetup.Operations.deleteAllFrom;

@Wait
public class PostTest extends FluentChromeTest {

    @Page
    PostPage postPage;
    public static final Operation DELETE_ALL = deleteAllFrom("article");

    @Before
    public void setUp() throws Exception {
        DbSetup dbSetup = new DbSetup(getDriverManagerDestination(), DELETE_ALL);
        dbSetup.launch();
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
}