/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biro.perjalanan;

/**
 *
 * @author Reza Amelia
 */
import java.util.ArrayList;
public class PaketWisata {
	private ArrayList<TempatWisata> daftarTujuanWisata;
	private int HargaPaket;
	private int nTempatWisata;
	private int maxTempatWisata;
	
	public PaketWisata(int HargaPaket, int maxTempatWisata){
		daftarTujuanWisata = new ArrayList();
		this.maxTempatWisata=maxTempatWisata;
		this.HargaPaket=HargaPaket;
	}
	
	public void addTempatWisata(TempatWisata w){
		if (nTempatWisata<maxTempatWisata) {
			daftarTujuanWisata.add(w);
			nTempatWisata++;
		}
		else {
			System.out.println("Kuota TempatWisata Penuh");
		}
	}
	
	public void hitungHarga(){
		long harga=0;
		for (TempatWisata tw : daftarTujuanWisata){
			harga=harga+tw.getHarga();
		}
	}
	
	public TempatWisata getTempatWisata1(int idx){
		return daftarTujuanWisata.get(idx);
	}
	
	public TempatWisata getTempatWisata2(long id){
		TempatWisata a=null;
		for(TempatWisata tw : daftarTujuanWisata){
			if(tw.getId()==id){
				a=tw;
			}
		}
		return a;
	}
	
	public void removeTempatWisata(long id){
		for(TempatWisata tws : daftarTujuanWisata){
			if(tws.getId()==id){
				tws=null;
			}
		}
	}
}