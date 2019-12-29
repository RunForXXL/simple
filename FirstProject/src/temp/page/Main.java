package temp.page;

import static temp.utils.ScannerChoice.ScannerInfoString;

public class Main {

    public static void main(String[] args) {
        Main.mainPage();
    }

    private static void mainPage() {
        System.out.println("***************************\n");
        System.out.println("\t 1.商品维护\n");
        System.out.println("\t 2.前台收银\n");
        System.out.println("\t 3.商品管理\n");
        System.out.println("***************************");

        System.out.println("\n请输入选项,或者按0退出.");
        do
        {
            String choice = ScannerInfoString();
            String regex = "[0-3]";//正则表达式
            if (choice.matches(regex))
            {
                int info = Integer.parseInt(choice);
                switch (info)
                {
                    case 0:
                        System.out.println("------------------");
                        System.out.println("您已经退出系统!");
                        System.exit(1);//退出程序，返回值随便设置
                        break;
                    case 1:
                        MaintenancePage();
                        break;
                    case 2:
                        checkstandLogPage();
                        break;
                    case 3:
                        commodityManagementPage();
                        break;
                    default:
                        break;
                }
            }
            System.err.println("!输入有误!");
            System.out.println("重新选择或者按0退出.");
        } while (true);

    }

    /**
     * 1.商品维护界面
     */
    private static void MaintenancePage() {
        System.out.println("***************************\n");
        System.out.println("\t 1.添加商品\n");
        System.out.println("\t 2.更改商品\n");
        System.out.println("\t 3.删除商品\n");
        System.out.println("\t 4.查询商品\n");
        System.out.println("\t 5.显示所有商品\n");
        System.out.println("***************************");

        System.out.println("\n请输入选项,或者按 0 返回上一级菜单.");



    }

    private static void checkstandLogPage() {
    }

    private static void commodityManagementPage() {
    }


}
