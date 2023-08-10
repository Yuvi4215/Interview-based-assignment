package in.ineuron.DaoFactory;

import in.ineuron.Persistance.IProductsDao;
import in.ineuron.Persistance.ProductsDaoImpl;

public class ProductsDaoFactory {
	private static IProductsDao productsDao=null;

	private ProductsDaoFactory() {}

	public static IProductsDao getProductsDao() {
		if (productsDao == null) 
			productsDao = new ProductsDaoImpl();
			return productsDao;
	}
	
}
