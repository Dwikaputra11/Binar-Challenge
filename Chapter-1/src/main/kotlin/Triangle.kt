class Triangle(private var height: Int) : TriangleForm {

    fun getTinggi(): Int = height
    fun setTinggi(height: Int){
        this.height = height
    }

    override
    fun showTriangle(){
        println("\nPiramida Bintang")
        for(i in 0 until (height!!)){
            for(j in 0 until height*2){
                if(j  in height-i..height+i){
                    print("*")
                }else{
                    print(" ")
                }
            }
            println()
        }
    }
    override
    fun showInvertedTriangle(){
        println("\nPiramida Terbalik Bintang")
        for(i in (height - 1).downTo(0)){
            for(j in 0 .. height*2){
                if(j  in height-i  .. height+i){
                    print("*")
                }else{
                    print(" ")
                }
            }
            println()
        }
    }
    override
    fun showX(){
        println("\nX Bintang")
        for(i in 0 .. height*2){
            for(j in 0 .. height*2){
                if(i == height){
                    if(j == height){
                        print("*")
                    }else{
                        print(" ")
                    }
                }else if(i < height){
                    if(j == i || j == height*2-i){
                        print("*")
                    }else{
                        print(" ")
                    }
                }else if(i > height){
                    if(j  == height*2-i || j == (i+height)-(height*2-i+(i - height))){
                        print("*")
                    }else{
                        print(" ")
                    }
                }
            }
            println()
        }
    }
    override
    fun showDiamond(){
        println("\nPiramida Gabung Bintang")
        for(i in 0 .. height*2){
            for(j in 0 ..  height*2){
                if(i == height){
                    print("*")
                }else if(i < height){
                    if(j  in height-i..height+i){
                        print("*")
                    }else{
                        print(" ")
                    }
                }else if(i > height){
                    if(j  in i-height .. (i+height)-2*(i-height)){
                        print("*")
                    }else{
                        print(" ")
                    }
                }
            }
            println()
        }
    }
    override
    fun showRightTriangle(){
        println("\nSegitiga Siku")
        for(i in 0 until height){
            for(j in 0..i){
                print("*")
            }
            println()
        }
    }
}