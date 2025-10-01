package dao;

public class DaoImpl implements IDao {

    @Override
    public double getData() {
        System.out.print("En utilisant la base de donnée comme source de données...");

        return 10.0;
    }
}
