import java.util.ArrayList;
import java.util.Scanner;

/*
 * Alina Carías (22539)
 * Algoritmos y Estructuras de Datos Sección 40
 * Hoja de Trabajo 6
 * 03-03-2023
 * Clase Principal: clase que interactua con el usuario
 */
public class Principal {

    
    /** 
     * @param args
     */
    public static void main(String[] args){
        controladora control = new controladora();
        
        String menu1 = "---------- Bienvenido a nuestra tienda--------------\n" +
        "----------Por favor Seleccione que desea realizar-------------\n" +
        "1. Agregar productos a su carrito\n"+
        "2. Mostrar categorías de productos\n"+
        "3. Mostrar datos del producto.\n"+
        "4. Mostrar datos del producto por tipo.\n"+
        "5. Mostrar todo el inventario\n"+
        "6. Mosntrar productos y categorías por tio.\n";
        String menu2 = "---- Lista de Productos----\n"+
        "1. Mueble de Terraza\n" +
        "2. Sillones de masaje\n" +
        "3. Bebidas\n"+
        "4. Condimentos\n"+
        "5. Frutas\n"+
        "6. Carnes\n"+
        "7. Lácteos\n";
        
        
        Scanner teclado = new Scanner(System.in);
        Archivo archivo = new Archivo("./ListadoProducto.txt");
        ArrayList<String> lineasDatos = archivo.leerArchivo();
        System.out.println(menu1);
        System.out.println("Seleccione una de las opciones:");
        int opcion = teclado.nextInt();
        teclado.nextLine();
        
        try{
            switch(opcion){
                case 1:
                    System.out.println(menu2);
                    System.out.println("Escriba el nombre de la categoria que desea agregar");
                    String categoria = teclado.nextLine();
                    System.out.println("Escriba el nombre del producto que desea agregar");
                    String producto = teclado.nextLine();
                    control.agregarProducto(categoria, producto);
                    break;
                case 2:
                    System.out.println("Nombre del producto que desea visualizar");
                    String leche = teclado.nextLine();
                    System.out.println("Categoría:" + leche + control.mostrarCategoría(leche));
                    break;
                case 3:
                    System.out.println("Productos dentro de su canasta");
                    System.out.println(control.mostrarDatos());
                    break;
                case 4:
                    System.out.println("Productos dentro de su canasta ordenados por tipo");
                    System.out.println(control.mostrarDatosPorTipo());
                    break;
                case 5:
                    System.out.println("Productos del inventario");
                    System.out.println(control.mostrarInventario());
                    break;
                case 6:
                    System.out.println("Productos del inventario ordenados por Tipo");
                    System.out.println(control.mostrarInventarioPorTipo());
                    break;
                default:
                    break;
            }
            } catch (Exception e) {
                teclado.nextLine();
                System.out.println("Ingresó algo inválido.");
                //TODO: handle exception
        }

    }
}

