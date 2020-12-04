package composite;

import medCenter.MedCenter;
import visitor.Visitor;

import java.util.List;

public interface Worker {

    MedCenter medCenter();

    String toString();

    List<Worker> list();

    Boolean isDirectorOrDoctor();

    void accept(Visitor visitor, Double amount);

    void add(Worker component);

    void remove(Worker component);

    void setStatus(Status status);

    Double getSalary();

    void setSalary(Double d);

    String getFullName();

    Status getStatus();
}
