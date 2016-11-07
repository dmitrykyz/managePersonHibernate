/*
 * Copyright (c) 2012 by VeriFone, Inc.
 * All Rights Reserved.
 *
 * THIS FILE CONTAINS PROPRIETARY AND CONFIDENTIAL INFORMATION
 * AND REMAINS THE UNPUBLISHED PROPERTY OF VERIFONE, INC.
 *
 * Use, disclosure, or reproduction is prohibited
 * without prior written approval from VeriFone, Inc.
 */
package by.academy.it.loader;

import by.academy.it.db.PersonDao;
import by.academy.it.db.exceptions.DaoException;
import by.academy.it.pojos.Address;
import by.academy.it.pojos.Emploeer;
import by.academy.it.pojos.Person;
import by.academy.it.pojos.Student;
import org.apache.log4j.Logger;

import java.util.Scanner;

/**
 * User: yslabko
 * Date: 14.04.14
 * Time: 12:28
 */
public class MenuLoader {
    private static Logger log = Logger.getLogger(MenuLoader.class);
    public static Boolean needMenu = true;
    private static PersonDao personDao = null;

    public static void menu() throws DaoException {
        Person person = null;
        while (needMenu) {
            printMenu();
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            switch (choice) {
                case 0:
                    System.exit(0); break;
                case 1:
                    deletePerson();
                    break;
                case 2:
                    person = findPerson();
                    break;
                case 3:
                    person = createPerson(person);
                    getPersonDao().saveOrUpdate(person);
                    break;
                case 4:
                    Emploeer emploeer = new Emploeer();
                    person = createEmploeer(emploeer);
                    getPersonDao().saveOrUpdate(person);
                    break;
                case 5:
                    Student student = new Student();
                    person = createStudent(student);
                    getPersonDao().saveOrUpdate(person);
                    break;
                case 6:
                    person = loadPerson();
                    break;
                case 7:
                    flushSession();
                    break;
                case 8:
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
        System.out.println("        1. Delete Person");
        System.out.println("        2. Get Person");
        System.out.println("        3. Save or Update Person");
        System.out.println("        4. Save or Update Employeer");
        System.out.println("        5. Save or Update Student");
        System.out.println("        6. Load Person");
        System.out.println("        7. Flush Session");
        System.out.println("        8. Refresh Session");
    }

    public static Person createPerson(Person person) {
        System.out.println("Please enter person description:");
        System.out.print("Name - ");

        if(person == null) {person = new Person();}
        Scanner scanner = new Scanner(System.in);
        String parameter = scanner.nextLine();
        person.setName(parameter);
        System.out.print("Surname - ");
        parameter = scanner.nextLine();
        person.setSurname(parameter);
        System.out.print("Age - ");
        person.setAge(scanner.nextInt());

        Address address = new Address();
        System.out.print("City - ");
        parameter = scanner.nextLine();
        parameter = scanner.nextLine();
        address.setCity(parameter);
        System.out.print("Street - ");
        parameter = scanner.nextLine();
        address.setStreet(parameter);
        System.out.print("ZipCode - ");
        parameter = scanner.nextLine();
        address.setZipCode(parameter);
        person.setAddress(address);

//        person.setPersonAddress(new Address());
//        person.getPersonAddress().setCity("Minsk");
//        person.getPersonAddress().setStreet("Gaya");
        return person;
    }

    private static Person createEmploeer(Emploeer emploeer) {
        System.out.println("Please enter person description:");
        System.out.print("Name - ");

        if(emploeer == null) {emploeer = new Emploeer();}
        Scanner scanner = new Scanner(System.in);
        String parameter = scanner.nextLine();
        emploeer.setName(parameter);
        System.out.print("Surname - ");
        parameter = scanner.nextLine();
        emploeer.setSurname(parameter);
        System.out.print("Age - ");
        emploeer.setAge(scanner.nextInt());

        Address address = new Address();
        System.out.print("City - ");
        parameter = scanner.nextLine();
        parameter = scanner.nextLine();
        address.setCity(parameter);
        System.out.print("Street - ");
        parameter = scanner.nextLine();
        address.setStreet(parameter);
        System.out.print("ZipCode - ");
        parameter = scanner.nextLine();
        address.setZipCode(parameter);
        emploeer.setAddress(address);

        System.out.print("Company - ");
        parameter = scanner.nextLine();
        emploeer.setCompany(parameter);
        System.out.print("Salary - ");
        emploeer.setSalary(scanner.nextDouble());
        return emploeer;
    }

    private static Person createStudent(Student student) {
        System.out.println("Please enter person description:");
        System.out.print("Name - ");

        if(student == null) {student = new Student();}
        Scanner scanner = new Scanner(System.in);
        String parameter = scanner.nextLine();
        student.setName(parameter);
        System.out.print("Surname - ");
        parameter = scanner.nextLine();
        student.setSurname(parameter);
        System.out.print("Age - ");
        student.setAge(scanner.nextInt());

        Address address = new Address();
        System.out.print("City - ");
        parameter = scanner.nextLine();
        parameter = scanner.nextLine();
        address.setCity(parameter);
        System.out.print("Street - ");
        parameter = scanner.nextLine();
        address.setStreet(parameter);
        System.out.print("ZipCode - ");
        parameter = scanner.nextLine();
        address.setZipCode(parameter);
        student.setAddress(address);

        System.out.print("Faculty - ");
        parameter = scanner.nextLine();
        student.setFaculty(parameter);
        System.out.print("Mark - ");
        student.setMark(scanner.nextDouble());
        return student;
    }

    public static Person findPerson() {
        System.out.println("Get by Id. Please enter person id:");
        System.out.print("Id - ");

        Scanner scanner = new Scanner(System.in);
        Person person = null;
        Integer id = scanner.nextInt();
        try {
            person = getPersonDao().get(id);
        } catch (DaoException e) {
            log.error(e, e);
        } catch (NullPointerException e) {
            log.error("Unable find person:", e);
        }
        System.out.print(person);
        return person;
    }

    public static boolean deletePerson() {
        System.out.println("Delete by Id. Please enter person id:");
        System.out.print("Id - ");
        Scanner scanner = new Scanner(System.in);
        Person person = null;
        Integer id = scanner.nextInt();
        try {
            person = getPersonDao().get(id);
            getPersonDao().delete(person);
        } catch (DaoException e) {
            log.error(e, e);
        } catch (NullPointerException e) {
            log.error("Unable find person:", e);
        }
        return true;
    }

    public static Person loadPerson() {
        System.out.println("Loag by Id. Please enter person id:");
        System.out.print("Id - ");

        Scanner scanner = new Scanner(System.in);
        Person person = null;
        Integer id = scanner.nextInt();
        try {
            person = getPersonDao().load(id);
        } catch (DaoException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (NullPointerException e) {
            log.error("Unable find person:", e);
        }
        System.out.print(person);
        return person;
    }

    public static void flushSession() {
        System.out.println("Please enter person id:");
        System.out.print("Id - ");
        Scanner scanner = new Scanner(System.in);
        Person person = null;
        Integer id = scanner.nextInt();
        System.out.println("Please enter new Name:");
        System.out.print("New Name - ");
        scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        try {
            getPersonDao().flush(id, name);
        } catch (DaoException e) {
            log.error("Unable run flush example");
        }
    }

    public static void refreshSession() {
        System.out.println("Please enter person id:");
        System.out.print("Id - ");
        Scanner scanner = new Scanner(System.in);
        Person person = null;
        Integer id = scanner.nextInt();
        System.out.println("Please enter new Name:");
        System.out.print("New Name - ");
        scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        try {
            getPersonDao().refresh(id, name);
        } catch (DaoException e) {
            log.error("Unable run refresh example");
        }
    }

    public static PersonDao getPersonDao() {
        if (personDao == null) {
            personDao = new PersonDao();
        }

        return personDao;
    }

}
