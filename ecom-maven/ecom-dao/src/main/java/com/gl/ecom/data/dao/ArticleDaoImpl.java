package com.gl.ecom.data.dao;

import com.gl.ecom.data.dao.database.Database;
import com.gl.ecom.data.dao.impl.ArticleDao;
import com.gl.ecom.data.model.Article;
import com.gl.ecom.data.model.MessageEnum;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public class ArticleDaoImpl implements ArticleDao {

    @Override
    public MessageEnum createArticle(Article article) throws Exception {

        if(article == null){
            return MessageEnum.ERROR_ARTICLE_NULL;
        }
        else{
            Database.tableArticle.put(article.getId(), article);
            return MessageEnum.SAVED_ARTICLE;
        }
    }

    @Override
    public Article getArticle(String pk) throws Exception {
        return Database.tableArticle.get(pk);
    }

    @Override
    public MessageEnum deleteArticle(String pk) throws Exception {
        Database.tableArticle.remove(pk);
        return MessageEnum.SUPPRESSED_ARTICLE;
    }

    @Override
    public MessageEnum updateArticle(String pk,Article article) throws Exception {
        if(article == null){
            return MessageEnum.ERROR_ARTICLE_NULL;
        }
        else{
            Database.tableArticle.put(pk,article); // si pk de l'article updated = pk article non updated alors ce put écrase le précédent
            return MessageEnum.MODIFIED_ARTICLE;
        }

    }

    @Override
    public Collection<Article> getArticles() throws Exception {
        return Database.tableArticle.values();
    }
}
