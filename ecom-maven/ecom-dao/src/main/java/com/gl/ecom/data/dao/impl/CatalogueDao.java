package com.gl.ecom.data.dao.impl;

import com.gl.ecom.data.model.Article;
import com.gl.ecom.data.model.Catalogue;
import com.gl.ecom.data.model.MessageEnum;


import java.util.Collection;

public interface CatalogueDao {

    MessageEnum createCatalogue(Catalogue catalogue) throws Exception;
    Catalogue getCatalogue(String pk)throws Exception;
    MessageEnum deleteCatalogue(String pk)throws Exception;
    MessageEnum updateCatalogue(String pk, Catalogue catalogue)throws Exception;
    Collection<Catalogue> getCatalogues()throws Exception;

}
