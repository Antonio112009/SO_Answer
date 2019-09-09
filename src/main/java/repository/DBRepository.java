package repository;

import config.HibernateUtil;
import entity.DBEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class DBRepository {

    private Transaction transaction = null;
    private Session session = null;


    public void saveData(DBEntity applicationRecruit) {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            session.saveOrUpdate(applicationRecruit);

            transaction.commit();

            session.clear();
            session.close();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }


    public List<DBEntity> getAllData(){
        List<DBEntity> list = new ArrayList<>();
        try {

            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            TypedQuery<DBEntity> query = session.createQuery("from DBEntity dbe", DBEntity.class);
            list = query.getResultList();

            session.clear();
            session.close();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return list;
    }
}
