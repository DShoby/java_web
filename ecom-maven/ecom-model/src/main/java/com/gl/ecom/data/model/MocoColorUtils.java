package com.gl.ecom.data.model;

import java.util.ArrayList;

public final class MocoColorUtils {

    public static ArrayList<Product> order (Catalogue catalogue, ColorEnum colorEnum){
        ArrayList<Product> productArrayList = new ArrayList<>();
        System.out.println(" Produits de couleur "+colorEnum.getLabel());
        System.out.println("\t Catalogue "+ catalogue.getLabel());
        for (Product p : catalogue.getProducts()){
            if(p instanceof Moco || p instanceof Article){
                if(p.desc().contains(colorEnum.getLabel())){
                    productArrayList.add(p);
                }
            }
        }
        return productArrayList;
    }
}