package com.project.shopping.cart;

import java.util.HashMap;
import java.util.Map;

public class Cart {

	private Map<Product, Integer> cartProducts = new HashMap<Product, Integer>(); 
	
	
	
	public Map<Product, Integer> getCartProducts() {
		return cartProducts;
	}

	public void setCartProducts(Map<Product, Integer> cartProducts) {
		this.cartProducts = cartProducts;
	}



	public void addItem(Product product, int amount) throws Exception {
		if(amount==0)
			throw new Exception("Amount not specified for the product selected");
		cartProducts.put(product, amount);
	}
	
	
	public void removeItem(Product product) throws Exception {
		Integer amount = cartProducts.get(product);
		if(amount==null)
			throw new Exception("The given product is not present in the cart");
		cartProducts.remove(product);
	}
	
	public void generateInvoice() {
		Double total = null;
		for (Map.Entry<Product, Integer> cartProduct : cartProducts.entrySet()) {
			if(cartProduct.getKey()!=null) {
				System.out.println(cartProduct.getKey().getName() + " " + cartProduct.getValue() + " " + cartProduct.getKey().getPrice());
			}
			total = total + ((cartProduct.getValue())*(cartProduct.getKey().getPrice()));
		}
		
		System.out.println("Total price: "+total);
	}
	
	//public void 
	
	
}
