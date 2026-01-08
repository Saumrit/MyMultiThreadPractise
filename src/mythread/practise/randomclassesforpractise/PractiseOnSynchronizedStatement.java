package mythread.practise.randomclassesforpractise;

import java.util.List;

public class PractiseOnSynchronizedStatement {
    String lastName;
    List<String> nameList;
    int nameCount=0;
    Object o1=new Object();
    Object o2=new Object();

    public void addName(String name){
        synchronized(this) {
            lastName = name;
            nameCount++;
        }
        nameList.add(name);
    }

    public void addName1(String name){
        synchronized(o1) {
            lastName = name;
            nameCount++;
        }
        nameList.add(name);
    }

    public void addName2(String name){
        synchronized(o2) {
            lastName = name;
            nameCount++;
        }
        nameList.add(name);
    }

    public static void main(String[] args) {

    }
}
