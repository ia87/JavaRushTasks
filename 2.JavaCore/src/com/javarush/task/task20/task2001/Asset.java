package com.javarush.task.task20.task2001;

import java.io.*;

public class Asset {
    public Asset(String name) {
        this.name = name;
    }

    private String name;
    private double price;

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Asset asset = (Asset) o;

        if (Double.compare(asset.price, price) != 0) return false;
        return name != null ? name.equals(asset.name) : asset.name == null;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name != null ? name.hashCode() : 0;
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    public void save(OutputStream outputStream) throws Exception
    {
        PrintWriter printWriter = new PrintWriter(outputStream);
        printWriter.println(name);
        printWriter.println(price);
        printWriter.flush();
//        printWriter.close();
    }

    public void load(InputStream inputStream) throws Exception
    {
        BufferedReader fileReader = new BufferedReader(new InputStreamReader(inputStream));
        System.out.println(fileReader.ready());

        name = fileReader.readLine();
        System.out.println(name);
        price = Integer.parseInt(fileReader.readLine());
        System.out.println(price);
//        reader.close();
    }
}
