package com.gl.ecom.data.dao.database;

import com.gl.ecom.data.model.*;

import java.util.HashMap;
import java.util.Map;

public class Database {

    public static Map<String, Catalogue> tableCatalogue;
    public static Map<String, Article> tableArticle;
    public static Article article = new Article(AutoIncrement.autoId(Article.class),"pull",TypeEnum.PRETAPORTER,ColorEnum.BLANC,"XXL");
    public static Article article2 = new Article(AutoIncrement.autoId(Article.class),"sac",TypeEnum.ACCESSOIRE,ColorEnum.NOIR,"Unique");
    public static Article article3 = new Article(AutoIncrement.autoId(Article.class),"montre",TypeEnum.LUXE,ColorEnum.BLANC,"Unique");
    public static Article article4 = new Article(AutoIncrement.autoId(Article.class),"montre",TypeEnum.LUXE,ColorEnum.BLANC,"Unique");
    public static Article article5 = new Article(AutoIncrement.autoId(Article.class),"montre",TypeEnum.LUXE,ColorEnum.BLANC,"Unique");
    public static Article article6 = new Article(AutoIncrement.autoId(Article.class),"montre",TypeEnum.LUXE,ColorEnum.BLANC,"Unique");
    public static Article article7 = new Article(AutoIncrement.autoId(Article.class),"montre",TypeEnum.LUXE,ColorEnum.BLANC,"Unique");
    public static Article article9 = new Article(AutoIncrement.autoId(Article.class),"montre",TypeEnum.LUXE,ColorEnum.BLANC,"Unique");
    public static Article article10 = new Article(AutoIncrement.autoId(Article.class),"montre",TypeEnum.LUXE,ColorEnum.BLANC,"Unique");
    public static Article article11 = new Article(AutoIncrement.autoId(Article.class),"montre",TypeEnum.LUXE,ColorEnum.BLANC,"Unique");
    public static Article article12 = new Article(AutoIncrement.autoId(Article.class),"montre",TypeEnum.LUXE,ColorEnum.BLANC,"Unique");
    public static Article article13 = new Article(AutoIncrement.autoId(Article.class),"montre",TypeEnum.LUXE,ColorEnum.BLANC,"Unique");
    public static Article article14 = new Article(AutoIncrement.autoId(Article.class),"montre",TypeEnum.LUXE,ColorEnum.BLANC,"Unique");
    public static Catalogue catalogue = new Catalogue("Homme");
    public static Catalogue catalogue2 = new Catalogue("Femme - Accessoires");
    public static Catalogue catalogue3 = new Catalogue("Homme - Accessoires");


static {
    tableArticle = new HashMap<String,Article>();
    tableCatalogue = new HashMap<String,Catalogue>();
    tableArticle.put(article.getId(),article);
    tableArticle.put(article2.getId(),article2);
    tableArticle.put(article3.getId(),article3);
    tableArticle.put(article4.getId(),article3);
    tableArticle.put(article5.getId(),article3);
    tableArticle.put(article6.getId(),article3);
    tableArticle.put(article7.getId(),article3);
    tableArticle.put(article10.getId(),article3);
    tableArticle.put(article9.getId(),article3);
    tableArticle.put(article11.getId(),article3);
    tableArticle.put(article12.getId(),article3);
    tableArticle.put(article13.getId(),article3);
    tableArticle.put(article14.getId(),article3);
    tableCatalogue.put(catalogue.getId(),catalogue);
    tableCatalogue.put(catalogue2.getId(),catalogue2);
    tableCatalogue.put(catalogue3.getId(),catalogue3);

}

}
