package com.cpystu.houserent.view;

import com.cpystu.houserent.utils.Utility;

/*
* 这个类要实现的功能
* 1.显示界面
* 2.接收用户的输入
* 3.调用HouseService完成对房屋信息的各种操作
**/
public class HouseView {
    //类似零钱通的界面显示，使用do-while循环
    //定义变量loop控制循环是否结束
    private boolean loop =true;//?属性有默认返回值，变量没有（我不确定）
    //TODO
    /**
     * 是的 类变量有默认值 private boolean loop; ====> 这样写编译器并没有报错
     * 方法周变量没有 需要设置
     */
    //定义变量key接收输入信息
    private char key=' ';//'空格'
    //1.显示一个主菜单
    public void mainMenu(){
        do {
            System.out.println("------------房屋出租系统---------");
            System.out.println("\t\t\t1 新 增 房 源");
            System.out.println("\t\t\t2 查 找 房 屋");
            System.out.println("\t\t\t3 删 除 房 屋 信 息");
            System.out.println("\t\t\t4 修 改 房 屋 信 息");
            System.out.println("\t\t\t5 显 示 房 屋 列 表");
            System.out.println("\t\t\t6 退       出 ");
            System.out.println("请输入你的选择（1-6）：");
            key= Utility.readChar();//调用工具类获取键盘输入信息
            //判断用户输入的信息并执行对应的操作
            //使用switch-case分支判断
            switch (key){
                case '1'://key的值与case比较
                    System.out.println("新 增 房 源");
                    break;//不要忘记break
                case '2':
                    System.out.println("查 找 房 屋");
                    break;//不要忘记break
                case '3':
                    System.out.println("删 除 房 屋 信 息");
                    break;//不要忘记break
                case '4':
                    System.out.println("修 改 房 屋 信 息");
                    break;//不要忘记break
                case '5':
                    System.out.println("显 示 房 屋 列 表");
                    break;//不要忘记break
                case '6':
                    System.out.println("退       出");
                    loop=false;
                    break;//不要忘记break
            }
        }while (loop);//;
    }

}
