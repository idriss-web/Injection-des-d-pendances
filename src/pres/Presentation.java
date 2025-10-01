package pres;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.lang.reflect.Constructor;
import metier.IMetier;
import dao.IDao;
import java.io.File;

public class Presentation {
    public static void main(String[] args) throws FileNotFoundException {
        try {
            Scanner scanner = new Scanner(new File("config.txt"));
            String daoClassName = scanner.next();
            String metierClassName = scanner.next();
            scanner.close();

            Class cdao = Class.forName(daoClassName);
            IDao dao = (IDao) cdao.newInstance();

            Class cmetier = Class.forName(metierClassName);
            Constructor constructor = cmetier.getConstructor(IDao.class);
            IMetier metier = (IMetier) constructor.newInstance(dao);

            System.out.println(metier.calcul());

        } catch (Exception e ) {
            System.out.println("Une erreur est survenue !");
        }
    }
}
