package e2e;

import com.ninja_squad.dbsetup.DbSetup;
import com.ninja_squad.dbsetup.operation.Operation;
import e2e.page.SearchPage;
import org.fluentlenium.core.annotation.Page;
import org.fluentlenium.core.hook.wait.Wait;
import org.junit.Before;
import org.junit.Test;

import static com.ninja_squad.dbsetup.Operations.deleteAllFrom;
import static com.ninja_squad.dbsetup.Operations.insertInto;
import static org.assertj.core.api.Assertions.assertThat;

/*
アプリケーションを gradle -Dspring.profiles.active=local bootRun で起動してください。
 */
@Wait
public class SearchTest extends FluentChromeTest {

    @Page
    SearchPage searchPage;
    public static final Operation DELETE_ALL = deleteAllFrom("ARTICLE");

    @Before
    public void setUp() throws Exception {
        DbSetup dbSetup = new DbSetup(getDriverManagerDestination(), DELETE_ALL);
        dbSetup.launch();
    }

    @Test
    public void 全ての記事を検索できること() {
        Operation operation = insertInto("ARTICLE")
                .columns("author", "title", "contents")
                .values("Yamada", "Title1", "contents1")
                .values("Tanaka", "Title2", "contents2")
                .values("Sasaki", "Title3", "contents3")
                .values("Takagi", "Title4", "contents4")
                .build();
        DbSetup dbSetup = new DbSetup(getDriverManagerDestination(), operation);
        dbSetup.launch();

        goTo(searchPage);

        assertThat(searchPage.row()).isEqualTo(4);
    }
}