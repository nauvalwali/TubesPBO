/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biro.perjalanan;

import java.io.Serializable;

/**
 *
 * @author Reza Amelia
 */
public class TempatWisata implements Serializable {
	private String namaTempat;
	private long harga;
	private long id;
	
	public TempatWisata(String namaTempat, long harga, long id){
		setNamaTempat(namaTempat);
		setHarga(harga);
		setId(id);
	}
	
	public void setNamaTempat(String namaTempat){
		this.namaTempat=namaTempat;
	}
	
	public String getNamaTempat(){
		return namaTempat;
	}
	
	public void setHarga(long harga){
		this.harga=harga;
	}
	
	public long getHarga(){
		return harga;
	}
	
	public void setId(long id){
		this.id=id;
	}
	
	public long getId(){
		return id;
	}
}
