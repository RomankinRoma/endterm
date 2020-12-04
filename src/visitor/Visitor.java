package visitor;

import composite.Worker;

public interface Visitor {
    void visitWorker(Worker worker, Double amount);
}
