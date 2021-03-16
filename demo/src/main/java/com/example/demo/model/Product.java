package com.example.demo.model;

public class Product {
	private int idProduct;
	private String nom;
	private double prix;
	
	
	public Product() {}
	
	public Product(int idProduct, String nom, double prix) {
		super();
		this.idProduct = idProduct;
		this.nom = nom;
		this.prix = prix;
	}
	
	public int getIdProduct() {
		return idProduct;
	}
	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	
	
	

}
