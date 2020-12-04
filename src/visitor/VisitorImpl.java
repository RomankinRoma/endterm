package visitor;

import composite.Worker;
import composite.Status;

public class VisitorImpl implements Visitor {
    @Override
    public void visitWorker(Worker worker, Double amount) {
        worker.setSalary(worker.getSalary()+amount);
    }
}
