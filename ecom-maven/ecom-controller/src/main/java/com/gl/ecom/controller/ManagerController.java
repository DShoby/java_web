package com.gl.ecom.controller;

import com.gl.ecom.data.model.*;
import com.gl.ecom.service.ArticleService;
import com.gl.ecom.service.CatalogueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import java.util.Scanner;
import static com.gl.ecom.data.model.OptionEnum.getByOrder;

@Controller
public class ManagerController {

    //region Variables
    private Scanner sc = new Scanner(System.in);
    private int choice;
    @Autowired
    private Menu menu;
    @Autowired
    private ArticleService articleService;
    @Autowired
    private CatalogueService catalogueService;
    //endregion

    //region Variables de test
    private Scanner scTest;
    private String strTest;
    private boolean testPhase = false;
    //endregion

    public void start() throws Exception {
       /* do{
            menu.getMenu(1);
            while(!sc.hasNextInt()){
                System.out.println("Erreur de saisie, veuillez recommencer.");
                sc.next();
            }
            choice = sc.nextInt();
        }while(choice <= 0 || choice > (OptionEnum.QUIT.getOrder()));
        while(choice != OptionEnum.QUIT.getOrder()) {
            switch (getByOrder(choice)) {

                case ADD_CATALOGUE:
                    System.out.println(catalogueService.createCatalogue(strTest).toString());
                    break;
                case MODIFY_CATALOGUE:
                    System.out.println(catalogueService.modifyCatalogue(scTest).toString());
                    break;
                case DEL_CATALOGUE:
                    System.out.println(catalogueService.deleteCatalogue(strTest).toString());
                    break;
                case LIST_CATALOGUES:
                    catalogueService.listCatalogues(testPhase);
                    break;
                case ADD_ARTICLE:
                    System.out.println(articleService.createArticle(scTest).toString());
                    break;
                case MODIFY_ARTICLE:
                    System.out.println(articleService.modifyArticle(scTest).toString());
                    break;
                case DEL_ARTICLE:
                    System.out.println(articleService.deleteArticle(strTest).toString());
                    break;
                case LINK_ARTICLE:
                    System.out.println(articleService.linkArticle(scTest).toString());
                    break;
                case LIST_ARTICLES:
                    articleService.productsByCatalogue();
                    break;
                case LIST_ALL_ARTICLES:
                    articleService.listAllProducts();
                    break;
            }
            menu.getMenu(2);
            choice = sc.nextInt();
        }
        goodbye();
    }


    private void goodbye(){
        System.out.println("Au revoir !");
    }





*/
}
}
