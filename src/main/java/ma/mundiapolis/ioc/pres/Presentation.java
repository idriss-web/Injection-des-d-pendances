package ma.mundiapolis.ioc.pres;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.lang.reflect.Constructor;
import ma.mundiapolis.ioc.metier.IMetier;
import ma.mundiapolis.ioc.dao.IDao;

public class Presentation {
    public static void main(String[] args) throws FileNotFoundException {
        try {
            Scanner scanner = new Scanner(new File("config.txt"));
            String daoClassName = scanner.next();
            String metierClassName = scanner.next();
            scanner.close();

            Class<?> cdao = Class.forName(daoClassName);
            IDao dao = (IDao) cdao.getDeclaredConstructor().newInstance();

            Class<?> cmetier = Class.forName(metierClassName);
            Constructor<?> constructor = cmetier.getConstructor(IDao.class);
            IMetier metier = (IMetier) constructor.newInstance(dao);

            System.out.println("Résultat = " + metier.calcul());
        } catch (Exception e) {

            System.out.println(e.toString());
        }
    }
}
