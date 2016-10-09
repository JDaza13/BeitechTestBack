package org.arpit.java2blog.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import javax.persistence.Id;

/*
 * This is our model class and it corresponds to Country table in database
 */
@Entity
@Table(name="usuarios_productos")
public class UserProduct{
	@Id
	@Column(name="user_id")
	int idUsuario;
	
	@Column(name="product_id")
	int idProducto;	

	public UserProduct() {
		super();
	}
	public UserProduct(int idu, int idp) {
		super();
		this.idUsuario = idu;
		this.idProducto = idp;
	}
	public int getIdUser() {
		return idUsuario;
	}
	public void setIduser(int id) {
		this.idUsuario = id;
	}
	public int getIdProduct() {
		return idUsuario;
	}
	public void setIdProduct(int id) {
		this.idProducto = id;
	}
}