object M {
//    def main(args: Array[String]): Unit = {
//        println("Hello World!")
//        // for (var <-
//        for (a <- 1 to 10) {
//            println("index:" + a)
//        }
//
//        m3()
//
//    }

    // 方法
    def m1(): Unit = {
        println("m1")
    }

    def m2(f:(Int,Int) => Int) : Int = {
        f(2, 6)
    }

    def m3() : Unit = {
        m2(addInt1)
    }

    // 函数
    val addInt = (x: Int,y: Int) => x + y
    val addInt1 = (x: Int,y: Int) => {
        println("Hello World!")
        x + y
    }

    def apply(x: Int): String = {
        x + ""
    }

}
