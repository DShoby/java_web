package com.gl.ecom.data.others;

import com.gl.ecom.data.model.Article;
import com.gl.ecom.data.model.Catalogue;

import java.util.concurrent.atomic.AtomicInteger;

public abstract class AutoIncrement {

    private static AtomicInteger aiArticle = new AtomicInteger(0);
    private static AtomicInteger aiCatalogue = new AtomicInteger(0);
    private static int idArticle;
    private static int idCatalogue;

    // génère un id auto, en fonction de la classe
    public static String autoId(Class classe) {
        String str = "";
        if (classe.getName().equals(Article.class.getName())) {
            idArticle = aiArticle.incrementAndGet();
            str = "" + idArticle + "";
        } else if (classe.getName().equals(Catalogue.class.getName())) {
            idCatalogue = aiCatalogue.incrementAndGet();
            str = "" + idCatalogue + "";
        }
        return str;
    }
}