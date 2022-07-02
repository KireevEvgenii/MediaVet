package src;

import src.auth.Authentication;
import src.methods.MethodsOfDoctors;
import src.methods.MethodsOfPatients;
import src.methods.MethodsOfVisits;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int authRes = Authentication.authenticate();
        if (authRes == 0) while (true) {
            System.out.print("""
                    0-Выход
                    1-Создать пациента
                    2-Создать доктора
                    3-Создать прием
                    4-Показать всех пациентов
                    5-Показать все приемы пациента
                    6-Редактировать ФИО пациента
                    7-Редактировать статус приема
                    8-Удалить пациента
                    """);
            switch (scanner.nextInt()) {
                case 0 -> System.exit(0);
                case 1 -> MethodsOfPatients.create();
                case 2 -> MethodsOfDoctors.create();
                case 3 -> MethodsOfVisits.create();
                case 4 -> MethodsOfPatients.showAll();
                case 5 -> MethodsOfVisits.showAllVisitsOfPatient();
                case 6 -> MethodsOfPatients.editName();
                case 7 -> MethodsOfVisits.changeStatus();
                case 8 -> MethodsOfPatients.delete();
            }

        }
        else {
            System.out.println("Неверные данные");
        }
    }
}
