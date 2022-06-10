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
        System.out.println("\n������������� ��������� ������������� ��� ���������� ����� ����� " +
                "\n�� �����������, � �������������� ���������� �� ����������:  \n"       +
                "1) ������� ����������\n" +
                "2) ���������� �����\n" +
                "3) ���������� ��������. ");
        boolean exit1 = false;
        while (!exit1) {
            System.out.println("\n\n-------------  ����  -------------\n" +
                    "������ ������ ��� ���������� (������ ������ z)\n" +
                    "��������� ���������� (������� ������� s)\n" +
                    "��������� ��������� (������� ������� q)\n");
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
                    System.out.println("����� � ������������ ����� ���������� �������� � ����� '����������'");
                    System.out.println("������ ��������� ���������");
                    exit1 = true;
                    break;
            }
        }
    }
    //������������ �������
    public static void formation_array(List<Integer> array) throws FileNotFoundException {
        Scanner InCMD = new Scanner(System.in);
        Random rnd = new Random();
        array.clear();
        System.out.println("������� ����� ������� ������������ ������� �����\n" +
                "a ��������� ������\n" +
                "b ��������� ����\n");
        String in = InCMD.nextLine();
        switch (in) {
            case "a":
                System.out.println("------------------------------------------------------------");
                System.out.println("������� ���������� ���������: ");
                int n = InCMD.nextInt();
                System.out.println("�������� ������ �����:");
                for (int i = 0; i < n; i++) {
                    array.add(i, rnd.nextInt(n * 8) - 30);
                    System.out.print(array.get(i) + " ");
                }
                break;
            case "b":
                try {
                    System.out.print("������� ��� ����� (���� ������ ��������� ����� '����� ��� ����������'): ");
                    String fname = InCMD.nextLine();
                    File file = new File("����� ��� ����������\\" + fname);
                    Scanner scanner = new Scanner(file);
                    System.out.println("�������� ������ �����:");
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
                    System.out.println("���� �� ������!");
                }
                break;
        }
    }

    //���������� �������
    public static void Sorting(int[] arr) throws IOException {
        boolean exit = false;
        if (arr.length == 0) {
            System.out.println("��� ������ ��� ����������, ������� ������ ��� ����������");
            return;//��������� ����������, ���� ����� ������� ����� 0
        }
        Date date = new Date() ;
        SimpleDateFormat dateObject = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss") ;
        File filePath = new File("����������");
        filePath.mkdir();
        while (!exit) {
            int[] For_sort_arr = new int[arr.length];
            for (int i = 0; i < arr.length; i++) {
                For_sort_arr[i] = arr[i];
            }
            System.out.println("\n------------------------------------------------------------");
            System.out.println("������� ����� ����������, ������� ������ ���������\n" +
                    "1 ������� ����������\n" +
                    "2 ���������� �����\n" +
                    "3 ���������� �������� \n" +
                    "����� � ���� (������� ������� m)\n" +
                    "��������� ��������� (������� ������� q)\n");
            Scanner In = new Scanner(System.in);
            String input = In.nextLine();
            switch (input) {
                case "1":
                    System.out.println("------------------------------------------------------------");
                    System.out.println("1 ������� ����������");
                    int low = 0;
                    int high = For_sort_arr.length - 1;
                    System.out.println("�������� ������ �����:");
                    System.out.println(Arrays.toString(For_sort_arr));
                    QuickSort(For_sort_arr, low, high);
                    System.out.println("��������������� ������ �����:");
                    System.out.println(Arrays.toString(For_sort_arr));
                    try{
                        File file_QS = new File(filePath + "\\��������� - ������� ���������� "+dateObject.format(date)+".txt");
                        file_QS.createNewFile(); //�������� �����
                        PrintWriter out = new PrintWriter(filePath + "\\��������� - ������� ���������� "+dateObject.format(date)+".txt", "UTF8");
                        out.println("------------------------------------------------------------");
                        out.println("������� ����������");
                        out.println("�������� ������ �����:");
                        out.println(Arrays.toString(arr));

                        out.println("��������������� ������ �����:");
                        out.println(Arrays.toString(For_sort_arr));
                        out.flush();
                        out.close();
                    } catch (IOException e) {
                        System.out.println("������!"); }
                    break;
                case "2":
                    System.out.println("------------------------------------------------------------");
                    System.out.println("2 ���������� �����");
                    System.out.println("�������� ������ �����:");
                    System.out.println(Arrays.toString(For_sort_arr));
                    shellSort(For_sort_arr);
                    System.out.println("��������������� ������ �����:");
                    System.out.println(Arrays.toString(For_sort_arr));
                    try{
                        File file_SS = new File(filePath + "\\��������� - ���������� ����� "+dateObject.format(date)+".txt");
                        file_SS.createNewFile(); //�������� �����
                        PrintWriter out = new PrintWriter(filePath + "\\��������� - ���������� ����� "+dateObject.format(date)+".txt", "UTF8");
                        out.println("------------------------------------------------------------");
                        out.println("���������� �����");
                        out.println("�������� ������ �����:");
                        out.println(Arrays.toString(arr));
                        out.println("��������������� ������ �����:");
                        out.println(Arrays.toString(For_sort_arr));
                        out.flush();
                        out.close();
                    } catch (IOException e) {
                        System.out.println("������!"); }
                    break;
                case "3":
                    System.out.println("------------------------------------------------------------");
                    System.out.println("3 ���������� ��������");
                    System.out.println("�������� ������ �����:");
                    System.out.println(Arrays.toString(For_sort_arr));
                    mergeSort(For_sort_arr, arr.length);
                    System.out.println("��������������� ������ �����:");
                    System.out.println(Arrays.toString(For_sort_arr));
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
                    LocalDateTime dateTime = LocalDateTime.now();
                    String dt = dateTime.format(formatter);

                   try{
                        File file_SlS = new File(filePath + "\\��������� - ���������� �������� "+dateObject.format(date)+".txt");
                        file_SlS.createNewFile(); //�������� �����
                        PrintWriter out = new PrintWriter(filePath + "\\��������� - ���������� �������� "+dateObject.format(date)+".txt", "UTF8");
                        out.println("------------------------------------------------------------");
                        out.println("���������� ��������");
                        out.println("�������� ������ �����:");
                        out.println(Arrays.toString(arr));
                        out.println("��������������� ������ �����:");
                        out.println(Arrays.toString(For_sort_arr));
                        out.flush();
                        out.close();
                    } catch (IOException e) {
                        System.out.println("������!"); }
                    break;
                case "m":
                    exit = true;
                    break;
                case "q":
                    System.out.println("����� � ������������ ����� ���������� �������� � ����� '����������'");
                    System.out.println("������ ��������� ���������");
                    System.exit(0);
            }
        }
}

