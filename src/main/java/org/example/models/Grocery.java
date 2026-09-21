package org.example.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Grocery {
  public static ArrayList<String> groceryList = new ArrayList<>();

  public static void startGrocery(){
      Scanner scanner = new Scanner(System.in);

      boolean running = true;

      while (running){
          System.out.println("0 - Çıkış");
          System.out.println("1 - Eleman Ekle");
          System.out.println("2 - Eleman Çıkar");

          int choice = scanner.nextInt();
          scanner.nextLine();

          switch (choice){
              case 0:
                  running = false;
                  break;
              case 1:
                  System.out.println("Eklenmesini istediğiniz elemanları giriniz:");
                  String addInput = scanner.nextLine();
                  addItems(addInput);
                  break;
              case 2:
                  System.out.println("Çıkarılmasını istediğiniz elemanları giriniz:");
                  String removeInput = scanner.nextLine();
                  removeItems(removeInput);
                  break;
              default:
                  System.out.println("Geçersiz seçim.");
          }
      }


  }

    public static void addItems(String input) {
        String[] items = input.split(",");

        for (String item : items) {
            item = item.trim();

            if (!checkItemIsInList(item)) {
                groceryList.add(item);
            }
        }

        printSorted();
    }

    public static void removeItems(String input){
      String[] items = input.split(",");

      for(String item: items){
          item = item.trim();

          if (checkItemIsInList(item)){
              groceryList.remove(item);
          }
      }
      printSorted();
    }

    public static boolean checkItemIsInList(String product){
        return groceryList.contains(product);
  }
  public static void printSorted(){
      Collections.sort(groceryList);
      System.out.println(groceryList);
  }
}
