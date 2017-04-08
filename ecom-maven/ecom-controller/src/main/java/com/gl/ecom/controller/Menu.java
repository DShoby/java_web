package com.gl.ecom.controller;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Scanner;

import static com.gl.ecom.data.model.OptionEnum.printOptions;

@Repository
public class Menu {

    public Scanner scanner = new Scanner(System.in);

    public Menu(){}

    public void getMenu(int type){
        System.out.println("X--------------------------------------------------------------------X");
        if(type == 1){
            System.out.println("Bienvenue ! \n Que souhaitez-vous faire ? (Veuillez saisir le chiffre correspondant) \n");
        }
        else if(type == 2){
            System.out.println("Souhaitez-vous faire autre chose ? ");
        }
        printOptions();
        System.out.println("X--------------------------------------------------------------------X \n");

    }



}
