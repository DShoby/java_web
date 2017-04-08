package com.gl.ecom.data.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Catalogue {


    //region vars
    private String id;
    private String label;
    private List<Product> productList;
    private String creationDate;
    private String lastModificationDate;
    private SimpleDateFormat formatter = new SimpleDateFormat(" 'Le' dd/MM/yy 'à' H:mm:ss");
    //endregion

    //region constructors
    public Catalogue(String label) {

        this.label = label;
        productList = new ArrayList<>();
        id = AutoIncrement.autoId(Catalogue.class);
        creationDate = formatter.format(new Date());
        lastModificationDate = formatter.format(new Date());
    }

    public Catalogue() {
    }
    //endregion


    //region getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getLastModificationDate() {
        return lastModificationDate;
    }

    public void setLastModificationDate(String lastModificationDate) {
        this.lastModificationDate = lastModificationDate;
    }

    //endregion


    //region other methods
    @Override
    public String toString() {
        return "Catalogue N°" + id + " : " + label;
    }
    //endregion


}