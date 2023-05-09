// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.

import java.util.Random;

public class Busqueda {
    //  búsqueda lineal
    public static int linearSearch(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        return -1;
    }

    // búsqueda binaria
    public static int binarySearch(int[] nums, int target) {
        int a = 0, b = nums.length - 1;
        while (a <= b) {
            int mid = (a + b) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                a = mid + 1;
            } else {
                b = mid - 1;
            }
        }
        return -1;
    }

    // arreglo aleatorio
    public static int[] generateRandomArray(int size, int minValue, int maxValue) {
        Random rand = new Random();
        int[] num = new int[size];
        for (int i = 0; i < size; i++) {
            num[i] = rand.nextInt(maxValue - minValue + 1) + minValue;
        }
        return num;
    }

    public static void main(String[] args) {
        int[] sizes = {100, 1000, 10000}; // Tamaños de arreglo
        long timeLinear, timeBinary; // Tiempos de ejecución
        int target; // Elemento a buscar
        int[] num1; // Arreglo generado
        for (int size : sizes) {
            num1 = generateRandomArray(size, 0, size); // Genera el arreglo ordenado
            target = num1[new Random().nextInt(size)]; // Seleccion aleatoria
            System.out.println("Arreglo de tamaño " + size);
            System.out.println("Elemento a buscar: " + target);
            //  tiempo de búsqueda lineal
            long startTime = System.nanoTime();
            int indexLinear = linearSearch(num1, target);
            timeLinear = System.nanoTime() - startTime;
            // tiempo de búsqueda binaria
            startTime = System.nanoTime();
            int indexBinary = binarySearch(num1, target);
            timeBinary = System.nanoTime() - startTime;
            // Compara tiempos de ejecución
            System.out.println("Búsqueda lineal: " + timeLinear + " ns");
            System.out.println("Búsqueda binaria: " + timeBinary + " ns");
            if (indexLinear == indexBinary) {
                System.out.println("Ambas funciones encontraron el elemento  " + indexLinear);
            } else {
                System.out.println("Error: las funciones no encontraron el elemento ");
            }
            System.out.println();
        }
    }
}
