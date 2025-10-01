package dao;

public class DaoImpl2 implements IDao {

    @Override
    public double getData() {
        System.out.print("En utilisant le WB ( Web Service ) comme source de données...");

        return 10.0;
    }
}
