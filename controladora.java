import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;



/*
 * Alina Carías (22539)
 * Algoritmos y Estructuras de Datos Sección 40
 * Hoja de Trabajo 6
 * 03-03-2023
 * Clase controladora: es la clase que crea todos los metodosk, para que se puedan llamar en la princial
 */
public class controladora {
    private Map<String, ArrayList<String>> bodega;
    private Map<String, ArrayList<String>> canasta;
    private FactoryHash factoria;


    public controladora(int tipo) {
        this.bodega = factoria.getInstance(tipo);
        this.canasta = factoria.getInstance(tipo);
        this.factoria = new FactoryHash();
    }
    
    /** 
     * @param inventario
     */
    public void leerArchivo(ArrayList<String> inventario){
        for (String linea : inventario) {
            String[] partes = linea.split("\\|");
            String producto = partes[1].trim();
            String categoria = partes[0].trim();
            bodega.putIfAbsent(categoria, new ArrayList<String>());
            bodega.get(categoria).add(producto);
            }
    }
    
    
    /** 
     * @param categoria
     * @param producto
     */
    public void agregarProducto(String categoria, String producto){
        canasta.putIfAbsent(categoria, new ArrayList<String>());
        canasta.get(categoria).add(producto);
    }

    
    /** 
     * @param product
     * @return String
     */
    public String mostrarCategoría(String product){
        String estado = "";

        for (Map.Entry<String, ArrayList<String>> muestra : bodega.entrySet()){
            String catego = muestra.getKey();
            ArrayList<String> si = muestra.getValue();

            String[] categoriasPermitidas = {"Mueble de terraza", "Sillones de masaje", "Bebidas", "Condimentos", "Frutas", "Carnes", "Lácteos"};
            if (Arrays.asList(categoriasPermitidas).contains(catego)) {
                if(si.contains(product)){
                   estado = catego;
                   break;
                   
               }
               if(estado.equals("")){
                  estado = "No se encontró el producto";
               }
                }
            }
    
        return estado;

    }

    
    /** 
     * @return String
     */
    public StringBuilder mostrarDatos(){
        StringBuilder estado = new StringBuilder();
        ArrayList<String> MuestradeProducts = new ArrayList<String>();

        for (ArrayList<String> productos : canasta.values()) {
        for (String producto : productos) {
            if (MuestradeProducts.add(producto)) {
                estado.append("\n\n").append(producto)
                         .append("\n  - Cantidad: ").append(Collections.frequency(productos, producto))
                         .append("\n  - Categoría: ").append(mostrarCategoría(producto));
                }
            }
        }

        return estado;

    }

    
    /** 
     * @return String
     */
    public StringBuilder mostrarDatosPorTipo(){
        StringBuilder estado = new StringBuilder();
        
        for (Map.Entry<String, ArrayList<String>> adentro : canasta.entrySet()){
            estado.append(String.format("\n\n", adentro.getKey().toUpperCase()));
            ArrayList<String> productosPorTipo = new ArrayList<String>(); 
            for (String producto : adentro.getValue()){
                if(!productosPorTipo.contains(producto)){
                    int num = Collections.frequency(adentro.getValue(), producto);
                    estado.append(String.format("\n - Cantidad: \n", producto, num));
                    productosPorTipo.add(producto);
                }
            }
            
        }
        return estado;

    }

    
    /** 
     * @return String
     */
    public StringBuilder mostrarInventario(){
        StringBuilder estado = new StringBuilder();
        ArrayList<String> MuestradeProductos = new ArrayList<String>();

        for (Map.Entry<String, ArrayList<String>> adentro : bodega.entrySet()) {
        for (String producto : adentro.getValue()) {
            if (!MuestradeProductos.contains(producto)) {
                int num = Collections.frequency(adentro.getValue(), producto);
                String categoria = mostrarCategoría(producto);

                estado.append("\n\n").append(producto)
                    .append("\n  - Cantidad: ").append(num)
                    .append("\n  - Categoría: ").append(categoria);

                MuestradeProductos.add(producto);
                }
            }
        }

        return estado;

    }

    
    /** 
     * @return String
     */
    public StringBuilder mostrarInventarioPorTipo(){
        StringBuilder estado = new StringBuilder();
        for (Map.Entry<String, ArrayList<String>> adentro : bodega.entrySet()) {
            estado.append("\n\n").append(adentro.getKey().toUpperCase()).append("\n\n");
            ArrayList<String> productos = adentro.getValue();
            ArrayList<String> MuesradeProductos = new ArrayList<String>();
    
            for (String producto : productos) {
                if (MuesradeProductos.add(producto)) {
                    int num = Collections.frequency(productos, producto);
                    estado.append("\n").append(producto).append(" - Cantidad: ").append(num);
                }
            }
        }
    
        return estado;
    }

    //Sets y gets
    
    /** 
     * @return Map<String, ArrayList<String>>
     */
    public Map<String,ArrayList<String>> getBodega() {
        return this.bodega;
    }

    
    /** 
     * @param bodega
     */
    public void setBodega(Map<String,ArrayList<String>> bodega) {
        this.bodega = bodega;
    }

    
    /** 
     * @return Map<String, ArrayList<String>>
     */
    public Map<String,ArrayList<String>> getCanasta() {
        return this.canasta;
    }

    
    /** 
     * @param canasta
     */
    public void setCanasta(Map<String,ArrayList<String>> canasta) {
        this.canasta = canasta;
    }

    
    /** 
     * @return FactoryHash
     */
    public FactoryHash getFactoria() {
        return this.factoria;
    }

    
    /** 
     * @param factoria
     */
    public void setFactoria(FactoryHash factoria) {
        this.factoria = factoria;
    }

    
}
