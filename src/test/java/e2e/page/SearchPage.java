package e2e.page;

import org.fluentlenium.core.FluentPage;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchPage extends FluentPage {

    @Override
    public void isAt() {
        assertThat(window().title()).contains("記事一覧");
    }

    @Override
    public String getUrl() {
        return "http://localhost:8080/articles/list";
    }

    public String author(int index) {
        return $(".author").get(index).text();
    }

    public String title(int index) {
        return $(".title").get(index).text();
    }

    public String contents(int index) {
        return $(".contents").get(index).text();
    }

    public int row() {
        return $(".row").size();
    }
}
