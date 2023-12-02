package com.example.myrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvHeroes: RecyclerView
    private val list = ArrayList<Hero>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvHeroes = findViewById(R.id.rv_heroes)
        rvHeroes.setHasFixedSize(true)
        
        list.addAll(getListHeroes())
        showRecyclerList()

        // RecyclerView adalah sebuah komponen tampilan (widget) yang lebih canggih ketimbang pendahulunya, yakni ListView.

        // Berikut ini adalah beberapa kelebihan ketika kita menggunakan RecyclerView.

        // 1. Memiliki memori yang ringan dan performa yang baik.
        // 2. Secara default memiliki ViewHolder.
        // 3. Mudah untuk memberikan animasi ketika menambahkan, memperbarui, atau menghapus item dengan ItemAnimator.
        // 4. Mendukung LayoutManager untuk mengubah tata letak.
        // 5. Mendukung pengguliran (scrolling) secara vertikal dan horizontal.
        // 6. Dapat digunakan bersama dengan DiffUtil.

        // Alur Latihan
        // 1. Menambahkan RecyclerView
        // 2. Membuat item layout
        // 3. Membuat Data Class
        // 4. Membuat Adapter RecyclerView
        // 5. Mengatur Layout Manager dan Adapter
        // 6. Menambahkan Onclick pada Adapter
        // 7. Membuat callback untuk Onclick pada Adapter
        // 8. Mengubah tampilan list menjadi grid menggunakan Layout Manager

        // Proses
        // 1. Menambahkan plugin kotlin-parcelize pada build.gradle (module:app) dan langsung di Synchronization
        // 2. Masukkan komponen berupa gambar-gambar kedalam project
        // 3. Oke, lanjut pada activity_main.xml. Untuk menambahkan RecyclerView, silakan drag item RecyclerView ke dalam screen.
        // 4. Oke, komponen RecyclerView sudah ditambahkan, kini saatnya kita membuat sebuah item tampilan dalam bentuk berkas layout xml yang akan ditampilkan di RecyclerView. Karena data pertama kali akan ditampilkan dalam bentuk list, kita perlu membuat layout dengan cara klik kanan pada direktori layout → new → layout resource file dan beri nama item_row_hero. Pastikan Root element menggunakan ConstraintLayout terlebih dahulu.
        // 5. Setelah terbentuk, silakan buat desain untuk layout item\
        // 6. Tambahkan String Value dalam res->values->string.xml
        // 7. Kemudian buat sebuah kelas model data bernama Hero dengan cara klik kanan pada nama package → new → Java/Kotlin class. Class ini nantinya digunakan untuk menampung property data yang akan ditampilkan.
        // 8. Setelah itu, kita bisa menambahkan property data yang akan ditampilkan, seperti nama, deskripsi, dan photo.
        // 9. Jangan lupa untuk menambahkan implementasi parcelable ke kelas Hero seperti pada Modul Intent Explicit dengan Parcelable.
        // 10. Sekarang kita akan membuat sebuah adapter yang akan memformat tampilan setiap elemen dari koleksi data. Buatlah kelas adapter secara manual dengan klik kanan pada package utama → new → Kotlin/Java Class dan beri nama ListHeroAdapter.
        // 11. Kemudian muncul garis merah pada kode, begitu pun pada ListViewHolder. Kita resolve satu per satu. Pertama adalah kita tekan alt+enter/klik tombol merah pada ListViewHolder dan pilih Create class ListViewHolder, kemudian pilih ListHeroAdapter karena kita akan membuat sebuah inner class, Kemudian pilih ListHeroAdapter untuk membuat kelas ListViewHolder di dalam ListHeroAdapter.
        // 12. Masih ada garis merah. Arahkan kursor ke teks class ListHeroAdapter dan lakukan lagi alt+enter / klik tombol merah, lalu pilih implement members (Kotlin) atau implement methods(Java).
        // 13. Kemudian pilih ketiga metode dari RecyclerView.Adapter.
        // 14. Garis merahnya masih ada karena ListViewHolder seharusnya inherit ke RecyclerView.ViewHolder.
        // 15. Kemudian buatlah constructor untuk list
        // 16. Setelah itu kita bisa melengkapi kode kode hasil dari turunan RecyclerView.Adapter sehingga kode lengkap dari kelas ListHeroAdapter
        // Catatan untuk nomor (16): Variabel parent didapat dari parameter yang ada pada fungsi onCreateViewHolder. Apabila hasil generate pada Android Studio Anda berbeda (misal viewGroup, bukan parent). Silakan sesuaikan saja dengan parameternya atau nama variabelnya.
        // 17. Kemudian kita modifikasi berkas kelas MainActivity dan atur fixed size RecyclerView yang sudah dibuat di activity_main.
        // 18. Selanjutnya setelah diinisiasikan, kita akan panggil data yang sudah kita buat di resource strings.xml.

        // Selanjutnya Masuk untuk Latihan OnClick pada Item RecyclerView
        // 1. Bukalah kelas ListHeroAdapter dan perhatikan kode berikut. Pada bagian ini, kita bisa menambahkan fungsi onclick setiap itemnya ditekan. Tambahkan kode baris berikut ke dalam fungsi onBindViewHolder.
        // 2. Pertanyaan selanjutnya, bagaimana jika kita ingin agar fungsi onClick dapat dipicu atau di-trigger dari kelas MainActivity? Silakan hapus fungsi onClick yang telah Anda buat sebelumnya, kemudian tambahkan interface berikut dan implementasikan onClickke kelas interface berikut.

        // Selanjutnya Masuk untuk Latihan mengubah tampilan pada RecyclerView
        // # Anda juga bisa mengubah tampilan List menjadi mode Grid. Namun sebelum itu, buat terlebih dahulu menu untuk menampilkan opsi tampilan pada App Bar. Ikut beberapa langkah berikut untuk melakukannya.

        // 1. Langkah pertama yang perlu Anda lakukan adalah mengubah tema bawaan dari NoActionBar. Mengapa mengganti tema? Sebab, kita akan menambahkan option menu pada halaman Activity. Bukalah berkas themes.xml di res/values/themes, baik untuk mode siang dan malam. Setelah itu, hapus bagian .NoActionBarpada tema utama aplikasi.

        // 2. Selanjutnya buat resource directory terkait. Resource directory menu secara bawaan tidak disediakan. Kita harus membuatnya terlebih dahulu. Klik kanan pada direktori res → new → Android Resource Directory.

        // 3. Setelah muncul dialog box seperti di bawah ini, ganti Resource type menjadi menu dan tekan OK.

        // 4. Kemudian klik kanan pada folder menu → New → Menu Resource File.

        // 5. Beri nama menu_main pada File name dan pilih OK.

        // 6. Setelah itu, tambahkan pilihan menu pada menu_main.xml

        // 7. Setelah selesai, saatnya kita pasang menu tersebut di MainActivity dengan menambahkan metode fungsi onCreateOptionsMenu. Untuk menambahkannya, ketik onCreateOptionMenu di dalam MainActivity sehingga snippet akan muncul untuk meng-override fungsi yang sesuai.

        // 8. Saat ini belum ada perubahan ketika menu dipilih. Kita akan menambahkan aksi dengan menambahkan fungsi onOptionsItemSelected pada MainActivity
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_list -> {
                rvHeroes.layoutManager = LinearLayoutManager(this)
            }
            R.id.action_grid -> {
                rvHeroes.layoutManager = GridLayoutManager(this, 2)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun getListHeroes(): ArrayList<Hero> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listHero = ArrayList<Hero>()
        for (i in dataName.indices) {
            val hero = Hero(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1))
            listHero.add(hero)
        }
        return listHero
    }

    private fun showRecyclerList() {
        rvHeroes.layoutManager = LinearLayoutManager(this)
        val listHeroAdapter = ListHeroAdapter(list)
        rvHeroes.adapter = listHeroAdapter

        listHeroAdapter.setOnItemClickCallback(object : ListHeroAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Hero) {
                showSelectedHero(data)
            }
        })

    }
    private fun showSelectedHero(hero: Hero) {
        Toast.makeText(this, "Kamu memilih " + hero.name, Toast.LENGTH_SHORT).show()
    }
}