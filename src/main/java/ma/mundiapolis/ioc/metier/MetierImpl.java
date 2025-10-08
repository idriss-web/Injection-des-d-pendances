package ma.mundiapolis.ioc.metier;

import ma.mundiapolis.ioc.dao.IDao;

public class MetierImpl implements IMetier {
    private IDao dao;

    public MetierImpl(IDao dao) {
        this.dao = dao;
    }

    @Override
    public double calcul() {
        double data = dao.getData();
        return data * 100;
    }
}
