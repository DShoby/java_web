package com.gl.ecom.rest;

import com.gl.ecom.data.model.*;
import com.gl.ecom.service.ArticleService;
import com.gl.ecom.service.CatalogueService;
import com.sun.deploy.net.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

    @RequestMapping(value = "/addCatalogue", method = RequestMethod.POST)
    public MessageEnum addCatalogue(@RequestParam(value="nameCat") String name) throws Exception{
        return catalogueService.createCatalogue(name);
    }

    @RequestMapping(value = "/addArticle",method = RequestMethod.POST)
    public MessageEnum addArticle(@RequestParam(value="nameArt") String name, @RequestParam(value = "type")TypeEnum typeEnum, @RequestParam(value = "color") ColorEnum colorEnum, @RequestParam(value = "size") String size ) throws Exception {
        return articleService.createArticle(name,typeEnum,colorEnum,size);
    }
}
