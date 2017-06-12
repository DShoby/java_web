package com.gl.ecom.data.model;

import com.gl.ecom.data.others.ColorEnum;
import com.gl.ecom.data.others.TypeEnum;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Article extends Moco {

    private String size;

    public Article(){

    }
    public Article(String id, String label, TypeEnum typeEnum, ColorEnum colorEnum, String size) {
        super(id,label, typeEnum, colorEnum);
        this.size = size;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

}