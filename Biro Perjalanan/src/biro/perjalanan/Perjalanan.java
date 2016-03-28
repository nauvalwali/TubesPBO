/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biro.perjalanan;

import java.util.ArrayList;

/**
 *
 * @author Reza Amelia
 */
public class Perjalanan {

    private ArrayList<Pelanggan> pelanggan = new ArrayList();
    private PaketWisata paket;
    int jum=0;
    long noPerjalanan;

    public long getNoPerjalanan() {
        return noPerjalanan;
    }

    public void setNoPerjalanan(long noPerjalanan) {
        this.noPerjalanan = noPerjalanan;
        
    }

    public Perjalanan(long noPerjalanan, PaketWisata pkt) {
        setPaket(pkt);
        setNoPerjalanan(noPerjalanan);
    }
    
    public void addPelanggan(Pelanggan p) {
        if (pelanggan.size() < 40) {
            pelanggan.add(p);
            jum++;
            
        } else {
            System.out.println("Kuota Pelanggan Penuh");
        }
    }
    
    public int getJumlahPelanggan(){
        return jum;
    }
    
    public void setPaket(PaketWisata pw) {
        paket = pw;
    }
    
    public void removePelanggan(long id) {
        for (Pelanggan p : pelanggan) {
            if (p.getId() == id) {
                p = null;
            }
        }
    }
	
    public void editPelanggan(String nama, long id, String alamat) {
        for (Pelanggan p : pelanggan) {
            if (p.getId() == id) {
                p.setNama(nama);
                p.setAlamat(alamat);
            }
        }
    }
    
    public Pelanggan getPelanggan(int idx) {
        return pelanggan.get(idx);
    }    
    
    public Pelanggan getPelanggan(long id) {
        Pelanggan a = null;
        for (Pelanggan p : pelanggan) {
            if (p.getId() == id) {
                a = p;
            }
        }
        return a;
    }
    
}
