package mythread.practise.randomclassesforpractise;

import java.util.Objects;

public class Cat {
    String aname;
    String type;

    public Cat(String aname, String type) {
        this.aname = aname;
        this.type = type;
    }

    public static void main(String[] args) {
        Cat cat1= new Cat("asas","wqwqw");
        Cat cat2= new Cat("asas","wqwqw");
        Cat cat3= cat2;
        System.out.println("Cat1 is "+cat1.hashCode());
        System.out.println("Cat2 is "+cat2.hashCode());
        System.out.println("Cat2 is "+cat3.hashCode());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cat cat)) return false;
        return Objects.equals(aname, cat.aname) && Objects.equals(type, cat.type);
    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(aname, type);
//    }
}
