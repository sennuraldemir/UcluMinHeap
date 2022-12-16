package minheap;

import java.util.Arrays;
import java.util.Scanner;

public class MinHeap {

    private static boolean minHeap(Integer[] list) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private int[] Heap;
    private int index;
    private int boyut;

    public MinHeap(int boyut) {
        this.boyut = boyut;
        this.index = 0;
        Heap = new int[boyut];
    }
    //root düğümün bulunması
    private int root(int i) {
        return (i - 1) / 3;
    }
    //i düğümünün sol tarafının bulunması 
    private int soltaraf(int i) {
        return (i * 3) + 1;
    }
    //i düğümünün ara tarafının bulunması 
    private int arataraf(int i) {
        return (i * 3) + 2;
    }
    //i düğümünün sağ tarafının bulunması 
    private int sagtaraf(int i) {
        return (i * 3) + 3;
    }
    //yaprak düğümün doluluk oranının kontrolü
    private boolean isLeaf(int i) {
        if (sagtaraf(i) >= boyut || soltaraf(i) >= boyut || arataraf(i) >= boyut) {
            return true;
        }
        return false;
    }

    public void ekle(int element) {
        if (index >= boyut) {
            return;
        }
        Heap[index] = element;
        int current = index;
        
        while (Heap[current] < Heap[root(current)]) {
            swap(current, root(current));//eklenecek eleman şu andaki elemandan daha büyük ise
            current = root(current);
        }
        index++;
    }

    private void minHeapify(int i) {
        // Düğüm yaprak olmayan bir düğüm ise ve alt düğümlerden herhangi biri daha küçük ise:
        if (!isLeaf(i)) {
            //olasılıklara göre swap işlemleri
            if (Heap[i] > Heap[soltaraf(i)] || Heap[i] > Heap[sagtaraf(i)] || Heap[i] > Heap[arataraf(i)]) {

                if (Heap[soltaraf(i)] < Heap[sagtaraf(i)] && Heap[soltaraf(i)] < Heap[arataraf(i)]) {
                    swap(i, soltaraf(i));
                    minHeapify(soltaraf(i));

                } else if (Heap[sagtaraf(i)] < Heap[soltaraf(i)] && Heap[sagtaraf(i)] < Heap[arataraf(i)]) {
                    swap(i, sagtaraf(i));
                    minHeapify(sagtaraf(i));

                } else {
                    swap(i, arataraf(i));
                    minHeapify(arataraf(i));
                }
            }
        }
    }

    
    public void minHeap() {
        for (int i = (index - 1 / 3); i >= 1; i--) {
            minHeapify(i);//minHeapify kullanarak min heap yapısını oluşturma:
        }
    }

    
    public void printHeap() {
        for (int i = 0; i < (index / 3); i++) {
            System.out.print("Parent : " + Heap[i]);
            if (soltaraf(i) < index) {
                System.out.print(" , Left : " + Heap[soltaraf(i)]);
            }
            if (arataraf(i) < index) {
                System.out.print(" , Midle :" + Heap[arataraf(i)]);
            }
            if (sagtaraf(i) < index) {
                System.out.print(" , Right :" + Heap[sagtaraf(i)]);
            }

            System.out.println();
        }
    }

    private void swap(int x, int y) {
        int tmp;
        tmp = Heap[x];
        Heap[x] = Heap[y];
        Heap[y] = tmp;
    }

    public static void main(String[] arg) {

        System.out.println("Dizinin değerlerini giriniz:");
        String dizi = scanner.nextLine();

        String[] temp = dizi.split(",");
        Integer[] list = new Integer[temp.length];

        for (int i = 0; i < temp.length; i++) {
            list[i] = Integer.valueOf(temp[i]);
        }

        if (minHeap(list)) {
            System.out.println("verilen sayılar Üçlü min heap degerlerini saglıyor.");
        } else {
            System.out.println("verilen sayılar Üçlü min heap tanımına uymuyor.");
            list = minHeap(list);

            System.out.print("dizinin min heap hali: ");
            for (Integer i = 0; i < list.length - 1; i++) {
                System.out.print(list[i] + ",");
            }
            System.out.print(list[list.length - 1]);
            System.out.println();
        }

        System.out.println("The Min Heap is : " + Arrays.toString(minHeap.Heap));
        minHeap.printHeap();

    }
}
