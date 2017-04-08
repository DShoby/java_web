package com.gl.ecom.service;

import com.gl.ecom.data.dao.CatalogueDaoImpl;
import com.gl.ecom.data.model.Article;
import com.gl.ecom.data.model.Catalogue;
import com.gl.ecom.data.model.MessageEnum;
import com.gl.ecom.data.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Scanner;

@Service
public class CatalogueService {

    //region Variables
    private SimpleDateFormat formatter = new SimpleDateFormat(" 'Le' dd/MM/yy 'à' H:mm:ss");
    @Autowired
    private CatalogueDaoImpl catalogueDao;
    //endregion

    public Collection<Catalogue> getCatalogues() throws Exception {
        return catalogueDao.getCatalogues();
    }

    public MessageEnum createCatalogue(String label) throws Exception {
        catalogueDao.createCatalogue(new Catalogue(label));
        return MessageEnum.CATALOGUE_SAVED;
    }

    public MessageEnum modifyCatalogue(String pk,String label) throws Exception {
        String primaryKey,name;
        MessageEnum messageEnum;
        primaryKey = pk;
        if(catalogueDao.getCatalogue(primaryKey) == null){ // si catalogue inexistant
            messageEnum =  MessageEnum.INPUT_ERROR_CATALOGUE_INEXISTANT;
        }
        else{ // si modifié avec succès
            name = label;
            Catalogue modCatalogue = catalogueDao.getCatalogue(primaryKey);
            modCatalogue.setLabel(name);
            modCatalogue.setLastModificationDate(formatter.format(new Date()));
            catalogueDao.updateCatalogue(primaryKey,modCatalogue);
            messageEnum =  MessageEnum.MODIFIED_CATALOGUE;
        }
        return messageEnum;

    }

    public MessageEnum deleteCatalogue(String pk) throws Exception {
        String primaryKey;
        MessageEnum msgEnum;

            primaryKey = pk;
            if(catalogueDao.getCatalogue(primaryKey) == null){
                msgEnum = MessageEnum.INPUT_ERROR_CATALOGUE_INEXISTANT;

            }
            else{
                catalogueDao.deleteCatalogue(primaryKey);
                msgEnum = MessageEnum.SUPPRESSED_CATALOGUE;
            }

        return msgEnum;
    }

    public Catalogue getCatalogueById(String id) throws Exception {
        return catalogueDao.getCatalogue(id);
    }

    public Collection<Product> getArticlesFromCatalogueId(String id) throws Exception {
        return catalogueDao.getCatalogue(id).getProducts();
    }



}
