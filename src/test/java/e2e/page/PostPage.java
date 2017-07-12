package e2e.page;

import org.fluentlenium.core.FluentPage;

import static org.assertj.core.api.Assertions.assertThat;

public class PostPage extends FluentPage {

    @Override
    public void isAt() {
        assertThat(window().title()).contains("記事投稿");
    }

    @Override
    public String getUrl() {
        return "http://localhost:8080/";
    }

    public PostPage fillAuthor(String author) {
        $("#author").fill().with(author);
        return this;
    }

    public PostPage fillTitle(String title) {
        $("#title").fill().with(title);
        return this;
    }

    public PostPage fillContents(String contents) {
        $("#contents").fill().with(contents);
        return this;
    }

    public void post() {
        $("#post-button").click();
    }
}
