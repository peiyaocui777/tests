package com.cpystu.houserent.service;

import com.cpystu.houserent.domain.House;

/*
 HouseService.java类（业务层）
 作用：
 1.实现对房屋的增删改查
 2.响应HouseView的调用
 3.定义House[]数组，保存house对象  ？？？？为什么house数组要放在service类里面
 4.list方法返回所有房屋信息(在HouseView里编写listHouse（）调用房屋信息)
属于业务层代码  核心逻辑  增删改查  封装的意义
方便扩展和维护 后期框架调用大都 调用service 层的代码 互相调用
* */
public class HouseService {
    //1.定义一个house数组保存house对象
    private House[] houses;//声明一个House数组，名字叫houses  此时为空
    private int houseNums = 1;//记录当前房屋个数
    private int idCounter = 1;//记录当前id值

    //1.1使用构造器初始化houses，并指定数组大小（size）
    public HouseService(int size) {//构造器的名字与类名保持一致
        //创建houses
        houses = new House[size];//创建HouseService对象时，指定数组大小（？？）
        //当前数组中没有信息
        houses[0] = new House(1, "join", "142", "海淀区", 2000, "未出租");
        //houses[0]=new House{1,"cc",...}是错误的吗？？
    }

    //del方法，实现删除一个房屋信息，返回一个boolean值，删除成功/失败
    public boolean del(int delId) {//del(int delId):这个方法接收的是想要删除的房间id号
        //但是房间的id不等于房屋的下标，要根据下标找到删除的房屋信息
        int index = -1;//下标
        //遍历当前数组的所有元素
        for (int i = 0; i < houseNums; i++) {
            if (delId == houses[i].getId()) {//判断要删除的这个房屋有没有存在在数组中
                //？？？要删除的房屋id是数组下标为i的元素
                index = i;
            }
        }
        if (index == -1) {//delId在数组中没有找到对应的下标，即不存在这个id？
            return false;
        }
        for (int i = 0; i < houseNums - 1; i++) {
            houses[i] = houses[i + 1];//后面的元素往前移动
        }
        houses[houseNums - 1] = null;//把当前存在的信息的最后一个的置空
        //houses[--houseNums]=null;
        return true;
    }

    //add方法添加新对象，返回boolean值，true添加成功，false添加失败
    public boolean add(House newHouse) {
        //判断是否可以继续添加（House[10]）
        //我要判断这个数组里能不能继续添加信息
        // 为什么还需要定义一个变量来记录当前数组大小 再跟arr.length比较呢
        //House[10]只是定义了一个空对象，与实际的有效元素不一样
        //需要定义一个houseNumes变量记录现在真正存在的数组个数
        if (houseNums == houses.length) {
            //return false;
            System.out.println("数组已满，不能添加");
            return false;
        } else {
            houses[houseNums] = newHouse;//把newHouse的信息赋给数组中的这个值
            houseNums++;//信息数量增加
            //houses[houseNums++]=newHouse;与上面两行代码实现的功能相同，这个更简洁
            //！id自增需要我们自己设计，定义一个变量记录当前id值，
            //每添加一条房屋信息（即houseNums+1）id也增加1
            idCounter++;//更新newHouse的id
            newHouse.setId(idCounter);
            //newHouse.setId(++idCounter);
            return true;
        }
    }

    //用list方法返回houses信息
    public House[] list() {
        return houses;
    }
}
