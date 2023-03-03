import java.util.ArrayList;

/*
 * Alina Carías (22539)
 * Algoritmos y Estructuras de Datos Sección 40
 * Hoja de Trabajo 6
 * 03-03-2023
 * Clase Principal: clase que interactua con el usuario
 */
public class Principal {

    public static void main(String[] args){
        Archivo archivo = new Archivo("./ListadoProducto.txt");
        ArrayList<String> lineasDatos = archivo.leerArchivo();



        for (String fila : lineasDatos) {
            ArrayList<String> oneLine = new ArrayList<String>();
            String [] lineaSeparada = fila.split(" ");
            for (String caracter : lineaSeparada) {
                oneLine.add(caracter);
            }
        }
    }
}
