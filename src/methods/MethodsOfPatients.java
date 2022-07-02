package src.methods;

import src.models.Patient;
import src.storage.DataStorage;

import java.util.Date;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.UUID;

public class MethodsOfPatients {
    public static void create(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите ФИО:");
        String fullName = scanner.nextLine();
        System.out.print("Введите дату(yyyy-MM-dd): ");
        String sDate = scanner.nextLine();
        try{
            Date regDate = new SimpleDateFormat("yyyy-MM-dd").parse("2020-07-30");
            DataStorage.patients.add(new Patient(fullName, regDate));
        }
        catch (Exception ex){}
        System.out.println("Пациент добавлен!");

    }
    public static void showAll(){
        if (DataStorage.patients.isEmpty()) {
            System.out.println("Список пуст");
            return;
        }
        DataStorage.patients.forEach(p -> {
                    System.out.printf("ID: %s\nФИО: %s\nДата регистрации: %s", p.getId(), p.getFullName(), p.getRegDate());
                    System.out.println("\n");
                }
        );

    }
    public static void delete(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите id пациента подлежащего удалению: ");
        UUID patientId = UUID.fromString(scanner.nextLine());
        DataStorage.patients.removeIf(p -> p.getId().equals(patientId));
        System.out.println("Пациент удален!");

    }
    public static void editName(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите id пациента подлежащего редактированию: ");
        UUID patientId = UUID.fromString(scanner.nextLine());
        Patient patient = DataStorage.patients.stream().filter(p -> p.getId().equals(patientId)).findFirst().get();
        System.out.print("Введите новые ФИО: ");
        String fullName = scanner.nextLine();
        patient.setFullName(fullName);
    }
}
