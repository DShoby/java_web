import com.gl.ecom.data.dao.database.Database;
import com.gl.ecom.data.model.Catalogue;
import com.gl.ecom.data.model.MessageEnum;
import com.gl.ecom.service.CatalogueService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class CatalogueServiceTest {

    static final String FILE_INPUT_NAME = "src\\main\\test\\catalogue_updated.txt";
    Scanner scannerTest = new Scanner(new File(FILE_INPUT_NAME));
    @InjectMocks
    CatalogueService catalogueService;

    public CatalogueServiceTest() throws FileNotFoundException {
    }

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        Database.tableCatalogue.put("1",new Catalogue("random"));
    }

    @After
    public void tearDown(){
        Database.tableCatalogue.clear();
    }

    @Test
    public void createCatalogue_should_return_created_message() throws Exception {
//        assertThat(catalogueService.createCatalogue("random2","random2"), is(equalTo(MessageEnum.CATALOGUE_SAVED)));
//        assertThat(Database.tableCatalogue.size(),is(equalTo(2))); // because there are 2 catalogues in the database
    }

    @Test
    public void modifyCatalogue_should_return_modified_message() throws Exception {
        assertEquals("random",Database.tableCatalogue.get("1").getLabel());
//        assertThat(catalogueService.modifyCatalogue(null,null,scannerTest), is(equalTo(MessageEnum.MODIFIED_CATALOGUE)));
        assertThat(Database.tableCatalogue.get("1").getLabel(),is(equalTo("random_updated")));
    }

    @Test
    public void deleteCatalogue_should_return_suppressed_message() throws Exception {
        assertThat(Database.tableCatalogue.size(),is(equalTo(1))); // before suppression
//        assertThat(catalogueService.deleteCatalogue(null,"1"),is(equalTo(MessageEnum.SUPPRESSED_CATALOGUE)));
        assertThat(Database.tableCatalogue.size(),is(equalTo(0))); // after suppression
    }

    @Test
    public void getCatalogues_should_return_catalogues() throws Exception {
//        assertThat(catalogueService.getCatalogues(true).size(), is(equalTo(Database.tableCatalogue.size())));
//        assertThat(catalogueService.getCatalogues(true),is(equalTo(Database.tableCatalogue.values()))); // because there are 2 catalogues in the database
    }


}