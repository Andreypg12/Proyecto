package TempMain;

import BLL_PruebaLaboratorio.*;
import BLL_Motivos.*;
import BLL.*;
import java.time.Instant;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class TempMain {
    
    public static Sangre crearPruebaLaboratorio(){
        Sangre sangre = new Sangre();
        sangre.agregarCategoria(CategoriasSangre.SERIE_ROJA);
        sangre.agregarCategoria(CategoriasSangre.SERIE_BLANCA);
        return sangre;
    }
    
    public static Heces crearPruebaLaboratorio2(){
        Heces heces = new Heces();
        heces.agregarCategoria(CategoriasHeces.PARASITOS);
        heces.agregarCategoria(CategoriasHeces.SANGRE_EN_HECES);
        return heces;
    }
    
    public static Orina crearPruebaLaboratorio3(){
        Orina orina = new Orina();
        orina.agregarCategoria(CategoriasOrina.CULTIVOS_PARA_HONGOS);
        orina.agregarCategoria(CategoriasOrina.PROTEINAS);
        return orina;
    }
    
    public static Cultivos crearPruebaLaboratorio4(){
        Cultivos cultivos = new Cultivos();
        cultivos.agregarCategoria(CategoriasCultivos.BACTERIAS);
        cultivos.agregarCategoria(CategoriasCultivos.HONGOS);
        return cultivos;
    }
    
    public static Evaluacion crearEvaluacion(){
        return new Evaluacion(Estado.ANORMAL, TiposEvaluaciones.HIDRATACION);
    }

    public static void main(String[] args) {
        Cita cita;
        
        Sangre pruebaLaboratorio = crearPruebaLaboratorio();
        Heces pruebaLaboratorio2 = crearPruebaLaboratorio2();
        Orina pruebaLaboratorio3 = crearPruebaLaboratorio3();
        Cultivos pruebaLaboratorio4 = crearPruebaLaboratorio4();
        
        Evaluacion evaluacion =  crearEvaluacion();
        
//        try {
//            Razas.agregar(new RazasGato("Persa"));
//        } catch (Exception ex) {
//            Logger.getLogger(TempMain.class.getName()).log(Level.SEVERE, null, ex);
//        }
        
        
        Vacunacion motivoVacunacion = new Vacunacion(Vacunas.PARVOVIRUS, true);
        ChequeoGeneral chequeoGeneral = new ChequeoGeneral(false);
        Enfermedad enfermedad = new Enfermedad(10000, true);
        Desparasitacion desparasitacion = new Desparasitacion( true);
        Cirugia cirugia = new Cirugia(900000, true);
        
        String diagnostico = "sisisi";
        String indicaciones = "sisisi";
        
        Date fecha = Date.from(Instant.now());
        int frecuenciaCardiaca = 100;
        int frecuenciaRespiratoria = 100;
        int impulso = 100;
        int temperatura = 100;
        
        cita = new Cita(diagnostico, indicaciones, fecha, frecuenciaCardiaca, frecuenciaRespiratoria, impulso, temperatura);
        
        cita.agregarActitud(Actitud.EXCITADO);
        
        cita.agregarCondicion(Condicion.SOBREPESO);
        
        cita.agregarMotivo(motivoVacunacion);
        cita.agregarMotivo(chequeoGeneral);
        cita.agregarMotivo(enfermedad);
        cita.agregarMotivo(desparasitacion);
        cita.agregarMotivo(cirugia);
        
        cita.agregarEvaluacion(evaluacion);
        
        cita.agregarPruebaLaboratorio(pruebaLaboratorio);
        
        cita.agregarPruebaLaboratorio(pruebaLaboratorio2);
        
        cita.agregarPruebaLaboratorio(pruebaLaboratorio3);
        
        cita.agregarPruebaLaboratorio(pruebaLaboratorio4);
        
        
        
            //        System.out.println(cita.toString());
            
//        try {
//            for (Razas raza : Razas.listaRazas()) {
//                JOptionPane.showConfirmDialog(null, raza);
//            }
//        } catch (Exception ex) {
//            Logger.getLogger(TempMain.class.getName()).log(Level.SEVERE, null, ex);
//        }

        try {
            for (Razas raza : Razas.listaRazas()) {
                JOptionPane.showMessageDialog(null, raza.getNombreRaza());
            }       
        } catch (Exception ex) {
            Logger.getLogger(TempMain.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
}
