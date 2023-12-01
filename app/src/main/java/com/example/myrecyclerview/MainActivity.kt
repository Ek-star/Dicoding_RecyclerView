package com.example.myrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
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
    }
}