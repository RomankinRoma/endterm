import builder.Order;
import composite.Director;
import composite.Doc;
import composite.Status;
import composite.Worker;
import facade.CRMFacade;
import medCenter.ASAP;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CRM {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Integer chose=-1;
        List<Order> orderList=new ArrayList<>();

        Director director=new Director(new ASAP(), Status.DIRECTOR,"Someone Someone",500000.0);
        Doc doc=new Doc(new ASAP(),Status.DOCTOR,"Amanov Rakhmatulla",50000.0);
        director.add(doc);
        CRMFacade crmFacade=new CRMFacade(director);
        while (chose!=0){
            System.out.println("");
            System.out.println("1.Add worker to company");
            System.out.println("2.Find worker");
            System.out.println("3.Fire worker");
            System.out.println("4.All workers");
            System.out.println("5.Assign worker");
            System.out.println("6.Change salary ");
            System.out.println("7.Get order");
            System.out.println("0.Exit");
            chose=in.nextInt();
            switch (chose){
                case 1:
                    crmFacade.addWorkerToCompany();
                    break;
                case 2:
                    System.out.println("Input full name of worker:");
                    String s=in.nextLine();
                    s=in.nextLine();
                    Worker worker=crmFacade.findWorker(s,director);
                    System.out.println(worker!=null?worker.toString():"Worker not found");
                    break;
                case 3:
                    System.out.println("Input full name of worker:");
                    s=in.nextLine();
                    s=in.nextLine();
                    crmFacade.removeWorker(s,director);
                    break;
                case 4:
                    crmFacade.workerList(director);
                    break;
                case 5:
                    System.out.println("Input full name of senior:");
                    String senior=in.nextLine();
                    senior=in.nextLine();
                    System.out.println("Input full name of junior:");
                    String junior=in.nextLine();
                    crmFacade.assignWorker(junior,senior);
                    break;
                case 6:
                    System.out.println("Input full name of worker:");
                    s=in.nextLine();
                    s=in.nextLine();
                    crmFacade.changeSalary(s);
                    break;
                case 7:
                    crmFacade.getOrder(orderList);
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Incorrect choise!");
                    break;

            }
        }
    }
}
