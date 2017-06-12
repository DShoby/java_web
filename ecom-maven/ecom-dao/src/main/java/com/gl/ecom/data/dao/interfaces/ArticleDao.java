package com.gl.ecom.data.dao.interfaces;

import com.gl.ecom.data.model.Article;
import com.gl.ecom.data.others.MessageEnum;

import java.util.Collection;

public interface ArticleDao {
    
    MessageEnum createArticle(Article article) throws Exception;
    Article getArticle(String label) throws Exception;
    MessageEnum deleteArticle(String label) throws Exception;
    MessageEnum updateArticle(Article article) throws Exception;
    Collection<Article> getArticles() throws Exception;
}
