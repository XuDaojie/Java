package io.github.xudaojie.javase.classloader;

public class Sample {
//    private Data data;
//
//    public Data getData() {
//        return data;
//    }
//
//    public void setData(Data data) {
//        this.data = data;
//    }

    private String a;

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Sample) {
            return ((Sample) obj).getA().equals(this.getA());
        }
        return super.equals(obj);
    }
}
