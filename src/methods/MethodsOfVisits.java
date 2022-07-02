package src.methods;

import src.models.Visit;
import src.storage.DataStorage;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;


public class MethodsOfVisits {
    public static void create(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите ФИО пациента: ");
        String patientFullName = scanner.nextLine();
        System.out.print("Введите дату(yyyy-MM-dd): ");
        String sDate = scanner.nextLine();
        System.out.print("Введите ФИО доктора: ");
        String doctorFullName = scanner.nextLine();
        String status = "Новый";
        AtomicBoolean isPatientExist = new AtomicBoolean(false);
        AtomicBoolean isDoctorExist = new AtomicBoolean(false);
        DataStorage.patients.forEach(a -> {
            if (a.getFullName().equals(patientFullName))
                isPatientExist.set(true);}
            );
        DataStorage.doctors.forEach(a -> {
            if (a.getFullName().equals(doctorFullName))
                isDoctorExist.set(true);}
        );

        if(isPatientExist.get() == true && isDoctorExist.get()==true){
            try
            {Date regDate = new SimpleDateFormat("yyyy-MM-dd").parse(sDate);
                Visit visit = new Visit(patientFullName,doctorFullName, regDate, status);
                DataStorage.visits.add(visit);
                System.out.print("Прием создан\n");
            } catch (Exception exception) {}
        }
        else {
            System.out.print("Доктор или пациент не существует\n");
        }
    }
    public static void showAllVisitsOfPatient() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите ФИО: ");
        String patientFullName = scanner.nextLine();
        System.out.println("Приемы " + patientFullName + ":");
        DataStorage.visits.forEach(a -> {
            if (a.getPatientFullName().equals(patientFullName)){
                System.out.println("ID:" + a.getId());
                System.out.println("Дата регистрации:" + a.getRegDate());
                System.out.println("Статус:" + a.getStatus());
                System.out.println("Доктор:" + a.getDoctorFullName());
            }
        });
    }
    public static void  changeStatus(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите id приема: ");
        UUID visitId = UUID.fromString(scanner.nextLine());
        System.out.print("Задайте новый статус(новый, в процессе, отменен, ожидает оплаты, завершен)\n");
        String newStatus = scanner.nextLine();
        if (newStatus.equals("новый") || newStatus.equals("в процессе") || newStatus.equals("отменен") || newStatus.equals("ожидает оплаты") || newStatus.equals("завершен")){
            DataStorage.visits.stream().filter(a -> a.getId().equals(visitId)).findFirst().get().setStatus(newStatus);
        }
        else {
            System.out.print("Некорретный статус");
        }
    }
}
