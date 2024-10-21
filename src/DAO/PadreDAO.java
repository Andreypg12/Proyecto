package DAO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public abstract class PadreDAO <T, E>{
    
    protected String RUTA_ARCHIVO;

    protected ObjectOutputStream escritor;
    protected ObjectInputStream lector;

    protected FileOutputStream fileOutputStream;
    protected FileInputStream fileInputStream;

    protected List<T> array;

    private static PadreDAO instance = null;
    
    protected PadreDAO(){
        
    }
    
    public void abrirArchivoOutput() throws Exception{
        try {
            File oArchivo = new File(RUTA_ARCHIVO);
            if (oArchivo.exists()) {
                fileOutputStream = new FileOutputStream(oArchivo,true);
                escritor = new MeObjectOutputStream(fileOutputStream);
            }else{
                fileOutputStream = new FileOutputStream(oArchivo,true);
                escritor = new ObjectOutputStream(fileOutputStream);
            }
        } catch (IOException e) {
            throw e;
        }
    }
    
    public void abrirArchivoInput() throws Exception{
        try {
            fileInputStream = new FileInputStream(RUTA_ARCHIVO);
            lector = new ObjectInputStream(fileInputStream);
        } catch (IOException e) {
            throw e;
        }
    }
    
    public void cerrarArchivoOutput() throws Exception{
        try {
            if(escritor != null)
            {
                escritor.close();
                escritor = null;
            }
        } catch (IOException e) {
            throw e;
        }
    }
    public void cerrarArchivoInput() throws Exception{
        try {
            if (lector != null) {
                lector.close();
                lector = null;
            }
        } catch (IOException e) {
            throw e;
        }
    }
    
    public void agregar(T t)throws Exception{
        try {
            this.abrirArchivoOutput();
            if (escritor != null) {

                escritor.writeObject(t);

                escritor.flush();
            }
        } catch (Exception e) {
            throw e;
        }
        finally{
            this.cerrarArchivoOutput();
        }
    }
    
    public abstract T consultar(E codigo)throws Exception;
    
    protected void pasarArrayTemporal_Archivo() throws Exception{
        File archivoOriginal = new File(RUTA_ARCHIVO);
        if (archivoOriginal.exists()) {
            archivoOriginal.delete();
        } 
        if (!array.isEmpty()) {
            this.abrirArchivoOutput();
            for (T t : array) {
                escritor.writeObject(t);
            }
            escritor.flush();
        }
        this.cerrarArchivoOutput();
    }
    
    public abstract void modificar(T t)throws Exception;
    
    public abstract void eliminar(E codigo)throws Exception;
    
    public List<T> listado() throws Exception{
        array = new ArrayList<>();
        try {
            abrirArchivoInput();
            while (true) {
                array.add((T)this.lector.readObject());
            }
        } catch (Exception e) {
        } finally {
            cerrarArchivoInput();
        }
        return array;
    }

    public void setRUTA_ARCHIVO(String RUTA_ARCHIVO) {
        this.RUTA_ARCHIVO = RUTA_ARCHIVO;
    }
}
