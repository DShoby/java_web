package com.gl.ecom.data.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Product implements TechId  {

    //region vars
    private String id;
    private String label;
    private TypeEnum typeEnum;
    private String techId;
    private String creationDate;
    private String lastModificationDate;
    private SimpleDateFormat formatter;
    private Date date;
    //private List<String> images;
   //endregion


    //region Constructors
    public Product(){

    }

    public Product(String id, String label, TypeEnum typeEnum) {
        formatter = new SimpleDateFormat(" 'Le' dd/MM/yy 'à' H:mm:ss");
        date = new Date();
        this.id = id;
        this.label = label;
        this.typeEnum = typeEnum;
        this.creationDate = formatter.format(date);
        this.lastModificationDate = formatter.format(date);
        //this.images = new ArrayList<>();
        generateId(id, "", ""); // generates techId
    }
    //endregion

    //region Getters And Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public String getTechId() {
        return techId;
    }

    public void setTechId(String techId) {
        this.techId = techId;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public String getLastModificationDate() {
        return lastModificationDate;
    }


//    public List<String> getImages() {
//        return images;
//    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public void setLastModificationDate(String lastModificationDate) {
        this.lastModificationDate = lastModificationDate;
    }

//    public void setImages(List<String> images) {
//        this.images = images;
//    }

    //endregion

    //region Other methods
    public String desc(){
        String str = "\n Article n° : " + id + "\n----------------------------\n";
        str += "Référence : "+ techId + "\nLibellé : " + label + "\nType : " + typeEnum.getLabel();
        return str;
    }

    @Override
    public void generateId(String id, String color, String size) {
        String str = id;
        this.setTechId(str);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", label='" + label + '\'' +
                ", typeEnum=" + typeEnum.getLabel() +
                '}';
    }
    //endregion
}