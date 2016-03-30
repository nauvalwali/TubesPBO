/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biro.perjalanan;

/**
 *
 * @author NVLWL
 */
import java.io.Serializable;
public abstract class Orang implements Serializable {

    private String nama;
    private long id;
    private String alamat;

    public Orang(String nama, long id, String alamat) {
        setNama(nama);
        setId(id);
        setAlamat(alamat);
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNama() {
        return nama;
    }

    public long getId() {
        return id;
    }

    public String getAlamat() {
        return alamat;
    }
}
