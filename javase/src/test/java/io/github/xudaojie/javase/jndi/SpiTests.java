package io.github.xudaojie.javase.jndi;

import org.junit.Test;

import java.sql.DriverManager;

public class SpiTests {

    /**
     * 使用SPI加载MySQL jdbc driver
     */
    @Test
    public void mysqlDriverTest() {
//        ServiceLoader<Driver> serviceLoader = ServiceLoader.load(Driver.class);
//        Iterator<Driver> iterator = serviceLoader.iterator();
//        boolean hasMysql = false;
//        while (iterator.hasNext()) {
//            Driver driver = iterator.next();
//            System.out.println(driver.getClass().getName());
//            if (driver.getClass().getName().contains("mysql")) {
//                hasMysql = true;
//            }
//        }
//
//        assertTrue(hasMysql);

        // DriverManager默认会调用SPI加载jdbc驱动
        DriverManager.getDrivers();
    }
}
