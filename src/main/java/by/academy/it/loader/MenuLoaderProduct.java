package by.academy.it.loader;

import by.academy.it.db.PersonDao;
import by.academy.it.db.ProductDao;
import by.academy.it.db.exceptions.DaoException;
import by.academy.it.pojos.Person;
import by.academy.it.pojos.Product;
import org.apache.log4j.Logger;

import java.util.Scanner;

import static by.academy.it.loader.MenuLoader.findPerson;

/**
 * Created by Dmitry on 11/3/2016.
 */
public class MenuLoaderProduct {
    private static Logger log = Logger.getLogger(MenuLoaderProduct.class);
    public static Boolean needMenu = true;
    private static ProductDao productDao = null;

    public static void menuProduct() throws DaoException {
        Product product = null;
        while (needMenu) {
            printMenu();
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            switch (choice) {
                case 0:
                    System.exit(0); break;
                case 1:
                    deleteProduct();
                    break;
                case 2:
                    product = findProduct();
                    break;
                case 3:
                    product = createProduct(product);
                    getProductDao().saveOrUpdate(product);
                    break;
                case 4:
                    //person = loadPerson();
                    break;
                case 5:
                    //flushSession();
                    break;
                case 6:
                    //refreshSession();
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
        System.out.println("        1. Delete Product");
        System.out.println("        2. Get Product");
        System.out.println("        3. Save or Update Product");
        //System.out.println("        4. Load Product");
        //System.out.println("        5. Flush Session");
        //System.out.println("        6. Refresh Session");
    }

    public static Product createProduct(Product product) {
        System.out.println("Please enter product description:");
        System.out.print("ProductName - ");

        if(product == null) {product = new Product();}
        Scanner scanner = new Scanner(System.in);
        String parameter = scanner.nextLine();
        product.setNameProduct(parameter);
        System.out.print("Price - ");
        product.setPrice(scanner.nextDouble());
        System.out.print("Status product - ");
        parameter = scanner.nextLine();
        parameter = scanner.nextLine();
        product.setStatus(parameter);
//        product.setPersonAddress(new Address());
//        product.getPersonAddress().setCity("Minsk");
//        product.getPersonAddress().setStreet("Gaya");
        return product;
    }

    public static Product findProduct() {
        System.out.println("Get by Id. Please enter product id:");
        System.out.print("Id - ");

        Scanner scanner = new Scanner(System.in);
        Product product = null;
        Long id = scanner.nextLong();
        try {
            product = getProductDao().get(id);
        } catch (DaoException e) {
            log.error(e, e);
        } catch (NullPointerException e) {
            log.error("Unable find product:", e);
        }
        System.out.print(product);
        return product;
    }

    public static boolean deleteProduct() {
        System.out.println("Delete by Id. Please enter product id:");
        System.out.print("Id - ");
        Scanner scanner = new Scanner(System.in);
        Product product = null;
        Integer id = scanner.nextInt();
        try {
            product = getProductDao().get(id);
            getProductDao().delete(product);
        } catch (DaoException e) {
            log.error(e, e);
        } catch (NullPointerException e) {
            log.error("Unable find product:", e);
        }
        return true;
    }

    public static ProductDao getProductDao() {
        if (productDao== null) {
            productDao = new ProductDao();
        }
        return productDao;
    }
}
