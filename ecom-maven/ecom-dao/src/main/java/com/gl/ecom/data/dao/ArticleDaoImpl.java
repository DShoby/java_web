package com.gl.ecom.data.dao;

import com.gl.ecom.data.dao.databaseConfig.SpringMongoConfig;
import com.gl.ecom.data.dao.interfaces.ArticleDao;
import com.gl.ecom.data.model.Article;
import com.gl.ecom.data.others.MessageEnum;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public class ArticleDaoImpl implements ArticleDao {

    private ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringMongoConfig.class);
    private MongoOperations request = (MongoOperations) ctx.getBean("mongoTemplate");

    @Override
    public MessageEnum createArticle(Article article) {
        if(article == null){
            return MessageEnum.ERROR_ARTICLE_NULL;
        }
        else{
            request.save(article);
            return MessageEnum.SAVED_ARTICLE;
        }
    }

    @Override
    public Article getArticle(String label) throws Exception {
        return request.findOne(new Query(Criteria.where("label").is(label)),Article.class);
    }

    @Override
    public MessageEnum deleteArticle(String label) throws Exception {
        request.remove(new Query(Criteria.where("label").is(label)),Article.class);
        return MessageEnum.SUPPRESSED_ARTICLE;
    }

    @Override
    public MessageEnum updateArticle(Article article) throws Exception {
        if(article == null){
            return MessageEnum.ERROR_ARTICLE_NULL;
        }
        else{
            Article art =  getArticle(article.getLabel());
            art.setSize(article.getSize());
            art.setColorEnum(article.getColorEnum());
            art.setTypeEnum(article.getTypeEnum());
            request.save(art);
            return MessageEnum.MODIFIED_ARTICLE;
        }
    }

    @Override
    public Collection<Article> getArticles() throws Exception {
        return request.findAll(Article.class);
    }
}
