package com.gl.ecom.service;

import com.gl.ecom.data.dao.ArticleDaoImpl;
import com.gl.ecom.data.dao.CatalogueDaoImpl;
import com.gl.ecom.data.model.*;
import com.gl.ecom.data.others.MessageEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Collection;

@Service
public class ArticleService {

    //region Variables
    SimpleDateFormat formatter = new SimpleDateFormat(" 'Le' dd/MM/yy 'à' H:mm:ss");
    @Autowired
    private CatalogueDaoImpl catalogueDao;
    @Autowired
    private ArticleDaoImpl articleDao;
    //endregion

    public MessageEnum createArticle(Article article) throws  Exception{
        return articleDao.createArticle(article);
    }

    public MessageEnum updateArticle(Article article) throws Exception {
        //region vars
        Article modArticle;
        MessageEnum messageEnum;
        //endregion

            if(articleDao.getArticle(article.getLabel()) == null){
                messageEnum = MessageEnum.INPUT_ERROR_ARTICLE_INEXISTANT;
            }
            else{
                articleDao.updateArticle(article);
                messageEnum = MessageEnum.MODIFIED_ARTICLE;
            }
        return messageEnum;
    }

    public MessageEnum deleteArticle(String pk) throws Exception {
        MessageEnum messageEnum;

            if(articleDao.getArticle(pk) == null){
                messageEnum = MessageEnum.INPUT_ERROR_ARTICLE_INEXISTANT;
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
                //catalogueDao.updateCatalogue(primaryKeyCatalogue,linkCatalogue);
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