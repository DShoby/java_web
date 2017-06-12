import com.gl.ecom.data.dao.CatalogueDaoImpl;
import com.gl.ecom.data.model.Catalogue;
import com.gl.ecom.data.model.MessageEnum;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class CatalogueDaoImplTest {

    //region vars
    @InjectMocks
    CatalogueDaoImpl catalogueDao;
    @Mock
    Catalogue men;
    @Mock
    Catalogue catalogue_null;
    @Mock
    Catalogue men_updated;
    //endregion

    @Before
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);
        men = new Catalogue("Homme");
        men_updated = new Catalogue("Homme - Accessoires");
        catalogueDao.createCatalogue(men);
        catalogue_null = null;
    }

    @After
    public void tearDown() throws Exception {
        catalogueDao.deleteCatalogue(men.getId());
    }

    @Test
    public void createCatalogue_should_return_created_message() throws Exception {
        assertEquals(MessageEnum.CATALOGUE_SAVED,catalogueDao.createCatalogue(men));
    }

    @Test
    public void createCatalogue_should_return_null_message() throws Exception {
        assertEquals(MessageEnum.ERROR_CATALOGUE_NULL,catalogueDao.createCatalogue(catalogue_null));
    }

    @Test
    public void getCatalogue_should_return_catalogue() throws Exception {
        assertThat(men,is(equalTo(catalogueDao.getCatalogue(men.getId()))));
    }

    @Test
    public void getCatalogues_should_return_same_number_of_catalogues() throws Exception {
        assertEquals(Database.tableCatalogue.size(),catalogueDao.getCatalogues().size());
    }

    @Test
    public void getCatalogues_should_return_right_collection_of_catalogues() throws Exception{
        assertThat(catalogueDao.getCatalogues(), is(equalTo(Database.tableCatalogue.values())));
    }

    @Test
    public void update_catalogue_should_return_updated_message() throws Exception {
        assertEquals(MessageEnum.MODIFIED_CATALOGUE, catalogueDao.updateCatalogue("1",men_updated));
    }

    @Test
    public void update_catalogue_should_return_null_message() throws Exception {
        assertEquals(MessageEnum.ERROR_CATALOGUE_NULL, catalogueDao.updateCatalogue("1",catalogue_null));
    }

    @Test
    public void delete_catalogue_should_return_deleted_message() throws Exception{
        assertEquals(MessageEnum.SUPPRESSED_CATALOGUE,catalogueDao.deleteCatalogue("1"));
    }

}