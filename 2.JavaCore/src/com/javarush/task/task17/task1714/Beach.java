package com.javarush.task.task17.task1714;

/* 
Comparable
*/

public class Beach implements Comparable<Beach>{
    private String name;      //название
    private float distance;   //расстояние
    private int quality;    //качество

    public Beach(String name, float distance, int quality) {
        this.name = name;
        this.distance = distance;
        this.quality = quality;
    }

    synchronized public String getName() {
        return name;
    }

    synchronized public void setName(String name) {
        this.name = name;
    }

    synchronized public float getDistance() {
        return distance;
    }

    synchronized public void setDistance(float distance) {
        this.distance = distance;
    }

    synchronized public int getQuality() {
        return quality;
    }

    synchronized public void setQuality(int quality) {
        this.quality = quality;
    }

    @Override
    synchronized public int compareTo(Beach o) {
//        return Float.compare(distance*quality, o.getDistance()*o.getQuality());
        if (!(this==o)) return ( (int)(distance - o.getDistance()) - 10*(quality- o.getQuality()));
        return 0;
    }

    public static void main(String[] args) {
        Beach beach1 = new Beach("beach1", 100, 5);
        Beach beach2 = new Beach("beach2", 100, 6);
        System.out.println(beach1.compareTo(beach1));
        System.out.println(beach2.compareTo(beach2));
        System.out.println(beach1.compareTo(beach2));
        System.out.println(beach2.compareTo(beach1));

    }
}
