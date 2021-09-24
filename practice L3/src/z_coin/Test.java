package z_coin;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        ArrayList <Integer>list = new ArrayList();
        for(int i=0;i<10;i++){
            list.add(i);
        }
        System.out.println(list);
        for(int i=0;i< list.size();i++){
            if(list.get(i)%2==0){

            }
            else
                list.remove(i);
        }
        System.out.println(list);

    }
}
