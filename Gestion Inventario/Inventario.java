import java.util.ArrayList;
import java.util.Scanner;

public class Inventario{
    private static ArrayList<Producto> inventario = new ArrayList<>();

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        
        int opcion;

        do{
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine(); //ESTO REPRESENTA UN SALTO DE LINEA
            
            switch(opcion){
                case 1:
                agregarProducto(scanner);
                break;
                case 2:
                eliminarProducto(scanner);
                break;
                case 3:
                buscarProducto(scanner);
                break;
                case 4:
                listarProducto();
                break;
                case 5:
                System.out.println("Estamos saliendo del sistema");
                break;
                default:
                    System.out.println("Opcion no valida");
            }

        } while(opcion != 5);
        scanner.close();
    }
    private static void mostrarMenu(){
        System.out.println("1. Agregar producto");
        System.out.println("2. Eliminar producto");
        System.out.println("3. Buscar producto");
        System.out.println("4. Listar productos");
        System.out.println("5. Salir");
        System.out.println("Seleccione una opcion: ");
    }

    private static void agregarProducto(Scanner scanner){
        System.out.println("Ingrese su codigo de producto: ");
        String codigo = scanner.nextLine();
        System.out.println("Ingrese el nombre del producto: ");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese su precio de producto: ");
        double precio = scanner.nextDouble();
        System.out.println("Ingrese la cantidad que existe en Stock del producto: ");
        int cantidad = scanner.nextInt();

        Producto producto = new Producto(codigo, nombre, precio, cantidad);
        inventario.add(producto);
        System.out.println("El producto ha sido agregado correctamente");
    }

    private static void eliminarProducto(Scanner scanner){
        System.out.println("Ingrese el codigo del producto que desea eliminar: ");
        String codigo = scanner.nextLine();
        Producto productoEliminar = null;

        for(Producto producto : inventario){
            if(producto.getCodigo().equals(codigo)){
                productoEliminar = producto;
                break;
            }
        }
        if (productoEliminar != null){
            inventario.remove(productoEliminar);
            System.out.println("El producto ha sido eliminado correctamente");
        } else {
            System.out.println("El producto no ha sido encontrado");
        }
    }

    private static void buscarProducto(Scanner scanner){
        System.out.println("Ingrese el nombre del producto que busca");
        String nombre = scanner.nextLine();

        for (Producto producto : inventario){
            if(producto.getNombre().equalsIgnoreCase(nombre)){
                System.out.println(producto);
                return;
            }
        }
        System.out.println("El producto no ha sido encontrado");
    }

    private static void listarProducto(){
        if (inventario.isEmpty()){
            System.out.println("No existen productos dentro del inventario");
        } else{
            for(Producto producto : inventario){
                System.out.println(producto);
            }
        }
    } 
}