package com.gl.ecom.data.model;

public enum TypeEnum {
    LUXE (1,"Luxe"),
    BEAUTE (2,"Beauté"),
    PRETAPORTER (3,"Prêt à porter"),
    ACCESSOIRE (4,"Accessoire"),
    NONE (5,"Non défini");

    private String label;
    private int order;

    TypeEnum(int order,String label) {
        this.order = order;
        this.label = label;
    }

    public int getOrder() {
        return order;
    }

    public String getLabel() {
        return label;
    }

    public static TypeEnum checkTypeEnum(int number){
        TypeEnum typeEnum = TypeEnum.NONE;
        for(TypeEnum typeE : TypeEnum.values()){
            if(typeE.getOrder() == (number)){
               typeEnum = typeE;
            }
        }
        return typeEnum;
    }

    public static void printTypes() {
        for (TypeEnum t:TypeEnum.values()){
            System.out.println(t.getOrder() +". "+t.getLabel());
        }
    }
}