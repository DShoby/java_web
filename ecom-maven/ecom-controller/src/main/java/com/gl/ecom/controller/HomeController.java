package com.gl.ecom.controller;

import com.gl.ecom.data.model.*;
import com.gl.ecom.service.ArticleService;
import com.gl.ecom.service.CatalogueService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Collection;


@Controller
public class HomeController {

    private final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    private CatalogueService catalogueService;
    @Autowired
    private ArticleService articleService;

    @RequestMapping(value="/home")
    public String home(ModelMap modelMap) throws Exception {
        modelMap.addAttribute("sizeArticles",articleService.getArticles().size());
        modelMap.addAttribute("sizeCatalogues",catalogueService.getCatalogues().size());
        return "home";
    }

    // Ajout d'un catalogue
    @RequestMapping(value = "/addCatalogue", method = RequestMethod.GET)
    public ModelAndView addCatalogue() {
        return new ModelAndView("addCatalogue", "command", new Catalogue());
    }

    @RequestMapping(value="/resultForm",method = RequestMethod.POST)
    public String resultForm(@ModelAttribute("SpringWeb")Catalogue catalogue, RedirectAttributes redir) throws Exception {
        MessageEnum messageEnum = catalogueService.createCatalogue(catalogue.getLabel());
        redir.addFlashAttribute("resultMessage", messageEnum);
        redir.addFlashAttribute("label",catalogue.getLabel());
        return "redirect:/home";
    }

    // Affichage des catalogues
    @RequestMapping(value ="/showCatalogues")
    public String showCatalogues(ModelMap model) throws Exception {
        Collection<Catalogue> catalogues = catalogueService.getCatalogues();
        model.addAttribute("listeCatalogues",catalogues);
        return "showCatalogues";

    }


    //Modification des catalogues
    @RequestMapping(value = "/updateCatalogue/{id}", method = RequestMethod.GET)
    public String showUpdateCatForm(@PathVariable("id") String id, Model model) throws Exception {
        Catalogue catalogue = catalogueService.getCatalogueById(id);
        model.addAttribute("catalogueToUpdate", catalogue);
        return "updateCatalogue";

    }

    @RequestMapping(value = "/updateCatalogue/{id}/result", method = RequestMethod.POST)
    public String resultUpdateCatalogue(@PathVariable("id") String id, @ModelAttribute("label") String labelUpdated, RedirectAttributes redir) throws Exception {
        MessageEnum messageEnum = catalogueService.modifyCatalogue(id,labelUpdated);
        redir.addFlashAttribute("resultMessage", messageEnum);
        redir.addFlashAttribute("label",labelUpdated);
        return "redirect:/home";
    }

    //Suppression des catalogues
    @RequestMapping(value = "/deleteCatalogue/{id}", method = RequestMethod.GET)
    public String deleteCatalogue(@PathVariable("id") String id, RedirectAttributes redir) throws Exception {
        String label = catalogueService.getCatalogueById(id).getLabel();
        MessageEnum msgEnum = catalogueService.deleteCatalogue(id);
        redir.addFlashAttribute("resultMessage",msgEnum);
        redir.addFlashAttribute("label",label);
        return "redirect:/home";

    }

    //Ajout d'un article
    @RequestMapping(value = "/addArticle", method = RequestMethod.GET)
    public ModelAndView addArticle(Model model) {
        model.addAttribute("typeEnums", TypeEnum.values());
        model.addAttribute("colorEnums", ColorEnum.values());
        return new ModelAndView("addArticle", "command", new Article());
    }

    @RequestMapping(value="/resultArticleForm",method = RequestMethod.POST)
    public String resultArticleForm(@ModelAttribute("article") Article article, RedirectAttributes redir) throws Exception {
        MessageEnum messageEnum = articleService.createArticle(article.getLabel(),article.getTypeEnum(),article.getColorEnum(),article.getSize());
        redir.addFlashAttribute("resultMessage", messageEnum);
        redir.addFlashAttribute("label",article.getLabel());
        return "redirect:/home";
    }

