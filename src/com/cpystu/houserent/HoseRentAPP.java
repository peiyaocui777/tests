package com.cpystu.houserent;

import com.cpystu.houserent.view.HouseView;

public class HoseRentAPP {
    public static void main(String[] args) {
        //这是一个用来创建HoseView对象的类，
        //可以显示主菜单
        //是整个房屋租赁程序的入口

        /*
        //创建对象并接收
        HouseView hs=new HouseView();
        hs.mainMenu();//调用
        这种方法不简洁
        */
        //创建匿名对象调用主菜单
        new HouseView().mainMenu();//？？匿名对象
        //mainMenu中有个循环，只要循环不退出就不会执行下面这句代码
        System.out.println("==你退出了系统==");//退出时提示信息
    }
}
