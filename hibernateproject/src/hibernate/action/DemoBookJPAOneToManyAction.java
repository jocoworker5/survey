package hibernate.action;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import hibernate.model.Stock;
import hibernate.model.StockTransaction;

public class DemoBookJPAOneToManyAction {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();
            
            Stock stock = new Stock();
            stock.setStockname("台積電");
            stock.setStockcode("2330");
            
            StockTransaction trans1= new StockTransaction();
            trans1.setTradevolume(10);    
            StockTransaction trans2= new StockTransaction();
            trans2.setTradevolume(20);
            StockTransaction trans3= new StockTransaction();
            trans3.setTradevolume(20);
            
            trans1.setStock(stock);
            trans2.setStock(stock);
            trans3.setStock(stock);

            Set<StockTransaction> stockTransactions = stock.getStockTransactions();
            stockTransactions.add(trans1);
            stockTransactions.add(trans2);
            stockTransactions.add(trans3);
            stock.setStockTransactions(stockTransactions);
            session.save(stock);
			session.getTransaction().commit();
		} catch (Exception exception) {
			session.getTransaction().rollback();
			exception.printStackTrace();
		}

		session.close();
		HibernateUtil.closeSessionFactory();
	}

}
