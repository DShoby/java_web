package com.gl.ecom.data.others;

public enum  MessageEnum {
    // General
    LINK_MADE("Lien effectué !","alert-success"),
    // Article
    SAVED_ARTICLE("L'article est enregistré.","alert-success"),
    MODIFIED_ARTICLE("Votre article a bien été modifié !","alert-success"),
    NO_ARTICLE_SAVED("Il n'y a aucun article enregistré.","alert-danger"),
    SUPPRESSED_ARTICLE("Article supprimé !","alert-success"),
    ARTICLE_ALREADY_PRESENT("Cet article est déjà présent dans ce catalogue.","alert-danger"),
    // Catalogue
    NO_CATALOGUE("Il n'y a aucun catalogue.","alert-danger"),
    HAS_NO_ARTICLE("Ce catalogue ne contient aucun article.","alert-danger"),
    CATALOGUE_SAVED("Le catalogue a bien été créé.","alert-success"),
    MODIFIED_CATALOGUE("Votre catalogue a bien été modifié !","alert-success"),
    SUPPRESSED_CATALOGUE("Catalogue supprimé !","alert-success"),
    //Error
    INPUT_ERROR_ARTICLE_INEXISTANT("Erreur, cet article n'existe pas.","alert-danger"),
    INPUT_ERROR_CATALOGUE_INEXISTANT("Erreur, ce catalogue n'existe pas.","alert-danger"),
    ERROR_ARTICLE_NULL("Erreur, l'article est de valeur nulle.","alert-danger"),
    ERROR_CATALOGUE_NULL("Erreur, le catalogue est de valeur nulle.","alert-danger");

    private String message;
    private String alertType; // classe CSS-Bootstrap indiquant le type d'alert.

    MessageEnum(String message,String alertType) {
        this.message = message;
        this.alertType = alertType;
    }

    public String getAlertType() {
        return alertType;
    }

    @Override
    public String toString() {
        return message;
    }
}