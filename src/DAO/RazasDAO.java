package DAO;

import BLL.Razas;
import java.util.ArrayList;

public class RazasDAO extends PadreDAO<Razas, String>{

    private static RazasDAO instance = null;
    
    private RazasDAO() {
        super.setRUTA_ARCHIVO(System.getProperty("user.dir") 
            + "\\src\\Archivos\\Razas.txt");
    }
    
    public static RazasDAO getInstance(){
        if (instance == null) {
            instance = new RazasDAO();
        }
        return instance;
    }
    
    @Override
    public Razas consultar(String codigo) throws Exception {
        Razas retornar = null;
        try {
            super.abrirArchivoInput();
            
            while (true) {
                retornar = (Razas)super.lector.readObject();
                if (retornar.getNombreRaza().equalsIgnoreCase(codigo)) {
                    return retornar;
                }
            }
        } catch (Exception e) {
        }finally{
            super.cerrarArchivoInput();
        }
        return null;
    }

    @Override
    public void modificar(Razas raza) throws Exception {
        super.array = new ArrayList<>();
        try {
            abrirArchivoInput();
            Razas temp = null;
            while (true) {
                temp = (Razas)super.lector.readObject();
                if (temp.getNombreRaza().equals(raza.getNombreRaza())) {
                   temp = raza;
                }
                 super.array.add(temp);
            }
        } catch (Exception e) {
        } finally {
            cerrarArchivoInput();
            super.pasarArrayTemporal_Archivo();
        }
    }

    @Override
    public void eliminar(String nombre) throws Exception {
        super.array = new ArrayList<>();
        try {
            abrirArchivoInput();
            Razas temp = null;
            while (true) {
                temp = (Razas)super.lector.readObject();
                if (!temp.getNombreRaza().equals(nombre)) {
                    super.array.add(temp);
                }
            }
        } catch (Exception e) {
        } finally {
            cerrarArchivoInput();
            pasarArrayTemporal_Archivo();
        }
    }
}
