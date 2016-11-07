package by.academy.it.loader;

import by.academy.it.db.WorkerDao;
import by.academy.it.db.exceptions.DaoException;
import by.academy.it.pojos.ContractWorker;
import by.academy.it.pojos.RegularWorker;
import by.academy.it.pojos.Worker;
import org.apache.log4j.Logger;

import java.util.Scanner;

/**
 * Created by Dmitry on 11/7/2016.
 */
public class MenuLoaderWorker {
    private static Logger log = Logger.getLogger(MenuLoaderWorker.class);
    public static Boolean needMenu = true;
    private static WorkerDao workerDao = null;

    public static void menuWorker() throws DaoException {
        Worker worker = null;
        while (needMenu) {
            printMenu();
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            switch (choice) {
                case 0:
                    System.exit(0); break;
                case 1:
                    deleteWorker();
                    break;
                case 2:
                    worker = findWorker();
                    break;
                case 3:
                    ContractWorker contractWorker = new ContractWorker();
                    worker = createContractWorker(contractWorker);
                    getWorkerDao().saveOrUpdate(worker);
                    break;
                case 4:
                    RegularWorker regularWorker = new RegularWorker();
                    worker = createRegularWorker(regularWorker);
                    getWorkerDao().saveOrUpdate(worker);
                    break;
                case 5:
                    worker = loadWorker();
                    break;
                case 6:
                    flushSession();
                    break;
                case 7:
                    refreshSession();
                    break;
                default:
                    needMenu = true;
                    break;
            }
            needMenu = true;
        }

    }

    private static void printMenu() {
        System.out.println(" Options:");
        System.out.println("        0. Exit");
        System.out.println("        1. Delete Worker");
        System.out.println("        2. Get Worker");
        System.out.println("        3. Save or Update ContractWorker");
        System.out.println("        4. Save or Update RegularWorker");
        System.out.println("        5. Load Worker");
        System.out.println("        6. Flush Session");
        System.out.println("        7. Refresh Session");
    }

    private static Worker createContractWorker(ContractWorker contractWorker) {
        System.out.println("Please enter worker description:");
        System.out.print("Name - ");

        if(contractWorker == null) {contractWorker = new ContractWorker();}
        Scanner scanner = new Scanner(System.in);
        String parameter = scanner.nextLine();
        contractWorker.setName(parameter);

        System.out.print("Rate Per Hour - ");
        contractWorker.setRatePerHour(scanner.nextDouble());
        System.out.print("Contract duration - ");
        parameter = scanner.nextLine();
        parameter = scanner.nextLine();
        contractWorker.setContractDuration(parameter);
        
        return contractWorker;
    }

    private static Worker createRegularWorker(RegularWorker regularWorker) {
        System.out.println("Please enter worker description:");
        System.out.print("Name - ");

        if(regularWorker == null) {regularWorker = new RegularWorker();}
        Scanner scanner = new Scanner(System.in);
        String parameter = scanner.nextLine();
        regularWorker.setName(parameter);

        System.out.print("Salary - ");
        regularWorker.setSalary(scanner.nextDouble());
        System.out.print("Bonus - ");
        regularWorker.setBonus(scanner.nextInt());

        return regularWorker;
    }


    public static Worker findWorker() {
        System.out.println("Get by Id. Please enter Worker id:");
        System.out.print("Id - ");

        Scanner scanner = new Scanner(System.in);
        Worker worker = null;
        Integer id = scanner.nextInt();
        try {
            worker = getWorkerDao().get(id);
        } catch (DaoException e) {
            log.error(e, e);
        } catch (NullPointerException e) {
            log.error("Unable find worker:", e);
        }
        System.out.print(worker);
        return worker;
    }

    public static boolean deleteWorker() {
        System.out.println("Delete by Id. Please enter Worker id:");
        System.out.print("Id - ");
        Scanner scanner = new Scanner(System.in);
        Worker worker = null;
        Integer id = scanner.nextInt();
        try {
            worker = getWorkerDao().get(id);
            getWorkerDao().delete(worker);
        } catch (DaoException e) {
            log.error(e, e);
        } catch (NullPointerException e) {
            log.error("Unable find worker:", e);
        }
        return true;
    }

    public static Worker loadWorker() {
        System.out.println("Loag by Id. Please enter worker id:");
        System.out.print("Id - ");

        Scanner scanner = new Scanner(System.in);
        Worker worker = null;
        Integer id = scanner.nextInt();
        try {
            worker = getWorkerDao().load(id);
        } catch (DaoException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (NullPointerException e) {
            log.error("Unable find worker:", e);
        }
        System.out.print(worker);
        return worker;
    }


    public static void flushSession() {
        System.out.println("Please enter Worker id:");
        System.out.print("Id - ");
        Scanner scanner = new Scanner(System.in);
        Worker worker = null;
        Integer id = scanner.nextInt();
        System.out.println("Please enter new Name:");
        System.out.print("New Name - ");
        scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        try {
            getWorkerDao().flush(id, name);
        } catch (DaoException e) {
            log.error("Unable run flush example");
        }
    }

    public static void refreshSession() {
        System.out.println("Please enter Worker id:");
        System.out.print("Id - ");
        Scanner scanner = new Scanner(System.in);
        Worker worker = null;
        Integer id = scanner.nextInt();
        System.out.println("Please enter new Name:");
        System.out.print("New Name - ");
        scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        try {
            getWorkerDao().refresh(id, name);
        } catch (DaoException e) {
            log.error("Unable run refresh example");
        }
    }

    public static WorkerDao getWorkerDao() {
        if (workerDao == null) {
            workerDao = new WorkerDao();
        }

        return workerDao;
    }
}
