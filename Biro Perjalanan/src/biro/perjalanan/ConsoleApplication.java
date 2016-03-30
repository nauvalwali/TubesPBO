/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biro.perjalanan;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Reza Amelia
 */
public class ConsoleApplication {

    private ArrayList<Petugas> daftarPetugas = new ArrayList<Petugas>();
    private ArrayList<Pelanggan> daftarPelanggan = new ArrayList<Pelanggan>();
    private ArrayList<Perjalanan> daftarPerjalanan = new ArrayList<Perjalanan>();
    private ArrayList<PaketWisata> daftarPaketWisata = new ArrayList();
    private ArrayList<TempatWisata> daftarTempatWisata = new ArrayList();
    //int a;

    public void addPetugas(Petugas p) {
        daftarPetugas.add(p);
    }

    public void addPelanggan(Pelanggan pel) {
        daftarPelanggan.add(pel);
    }

    public void addTempat(TempatWisata tw) {
        daftarTempatWisata.add(tw);
    }

    public void insertPetugas(String nama, long id, String alamat) {
        Petugas p = new Petugas(nama, id, alamat);
        if (daftarPetugas.size() < 40) {
            daftarPetugas.add(p);
        } else {
            System.out.println("Kuota Penuh");
        }
    }

    public Petugas getPetugas(long id) throws FileNotFoundException, IOException, ClassNotFoundException {
        Petugas p1 = null;
        FileInputStream fis = new FileInputStream("Data Petugas.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        ArrayList<Petugas> ptgs = (ArrayList<Petugas>) ois.readObject();
        while (ois.readObject() != null) {
            for (int i = 0; i < daftarPetugas.size(); i++) {
                if (daftarPetugas.get(i).getId() == id) {
                    p1 = daftarPetugas.get(i);
                }
            }
        }
        return p1;
    }

    public void deletePetugas(long id) throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("Data Petugas.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        ArrayList<Petugas> ptgs = (ArrayList<Petugas>) ois.readObject();
        File data = new File("Data Petugas.dat");
        if (ois.readObject() == null) {
            System.out.println("Data tidak ada !");
        } 
        else {
            while (ois.readObject() != null) {
                for (int i = 0; i < daftarPetugas.size(); i++) {
                    if (daftarPetugas.get(i).getId() == id) {
                        daftarPetugas.remove(i);
                    }
                }
            }
        }
    }

    public void insertPelanggan(String nama, long id, String alamat) {
        Pelanggan pg = new Pelanggan(nama, id, alamat);
        if (daftarPelanggan.size() < 40) {
            daftarPelanggan.add(pg);

        } else {
            System.out.println("Kuota Penuh");
        }
    }

    public Pelanggan getPelanggan(long id) throws FileNotFoundException, IOException, ClassNotFoundException {
        Pelanggan pel1 = null;
        FileInputStream fis = new FileInputStream("Data Pelanggan.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        ArrayList<Pelanggan> plgn = (ArrayList<Pelanggan>) ois.readObject();
        while (ois.readObject() != null) {
            for (int i = 0; i < daftarPelanggan.size(); i++) {
                if (daftarPelanggan.get(i).getId() == id) {
                    pel1 = daftarPelanggan.get(i);
                }
            }
        }
        return pel1;
    }

    public void deletePelanggan(long id) throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("Data Pelanggan.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        ArrayList<Pelanggan> plgn = (ArrayList<Pelanggan>) ois.readObject();
        if (ois.readObject() == null) {
            System.out.println("Data tidak ada !");
        } 
        else {
            while (ois.readObject() != null) {
                for (int i = 0; i < daftarPelanggan.size(); i++) {
                    if (daftarPelanggan.get(i).getId() == id) {
                        daftarPelanggan.remove(i);
                    }
                }
            }
        }
    }

    public void insertPerjalanan(long noPerjalanan, PaketWisata pkt) throws FileNotFoundException, IOException {
        Perjalanan a = new Perjalanan(noPerjalanan, pkt);
        FileOutputStream fos = new FileOutputStream("Data Perjalanan.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(a);
        oos.flush();
        System.out.println("Data Telah Disimpan");
        if (daftarPerjalanan.size() < 40) {
            daftarPerjalanan.add(a);

        } else {
            System.out.println("Kuota Penuh");
        }
    }

    public Perjalanan getPerjalanan(long noPerjalanan) throws FileNotFoundException, IOException, ClassNotFoundException {
        Perjalanan per = null;
        FileInputStream fis = new FileInputStream("Data Perjalanan.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        while (ois.readObject() != null) {
            for (int i = 0; i < 5; i++) {
                if (daftarPerjalanan.get(i).getNoPerjalanan() == noPerjalanan) {
                    per = daftarPerjalanan.get(i);
                }
            }
        }
        return per;
    }

    public void deletePerjalanan(long noPerjalanan) throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("Data Perjalanan.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        if (ois.readObject() == null) {
            System.out.println("Data tsb tidak ada !");
        } else {
            while (ois.readObject() != null) {
                for (int i = 0; i < daftarPerjalanan.size(); i++) {
                    if (daftarPerjalanan.get(i).getNoPerjalanan() == noPerjalanan) {
                        daftarPerjalanan.remove(i);
                    }
                }
            }
        }
    }

    public void insertPaketWisata(long idPaket, int maxTempatWisata) throws FileNotFoundException, IOException {
        PaketWisata pw = new PaketWisata(idPaket, maxTempatWisata);
        FileOutputStream fos = new FileOutputStream("Data PaketWisata.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(pw);
        oos.flush();
        System.out.println("Data Telah Disimpan");
        if (daftarPaketWisata.size() < maxTempatWisata) {
            daftarPaketWisata.add(pw);

        } else {
            System.out.println("Kuota Penuh");
        }
    }

    public PaketWisata getPaketWisata(long idPaket) throws FileNotFoundException, IOException, ClassNotFoundException {
        PaketWisata pak = null;
        FileInputStream fis = new FileInputStream("Data Paket.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        while (ois.readObject() != null) {
            for (int i = 0; i < 5; i++) {
                if (daftarPaketWisata.get(i).getIdPaket() == idPaket) {
                    pak = daftarPaketWisata.get(i);
                }
            }
        }
        return pak;
    }

    public void deletePaketWisata(long idPaket) throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("Data Paket.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        if (ois.readObject() == null) {
            System.out.println("Data tsb tidak ada !");
        } else {
            while (ois.readObject() != null) {
                for (int i = 0; i < daftarPaketWisata.size(); i++) {
                    if (daftarPaketWisata.get(i).getIdPaket() == idPaket) {
                        daftarPaketWisata.remove(i);
                    }
                }
            }
        }
    }

    public void viewPaketWisata() {
        for (int i = 0; i < daftarPaketWisata.size(); i++) {
            System.out.println("");
        }
    }

    public void insertTempatWisata(String namaTempat, long harga, long id) throws FileNotFoundException, IOException {
        TempatWisata tw = new TempatWisata(namaTempat, harga, id);
        FileOutputStream fos = new FileOutputStream("Data Tempat Wisata.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(tw);
        oos.flush();
        System.out.println("Data Telah Disimpan");
        if (daftarTempatWisata.size() < 40) {
            daftarTempatWisata.add(tw);

        } else {
            System.out.println("Kuota Penuh");
        }
    }

    public TempatWisata getTempatWisata(long id) throws FileNotFoundException, IOException, ClassNotFoundException {
        TempatWisata tem = null;
        FileInputStream fis = new FileInputStream("Data Tempat.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        while (ois.readObject() != null) {
            for (int i = 0; i < 5; i++) {
                if (daftarTempatWisata.get(i).getId() == id) {
                    tem = daftarTempatWisata.get(i);
                }
            }
        }
        return tem;
    }

    public void deleteTempatWisata(long id) throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("Data Tempat.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        if (ois.readObject() == null) {
            System.out.println("Data tsb tidak ada !");
        } else {
            while (ois.readObject() != null) {
                for (int i = 0; i < daftarTempatWisata.size(); i++) {
                    if (daftarTempatWisata.get(i).getId() == id) {
                        daftarTempatWisata.remove(i);
                    }
                }
            }
        }
    }

    public void viewTempatWisata() {
        for (int i = 0; i < daftarTempatWisata.size(); i++) {
            System.out.println(daftarTempatWisata.get(i).getId());
            System.out.println(daftarTempatWisata.get(i).getNamaTempat());
            System.out.println(daftarTempatWisata.get(i).getHarga());
        }
    }
    
    public void viewPelanggan() {
        for (int i = 0; i < daftarPelanggan.size(); i++) {
            System.out.println(daftarPelanggan.get(i).getId());
            System.out.println(daftarPelanggan.get(i).getNama());
            System.out.println(daftarPelanggan.get(i).getAlamat());
        }
    }
    
    public void viewPetugas() {
        for (int i = 0; i < daftarPetugas.size(); i++) {
            System.out.println(daftarPetugas.get(i).getId());
            System.out.println(daftarPetugas.get(i).getNama());
            System.out.println(daftarPetugas.get(i).getAlamat());
        }
    }

    public void menuInsertPerjalanan(long noPerjalanan, PaketWisata pkt) throws IOException {
        insertPerjalanan(noPerjalanan, pkt);
    }

    public void menuViewPaketWisata() {
        viewPaketWisata();
    }
    
    public void menuViewPelanggan() {
        viewPelanggan();
    }
    
    public void menuViewPetugas() {
        viewPetugas();
    }

    public void menuInsertPaketWisata(long idPaket, int maxTempatWisata) throws FileNotFoundException, IOException {
        insertPaketWisata(idPaket, maxTempatWisata);
    }

    public void menuViewTempatWisata() {
        viewTempatWisata();
    }

    public void menuInsertTempatWisata(String namaTempat, long harga, long id) throws IOException {
        insertTempatWisata(namaTempat, harga, id);
    }

    public void menuInsertPelanggan(String nama, long id, String alamat) {
        insertPelanggan(nama, id, alamat);
    }

    public void menuRemovePelanggan(int id) throws IOException, FileNotFoundException, ClassNotFoundException {
        deletePelanggan(id);
    }

    public void menuInsertPetugas(String nama, long id, String alamat) {
        insertPetugas(nama, id, alamat);
    }

    public void menuRemovePetugas(int id) throws IOException, FileNotFoundException, ClassNotFoundException {
        deletePetugas(id);
    }

    public void mainMenu() throws IOException, FileNotFoundException, ClassNotFoundException {
        Scanner input = new Scanner(System.in);
        int pilih;
        do {
            System.out.println("Menu");
            System.out.println("1. Tambah Perjalanan");
            System.out.println("2. View Paket Wisata ");
            System.out.println("3. Tambah Paket Wisata");
            System.out.println("4. View Tujuan Wisata");
            System.out.println("5. Tambah Tujuan Wisata");
            System.out.println("6. Tambah Pelanggan");
            System.out.println("7. Remove Pelanggan");
            System.out.println("8. Tambah Petugas");
            System.out.println("9. Remove Petugas");
            System.out.println("Masukkan Pilihan: ");
            pilih = input.nextInt();
            switch (pilih) {
                case 1:
                    long a = 0;
                    long b = 0;
                    try {
                        System.out.println("Nomor Perjalanan: ");
                        a = input.nextLong();
                    } catch (InputMismatchException e) {
                        System.out.println("Input Nomor Perjalanan!");
                    }
                    try {
                        System.out.println("Paket Wisata: ");
                        b = input.nextLong();
                    } catch (InputMismatchException e) {
                        System.out.println("Input Paket Wisata!");
                    }
                    //menuInsertPerjalanan(a, getPaketWisata(b));
                    break;

                case 2:
                    System.out.println("Paket Wisata");
                    menuViewPaketWisata();
                    break;
                    

                case 3:
                    long c = 0;
                    int d = 0;
                    try {
                        System.out.println("Id: ");
                        c = input.nextLong();
                    } catch (InputMismatchException e) {
                        System.out.println("Input Id!");
                    }
                    try {
                        System.out.println("Max Tempat Wisata: ");
                        d = input.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Input Max Tempat Wisata!");
                    }
                    menuInsertPaketWisata(c, d);
                    break;

                case 4:
                    System.out.println("");
                    System.out.println("Tempat Wisata");
                    menuViewTempatWisata();
                    System.out.println("");
                    break;
                    
                case 5:
                    String x = null;
                    long f = 0;
                    long g = 0;
                    try {
                        System.out.println("Nama Tempat: ");
                        x = input.next();
                    } catch (InputMismatchException e) {
                        System.out.println("Input Nama Tempat!");
                    }
                    try {
                        System.out.println("Masukkan Harga: ");
                        f = input.nextLong();
                    } catch (InputMismatchException e) {
                        System.out.println("Input Harga!");
                    }
                    try {
                        System.out.println("Id: ");
                        g = input.nextLong();
                    } catch (InputMismatchException e) {
                        System.out.println("Input Id!");
                    }
                    menuInsertTempatWisata(x, f, g);
                    break;

                case 6:
                    String h = null;
                    long i = 0;
                    String j = null;
                    try {
                        System.out.println("Nama: ");
                        h = input.next();
                    } catch (InputMismatchException e) {
                        System.out.println("Input Nama!");
                    }
                    try {
                        System.out.println("Id: ");
                        i = input.nextLong();
                    } catch (InputMismatchException e) {
                        System.out.println("Input Id!");
                    }
                    try {
                        System.out.println("Alamat: ");
                        j = input.next();
                    } catch (InputMismatchException e) {
                        System.out.println("Input Alamat!");
                    }
                    menuInsertPelanggan(h, i, j);
                    break;

                case 7:
                    int k = 0;
                    try {
                        System.out.println("Id: ");
                        k = input.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Input Id!");
                    }
                    menuRemovePelanggan(k);
                    break;

                case 8:
                    String l = null;
                    long m = 0;
                    String n = null;
                    try {
                        System.out.println("Nama: ");
                        l = input.next();
                    } catch (InputMismatchException e) {
                        System.out.println("Input Nama!");
                    }
                    try {
                        System.out.println("Id: ");
                        m = input.nextLong();
                    } catch (InputMismatchException e) {
                        System.out.println("Input Id!");
                    }
                    try {
                        System.out.println("Alamat: ");
                        n = input.next();
                    } catch (InputMismatchException e) {
                        System.out.println("Input Alamat!");
                    }
                    menuInsertPetugas(l, m, n);
                    break;

                case 9:
                    int o = 0;
                    try {
                        System.out.println("Id: ");
                        o = input.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Input Id!");
                    }
                    menuRemovePetugas(o);
                    break;
            }
        } while (pilih != 0);
    }
}
