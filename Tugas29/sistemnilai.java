package Tugas29;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class sistemnilai {
    List<mahasiswa> daftarmahasiswa = new ArrayList<>();
    List<matakuliah> daftarmatakuliah = new ArrayList<>();
    List<nilai> daftarnilai = new ArrayList<>();
    Queue<mahasiswa> antrianHapus = new LinkedList<>();

    void tambahmahasiswa(String nim, String nama, String telf) {
        mahasiswa mahasiswa = new mahasiswa(nim, nama, telf);
        daftarmahasiswa.add(mahasiswa);
    }

    void tambahmatakuliah(String kode, String nama, int sks) {
        matakuliah matakuliah = new matakuliah(kode, nama, sks);
        daftarmatakuliah.add(matakuliah);
    }

    void inputnilai(String nim, String kodeMk, double nilai) {
        mahasiswa mahasiswa = daftarmahasiswa.stream().filter(m -> m.nim.equals(nim)).findFirst().orElse(null);
        matakuliah matakuliah = daftarmatakuliah.stream().filter(mk -> mk.kode.equals(kodeMk)).findFirst().orElse(null);

        if (mahasiswa != null && matakuliah != null) {
            nilai nilaiObj = new nilai(mahasiswa, matakuliah, nilai);
            daftarnilai.add(nilaiObj);
        } else {
            if (mahasiswa == null) {
                System.out.println("mahasiswa dengan NIM " + nim + " tidak ditemukan.");
            } else {
                System.out.println("Mata kuliah dengan kode " + kodeMk + " tidak ditemukan.");
            }
        }
    }

    void tampilnilai() {
        System.out.println("=======================================");
        System.out.println("         DAFTAR nilai mahasiswa        ");
        System.out.println("=======================================");
        for (nilai nilai : daftarnilai) {
            System.out.println("NIM         : " + nilai.mahasiswa.nim);
            System.out.println("Nama        : " + nilai.mahasiswa.nama);
            System.out.println("Mata Kuliah : " + nilai.matakuliah.nama);
            System.out.println("SKS         : " + nilai.matakuliah.sks);
            System.out.println("nilai       : " + nilai.nilai);
            System.out.println("---------------------------------------");
        }
    }

    void carinilaimahasiswa(String nim) {
        System.out.println("=======================================");
        System.out.println("       nilai mahasiswa NIM: " + nim);
        System.out.println("=======================================");
        for (nilai nilai : daftarnilai) {
            if (nilai.mahasiswa.nim.equals(nim)) {
                System.out.println("Nama        : " + nilai.mahasiswa.nama);
                System.out.println("Mata Kuliah : " + nilai.matakuliah.nama);
                System.out.println("SKS         : " + nilai.matakuliah.sks);
                System.out.println("nilai       : " + nilai.nilai);
                System.out.println("---------------------------------------");
            }
        }
    }

    void urutDatanilai() {
        daftarnilai.sort(Comparator.comparing(n -> n.mahasiswa.nama));
        tampilnilai();
    }

    void antrianHapusmahasiswa(String nim) {
        mahasiswa mahasiswa = daftarmahasiswa.stream().filter(m -> m.nim.equals(nim)).findFirst().orElse(null);
        if (mahasiswa != null) {
            antrianHapus.add(mahasiswa);
            System.out.println("mahasiswa dengan NIM " + nim + " ditambahkan ke dalam antrian penghapusan.");
        } else {
            System.out.println("mahasiswa dengan NIM " + nim + " tidak ditemukan.");
        }
    }

    void hapusmahasiswa() {
        mahasiswa mahasiswa = antrianHapus.poll();
        if (mahasiswa != null) {
            daftarmahasiswa.remove(mahasiswa);
            daftarnilai.removeIf(nilai -> nilai.mahasiswa.equals(mahasiswa));
            System.out.println("mahasiswa dengan NIM " + mahasiswa.nim + " telah dihapus.");
        } else {
            System.out.println("Tidak ada mahasiswa dalam antrian penghapusan.");
        }
    }
}
