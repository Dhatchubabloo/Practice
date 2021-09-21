package car_management;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Runner {
    static Scanner scan = new Scanner(System.in);
    static Logical logic = new Logical();
    public static void main(String[] args) {
        HashMap<String, HashMap<String, ArrayList<CarInfo>>>detailsMap = new HashMap<>();
        System.out.println("Enter Number of cities");
        int city = scan.nextInt();
        for(int i=1;i<=city;i++){
            HashMap<String, ArrayList<CarInfo>>branchMap =new HashMap<>();
            System.out.println("Enter city"+i);
            String cityName =scan.next();
            System.out.println("Enter subBranches");
            int branch = scan.nextInt();
            for(int j=1;j<=branch;j++){
                ArrayList<CarInfo> carList = new ArrayList();
                for(int k=0;k<2;k++) {
                    CarInfo info = new CarInfo();
                    carList.add(info);
                }
                System.out.println("Enter subbranch"+j);
                String subBranch = scan.next();
                branchMap.put(subBranch,carList);
            }
            detailsMap.put(cityName,branchMap);
        }
        logic.dataStore(detailsMap);
        execute();
    }
    static int temp=0;
    public static void execute() {
        int val = 0;
        while(val==0) {
            System.out.println("\n1.customer\n2.Admin\n3.Sales\n4.WholeDatils\n5.Exit");
            int choice = scan.nextInt();
            switch (choice) {
                case 1:
                    CustomerInfo info1 = new CustomerInfo();
                    System.out.println("Enter city");
                    String city = scan.next();
                    info1.setCity(city);
                    System.out.println("Ënter Branch");
                    info1.setBranch(scan.next());
                    System.out.println("Enter car brand");
                    String car = scan.next();
                    info1.setCar(car);
                    if (logic.customer(info1)) {
                        if (temp++ == 0) {
                            logic.setSoldFirst(city, car);
                        } else
                            logic.setSoldRecent(city, car);
                        System.out.println("Car sold!...");
                    } else
                        System.out.println("There will be no cars Are available" +
                                "Thank You!.......");
                    break;
                case 2:
                    System.out.println("1.dispatch\n2.Find city to Add stock\n3.find sold first city\n4.find sold recent city");
                    int option = scan.nextInt();
                    switch (option) {
                        case 1:
                            ArrayList<DispatchInfo> dispatchList = new ArrayList<>();
                            System.out.println("Enter Number of Brands");
                            int brandsCount = scan.nextInt();
                            System.out.println("Enter city");
                            String cityName = scan.next();
                            System.out.println("Enter branch");
                            String branch = scan.next();
                            for (int i = 1; i <= brandsCount; i++) {
                                DispatchInfo info = new DispatchInfo();
                                info.setCity(cityName);
                                info.setBranch(branch);
                                System.out.println("Enter car Brand" + i);
                                info.setCar(scan.next());
                                System.out.println("Enter count");
                                info.setCount(scan.nextInt());
                                dispatchList.add(info);
                            }
                            System.out.println(logic.dispatch(dispatchList));
                        case 2:
                            HashMap<String, Integer> data = logic.addStock();
                            if (data.size() == 0) {
                                System.out.println("There will be no city to add Stock");
                            } else {
                                for (Map.Entry<String, Integer> entry : data.entrySet()) {
                                    System.out.println(entry.getKey() + " - " + entry.getValue());
                                }
                            }
                        case 3:
                            System.out.println("City in which car sold first \n" + logic.getSoldFirst());
                            break;
                        case 4:
                            System.out.println("City in which car sold recent \n" + logic.getSoldLast());
                            break;
                    }
                    break;
                case 3:
                    System.out.println("1.Enter sales Data for weeks\n2.Find consecutive Days in which profit was most");
                    switch (scan.nextInt()) {
                        case 1:
                            int array[] = new int[7];
                            for (int i = 0; i < 7; i++) {
                                array[i] = scan.nextInt();
                            }
                            System.out.println(logic.updateSalesData(array));
                        case 2:
                            ArrayList<String> list = logic.getProdfitData();
                            for (String i : list)
                                System.out.print(i + " ");
                            System.out.println();
                    }
                    break;
                case 4:
                    for (Map.Entry entry : logic.getData().entrySet()) {
                        System.out.println(entry.getKey() + "-----");
                        HashMap<String, CarInfo> data = (HashMap<String, CarInfo>) entry.getValue();
                        for (Map.Entry entries : data.entrySet())
                            System.out.println(entries.getKey() + " - " + entries.getValue());
                    }
                    break;
                case 5:
                    ++val;
            }
        }
    }
}
