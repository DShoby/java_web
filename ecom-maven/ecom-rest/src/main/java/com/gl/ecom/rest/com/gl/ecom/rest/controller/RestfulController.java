package com.gl.ecom.rest.com.gl.ecom.rest.controller;

import com.gl.ecom.data.model.*;
import com.gl.ecom.data.others.MessageEnum;
import com.gl.ecom.service.ArticleService;
import com.gl.ecom.service.CatalogueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;


@RestController
public class RestfulController {

    @Autowired
    private CatalogueService catalogueService;
    @Autowired
    private ArticleService articleService;


    // CATALOGUES
    @RequestMapping(value = "/getAllCatalogues", method =  RequestMethod.GET)
    public Collection<Catalogue> getAllCatalogues() throws Exception {
        return catalogueService.getCatalogues();
    }

    @RequestMapping(value = "/addCatalogue", method = RequestMethod.POST)
    public MessageEnum addCatalogue(@RequestParam(value="nameCat") String name) throws Exception{
        return catalogueService.createCatalogue(name);
    }

    @RequestMapping(value = "/delCatalogue",method = RequestMethod.DELETE)
    public MessageEnum deleteCatalogue(@RequestParam(value = "nameCat")String name) throws Exception {
        return catalogueService.deleteCatalogue(name);
    }

    @RequestMapping(value = "/updateCatalogue",method = RequestMethod.POST)
    public MessageEnum updateCatalogue(@RequestBody Catalogue catalogue) throws Exception {
        return catalogueService.modifyCatalogue(catalogue);
    }

    // ARTICLES
    @RequestMapping(value = "/getAllArticles", method =  RequestMethod.GET)
    public Collection<Article> getAllArticles() throws Exception {
        return articleService.getArticles();
    }

    @RequestMapping(value = "/addArticle",method = RequestMethod.POST)
    public MessageEnum addArticle(@RequestBody Article article ) throws Exception {
        return articleService.createArticle(article);
    }

    @RequestMapping(value = "/updateArticle",method = RequestMethod.POST)
    public MessageEnum updateArticle(@RequestBody Article article ) throws Exception {
        return articleService.updateArticle(article);
    }

    @RequestMapping(value = "/delArticle",method = RequestMethod.DELETE)
    public MessageEnum deleteArticle(@RequestParam(value = "nameArt")String name) throws Exception {
        return articleService.deleteArticle(name);
    }

}
