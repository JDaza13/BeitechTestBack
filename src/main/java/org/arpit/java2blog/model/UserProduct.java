package org.arpit.java2blog.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import javax.persistence.Id;

/*
 * This is our model class and it corresponds to Country table in database
 */
@Entity
@Table(name="usuarios_productos")
public class UserProduct{

	@Id
	@Column(name="user_product_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	
	@Column(name="user_id")
	int idUsuario;

	@Column(name="product_id")
	int idProducto;	

	public UserProduct() {
		super();
	}
	public UserProduct(int i,int idu, int idp) {
		super();
		this.id = i;
		this.idUsuario = idu;
		this.idProducto = idp;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdUser() {
		return idUsuario;
	}
	public void setIdUser(int id) {
		this.idUsuario = id;
	}
	public int getIdProduct() {
		return idProducto;
	}
	public void setIdProduct(int id) {
		this.idProducto = id;
	}
}