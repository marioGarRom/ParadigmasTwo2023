package Prueba;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Empleado[] empleados = {
                new Empleado("José", "García", 5000, "TI"),
                new Empleado("Rosario", "Vázquez", 7600, "TI"),
                new Empleado("Luis", "Prieto", 10000, "TI"),
                new Empleado("Luis", "Vázquez", 4500, "Ventas"),
                new Empleado("Gabriela", "Prieto", 6000, "Ventas"),
                new Empleado("Vianney", "Rodríguez", 65000, "Marketing"),
                new Empleado("Francisco", "Vázquez", 50000, "Marketing"),
                new Empleado("Irma", "Domínguez", 7500, "Ventas"),
                new Empleado("Rosario", "Prieto", 100000, "Marketing")
        };
        List<Empleado> listaEmpleados = Arrays.asList(empleados);
        // Muestra a todos los empleados
        System.out.println("Lista completa de empleados");
        imprimirEncabezado();
        listaEmpleados.parallelStream().forEach(System.out::println);
        imprimirRenglon();
        // Agrupación de objetos Empleado por departamento
        System.out.println("Empleados por departamento");
        Map<String, List<Empleado>> agrupadoPorDepartamento =
                listaEmpleados.stream()
                        .collect(Collectors.groupingBy(Empleado::getDepartamento));
        agrupadoPorDepartamento.forEach(
                (departamento, empleadosEnDepartamento) -> {
                    System.out.println(departamento);
                    empleadosEnDepartamento.forEach(
                            empleado -> System.out.printf(" %s%n", empleado.toString())
                    );
                }
        );
        imprimirRenglon();
    }

    public static void imprimirRenglon() {
        System.out.println();
        System.out.println("----------------------------------------------------------");
    }

    public static void imprimirEncabezado() {
        System.out.printf("%12s %12s %12s %12s%n", "Nombre", "Apellidos",
                "Salario", "Departamento");
        System.out.println("----------------------------------------------------");
    }
}