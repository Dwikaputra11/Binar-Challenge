// Nama: I Made Dwika Putra Riswanda

fun main(args: Array<String>) {
    val strip = "-".repeat(40)
    val sym = "=".repeat(40)
    println(sym)
    println("Selamat Datang")
    println(sym)

    print("\nMasukkan Tinggi: ")
    var height = readLine()?.toInt() ?: 0
    val triangle = Triangle(height)
    var isLoop = true
    while(isLoop) {
        val opt = menu()
        when(opt){
            1 -> triangle.showTriangle()
            2 -> triangle.showInvertedTriangle()
            3 -> triangle.showDiamond()
            4 -> triangle.showX()
            5 -> triangle.showRightTriangle()
            6 -> starPlus(triangle.getTinggi())
            7 -> {
                triangle.showTriangle()
                triangle.showInvertedTriangle()
                triangle.showDiamond()
                triangle.showX()
                triangle.showRightTriangle()
                starPlus(triangle.getTinggi())
            }
            8 -> {
                isLoop = false
                println(strip)
                println("TERIMA KASIH")
                println(strip)
                continue
            }
        }

        println(strip)
        print("Ubah Tinggi (Y/N)? ")
        var change = readLine()!! == "Y"
        println(strip)
        if(change){
            println("Tinggi Lama: " + triangle.getTinggi())
            print("Tinggi Baru: ")
            height = readLine()?.toInt() ?: 0
            triangle.setTinggi(height)
            println("BERHASIL DIRUBAH")
        }

    }
}

fun menu(): Int{
    val loop = true
    while(loop){
        print("1. Segitiga Bintang\n" +
                "2. Segitiga Bintang Terbalik\n" +
                "3. Segitiga Bintang Gabungan\n" +
                "4. Bentuk X\n" +
                "5. Segitiga Siku-Siku\n" +
                "6. Plus Bintang\n" +
                "7. Semua\n" +
                "8. Keluar\n")
        print("Pilih bentuk yang ingin ditampilkan: ")
        val opt = readLine()?.toInt() ?: 0
        if(opt in 1..7){
            return opt
        } else{
            println("Masukkan opsi sesuai pilihan!". uppercase())
        }
    }
    return  0
}

fun starPlus(height: Int){
    println("\nPlus Bintang")
    for(i in 1..height){
        for(j in 1..height){
            if(i == (height/2 + 1)){
                print("* ")
            }else if(j == (height/2 + 1)){
                print("*")
            }else{
                print("  ")
            }
        }
        println()
    }
}