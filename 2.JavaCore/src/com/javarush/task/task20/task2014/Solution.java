package com.javarush.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/* 
Serializable Solution
*/
public class Solution implements Externalizable{
    public static void main(String[] args) throws Exception {
        Solution savedObject = new Solution(5);
        Solution loadedObject;
        OutputStream outputStream = new FileOutputStream("D:\\1.txt");
        InputStream inputStream = new FileInputStream("D:\\1.txt");

        ObjectOutputStream out = new ObjectOutputStream(outputStream);
        ObjectInputStream in = new ObjectInputStream(inputStream);
        out.writeObject(savedObject);
        out.close();

        loadedObject = (Solution) in.readObject();
        System.out.println(savedObject.string.equals(loadedObject.string));
    }

    transient private final String pattern = "dd MMMM yyyy, EEEE";
    transient private Date currentDate;
    transient private int temperature;
    String string;

    public Solution() {
    }

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
//        out.writeLong(currentDate.getTime());
//        out.writeInt(temperature);
        out.writeUTF(string);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
//        currentDate = new Date(in.readLong());
//        temperature = in.readInt();
        string = in.readUTF();
    }
}
