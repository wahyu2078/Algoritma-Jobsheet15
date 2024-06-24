graph LR
subgraph Penerimaan Laundry
    A((Mulai)) --> B[Penerimaan Cucian]
    B --> C[Pemilihan/Seleksi Pakaian]
    C --> D[Penimbangan Pakaian]
    D --> E{Self-service atau Full-service?}
    E -->|Self-service| F[Pencatatan Data (Sistem Digital)]
    E -->|Full-service| G[Pencatatan Data (Staff)]
    F --> H[Penandaan (Tagging)]
    G --> H
    H --> I[Memberikan Estimasi Waktu]
    I --> J((Selesai Penerimaan))
end

subgraph Proses Pencucian dan Pengeringan
    J --> K[Pra Cuci]
    K --> L[Cuci]
    L --> M[Bilas + Pelembut]
    M --> N[Pengeringan Ekstrak]
    N --> O[Pengeringan 100%]
    O --> P[Penyetrikaan (Jika Diperlukan)]
    P --> Q[Penyimpanan Pakaian]
    Q --> R((Selesai Pencucian))
end

subgraph Proses Pengambilan Pakaian
    R --> S[Notifikasi Pelanggan (Otomatis)]
    S --> T((Mulai Pengambilan))
    T --> U[Verifikasi Data Pelanggan]
    U --> V[Penyerahan Pakaian]
    V --> W((Selesai Pengambilan))
end
