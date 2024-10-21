/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/**
 *
 * @author Estudiante
 */
public class MeObjectOutputStream extends ObjectOutputStream {
    
    public MeObjectOutputStream(OutputStream out) throws IOException{
        super(out);
    }
    
    //redefiner el metodo que escribe los encabezados
    //los encabezados son los bytes serializables de los objetos que se almacenan
    @Override
    protected void writeStreamHeader() throws IOException{
        
    }
}
