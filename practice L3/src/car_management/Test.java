package car_management;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        ArrayList data = new ArrayList();
        for(int i=0;i<5;i++){
            data.add(i);
        }
        System.out.println(data);
        data.clear();
        System.out.println(data);
    }
}
