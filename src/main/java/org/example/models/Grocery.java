package org.example.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Grocery {

    // Pazar arabası listesi (statik)
    public static List<String> groceryList = new ArrayList<>();

    // 1️⃣ Listeye ürün ekleme
    public static void addItems(String input) {
        String[] items = input.split(",");
        for (String item : items) {
            String trimmedItem = item.trim();
            if (!checkItemIsInList(trimmedItem)) {   // tekrar kontrolü
                groceryList.add(trimmedItem);
                System.out.println(trimmedItem + " listeye eklendi.");
            } else {
                System.out.println(trimmedItem + " zaten listede var, tekrar eklenmedi.");
            }
        }
        sortList(); // her eklemeden sonra listeyi sırala
    }

    // 2️⃣ Listeden ürün çıkarma
    public static void removeItems(String input) {
        String[] items = input.split(",");
        for (String item : items) {
            String trimmedItem = item.trim();
            if (checkItemIsInList(trimmedItem)) {
                groceryList.remove(trimmedItem);
                System.out.println(trimmedItem + " listeden silindi.");
            } else {
                System.out.println(trimmedItem + " listede bulunamadı.");
            }
        }
        sortList(); // her silmeden sonra listeyi sırala
    }

    // 3️⃣ Ürünün listede olup olmadığını kontrol et
    public static boolean checkItemIsInList(String product) {
        return groceryList.contains(product);
    }

    // 4️⃣ Listeyi alfabetik sırayla ekrana bas
    public static void printSorted() {
        sortList(); // listeyi sırala
        System.out.println("Sıralı Liste: " + groceryList);
    }

    // Listeyi alfabetik olarak sırala (internal kullanım)
    private static void sortList() {
        Collections.sort(groceryList);
    }

    // Konsol menüsü
    public static void startGrocery() {
        Scanner scanner = new Scanner(System.in);
        int choice = -1;

        System.out.println("=== Pazar Arabası Uygulaması ===");

        while (choice != 0) {
            System.out.println("\n1 - Ürün Ekle");
            System.out.println("2 - Ürün Sil");
            System.out.println("0 - Çıkış");
            System.out.print("Seçiminiz: ");

            String line = scanner.nextLine();

            if (line.equals("0") || line.equals("1") || line.equals("2")) {
                choice = Integer.parseInt(line);
            } else {
                choice = -1;
            }

            if (choice == 1) {
                System.out.print("Eklemek istediğiniz ürün(leri) giriniz (virgülle ayırabilirsiniz): ");
                String input = scanner.nextLine();
                addItems(input);
            }
            else if (choice == 2) {
                System.out.print("Çıkarmak istediğiniz ürün(leri) giriniz (virgülle ayırabilirsiniz): ");
                String input = scanner.nextLine();
                removeItems(input);
            }
            else if (choice == 0) {
                System.out.println("Uygulamadan çıkılıyor...");
            }
            else {
                System.out.println("Geçersiz seçim! 0, 1 veya 2 giriniz.");
            }

            printSorted(); // her işlem sonrası listeyi göster
        }

        scanner.close();
    }
}
