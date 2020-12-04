package composite;

import medCenter.MedCenter;
import visitor.Visitor;

import java.util.ArrayList;
import java.util.List;

public class Director implements Worker {
    MedCenter medCenter;
    Status status;
    List<Worker> workers;
    String fullName;
    Double salary;

    public Director() {
        workers=new ArrayList<>();
    }

    public Director(MedCenter medCenter, Status status, String fullName, Double salary) {
        this.medCenter = medCenter;
        this.status = status;
        this.workers=new ArrayList<>();
        this.fullName = fullName;
        this.salary = salary;
    }

    public MedCenter getMedCenter() {
        return medCenter;
    }

    public void setMedCenter(MedCenter medCenter) {
        this.medCenter = medCenter;
    }

    public Status getStatus() {
        return status;
    }

    @Override
    public void setStatus(Status status) {
        this.status = status;
    }

    public List<Worker> getWorkers() {
        return workers;
    }

    public void setWorkers(List<Worker> workers) {
        this.workers = workers;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public Double getSalary() {
        return salary;
    }

    @Override
    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public MedCenter medCenter() {
        return medCenter;
    }

    @Override
    public List<Worker> list() {
        return workers;
    }


    @Override
    public Boolean isDirectorOrDoctor() {
        return true;
    }

    @Override
    public void accept(Visitor visitor, Double amount) {
        visitor.visitWorker(this,amount);
    }

    @Override
    public void add(Worker worker) {
        workers.add(worker);
    }

    @Override
    public void remove(Worker worker) {
        workers.remove(worker);
    }

    @Override
    public String toString() {
        return "Full name:"+fullName+" Med. Center:"+medCenter.getName()+" Salary:"+salary+" Position:"+status.toString();
    }
}
