package com.gl.ecom.data.dao;

import com.gl.ecom.data.dao.databaseConfig.SpringMongoConfig;
import com.gl.ecom.data.dao.interfaces.CatalogueDao;
import com.gl.ecom.data.model.Catalogue;
import com.gl.ecom.data.others.MessageEnum;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public class CatalogueDaoImpl implements CatalogueDao {

    private ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringMongoConfig.class);
    private MongoOperations request = (MongoOperations) ctx.getBean("mongoTemplate");

    @Override
    public MessageEnum createCatalogue(Catalogue catalogue) throws Exception {
        if(catalogue == null){
            return  MessageEnum.ERROR_CATALOGUE_NULL;
        }
        else{
           request.save(catalogue);
            return MessageEnum.CATALOGUE_SAVED;
        }
    }

    @Override
    public Catalogue getCatalogue(String label) throws Exception {
        return request.findOne(new Query(Criteria.where("label").is(label)),Catalogue.class);
    }

    @Override
    public MessageEnum deleteCatalogue(String label) throws Exception {
        request.remove(new Query(Criteria.where("label").is(label)),Catalogue.class);
        return MessageEnum.SUPPRESSED_CATALOGUE;
    }

    @Override
    public MessageEnum updateCatalogue(Catalogue catalogue) throws Exception {
        if(catalogue == null){
            return MessageEnum.ERROR_CATALOGUE_NULL;
        }
        else{
            Catalogue cat =  getCatalogue(catalogue.getLabel());
            cat.setProducts(catalogue.getProducts());
            request.save(cat);
            return MessageEnum.MODIFIED_CATALOGUE;
        }
    }

    @Override
    public Collection<Catalogue> getCatalogues() throws Exception {
        return request.findAll(Catalogue.class);
    }


}
