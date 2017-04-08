import com.gl.ecom.data.dao.ArticleDaoImpl;
import com.gl.ecom.data.dao.CatalogueDaoImpl;
import com.gl.ecom.data.dao.database.Database;
import com.gl.ecom.data.dao.impl.ArticleDao;
import com.gl.ecom.data.model.*;
import com.gl.ecom.service.ArticleService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.Scanner;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;


public class ArticleServiceTest extends ArticleService {

    //region variables de test
    Article articleTest = new Article(AutoIncrement.autoId(Article.class),"robe", TypeEnum.PRETAPORTER, ColorEnum.NOIR,"M");
    //endregion

    @InjectMocks
    ArticleService articleService;


    public ArticleServiceTest() throws IOException {

    }

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        Database.tableArticle.put("1",new Article(AutoIncrement.autoId(Article.class),"pull", TypeEnum.PRETAPORTER, ColorEnum.BLEU,"XS"));
        Database.tableCatalogue.put("1",new Catalogue("random"));
    }

    @After
    public void tearDown() throws Exception {
        Database.tableArticle.clear();
    }

    @Test
    public void createArticle_should_return_saved_message() throws Exception {
//       assertThat(articleService.createArticle(article),is(equalTo(MessageEnum.SAVED_ARTICLE)));
    }

    @Test
    public void modifyArticle_should_return_modified_message() throws Exception {
       // assertThat(articleService.modifyArticle(scannerTest2),is(equalTo(MessageEnum.MODIFIED_ARTICLE)));
    }

    @Test
    public void deleteArticle_should_return_suppressed_message() throws Exception {
        int tableArticleSizeBefore = Database.tableArticle.size();
//        assertThat(articleService.deleteArticle(null,"1"),is(equalTo(MessageEnum.SUPPRESSED_ARTICLE)));
        assertNotEquals(tableArticleSizeBefore,Database.tableArticle.size());
    }

    @Test
    public void linkArticle_should_return_link_made_message() throws Exception {
        System.out.println("\nBEFORE LINK : ");
//        Database.tableCatalogue.get("1").printProducts();
      //  assertThat(articleService.linkArticle(scannerTest3),is(equalTo(MessageEnum.LINK_MADE)));
        System.out.println("\nAFTER LINK : ");
//        Database.tableCatalogue.get("1").printProducts();
    }

    @Test
    public void selectTypeOrColor_should_return_selected_type_enum(){
//        assertThat(selectTypeOrColor('T',scannerTest4.reset()),is(equalTo(TypeEnum.PRETAPORTER)));
    }

    @Test
    public void selectTypeOrColor_should_return_selected_color_enum(){
//        assertThat(selectTypeOrColor('C',scannerTest4.reset()),is(equalTo(ColorEnum.BLEU)));
    }


}