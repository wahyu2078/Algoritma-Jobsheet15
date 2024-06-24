import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
public class ListMahasiswa29 {
    List<Mahasiswa29> mahasiswaa = new ArrayList<>();

    public void tambah(Mahasiswa29... mahasiswa) {
        mahasiswaa.addAll(Arrays.asList(mahasiswa));
    }
    
    public void hapus(int index) {
        mahasiswaa.remove(index);
    }
    
    public void update(int index, Mahasiswa29 mhs) {
        mahasiswaa.set(index, mhs);
    }
    
    public void tampil() {
        mahasiswaa.stream().forEach(mhs -> {
            System.out.println("" + mhs.toString());
        });
    }

    int linearSearch(String nim) {
        for(int i=0; i< mahasiswaa.size(); i++){
            if(nim.equals(mahasiswaa.get(i).nim)){
                return i;
            }
        }
        return -1;
    }
    int binarySearch(String nim) {
        int low = 0;
        int high = mahasiswaa.size() - 1;
    
        while (low <= high) {
            int mid = low + (high - low) / 2;
            Mahasiswa29 mhs = mahasiswaa.get(mid);
    
            if (mhs.nim.equals(nim)) {
                return mid;
            } else if (mhs.nim.compareTo(nim) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
    
        return -1;
    }

     public void sortByNimAsc() {
        Collections.sort(mahasiswaa, (mhs1, mhs2) -> mhs1.nim.compareTo(mhs2.nim));
    }

    public void sortByNimDesc() {
        Collections.sort(mahasiswaa, (mhs1, mhs2) -> mhs2.nim.compareTo(mhs1.nim));
    }

    public static void main(String[] args) {
        ListMahasiswa29 lm = new ListMahasiswa29();
        Mahasiswa29 m = new Mahasiswa29("201234", "Noureen", "021xx1");
        Mahasiswa29 m1 = new Mahasiswa29("201235", "Akhleena", "021xx2");
        Mahasiswa29 m2 = new Mahasiswa29("201236", "Shannum", "021xx3");

        lm.tambah(m, m1, m2);

        lm.tampil();

        lm.update(lm.binarySearch("201235"), new Mahasiswa29("201235","Aknhleena Lela", "021xx2"));
        System.out.println("");

        lm.tampil();
        lm.sortByNimDesc();
        lm.tampil();

        
    }

    
}