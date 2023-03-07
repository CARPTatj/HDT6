import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
/*
 * Alina Carías (22539)
 * Algoritmos y Estructuras de Datos Sección 40
 * Hoja de Trabajo 6
 * 03-03-2023
 * Clase FactoryHash: es la clase factory
 */

public class FactoryHash {
    private Map<String, ArrayList<String>> soyElMapa;

    
    /** 
     * @param estilo
     * @return Map<String, ArrayList<String>>
     */
    public Map<String, ArrayList<String>> getInstance(int estilo){
        switch(estilo){
            case 1:
                this.soyElMapa = new HashMap<String, ArrayList<String>>();
                break;
            case 2:
                this.soyElMapa = new LinkedHashMap<String, ArrayList<String>>();
                break;
            case 3:
                this.soyElMapa = new TreeMap<String, ArrayList<String>>();
                break;
            default:
                break;
        }
        return soyElMapa;
    }
    
}
