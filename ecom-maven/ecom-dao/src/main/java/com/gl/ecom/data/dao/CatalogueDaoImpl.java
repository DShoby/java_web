package com.gl.ecom.data.dao;

import com.gl.ecom.data.dao.database.Database;
import com.gl.ecom.data.dao.impl.CatalogueDao;
import com.gl.ecom.data.model.Article;
import com.gl.ecom.data.model.Catalogue;
import com.gl.ecom.data.model.MessageEnum;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public class CatalogueDaoImpl implements CatalogueDao {
    @Override
    public MessageEnum createCatalogue(Catalogue catalogue) throws Exception {
        if(catalogue == null){
            return  MessageEnum.ERROR_CATALOGUE_NULL;
        }
        else{
            Database.tableCatalogue.put(catalogue.getId(),catalogue);
            return MessageEnum.CATALOGUE_SAVED;
        }
    }

    @Override
    public Catalogue getCatalogue(String pk) throws Exception {
        return Database.tableCatalogue.get(pk);
    }

    @Override
    public MessageEnum deleteCatalogue(String pk) throws Exception {
        Database.tableCatalogue.remove(pk);
        return MessageEnum.SUPPRESSED_CATALOGUE;
    }

    @Override
    public MessageEnum updateCatalogue(String pk, Catalogue catalogue) throws Exception {
        if(catalogue == null){
            return MessageEnum.ERROR_CATALOGUE_NULL;
        }
        else{
            Database.tableCatalogue.put(pk,catalogue);
            return MessageEnum.MODIFIED_CATALOGUE;
        }
    }

    @Override
    public Collection<Catalogue> getCatalogues() throws Exception {
        return Database.tableCatalogue.values();
    }


}
