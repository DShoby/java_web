package com.gl.ecom.data.dao.impl;

import com.gl.ecom.data.model.Article;
import com.gl.ecom.data.model.MessageEnum;

import java.util.Collection;

public interface ArticleDao {
    
    MessageEnum createArticle(Article article) throws Exception;
    Article getArticle(String pk) throws Exception;
    MessageEnum deleteArticle(String pk) throws Exception;
    MessageEnum updateArticle(String pk, Article article) throws Exception;
    Collection<Article> getArticles() throws Exception;
}
