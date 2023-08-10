package in.ineuron.Service;

import in.ineuron.DTO.Products;

public interface IProductsService {
	public String addProduct(Products product);

	public Products searchProduct(int serialNo);

	public String deleteProduct(int serialNo);

	public String updateProduct(Products product);

}
