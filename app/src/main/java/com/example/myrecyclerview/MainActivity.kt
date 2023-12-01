package com.example.myrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
        // 19. 
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
    }


}