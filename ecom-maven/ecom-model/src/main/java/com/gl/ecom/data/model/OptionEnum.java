package com.gl.ecom.data.model;

public enum OptionEnum {
    ADD_CATALOGUE (1,"Ajouter un catalogue"),
    MODIFY_CATALOGUE (2,"Modifier un catalogue"),
    DEL_CATALOGUE (3,"Supprimer un catalogue"),
    LIST_CATALOGUES (4,"Lister les catalogues"),
    ADD_ARTICLE(5,"Ajouter un article"),
    MODIFY_ARTICLE(6,"Modifier un article"),
    DEL_ARTICLE(7,"Supprimer un article"),
    LINK_ARTICLE(8,"Lier un article à un catalogue"),
    LIST_ARTICLES(9,"Lister les articles de chaque catalogue"),
    LIST_ALL_ARTICLES(10,"Lister tous les articles enregistrés"),
    QUIT (11,"Quitter");

    private String label;
    private int order;

    OptionEnum(int order, String label) {
        this.order = order;
        this.label = label;
    }

    public int getOrder() {
        return order;
    }

    public String getLabel() {
        return label;
    }

    public static void printOptions() {
        int i = 1;
        for (OptionEnum o:OptionEnum.values()){
            System.out.println(i +". "+o.getLabel());
            i++;
        }
    }

    public static OptionEnum getByOrder(int order){
        OptionEnum optionEnum = OptionEnum.QUIT;
        for(OptionEnum option :OptionEnum.values()){
            if(option.getOrder() == order){
                optionEnum = option;
            }
        }
        return optionEnum;
    }
}