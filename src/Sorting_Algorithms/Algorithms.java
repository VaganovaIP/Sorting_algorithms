package Sorting_Algorithms;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Algorithms {
    public static void main(String[] args) throws IOException {
        Scanner InCMD = new Scanner(System.in);
        List<Integer> array = new ArrayList<Integer>();
        System.out.println("\nРазработанная программа предназначена для сортировки целых чисел " +
                "\nпо возрастанию, с использованием алгоритмов на сравнениях:  \n"       +
                "1) быстрая сортировка\n" +
                "2) сортировка Шелла\n" +
                "3) сортировка слиянием. ");
        boolean exit1 = false;
        while (!exit1) {
            System.out.println("\n\n-------------  МЕНЮ  -------------\n" +
                    "Ввести данные для сортировки (нажать кнопку z)\n" +
                    "Выполнить сортировку (нажмите клавишу s)\n" +
                    "Завершить программу (нажмите клавишу q)\n");
            String in = InCMD.nextLine();
            switch (in) {
                case "z":
                    try {
                        formation_array(array);
                        } catch (Exception e) {
                    }
                    break;
                case "s":
                    int[] arr = new int[array.size()];
                    for (int i = 0; i < array.size(); i++) {
                        arr[i] = array.get(i);
                    }
                    Sorting(arr);
                    break;
                case "q":
                    System.out.println("Файлы с результатами работ сортировок смотрите в папке 'Результаты'");
                    System.out.println("Работа программы завершена");
                    exit1 = true;
                    break;
            }
        }
    }
    //формирование массива
    public static void formation_array(List<Integer> array) throws FileNotFoundException {
        Scanner InCMD = new Scanner(System.in);
        Random rnd = new Random();
        array.clear();
        System.out.println("Введите номер способа формирования массива чисел\n" +
                "a Рандомный способ\n" +
                "b Текстовый файл\n");
        String in = InCMD.nextLine();
        switch (in) {
            case "a":
                System.out.println("------------------------------------------------------------");
                System.out.println("Введите количество элементов: ");
                int n = InCMD.nextInt();
                System.out.println("Исходный массив чисел:");
                for (int i = 0; i < n; i++) {
                    array.add(i, rnd.nextInt(n * 8) - 30);
                    System.out.print(array.get(i) + " ");
                }
                break;
            case "b":
                try {
                    System.out.print("Введите имя файла (файл должен находится папке 'Файлы для сортировки'): ");
                    String fname = InCMD.nextLine();
                    File file = new File("Файлы для сортировки\\" + fname);
                    Scanner scanner = new Scanner(file);
                    System.out.println("Исходный массив чисел:");
                    while (scanner.hasNext()) {
                        if (scanner.hasNextInt()) {
                            int element = scanner.nextInt();
                            array.add(element);
                            System.out.print(element +"  ");
                        } else {
                            scanner.next();
                        }
                    }
                } catch (Exception e) {
                    System.out.println("Файл не найден!");
                }
                break;
        }
    }

    //сортировка массива
    public static void Sorting(int[] arr) throws IOException {
        boolean exit = false;
        if (arr.length == 0) {
            System.out.println("Нет данных для сортировки, введите данные для сортировки");
            return;//завершить выполнение, если длина массива равна 0
        }
        Date date = new Date() ;
        SimpleDateFormat dateObject = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss") ;
        File filePath = new File("Результаты");
        filePath.mkdir();
        while (!exit) {
            int[] For_sort_arr = new int[arr.length];
            for (int i = 0; i < arr.length; i++) {
                For_sort_arr[i] = arr[i];
            }
            System.out.println("\n------------------------------------------------------------");
            System.out.println("Введите номер сортировки, которую хотите выполнить\n" +
                    "1 Быстрая сортировка\n" +
                    "2 Сортировка Шелла\n" +
                    "3 Сортировка слиянием \n" +
                    "Выйти в меню (нажмите клавишу m)\n" +
                    "Завершить программу (нажмите клавишу q)\n");
            Scanner In = new Scanner(System.in);
            String input = In.nextLine();
            switch (input) {
                case "1":
                    System.out.println("------------------------------------------------------------");
                    System.out.println("1 Быстрая сортировка");
                    int low = 0;
                    int high = For_sort_arr.length - 1;
                    System.out.println("Исходный массив чисел:");
                    System.out.println(Arrays.toString(For_sort_arr));
                    QuickSort(For_sort_arr, low, high);
                    System.out.println("Отсортированный массив чисел:");
                    System.out.println(Arrays.toString(For_sort_arr));
                    try{
                        File file_QS = new File(filePath + "\\Результат - Быстрая сортировка "+dateObject.format(date)+".txt");
                        file_QS.createNewFile(); //создание файла
                        PrintWriter out = new PrintWriter(filePath + "\\Результат - Быстрая сортировка "+dateObject.format(date)+".txt", "UTF8");
                        out.println("------------------------------------------------------------");
                        out.println("Быстрая сортировка");
                        out.println("Исходный массив чисел:");
                        out.println(Arrays.toString(arr));

                        out.println("Отсортированный массив чисел:");
                        out.println(Arrays.toString(For_sort_arr));
                        out.flush();
                        out.close();
                    } catch (IOException e) {
                        System.out.println("Ошибка!"); }
                    break;
                case "2":
                    System.out.println("------------------------------------------------------------");
                    System.out.println("2 Сортировка Шелла");
                    System.out.println("Исходный массив чисел:");
                    System.out.println(Arrays.toString(For_sort_arr));
                    shellSort(For_sort_arr);
                    System.out.println("Отсортированный массив чисел:");
                    System.out.println(Arrays.toString(For_sort_arr));
                    try{
                        File file_SS = new File(filePath + "\\Результат - Сортировка Шелла "+dateObject.format(date)+".txt");
                        file_SS.createNewFile(); //создание файла
                        PrintWriter out = new PrintWriter(filePath + "\\Результат - Сортировка Шелла "+dateObject.format(date)+".txt", "UTF8");
                        out.println("------------------------------------------------------------");
                        out.println("Сортировка Шелла");
                        out.println("Исходный массив чисел:");
                        out.println(Arrays.toString(arr));
                        out.println("Отсортированный массив чисел:");
                        out.println(Arrays.toString(For_sort_arr));
                        out.flush();
                        out.close();
                    } catch (IOException e) {
                        System.out.println("Ошибка!"); }
                    break;
                case "3":
                    System.out.println("------------------------------------------------------------");
                    System.out.println("3 Сортировка слиянием");
                    System.out.println("Исходный массив чисел:");
                    System.out.println(Arrays.toString(For_sort_arr));
                    mergeSort(For_sort_arr, arr.length);
                    System.out.println("Отсортированный массив чисел:");
                    System.out.println(Arrays.toString(For_sort_arr));
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
                    LocalDateTime dateTime = LocalDateTime.now();
                    String dt = dateTime.format(formatter);

                   try{
                        File file_SlS = new File(filePath + "\\Результат - Сортировка слиянием "+dateObject.format(date)+".txt");
                        file_SlS.createNewFile(); //создание файла
                        PrintWriter out = new PrintWriter(filePath + "\\Результат - Сортировка слиянием "+dateObject.format(date)+".txt", "UTF8");
                        out.println("------------------------------------------------------------");
                        out.println("Сортировка слиянием");
                        out.println("Исходный массив чисел:");
                        out.println(Arrays.toString(arr));
                        out.println("Отсортированный массив чисел:");
                        out.println(Arrays.toString(For_sort_arr));
                        out.flush();
                        out.close();
                    } catch (IOException e) {
                        System.out.println("Ошибка!"); }
                    break;
                case "m":
                    exit = true;
                    break;
                case "q":
                    System.out.println("Файлы с результатами работ сортировок смотрите в папке 'Результаты'");
                    System.out.println("Работа программы завершена");
                    System.exit(0);
            }
        }
}

//Быстрая сортировка
public static void QuickSort(int[] array, int low, int high) {
        if (low >= high)
            return;//завершить выполнение если уже нечего делить
        // выбор опорного элемента
        int middle = low + (high - low) / 2;
        int support_element= array[middle];
        // разделение на два подмассива, которые больше и меньше опорного элемента
        int i = low, j = high;
        while (i <= j) {
            while (array[i] < support_element) {
                i++;
            }
            while (array[j] > support_element) {
                j--;
            }
            if (i <= j) {
                int temp = array[i];//перестановка элементов
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }
        // вызов рекурсии для сортировки левой и правой части
        if (low < j)
            QuickSort(array, low, j);
        if (high > i)
            QuickSort(array, i, high);
}

//Сортировка Шелла
public static void shellSort(int[] array) {
    for(int d = array.length / 2; d > 0; d /= 2) {
        for (int i = d; i < array.length; i++) {
            for (int j = i - d; j >= 0 && array[j] > array[j + d]; j -= d) {
                int a = array[j];
                array[j] = array[j + d];
                array[j + d] = a;
            }
        }
    }
}

//Сортировка слиянием
public static void mergeSort(int[] a, int n) {
        if (n < 2) {
            return;
        }
        int middle = n / 2;// выбор позиции опорного элемента
        int[] left = new int[middle];
        int[] rigth = new int[n - middle];
        //разделение массива на два подмассива
        for (int i = 0; i < middle; i++) {
            left[i] = a[i];
        }
        for (int i = middle; i < n; i++) {
            rigth[i - middle] = a[i];
        }
        mergeSort(left, middle); //разделение левого подмассива
        mergeSort(rigth, n - middle);////разделение правого подмассива
        // слияние
        merge(a, left, rigth, middle, n - middle);
}
    // слияние
    public static void merge(int[] a, int[] left_arr, int[] right_arr, int left, int right) {
        int i = 0, j = 0, k = 0;

        while (i < left && j < right) {
            //выбор меньшего элемента
            if (left_arr[i] <= right_arr[j]) {
                a[k++] = left_arr[i++];
            }
            else {
                a[k++] = right_arr[j++];
            }
        }
        //слияние подмассивов в один общий массив
        while (i < left) {
            a[k++] = left_arr[i++];
        }
        while (j < right) {
            a[k++] = right_arr[j++];
        }
    }
}




