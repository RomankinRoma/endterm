package composite;

import medCenter.MedCenter;
import visitor.Visitor;

import java.util.List;

public class Nurse implements Worker {
    MedCenter medCenter;
    String fullName;
    Double salary;
    Status status;

    public Nurse() {
    }

    public Nurse(MedCenter medCenter, Status status ,String fullName, Double salary) {
        this.medCenter = medCenter;
        this.fullName = fullName;
        this.salary = salary;
        this.status = status;
    }

    @Override
    public MedCenter medCenter() {
        return medCenter;
    }

    @Override
    public List<Worker> list() {
        return null;
    }

    @Override
    public Boolean isDirectorOrDoctor() {
        return false;
    }

    @Override
    public void accept(Visitor visitor, Double amount) {
        visitor.visitWorker(this,amount);
    }

    @Override
    public void add(Worker component) {

    }

    @Override
    public void remove(Worker component) {

    }

    @Override
    public void setStatus(Status status) {
        this.status=status;
    }

    @Override
    public Double getSalary() {
        return salary;
    }

    @Override
    public void setSalary(Double d) {
        salary=d;
    }

    public MedCenter getMedCenter() {
        return medCenter;
    }

    public void setMedCenter(MedCenter medCenter) {
        this.medCenter = medCenter;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Status getStatus() {
        return status;
    }

    @Override
    public String getFullName() {
        return fullName;
    }

    @Override
    public String toString() {
        return "Full name:"+fullName+" Med. Center:"+medCenter.getName()+" Salary:"+salary;
    }
}
