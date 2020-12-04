package facade;

import builder.OrderFactory;
import composite.*;
import medCenter.ASAP;
import medCenter.MedCenter;
import medCenter.SNAKE;
import observable.MedCenterPublisher;
import observable.Publisher;
import observable.User;
import visitor.Visitor;
import visitor.VisitorImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CRMFacade {
    private Director director;
    private List<MedCenter> medCenters;
    Scanner in = new Scanner(System.in);

    public CRMFacade(Director drktr) {
        medCenters = new ArrayList<>();
        medCenters.add(new ASAP());
        medCenters.add(new SNAKE());
        director = drktr;
    }

    public void addWorkerToCompany() {
        System.out.print("Input full name:");
        String fullName ;
        fullName = in.nextLine();
        fullName = in.nextLine();
        System.out.println("Choose id of medical center:");
        MedCenter medicalCenter = null;
        for (MedCenter medCenter : medCenters) {
            System.out.println("ID:" + medCenter.getId() + "     Name:" + medCenter.getName() + "    Address:" + medCenter.getAddress());
        }
        Integer medID = in.nextInt();
        for (MedCenter medC : medCenters) {
            if (medC.getId().equals(medID)) {
                medicalCenter = medC;
            }
        }
        System.out.println("Input salary:");
        Double salary = in.nextDouble();
        System.out.println("Choose position:");
        System.out.println("1.Doctor");
        System.out.println("2.Nurse");
        int statusId = in.nextInt();
        Status status1 = statusId == 1 ? Status.DOCTOR : Status.NURSE;
        Worker worker = statusId == 1 ? new Doc(medicalCenter, status1, fullName, salary) : new Nurse(medicalCenter, status1, fullName, salary);
        director.add(worker);
        System.out.println("Successful");
    }

    public void removeWorker(String fullName, Worker worker) {
        for (Worker workr : worker.list()) {
            if (workr.getFullName().equals(fullName)) {
                System.out.println("Successful");
                worker.list().remove(workr);
                return;
            }
            if (workr.isDirectorOrDoctor()) {
                removeWorker(fullName, workr);
            }
        }
    }


    public Worker findWorker(String fullName, Worker worker) {
        for (Worker workr : worker.list()) {
            if (workr.getFullName().equals(fullName))
                return workr;
            if (workr.isDirectorOrDoctor()) {
                findWorker(fullName, workr);
            }
        }
        return null;
    }

    public void changeSalary(String s) {
        System.out.println("1.Increase");
        System.out.println("2.Decrease");
        int inDe = in.nextInt();
        Double i = inDe == 1 ? 1.0 : -1.0;
        System.out.println("Input amount:");
        Double amount = in.nextDouble();
        amount*=i;
        Worker worker = findWorker(s, director);
        Visitor visitor = new VisitorImpl();
        if (worker != null) {
            {
                worker.accept(visitor, amount);
                System.out.println("Successful");
            }
        }
    }

    public void workerList(Worker worker) {
        if (worker.getStatus().equals(Status.DIRECTOR)){
            System.out.println(worker.toString());
        }
        for (Worker workr : worker.list()) {
            System.out.println(workr.toString());
            if (workr.isDirectorOrDoctor()) {
                workerList(workr);
            }
        }
    }

    public void assignWorker(String junior, String senior) {
        Worker worker = findWorker(junior, director);
        if (worker != null) {
            director.getWorkers().remove(worker);
            if (findWorker(senior, director) != null) {
                findWorker(senior, director).list().add(worker);
                System.out.println("Successful");
            }else {
                System.out.println("404");
            }
        }
    }
}
