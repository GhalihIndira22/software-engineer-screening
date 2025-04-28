# YouTube Event Simulation - Screening Test

## Deskripsi
Simulasi sederhana untuk meniru perilaku user dalam menonton video di platform seperti YouTube. User memilih video dan menekan tombol play. Apabila user tidak melakukan action selama 10 detik, dianggap user mengirimkan event `Continue`. Apabila user menonton durasi video sampai selesai, user mengirimkan event `Stop` di akhir video. Selain itu setiap user dapat mengirimkan event berikut:
- Pause
- Forward
- Back

Event yang dikirim oleh user akan diproses oleh server. 1 User bisa menonton video yang berbeda. Sistem ini dirancang agar scalable, extensible, dan mendukung concurrent user event.

## Requirements

1. **Command/Event Handling**  
   Setiap event (`Pause`, `Continue`, `Forward`, `Back`) harus diimplementasikan dengan design yang mudah dimaintain.

2. **Scalability**  
   Sistem harus dapat menangani banyak user secara bersamaan.

3. **Extensibility**  
   Sistem harus mudah dikembangkan untuk menambahkan event baru (i.e : `SpeedDown`, `SpeedUp`) tanpa mengubah struktur utama.

4. **Concurrency**  
   Sistem harus mendukung banyak user yang mengirim event secara paralel.

5. **Infrastructure & Deployment**  
   Aplikasi dan infrastrukturnya harus dapat dijalankan dari command line menggunakan Docker atau script serupa.

6. **Clean Code**  
   Struktur project harus rapi, mengikuti prinsip SOLID, dan diberi komentar seperlunya.

7. **Auto-scaling Simulation (Bonus)**  
   Sistem melakukan auto-scaling server instance/pod berdasarkan penggunaan RAM/CPU atau jumlah user.

## Testing
- Gunakan Postman, Curl, atau tools lain untuk mengirimkan menambah user atau mengurangi user.
- Endpoint contoh: `POST /user` dengan payload JSON `{ "action": "add", "count": 3 }`

## Catatan Tambahan
- Sistem ini harus mudah untuk ditambahkan event baru tanpa memodifikasi struktur utama.
- Bonus tambahan jika ada simulasi auto-scaling (misal: auto create worker thread/server ketika user bertambah banyak).
- **Pastikan semua file command/shell untuk melakukan deployment dapat berjalan baik di environment manapun (Windows, Linux, Mac, etc).**


## Asumsi
- Kamu dapat merancang arsitektur sesuai yang kamu butuhkan dan menambah infrastructure sesuai yang kamu butuhkan.
- Auto-scaling hanya berupa simulasi sederhana (misal berdasarkan jumlah user threshold).
- **Setiap instance / pod dari server service hanya dapat melayani maksimal 20 video yang ditonton secara bersamaan.**
- **Setiap video yang dijalankan oleh user akan dilayani oleh satu worker thread dari service server, dari awal sampai user selesai menonton.**
- **Auto-scaling akan dijalankan jika penggunaan RAM/CPU server mencapai antara 50-70%.**


---

Terima kasih atas partisipasinya. Semangat!
