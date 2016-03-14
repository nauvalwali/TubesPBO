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
public class Driver {
    public static void main(String[] args){
        Petugas P1=new Petugas("Zul",1,"Bandung");
        Pelanggan Pel1=new Pelanggan("Jaja",201,"Bandung");
        Pelanggan Pel2=new Pelanggan("Bejo",202,"Bandung");
        Pelanggan Pel3=new Pelanggan("Dadang",203,"Bandung");
        Pelanggan Pel4=new Pelanggan("Marwan",204,"Bandung");
        Pelanggan Pel5=new Pelanggan("Jajang",205,"Bandung");
        TempatWisata T1=new TempatWisata("Raja Ampat",300000,01);
        TempatWisata T2=new TempatWisata("Pantai Sari Ringgo",100000,02);
        TempatWisata T3=new TempatWisata("Bunaken",200000,03);
        TempatWisata T4=new TempatWisata("Teluk Kiluan Lampung",150000,04);
        TempatWisata T5=new TempatWisata("Lembah Hijau",150000,05);
        PaketWisata Pak1=new PaketWisata(3001,2);
        PaketWisata Pak2=new PaketWisata(3002,3);
        Pak1.addTempatWisata(T1);
        Pak1.addTempatWisata(T2);
        Pak2.addTempatWisata(T3);
        Pak2.addTempatWisata(T4);
        Pak2.addTempatWisata(T5);
        Pak1.hitungHarga();
        Pak2.hitungHarga();
        Perjalanan[] Per1=new Perjalanan[2];
        Per1[0]=new Perjalanan(Pak1);
        Per1[1]=new Perjalanan(Pak2);
        Per1[0].addPelanggan(Pel1);
        Per1[0].addPelanggan(Pel2);
        Per1[1].addPelanggan(Pel3);
        Per1[1].addPelanggan(Pel4);
        Per1[1].addPelanggan(Pel5);
        for(int i=0;i<2;i++){
            System.out.println("Paket "+(i+1)+": ");
            for(int i=0;i<)
            System.out.println("Tujuan: "+);
            
        }
    }
}
