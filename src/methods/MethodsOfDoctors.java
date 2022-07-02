package src.methods;

import src.storage.DataStorage;
import src.models.Doctor;

import java.util.Scanner;

public class MethodsOfDoctors {
    public static void create(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите ФИО: ");
        String fullName = scanner.nextLine();
        DataStorage.doctors.add(new Doctor(fullName));
        System.out.println("Доктор добавлен");
    }
}
