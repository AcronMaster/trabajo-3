import java.util.Scanner;

public class Ventas{
    private int[][] ventas;  // Arreglo bidimensional para almacenar las ventas
    private String[] departamentos = {"ropa", "deportes", "juguetería"};

    public Ventas() {
        ventas = new int[3][12];  // 3 departamentos, 12 meses por departamento
    }

    public void insertarVentas(String departamento, int mes, int monto) {
        int index = getDepartamentoIndex(departamento);
        if (index != -1 && mes >= 1 && mes <= 12) {
            ventas[index][mes - 1] = monto;
            System.out.println("Venta de " + monto + " insertada para " + departamento + " en el mes " + mes + ".");
        } else {
            System.out.println("Departamento o mes inválido.");
        }
    }

    public void buscarVenta(String departamento, int mes) {
        int index = getDepartamentoIndex(departamento);
        if (index != -1 && mes >= 1 && mes <= 12) {
            int monto = ventas[index][mes - 1];
            System.out.println("Venta en " + departamento + " durante el mes " + mes + ": " + monto);
        } else {
            System.out.println("Departamento o mes inválido.");
        }
    }

    public void eliminarVentas(String departamento) {
        int index = getDepartamentoIndex(departamento);
        if (index != -1) {
            for (int i = 0; i < 12; i++) {
                ventas[index][i] = 0;
            }
            System.out.println("Ventas eliminadas para el departamento " + departamento + ".");
        } else {
            System.out.println("Departamento inválido.");
        }
    }

    public void mostrarVentas() {
        System.out.println("\nVentas del año por departamento:");
        for (int i = 0; i < departamentos.length; i++) {
            System.out.print(departamentos[i].substring(0, 1).toUpperCase() + departamentos[i].substring(1) + ": ");
            for (int j = 0; j < 12; j++) {
                System.out.print(ventas[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void pedirDatos() {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < departamentos.length; i++) {
            System.out.println("\nIngrese las ventas para el departamento de " + departamentos[i] + ":");
            for (int j = 0; j < 12; j++) {
                int monto = -1;
                while (monto < 0) {
                    try {
                        System.out.print("  Mes " + (j + 1) + ": ");
                        monto = Integer.parseInt(scanner.nextLine());
                        if (monto < 0) {
                            System.out.println("El monto no puede ser negativo. Inténtelo nuevamente.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Entrada inválida. Inténtelo nuevamente.");
                    }
                }
                insertarVentas(departamentos[i], j + 1, monto);
            }
        }
    }

    private int getDepartamentoIndex(String departamento) {
        for (int i = 0; i < departamentos.length; i++) {
            if (departamento.equalsIgnoreCase(departamentos[i])) {
                return i;
            }
        }
        return -1;  // Retorna -1 si el departamento no existe
    }

    public static void main(String[] args) {
        Ventas ventas = new Ventas();

        // Pedir datos al usuario
        ventas.pedirDatos();

        // Mostrar todas las ventas ingresadas
        ventas.mostrarVentas();

        // Buscar y mostrar ventas de un departamento y mes específico
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nIngrese el nombre del departamento para buscar ventas ('ropa', 'deportes', 'juguetería'): ");
        String departamento = scanner.nextLine().trim();
        System.out.print("Ingrese el mes para buscar ventas (1 a 12): ");
        int mes = Integer.parseInt(scanner.nextLine().trim());
        ventas.buscarVenta(departamento, mes);

        // Eliminar todas las ventas de un departamento específico
        System.out.print("\nIngrese el nombre del departamento para eliminar ventas ('ropa', 'deportes', 'juguetería'): ");
        String departamentoAEliminar = scanner.nextLine().trim();
        ventas.eliminarVentas(departamentoAEliminar);

        // Mostrar el arreglo de ventas después de la eliminación
        ventas.mostrarVentas();
    }
}