    // Affichage des articles
    @RequestMapping(value ="/showArticles")
    public String showArticles(ModelMap model) throws Exception {
        Collection<Article> articles = articleService.getArticles();
        model.addAttribute("listeArticles",articles);
        return "showArticles";

    }

    //Affichage des articles d'un catalogue spécifique
    @RequestMapping(value = "/showArticles/{id}")
    public String showArticlesFromCatalogue(@PathVariable("id") String id, Model model) throws Exception {
        Collection<Product> articles = catalogueService.getArticlesFromCatalogueId(id);
        model.addAttribute("listeArticles",articles);
        model.addAttribute("articlesFromCat",true);
    return "showArticles";
    }

    //Suppression des articles
    @RequestMapping(value = "/deleteArticle/{id}", method = RequestMethod.GET)
    public String deleteArticle(@PathVariable("id") String id, RedirectAttributes redir) throws Exception {
        String label = articleService.getArticleById(id).getLabel();
        MessageEnum msgEnum = articleService.deleteArticle(id,false);
        redir.addFlashAttribute("resultMessage",msgEnum);
        redir.addFlashAttribute("label",label);
        return "redirect:/home";

    }

    @RequestMapping(value = "/deleteArticle/catalogue/{id}", method = RequestMethod.GET)
    public String deleteArticleFromCatalogue(@PathVariable("id") String id, RedirectAttributes redir) throws Exception {
        String label = articleService.getArticleById(id).getLabel();
        MessageEnum msgEnum = articleService.deleteArticle(id,true);
        redir.addFlashAttribute("resultMessage",msgEnum);
        redir.addFlashAttribute("label",label);
        return "redirect:/home";

    }

    //Modification des articles
    @RequestMapping(value = "/updateArticle/{id}", method = RequestMethod.GET)
    public String showUpdateArticleForm(@PathVariable("id") String id, Model model) throws Exception {
        Article article = articleService.getArticleById(id);
        model.addAttribute("articleToUpdate", article);
        model.addAttribute("typeEnums", TypeEnum.values());
        model.addAttribute("colorEnums", ColorEnum.values());
        return "updateArticle";
    }

    @RequestMapping(value = "/updateArticle/{id}/result", method = RequestMethod.POST)
    public String resultUpdateArticle(@PathVariable("id") String id, @ModelAttribute("label") String label, @ModelAttribute("type") TypeEnum type, @ModelAttribute("color") ColorEnum color, @ModelAttribute("size") String size, RedirectAttributes redir) throws Exception {
        MessageEnum messageEnum = articleService.modifyArticle(id,label,type,color,size,null);
        redir.addFlashAttribute("resultMessage", messageEnum);
        redir.addFlashAttribute("label",label);
        return "redirect:/home";
    }

    //Lier un article à un catalogue
    @RequestMapping(value = "/linkArticle/{id}", method = RequestMethod.GET)
    public String linkArticle(@PathVariable("id") String id, RedirectAttributes redir) throws Exception {
        redir.addFlashAttribute("idArticle", id);
        redir.addFlashAttribute("hideLink",false);
        return "redirect:/showCatalogues";
    }

    // Affichage des articles
    @RequestMapping(value ="/showArticles/linkArticle/{idCat}")
    public String showArticles(@PathVariable("idCat") String idCat,RedirectAttributes redir) throws Exception {
        redir.addFlashAttribute("catalogueId",idCat);
        redir.addFlashAttribute("addingPhase",true);
        return "redirect:/showArticles";

    }


    @RequestMapping(value = "/linkArticleToCat/{idCat}/{idArt}", method = RequestMethod.GET)
    public String resultLinkArticle(@PathVariable("idCat") String idCat, @PathVariable("idArt") String idArt,  RedirectAttributes redir) throws Exception {
        MessageEnum messageEnum = articleService.linkArticle(idArt,idCat);
        redir.addFlashAttribute("catalogueId",idCat);
        redir.addFlashAttribute("addingPhase",true);
        redir.addFlashAttribute("resultMessage", messageEnum);
        return "redirect:/showArticles";
    }




}
