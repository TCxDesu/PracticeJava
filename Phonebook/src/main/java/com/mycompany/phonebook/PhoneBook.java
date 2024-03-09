package com.mycompany.phonebook;

import java.util.Scanner;

public class PhoneBook {
//masyado kang maraming global/instance variable ahahahahha
//checked by: Luke Asher
    
    Scanner in = new Scanner(System.in);
    String name = "", number = "", choice = "";
    int terminator = 0;
    boolean nameStart = true, numberStart = true, showPhoneBook = true;
    String[][] phoneBook = {
        {"09548732435", "John Lloyd"},
        {"09548289454", "Ericka Gaspar"},
        {"09128475032", "Karl De Leon"},
        {"", ""},
        {"", ""}
    };

    public PhoneBook() {
        showPhoneBook();

        while (true) {
            //di nag rereset ung boolean kaya nagiging limited sa 1 input si user
            numberStart = true;
            nameStart = true;
            choice = in.nextLine().toUpperCase();

            //pinahirapan mo masyado sarili mo sa switch case
            if (choice.trim().equals("A")) {
                if (terminator != 2) {
                    while (nameStart) {
                        System.out.print("Enter name >>: ");
                        name = in.nextLine();

                        if (name.trim().equals("")) {
                            System.out.println("Name must not be blank.");
                        } else {
                            nameStart = false;
                        }
                    }
                    while (numberStart) {
                        System.out.print("Enter number >>: ");
                        number = in.nextLine();

                        //ung pang check mo since checheck mo lng din naman kung
                        //less than or greater than 11 edi != 11 nalang
                        if (number.length() != 11) {
                            System.out.println("Number must only be 11 Digits.");
                        } else {
                            numberStart = false;
                            addToPhoneBook(number, name);
                            System.out.println("==============================================");
                            System.out.println("\t\t UPDATED");
                            //terminator kung tama pagka alala ko di nag uupdate
                            terminator++;
                            showPhoneBook();
                        }

                    }

                } else {
                    System.out.println("Phone book is already full");
                    System.out.print("Your choice >>: ");
                }
            } else if (choice.trim().equals("E")) {
                System.out.println("Closing Phone Book");
                break;
            } else {
                System.out.println("Enter from choices only.");
                System.out.print("Your choice >>: ");
            }
        }
    }

    public void showPhoneBook() {
        int flag = 0;

        System.out.println("==============================================");
        System.out.println("\t\tPHONE BOOK");
        System.out.println("==============================================");
        System.out.println("\tNUMBERS \t | \t NAME");
        System.out.println("==============================================");
        for (int i = 0; i < phoneBook.length; i++) {
            if (flag == 0) {
                for (int j = 0; j < phoneBook[0].length; j++) {
                    if (phoneBook[i][j].trim().equals("")) {
                        flag = 1;
                        break;
                    } else if (j == 0) {
                        System.out.print("[" + (i + 1) + "]     ");
                        System.out.print(phoneBook[i][j] + "\t\t");
                    } else {
                        flag = 0;
                        System.out.print(phoneBook[i][j] + "\t\t");
                    }
                }
                
                //di ganto ginawa nmin knina pero medyo similar
                if (flag == 0) {
                    System.out.println("");
                } else {
                    break;
                }
            }

        }
        System.out.println("==============================================");
        System.out.println("OPTIONS:");
        System.out.print("[A]dd\n[E]xit\nYour choice >>: ");
    }

    public void addToPhoneBook(String num, String name) {
        int flag = 0;
//yep
        for (int i = 0; i < phoneBook.length; i++) {
            for (int j = 0; j < phoneBook[0].length; j++) {
                if (phoneBook[i][j].equals("")) {
                    if (j == 0) {
                        phoneBook[i][j] = num.trim();
                    } else {
                        phoneBook[i][j] = name.trim();
                        flag = 1;
                    }
                }
            }
            if (flag == 1) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        PhoneBook p = new PhoneBook();
    }
}
