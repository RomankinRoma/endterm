package composite;

import medCenter.MedCenter;
import visitor.Visitor;

import java.util.ArrayList;
import java.util.List;

public class Doc implements Worker {
    MedCenter medCenter;
    Status status;
    List<Worker> workers;
    String fullName;
    Double salary;

    public Doc() {
        workers=new ArrayList<>();
    }

    public Doc(MedCenter medCenter, Status status, String fullName, Double amount) {
        this.medCenter = medCenter;
        this.status = status;
        this.workers = new ArrayList<>();
        this.fullName = fullName;
        this.salary = amount;
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

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public Double getSalary() {
        return this.salary;
    }

    @Override
    public void setSalary(Double d) {
        this.salary=d;
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
        return "Full name:"+fullName+" Med. Center:"+medCenter.getName()+" Salary:"+salary;
    }
}
