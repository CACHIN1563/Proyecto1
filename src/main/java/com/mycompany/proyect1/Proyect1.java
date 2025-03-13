/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.proyect1;
import javax.swing.JOptionPane;
/**
 *
 * @author cachi
 */
//GARHER ES NUESTRA VARIABLE PARA CONVERTIR
//"\" SALTO DE LINEA
//Joption lo utilizamos para el cuadro de texto emergente

public class Proyect1 {
    public static void main(String[] args) {
        ArbolExpresion arbol =  
                new ArbolExpresion();
          ArbolExpresion.ArbolInfijaPostfija GARHER = 
                  arbol.new ArbolInfijaPostfija();

        String EINFIJA = JOptionPane.showInputDialog
        ("INGRESE LA EXPRESIÓN MATEMATICA: \n\n FAVOR DE DEJAR UN ESPACIO ENTRE CADA OPERADOR Y OPERANDO \n Ejemplo: A + B * C");
        
        
        if (!validarCaracteres(EINFIJA)) {
            JOptionPane.showMessageDialog
        (null, "EXPRESION INCORRECTA", "ERROR!!", JOptionPane.ERROR_MESSAGE);
                    return;
        }

        String[] EPOSTFIJA = GARHER.ArbolInfijaPostfija(EINFIJA);
        StringBuilder postfija = new StringBuilder
        ("EXPRESION EN NOTACION POSTFIJA:\n");
        for (String dato : EPOSTFIJA) {
            postfija.append(dato).append(" ");
        }
        JOptionPane.showMessageDialog(null, postfija.toString());


        NODO raiz = arbol.ArbolPostfija(EPOSTFIJA);

      
        StringBuilder recorridos = new StringBuilder();
        recorridos.append
        ("RECORRIDO INORDEN:\n");
        arbol.RecorridoIn(raiz, recorridos);
        recorridos.append
        ("\nRECORRIDO PREORDEN:\n");
        arbol.RecorridoPre(raiz, recorridos);
        recorridos.append
        ("\nRECORRIDO POSTORDEN:\n");
        arbol.RecorridoPost(raiz, recorridos);

        JOptionPane.showMessageDialog(null, recorridos.toString());

        int resultado = arbol.evaluarPostfija(EPOSTFIJA);
        JOptionPane.showMessageDialog
        (null, "RESULTADO: " + resultado);
    }

    private static boolean validarCaracteres(String expresion) {
        return expresion.matches("[a-zA-Z0-9+\\-*/^()\\s√]+");
    }

    }
