package com.layout;


import java.util.Scanner;

import com.controller.DbController;

public class Delete {
    public static void showDeleteData() {
        Scanner sc = new Scanner(System.in);

        System.out.println("==================================");
        System.out.println("Silahkan Pilih Data yang Ingin Dihapus");
        System.out.println("----------------------------------");
        DbController.getDatabase();
        System.out.println("----------------------------------");
        System.out.print("Pilih Nama Produk: ");
        String nama = sc.nextLine();
        System.out.println("==================================");

        if (DbController.deleteData(nama)) {
            System.out.println("Data Berhasil diDelete");
        } else {
            System.out.println("Maaf, Data Gagal diDelete");
        }

        System.out.println("----------------------------------");
        Menu.showMenu();
        sc.close();
    }
}

