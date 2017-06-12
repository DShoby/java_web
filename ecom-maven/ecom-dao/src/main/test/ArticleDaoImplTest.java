import com.gl.ecom.data.dao.ArticleDaoImpl;
import com.gl.ecom.data.model.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import java.util.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class ArticleDaoImplTest {

    //region vars
    @InjectMocks
    ArticleDaoImpl articleDao;
    Article article;
    Article article_updated;
    Article article_null;
    Article article_gotten;
    //endregion

    @Before
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);
        article = new Article(AutoIncrement.autoId(Article.class),"random", TypeEnum.NONE, ColorEnum.BLEU,"NONE");
        article_updated = new Article(AutoIncrement.autoId(Article.class),"random_updated", TypeEnum.NONE, ColorEnum.NONE,"NONE_UPDATED");
        articleDao.createArticle(article);
        articleDao.createArticle(article_updated);
        article_null = null;

    }

    @After
    public void after() throws Exception{
        Database.tableArticle.clear();
    }

    @Test
    public void createArticle_should_return_created_article_message() throws Exception {
        //Article article = new Article(AutoIncrement.autoId(Article.class),"random", TypeEnum.NONE, ColorEnum.NONE,"NONE");
        MessageEnum message = articleDao.createArticle(article);
        assertSame(MessageEnum.SAVED_ARTICLE,message);
    }
    @Test
    public void createArticle_should_return_null_message() throws Exception {
        //Article article = new Article(AutoIncrement.autoId(Article.class),"random", TypeEnum.NONE, ColorEnum.NONE,"NONE");
        MessageEnum message = articleDao.createArticle(article_null);
        assertSame(MessageEnum.ERROR_ARTICLE_NULL,message);
    }

    @Test
    public void getArticle_should_return_article() throws  Exception{
        article_gotten = articleDao.getArticle(article.getId());
        assertThat(articleDao.getArticle(article.getId()),is(equalTo(article)));
    }

    @Test
    public void update_article_should_return_updated_message() throws Exception {
        // here the article is only having its color modified, so we check if it has been updated.
        MessageEnum messageEnum = articleDao.updateArticle("1", article_updated);
        assertEquals(MessageEnum.MODIFIED_ARTICLE, messageEnum);
    }

    @Test
    public void update_article_should_return_null_message() throws Exception {
        MessageEnum messageEnum = articleDao.updateArticle("1",article_null);
        assertEquals(MessageEnum.ERROR_ARTICLE_NULL,messageEnum);
    }

    @Test
    public void delete_article_should_return_deleted_message() throws Exception{
        MessageEnum messageEnum = articleDao.deleteArticle("1");
        assertEquals(MessageEnum.SUPPRESSED_ARTICLE,messageEnum);
    }


    @Test
    public void getArticles_should_return_same_number_of_catalogues() throws Exception {
        assertEquals(Database.tableArticle.size(),articleDao.getArticles().size());
    }

    @Test
    public void getArticles_should_return_right_collection_of_articles() throws Exception {
        Collection<Article> articles = articleDao.getArticles();
        assertThat(articles,is(equalTo(Database.tableArticle.values())));
    }
}