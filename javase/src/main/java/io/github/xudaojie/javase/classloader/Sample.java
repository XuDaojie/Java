package io.github.xudaojie.javase.classloader;

public class Sample {
    private Sample sample;

    public void print() {
        System.out.println("Class.print");
    }

    public Sample getSample() {
        return sample;
    }

    public void setSample(Sample sample) {
        this.sample = sample;
    }
}
