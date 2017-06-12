package com.gl.ecom.data.dao.interfaces;

import com.gl.ecom.data.model.Catalogue;
import com.gl.ecom.data.others.MessageEnum;


import java.util.Collection;

public interface CatalogueDao {

    MessageEnum createCatalogue(Catalogue catalogue) throws Exception;
    Catalogue getCatalogue(String label)throws Exception;
    MessageEnum deleteCatalogue(String label)throws Exception;
    MessageEnum updateCatalogue(Catalogue catalogue)throws Exception;
    Collection<Catalogue> getCatalogues()throws Exception;

}
