package in.ineuron.Service;

import in.ineuron.DTO.Products;
import in.ineuron.DaoFactory.ProductsDaoFactory;
import in.ineuron.Persistance.IProductsDao;

public class ProductsServiceImpl implements IProductsService {

	private IProductsDao prdDao;
	private Products product;

	@Override
	public String addProduct(Products product) {
		prdDao = ProductsDaoFactory.getProductsDao();
		if (prdDao!=null) {
			return prdDao.addProduct(product);
		}else {
			return "faillure";
		}
	}
	@Override
	public String deleteProduct(int serialNo) {
		prdDao = ProductsDaoFactory.getProductsDao();
		if (prdDao != null) {
			return prdDao.deleteProduct(serialNo);
		}else {
		return "faillure";
	}
}
	
	@Override
	public Products searchProduct(int serialNo) {
		prdDao = ProductsDaoFactory.getProductsDao();
		if (prdDao != null) {
			return product = prdDao.searchProduct(serialNo);
		}
		return product;
	}


	@Override
	public String updateProduct(Products product) {
		IProductsDao prdDao = ProductsDaoFactory.getProductsDao();
		if (prdDao != null) {
			return prdDao.updateProduct(product);
		}else {
		return "faillure";
	}
	}

}
