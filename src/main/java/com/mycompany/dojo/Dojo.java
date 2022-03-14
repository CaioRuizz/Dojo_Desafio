/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dojo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 *
 * @author ITX
 */
public class Dojo {

    public static String removeEspacos(String texto, String[] elementos) {
        for (String elemento : elementos) {
            texto = texto.replaceAll(" " + elemento, elemento);
            texto = texto.replaceAll(elemento + " ", elemento);
        }
        return texto;
    }

    public static void main(String[] args) throws Exception {
        String texto = "";

        boolean dentroDeAspas = false;

        String textoFinal = "";

        FileReader reader = new FileReader("Dojo.txt");
        String auxiliar = null;
        BufferedReader linha = new BufferedReader(reader);
        while ((auxiliar = linha.readLine()) != null) {
            auxiliar = auxiliar.replaceAll("	", "");
            auxiliar = auxiliar.replaceAll("//.*", "");

            if (auxiliar.trim().isBlank()) {
                continue;
            }
            if (auxiliar.trim().startsWith("/*") || auxiliar.trim().startsWith("*")) {
                continue;
            }
            texto += auxiliar;
        }
        /*
        
        texto = texto.replaceAll("\\, ", ",");
        texto = texto.replaceAll(" \\,", ",");
        
        
        
       
        */
        
        texto = removeEspacos(texto, new String[]{
            "===",
            "=",
            "!==",
            "\\(",
            "\\)",
            "\\{",
            "\\}",
            "\\[",
            "\\]",
            ",",
            ">",
            "<",
            ">=",
            "<=",
            "\\?",
            ":"
        });
        
        System.out.println(texto);
        reader.close();
    }
}
