package com.gl.ecom.data.others;

public enum ColorEnum {
    ROUGE (1,"Rouge"),
    VERT (2,"Vert"),
    BLEU (3,"Bleu"),
    NOIR (4,"Noir"),
    BLANC (5,"Blanc"),
    ORANGE (6,"Orange"),
    OR (7,"Or"),
    NONE (8,"N/A");

    private String label;
    private int order;

    ColorEnum(int order,String label) {
        this.order = order;
        this.label = label;
    }

    public int getOrder() {
        return order;
    }

    public String getLabel() {
        return label;
    }

    public static ColorEnum checkColorEnum(int number){
        ColorEnum colorEnum = ColorEnum.NONE;
        for(ColorEnum color : ColorEnum.values() ){
            if(color.getOrder() == (number)){
                colorEnum = color;
            }
        }
        return colorEnum;
    }

    public static void printColors() {
        for (ColorEnum colorEnum :ColorEnum.values()){
            System.out.println(colorEnum.getOrder() +". "+colorEnum.getLabel());
        }
    }
}