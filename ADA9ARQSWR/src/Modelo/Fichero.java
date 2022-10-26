/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author Personal
 */
public class Fichero {
    private static Fichero instancia;
    private Fichero(){}
    
    public ArrayList<String> leerFichero(String direccion){
    ArrayList<String> retorno = new ArrayList<String>();
    try{
            FileReader fileReader = new FileReader(direccion);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String linea;
            while((linea = bufferedReader.readLine())!=null){
                retorno.add(linea);
            }
            bufferedReader.close();
    }
    catch(IOException e){
        e.printStackTrace();
    }
    return retorno;
    }
    
    public void escribirFichero(String direccion, String data){
        try{
            FileWriter fileWriter = new FileWriter(direccion, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(data);
            bufferedWriter.newLine();
            bufferedWriter.close();
        
        }catch(IOException e){
        e.printStackTrace();
        }
    }
    
    public File crearFichero(String direccion){
        File nuevo= new File(direccion);
        try{
            nuevo.createNewFile();
        }catch(IOException e){
        e.printStackTrace();
        }
        return nuevo;
    }
    
    

    public static Fichero getInstancia() {
        if(instancia==null)
            instancia= new Fichero();
        return instancia;
    }
    
}
