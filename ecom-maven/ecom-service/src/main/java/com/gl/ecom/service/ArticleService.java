package com.gl.ecom.service;

import com.gl.ecom.data.dao.ArticleDaoImpl;
import com.gl.ecom.data.dao.CatalogueDaoImpl;
import com.gl.ecom.data.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import static com.gl.ecom.data.model.ColorEnum.checkColorEnum;
import static com.gl.ecom.data.model.ColorEnum.printColors;
import static com.gl.ecom.data.model.TypeEnum.checkTypeEnum;
import static com.gl.ecom.data.model.TypeEnum.printTypes;

@Service
public class ArticleService {

    //region Variables
    private static Scanner sc = new Scanner(System.in);
    SimpleDateFormat formatter = new SimpleDateFormat(" 'Le' dd/MM/yy 'à' H:mm:ss");
    @Autowired
    private CatalogueDaoImpl catalogueDao;
    @Autowired
    private ArticleDaoImpl articleDao;
    //endregion

    public MessageEnum createArticle(String label, TypeEnum typeEnum, ColorEnum colorEnum, String size) throws  Exception{
        return articleDao.createArticle(new Article(AutoIncrement.autoId(Article.class),label,typeEnum,colorEnum,size));
    }

    public MessageEnum modifyArticle(String pk, String label, TypeEnum typeEnum, ColorEnum colorEnum, String size,Scanner scTest) throws Exception {
        //region vars
        String primaryKey;
        Article modArticle;
        MessageEnum messageEnum;
        //endregion
        primaryKey = pk;
            if(articleDao.getArticle(primaryKey) == null){
                messageEnum = MessageEnum.INPUT_ERROR_ARTICLE_INEXISTANT;
            }
            else{
                modArticle = articleDao.getArticle(primaryKey);
                modArticle.setLabel(label);
                modArticle.setTypeEnum(typeEnum);
                modArticle.setColorEnum(colorEnum);
                modArticle.setSize(size);
                modArticle.setLastModificationDate(formatter.format(new Date()));
                modArticle.generateId(modArticle.getId(),modArticle.getColorEnum().getLabel(),modArticle.getSize());
                articleDao.updateArticle(primaryKey,modArticle);
                messageEnum = MessageEnum.MODIFIED_ARTICLE;
            }
        return messageEnum;
    }

    public MessageEnum deleteArticle(String pk,boolean catalogueOnly) throws Exception {
        MessageEnum messageEnum;

            if(articleDao.getArticle(pk) == null){
                messageEnum = MessageEnum.INPUT_ERROR_ARTICLE_INEXISTANT;
            }
            else if(catalogueOnly) {
                deleteArticleFromAllCatalogues(pk);
                messageEnum =  MessageEnum.SUPPRESSED_ARTICLE;
            }
            else{
                deleteArticleFromAllCatalogues(pk);
                articleDao.deleteArticle(pk);
                messageEnum =  MessageEnum.SUPPRESSED_ARTICLE;
            }

        return messageEnum;
    }

    public MessageEnum linkArticle(String idArt, String idCat) throws Exception {
        String primaryKeyArticle;
        Article linkArticle;
        String primaryKeyCatalogue;
        Catalogue linkCatalogue;
        MessageEnum messageEnum;

            primaryKeyArticle = idArt;
            primaryKeyCatalogue = idCat;
            //to helper (service package)
            if(articleDao.getArticle(primaryKeyArticle) == null){
                messageEnum = MessageEnum.INPUT_ERROR_ARTICLE_INEXISTANT;
            }
            else if(catalogueDao.getCatalogue(primaryKeyCatalogue) == null){
                messageEnum = MessageEnum.INPUT_ERROR_CATALOGUE_INEXISTANT;
            }
            else if(catalogueDao.getCatalogue(primaryKeyCatalogue).getProducts().contains(articleDao.getArticle(primaryKeyArticle))){
                messageEnum = MessageEnum.ARTICLE_ALREADY_PRESENT;
            }
            //to helper
            else{
                linkArticle = articleDao.getArticle(primaryKeyArticle);
                linkCatalogue = catalogueDao.getCatalogue(primaryKeyCatalogue);
                linkCatalogue.addProduct(linkArticle);
                catalogueDao.updateCatalogue(primaryKeyCatalogue,linkCatalogue);
                messageEnum = MessageEnum.LINK_MADE;
            }

        return messageEnum;
    }


    public Collection<Article> getArticles() throws Exception {
        return articleDao.getArticles();
    }

    public Article getArticleById(String id) throws Exception {
        return articleDao.getArticle(id);
    }

    private void deleteArticleFromAllCatalogues(String articleId) throws Exception {
        if(catalogueDao != null){
            for(Catalogue catalogue : catalogueDao.getCatalogues()){
                if(catalogue.getArticle(articleDao.getArticle(articleId)) != null){
                    catalogue.getProducts().remove(articleDao.getArticle(articleId));
                }
            }
        }
    }

}