//������� ����������
public static void QuickSort(int[] array, int low, int high) {
        if (low >= high)
            return;//��������� ���������� ���� ��� ������ ������
        // ����� �������� ��������
        int middle = low + (high - low) / 2;
        int support_element= array[middle];
        // ���������� �� ��� ����������, ������� ������ � ������ �������� ��������
        int i = low, j = high;
        while (i <= j) {
            while (array[i] < support_element) {
                i++;
            }
            while (array[j] > support_element) {
                j--;
            }
            if (i <= j) {
                int temp = array[i];//������������ ���������
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }
        // ����� �������� ��� ���������� ����� � ������ �����
        if (low < j)
            QuickSort(array, low, j);
        if (high > i)
            QuickSort(array, i, high);
}

//���������� �����
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

//���������� ��������
public static void mergeSort(int[] a, int n) {
        if (n < 2) {
            return;
        }
        int middle = n / 2;// ����� ������� �������� ��������
        int[] left = new int[middle];
        int[] rigth = new int[n - middle];
        //���������� ������� �� ��� ����������
        for (int i = 0; i < middle; i++) {
            left[i] = a[i];
        }
        for (int i = middle; i < n; i++) {
            rigth[i - middle] = a[i];
        }
        mergeSort(left, middle); //���������� ������ ����������
        mergeSort(rigth, n - middle);////���������� ������� ����������
        // �������
        merge(a, left, rigth, middle, n - middle);
}
    // �������
    public static void merge(int[] a, int[] left_arr, int[] right_arr, int left, int right) {
        int i = 0, j = 0, k = 0;

        while (i < left && j < right) {
            //����� �������� ��������
            if (left_arr[i] <= right_arr[j]) {
                a[k++] = left_arr[i++];
            }
            else {
                a[k++] = right_arr[j++];
            }
        }
        //������� ����������� � ���� ����� ������
        while (i < left) {
            a[k++] = left_arr[i++];
        }
        while (j < right) {
            a[k++] = right_arr[j++];
        }
    }
}




