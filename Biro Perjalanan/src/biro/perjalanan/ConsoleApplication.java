/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biro.perjalanan;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Reza Amelia
 */
public class ConsoleApplication {
    private ArrayList<Petugas> daftarPetugas = new ArrayList();
    private ArrayList<Pelanggan> daftarPelanggan = new ArrayList();
    private ArrayList<Perjalanan> daftarPerjalanan = new ArrayList<Perjalanan>();
    private ArrayList<PaketWisata> daftarPaketWisata = new ArrayList();
    private ArrayList<TempatWisata> daftarTempatWisata = new ArrayList();
    int a;

    public ArrayList getListPaket() {
        return daftarPaketWisata;
    }

    public ArrayList getListTempat() {
        return daftarTempatWisata;
    }

    public void insertPetugas(String nama, long id, String alamat) {
        Petugas p = new Petugas(nama, id, alamat);
        if (daftarPetugas.size() < 40) {
            daftarPetugas.add(p);
        } else {
            System.out.println("Kuota Penuh");
        }
    }

    public Petugas getPetugas(long id) {
        Petugas a = null;
        for (int i = 0; i < 5; i++) {
            if (daftarPetugas.get(i).getId() == id) {
                a = daftarPetugas.get(i);
            }
        }
        return a;

    }

    public void deletePetugas(long id) {
        for (int i = 0; i < daftarPetugas.size(); i++) {
            if (daftarPetugas.get(i).getId() == id) {
                daftarPetugas.remove(i);
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

    public Pelanggan getPelanggan(long id) {
        Pelanggan a = null;
        for (int i = 0; i < 5; i++) {
            if (daftarPelanggan.get(i).getId() == id) {
                a = daftarPelanggan.get(i);
            }
        }
        return a;

    }

    public void deletePelanggan(long id) {
        for (int i = 0; i < daftarPelanggan.size(); i++) {
            if (daftarPelanggan.get(i).getId() == id) {
                daftarPelanggan.remove(i);
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

    public Perjalanan getPerjalanan(long noPerjalanan) {
        Perjalanan a = null;
        for (int i = 0; i < 5; i++) {
            if (daftarPerjalanan.get(i).getNoPerjalanan() == noPerjalanan) {
                a = daftarPerjalanan.get(i);
            }
        }
        return a;
    }

    public void deletePerjalanan(long noPerjalanan) {
        for (int i = 0; i < daftarPerjalanan.size(); i++) {
            if (daftarPerjalanan.get(i).getNoPerjalanan() == noPerjalanan) {
                daftarPerjalanan.remove(i);
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

    public PaketWisata getPaketWisata(long idPaket) {
        PaketWisata a = null;
        for (int i = 0; i < 5; i++) {
            if (daftarPaketWisata.get(i).getIdPaket() == idPaket) {
                a = daftarPaketWisata.get(i);
            }
        }
        return a;
    }

    public void deletePaketWisata(long idPaket) {
        for (int i = 0; i < daftarPaketWisata.size(); i++) {
            if (daftarPaketWisata.get(i).getIdPaket() == idPaket) {
                daftarPaketWisata.remove(i);
            }
        }
    }

    public void viewPaketWisata() {
        for (int i = 0; i < daftarPaketWisata.size(); i++) {
            System.out.println(getListPaket());
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

    public TempatWisata getTempatWisata(long id) {
        TempatWisata a = null;
        for (int i = 0; i < 5; i++) {
            if (daftarTempatWisata.get(i).getId() == id) {
                a = daftarTempatWisata.get(i);
            }
        }
        return a;
    }

    public void deleteTempatWisata(long id) {
        for (int i = 0; i < daftarTempatWisata.size(); i++) {
            if (daftarTempatWisata.get(i).getId() == id) {
                daftarTempatWisata.remove(i);
            }
        }
    }

    public void viewTempatWisata() {
        for (int i = 0; i < daftarTempatWisata.size(); i++) {
            System.out.println(getListTempat());
        }
    }

    public void menuInsertPerjalanan(long noPerjalanan, PaketWisata pkt) throws IOException {
        insertPerjalanan(noPerjalanan, pkt);
    }

    public void menuViewPaketWisata() {
        viewPaketWisata();
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

    public void menuRemovePelanggan(int id) {
        deletePelanggan(id);
    }

    public void menuInsertPetugas(String nama, long id, String alamat) {
        insertPetugas(nama, id, alamat);
    }

    public void menuRemovePetugas(int id) {
        deletePetugas(id);
    }

    public void mainMenu() throws IOException {

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
        Scanner input = new Scanner(System.in);
        System.out.println("Masukkan Pulihan: ");
        int pilih = input.nextInt();
        switch (pilih) {
            case 1:
                long a = 0;
                long b = 0;
                try {
                    System.out.println("Nomor Perjalanan: ");
                    a = input.nextLong();
                }catch (InputMismatchException e) {
                    System.out.println("Input Nomor Perjalanan!");
                }
                try {
                    System.out.println("Paket Wisata: ");
                    b = input.nextLong();
                }catch (InputMismatchException e) {
                    System.out.println("Input Paket Wisata!");
                }
                menuInsertPerjalanan(a, getPaketWisata(b));
                break;

            case 2:
                System.out.println("Paket Wisata");
                menuViewPaketWisata();

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
                }catch (InputMismatchException e) {
                    System.out.println("Input Max Tempat Wisata!");
                }
                menuInsertPaketWisata(c, d);
                break;

            case 4:
                System.out.println("Tempat Wisata");
                menuViewTempatWisata();

            case 5:
                String x = null;
                long f = 0;
                long g = 0;
                try {
                    System.out.println("Nama Tempat: ");
                    x = input.next();
                }catch (InputMismatchException e) {
                    System.out.println("Input Nama Tempat!");
                }
                try {
                    System.out.println("Masukkan Harga: ");
                    f = input.nextLong();
                }catch (InputMismatchException e) {
                    System.out.println("Input Harga!");
                }
                try {
                    System.out.println("Id: ");
                    g = input.nextLong();
                }catch (InputMismatchException e) {
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
                }catch (InputMismatchException e) {
                    System.out.println("Input Nama!");
                }
                try {
                    System.out.println("Id: ");
                    i = input.nextLong();
                }catch (InputMismatchException e) {
                    System.out.println("Input Id!");
                }
                try {
                    System.out.println("Alamat: ");
                    j = input.next();
                }catch (InputMismatchException e) {
                    System.out.println("Input Alamat!");
                }
                menuInsertPelanggan(h, i, j);
                break;

            case 7:
                int k = 0;
                try {
                    System.out.println("Id: ");
                    k = input.nextInt();
                }catch (InputMismatchException e) {
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
                }catch (InputMismatchException e) {
                    System.out.println("Input Nama!");
                }
                try {
                    System.out.println("Id: ");
                    m = input.nextLong();
                }catch (InputMismatchException e) {
                    System.out.println("Input Id!");
                }
                try {
                    System.out.println("Alamat: ");
                    n = input.next();
                }catch (InputMismatchException e) {
                    System.out.println("Input Alamat!");
                }
                menuInsertPetugas(l, m, n);
                break;

            case 9:
                int o = 0;
                try {
                    System.out.println("Id: ");
                    o = input.nextInt();
                }catch (InputMismatchException e) {
                    System.out.println("Input Id!");
                }
                menuRemovePetugas(o);
                break;
        }
    }
}
