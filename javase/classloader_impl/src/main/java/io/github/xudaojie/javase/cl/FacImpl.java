package io.github.xudaojie.javase.cl;

/**
 * @author XuDaojie
 * @since 2020/9/27
 */
public class FacImpl implements IFac {

    @Override
    public Data getData() {
        return new Data();
    }
}
