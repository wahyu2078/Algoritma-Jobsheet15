package Tugas29;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        sistemnilai sistem = new sistemnilai();
        Scanner input = new Scanner(System.in);
        int pilihan;

        sistem.tambahmahasiswa("20001", "Thalhah", "021xxx");
        sistem.tambahmahasiswa("20002", "Zubair", "021xxx");
        sistem.tambahmahasiswa("20003", "Abdur-Rahman", "021xxx");
        sistem.tambahmahasiswa("20004", "Sa'ad", "021xxx");
        sistem.tambahmahasiswa("20005", "Sa'id", "021xxx");
        sistem.tambahmahasiswa("20006", "Ubaidah", "021xxx");

        sistem.tambahmatakuliah("01", "Internet of Things", 3);
        sistem.tambahmatakuliah("02", "Algoritma dan Struktur Data", 2);
        sistem.tambahmatakuliah("03", "Algoritma dan Pemrograman", 2);
        sistem.tambahmatakuliah("04", "Praktikum Algoritma dan Struktur Data", 3);
        sistem.tambahmatakuliah("05", "Praktikum Algoritma dan Pemrograman", 3);

        do {
            System.out.println("=======================================");
            System.out.println(" SISTEM PENGOLAHAN DATA NILAI MAHASISWA ");
            System.out.println("=======================================");
            System.out.println("1. Input Nilai");
            System.out.println("2. Tampil Nilai");
            System.out.println("3. Mencari Nilai mahasiswa");
            System.out.println("4. Urut Data Nilai");
            System.out.println("5. Tambah mahasiswa ke Antrian Penghapusan");
            System.out.println("6. Hapus mahasiswa dari Antrian");
            System.out.println("5. Keluar");
            System.out.print("Pilih: ");
            pilihan = input.nextInt();
            input.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan NIM: ");
                    String nim = input.nextLine();
                    System.out.print("Masukkan Kode Mata Kuliah: ");
                    String kodeMk = input.nextLine();
                    System.out.print("Masukkan Nilai: ");
                    double nilai = input.nextDouble();
                    sistem.inputnilai(nim, kodeMk, nilai);
                    break;
                case 2:
                    sistem.tampilnilai();
                    break;
                case 3:
                    System.out.print("Masukkan NIM: ");
                    nim = input.nextLine();
                    sistem.carinilaimahasiswa(nim);
                    break;
                case 4:
                    sistem.urutDatanilai();
                    break;
                case 5:
                    System.out.print("Masukkan NIM mahasiswa yang akan ditambahkan ke antrian penghapusan: ");
                    nim = input.nextLine();
                    sistem.antrianHapusmahasiswa(nim);
                    break;
                case 6:
                    sistem.hapusmahasiswa();
                    break;
                case 7:
                    return;
                default:
                    System.out.println("Pilih antara 1-7.");
            }
        } while (pilihan != 7);

        input.close();
    }
}
