package temp.utils;

import java.util.Scanner;

public class ScannerChoice {

    /**
     * @return double 键盘获取商品价格,小数点后两位
     */
    public static double ScannerInfo(){
        double num = 0.00;
        do{
            Scanner scanner = new Scanner(System.in);
            System.out.println("保留小数点后两位，请输入：");
            String info = scanner.next();
            String regex = "(([1-9][0-9]*)\\.([0-9]{2}))|[0]\\.([0-9]{2})";//保留小数点后2位小数
            if(info.matches(regex)){
                num = Double.parseDouble(info);
            }else {
                System.out.println("输入有误，请重新输入:");
                continue;
            }
            break;

        }while (true);
        return num;
    }

    /**
     * @return int 键盘获取商品数量
     */
    public static int ScannerNum(){
        int num = 0;
        String regex = "([1-9])|([1-9][0-9]+)";//商品数量
        do {
            Scanner scanner = new Scanner(System.in);
            String info = scanner.next();

            if(info.matches(regex)){
                num = Integer.parseInt(info);
            }else{
                System.out.println("输入有误，请重新输入");
                continue;
            }
            break;
        }while (true);
        return num;
    }

    /**
     * @return String 获取的键盘输入
     */
    public static String ScannerInfoString(){
        Scanner scanner = new Scanner(System.in);
        String info = scanner.next();
        return info;
    }

    /**
     * 获取用户-更改完商品-下一步
     * 获取用户-删除完商品-下一步
     * 获取用户-添加完商品-下一步
     * @param 调用者
     */

    /**
     * 获取用户-更改-完售货员-下一步
     * 获取用户-添加-完售货员-下一步
     * 获取用户-查询-完售货员-下一步
     * 获取用户-删除-完售货员-下一步
     * @param 调用者
     */
}
