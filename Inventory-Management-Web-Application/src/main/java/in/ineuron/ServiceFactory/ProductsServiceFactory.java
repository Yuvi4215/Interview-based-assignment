package in.ineuron.ServiceFactory;

import in.ineuron.Service.IProductsService;
import in.ineuron.Service.ProductsServiceImpl;

public class ProductsServiceFactory {

	private static IProductsService productsService = null;

	private ProductsServiceFactory() {}

	public static IProductsService getProductsService() {
		if (productsService == null) 
			productsService = new ProductsServiceImpl();
		
		return productsService;
	}
}
