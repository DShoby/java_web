package com.gl.ecom.data.model;

import com.gl.ecom.data.others.AutoIncrement;
import org.springframework.data.annotation.Id;
import java.util.ArrayList;
import java.util.List;

public class Catalogue {

    //region vars
    @Id
    private String id;
    private String label;
    private List<Product> productList;
    //endregion

    //region constructors
    public Catalogue() {
    }

    public Catalogue(String label) {

        this.id = AutoIncrement.autoId(Catalogue.class);
        this.label = label;
        productList = new ArrayList<>();
    }
    //endregion


    //region getters and setters
    public void addProduct(Product p){
        productList.add(p);
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<Product> getProducts(){
        return productList;
    }

    public void setProducts(List<Product> productList) {
        this.productList = productList;
    }

    public Article getArticle(Article articleGiven){
        Article article;
        if(getProducts().size() == 0){
            article = null;
        }
        else if((getProducts().contains(articleGiven))){
            article = articleGiven;
        }
        else{
            article = null;
        }
        return article;
    }
    //endregion
}