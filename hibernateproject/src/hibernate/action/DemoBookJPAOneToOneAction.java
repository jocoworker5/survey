package hibernate.action;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import hibernate.model.Book;
import hibernate.model.BookDetail;

public class DemoBookJPAOneToOneAction {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();
            
			Book book = new Book();
			book.setAuthor("羅琳");
			book.setBookname("搶救果大作戰");
			book.setPrice(300);
			BookDetail bookDetail = new BookDetail();
            bookDetail.setPublisher("文化出版社");
            bookDetail.setPublisheraddress("TW");
            
            book.setBookdetail(bookDetail);
            bookDetail.setBook(book);
            
            session.save(book);
            
			session.getTransaction().commit();
		} catch (Exception exception) {
			session.getTransaction().rollback();
			exception.printStackTrace();
		}

		session.close();
		HibernateUtil.closeSessionFactory();
	}

}
