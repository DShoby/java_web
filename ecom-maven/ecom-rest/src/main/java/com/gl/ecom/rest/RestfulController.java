package com.gl.ecom.rest;

import com.gl.ecom.data.model.Article;
import com.gl.ecom.data.model.Catalogue;
import com.gl.ecom.service.ArticleService;
import com.gl.ecom.service.CatalogueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;


@RestController
public class RestfulController {

    @Autowired
    private CatalogueService catalogueService;
    @Autowired
    private ArticleService articleService;


    @RequestMapping(value = "/getAllCatalogues", method =  RequestMethod.GET)
    public Collection<Catalogue> getAllCatalogues() throws Exception {
        return catalogueService.getCatalogues();
    }

    @RequestMapping(value = "/getAllArticles", method =  RequestMethod.GET)
    public Collection<Article> getAllArticles() throws Exception {
        return articleService.getArticles();
    }
}
