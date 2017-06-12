package com.gl.ecom.data.model;

import com.gl.ecom.data.others.AutoIncrement;
import com.gl.ecom.data.others.TypeEnum;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Product  {

    //region vars
    @Id
    private String id;
    private String label;
    private TypeEnum typeEnum;
   //endregion


    //region Constructors
    public Product(){

    }

    public Product(String id,String label, TypeEnum typeEnum) {
        this.id = AutoIncrement.autoId(Article.class);
        this.label = label;
        this.typeEnum = typeEnum;
    }
    //endregion

    //region Getters And Setters

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public TypeEnum getTypeEnum() {
        return typeEnum;
    }

    public void setTypeEnum(TypeEnum typeEnum) {
        this.typeEnum = typeEnum;
    }




//
//    public String getCreationDate() {
//        return creationDate;
//    }
//
//    public String getLastModificationDate() {
//        return lastModificationDate;
//    }
//    public void setCreationDate(String creationDate) {
//        this.creationDate = creationDate;
//    }
//
//    public void setLastModificationDate(String lastModificationDate) {
//        this.lastModificationDate = lastModificationDate;
//    }


    //endregion


}