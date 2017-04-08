package com.gl.ecom.data.model;

public class Article extends Moco implements TechId {

    private String size;

    public Article(){

    }

    public Article(String id, String label, TypeEnum typeEnum, ColorEnum colorEnum) {
        super(id, label, typeEnum, colorEnum);
        this.size = "Taille unique";
        generateId(id, colorEnum.getLabel(), "TU");
    }

    public Article(String id, String label, TypeEnum typeEnum, ColorEnum colorEnum, String size) {
        super(id, label, typeEnum, colorEnum);
        this.size = size;
        generateId(id, colorEnum.getLabel(), size);
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String desc(){
        String str = super.desc();
        str += "\nTaille : " + size + "\n----------------------------\n";
        return str;
    }

    @Override
    public void generateId(String id, String color, String size) {
        String str = id + "_" + color + "_" + size;
        this.setTechId(str);
    }
}