package com.zoho.l2_programs;

import java.util.*;

public class MapSortBasedOnValue {
    public static void main(String[]args){
        Scanner scan = new Scanner(System.in);
        HashMap<Integer,Employee>map = new HashMap<>();
        for(int i=1;i<5;i++){
            Employee info = new Employee();
            System.out.println("Name");
            info.setName(scan.next());
            System.out.println("Age");
            info.setAge(scan.nextInt());
            System.out.println("Salary");
            info.setSalary(scan.nextFloat());
            map.put(i,info);
        }
        System.out.println("Before Sorting");
        for(Map.Entry<Integer,Employee>entry: map.entrySet()){
            System.out.println(entry.getKey()+" - "+entry.getValue());
        }
        ArrayList<Map.Entry<Integer,Employee>> list = new ArrayList<>();
        for(Map.Entry<Integer,Employee>entry:map.entrySet()){
            list.add(entry);
        }
      Comparator<Map.Entry<Integer,Employee>>cmp=new Comparator<Map.Entry<Integer,Employee>>() {
          @Override
          public int compare(Map.Entry<Integer, Employee> o1, Map.Entry<Integer, Employee> o2) {
              if(o1.getValue().getSalary()>o2.getValue().getSalary())
                  return -1;
              else if(o1.getValue().getSalary()<o2.getValue().getSalary())
                  return +1;
              else
               return 0;
          }
        };
        Collections.sort(list,cmp);
        System.out.println("After sorting by salary");
        for(Map.Entry<Integer,Employee>list1:list){
            System.out.println(list1);
        }
        System.out.println("Dummy");
        for(Map.Entry<Integer,Employee>entry: map.entrySet()){
            System.out.println(entry.getKey()+" - "+entry.getValue());
        }
    }
}
class Employee{
    private String name;
    private int age;
    private float salary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }
    public String toString(){
        return name+"\t"+age+"\t"+salary;
    }
}
