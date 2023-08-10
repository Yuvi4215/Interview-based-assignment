package in.ineuron.Persistance;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.DTO.Products;
import in.ineuron.Util.HibernateUtil;

public class ProductsDaoImpl implements IProductsDao {
	private static Session session = HibernateUtil.getSession();

	@Override
	public String addProduct(Products product) {
		Transaction transaction =null;
		boolean flag=false;
		try {
			if (session != null) {
				transaction = session.beginTransaction();
			}
			if (transaction != null) {
				session.save(product);
				flag=true;
			}
		} catch (HibernateException e) {
		}finally {
			if (flag) {
				transaction.commit();
				return "success";
			} else {
				if (transaction!=null) {
					transaction.rollback();
				} else {
					System.out.println("Transaction is null :::::");
				}
			}
		}
		return "failled";
	}

	@Override
	public String deleteProduct(int serialNo) {
		Transaction transaction=null;
		Products product=null;
		boolean flag=false;
		try {
			if (session != null) {
				transaction=session.beginTransaction();
			}if (transaction != null) {
				product = session.get(Products.class, serialNo);
				if (product != null) {
					session.delete(product);
					flag=true;
				}else {
					return"not found";
				}
			}
		} catch (HibernateException e) {
		}finally {
			if (flag) {
				transaction.commit();
				return "success";
			} else {
				if (transaction != null) {
					transaction.rollback();
				}
			}
		}
		return "failled";
	}

	@Override
	public Products searchProduct(int serialNo) {
		Products product = null;
		if (session != null) {
			product = session.get(Products.class, serialNo);
		}
		return product;
	}

	@Override
	public String updateProduct(Products product) {
		Transaction transaction =null;
		boolean flag=false;
		try {
			if (session != null) {
				transaction = session.beginTransaction();
			}
			if (transaction != null) {
				session.merge(product);
				flag=true;
			}
			
		} catch (HibernateException e) {
		}finally {
			if (flag) {
				transaction.commit();
				return "success";
			} else {
				if (transaction != null) {
					transaction.rollback();
				}
			}
		}
		return "filled";
	}

	public static void startup() {
		System.out.println("DAO started.........");
	}
}
