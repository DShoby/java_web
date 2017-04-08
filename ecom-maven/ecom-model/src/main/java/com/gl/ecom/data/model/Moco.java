package com.gl.ecom.data.model;

public class Moco extends Product implements TechId {

    private ColorEnum colorEnum;


    public Moco(){

    }
    public Moco(String id, String label, TypeEnum typeEnum, ColorEnum colorEnum) {
        super(id, label, typeEnum);
        this.colorEnum = colorEnum;
        generateId(id, colorEnum.getLabel(), "");
    }

    public ColorEnum getColorEnum() {
        return colorEnum;
    }

    public void setColorEnum(ColorEnum color) {
        this.colorEnum = color;
    }

    public String getColor(){
        String str = "" + this.colorEnum;
        return str;
    }

    public String desc(){
        String str = super.desc();
        str += "\nCouleur : " + colorEnum.getLabel();
        return str;
    }

    public String getId(){
       return super.getId();
    }

    @Override
    public void generateId(String id, String color, String size) {
        String str = id + "_" + color;
        this.setTechId(str);
    }

    @Override
    public String toString() {
        return this.getLabel();
    }
}
