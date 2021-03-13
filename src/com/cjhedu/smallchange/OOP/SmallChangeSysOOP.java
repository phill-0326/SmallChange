package com.cjhedu.smallchange.OOP;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * 该类完成零钱通的各个功能的类
 * 使用OOP(面向对象编程)
 * 将各个功能对应一个方法
 * author：phil
 */
public class SmallChangeSysOOP {
    //属性
    Boolean loop = true;
    Scanner scanner = new Scanner(System.in);
    int num;

    //1.先完成显示菜单，并可以选择
    //2.完成零钱通明细，使用字符串拼接的形式
    String detail = "\n------------零钱通明细------------";

    //3.完成收益入账
    double money = 0;
    double balance = 0;
    Date date = new Date();
    DateFormat sdf = new SimpleDateFormat("YYYY-MM-DD HH:mm");

    //4.完成消费
    String note = "";



    //1.先显示菜单，并可以选择
    public void mainMenu(){



        do {
            System.out.println("------------零钱通菜单(OOP)-----------");
            System.out.println("\t\t\t1 零钱通明细");
            System.out.println("\t\t\t2 收益入账");
            System.out.println("\t\t\t3 消费");
            System.out.println("\t\t\t4 退      出");
            System.out.println("请选择(1-4):");
            num = scanner.nextInt();
            switch (num) {
                case 1:
                   this.detail();
                   break;
                case 2:
                    this.inCome();
                    break;
                case 3:
                    this.pay();
                    break;
                case 4:
                    this.exit();
                    break;
                default:
                    System.out.println("输入有误，请重新输入！！！！！");
            }

        } while (loop);
    }

    //2.完成零钱通明细
    public void detail(){
        System.out.println(detail);
    }
    //3.完成收益入账
    public void inCome(){
        System.out.println("收益入账金额：");
        money = scanner.nextDouble();
        //money 的取值范围应该校验 -》 一会再完善
        //找出不正确的条件， 金额给出提示，直接退出break
        if (money < 0) {
            System.out.println("收益入账金额 需要 大于 0");
            return;
        }

        balance += money;
        //拼接收益入账信息到detail
        detail += "\n收益入账\t+" + money + "\t" + sdf.format(date) + "\t" + "余额：" + balance;

    }
    //4.完成消费
    public void pay(){
        System.out.println("消费金额：");
        money = scanner.nextDouble();
        if (money<0||money>balance){
            System.out.println("您的消费金额 应该在 0-"+balance);
            return;
        }

        System.out.println("消费说明：");
        note = scanner.next();
        balance -= money;
        //拼接信息到detail
        date = new Date();//获取当前的日期
        detail += "\n" + note + "\t\t-" + money + "\t" + sdf.format(date) + "\t" + "余额：" + balance;


    }
    //4.完成退出
    public void exit(){
        //功能扩展：
        String choice = "";
        while (true) {//使用while+break语句要求用户必须输入y/n，否则就一直循环
            System.out.println("你确定退出吗？ y/n");
            choice = scanner.next();
            if ("y".equals(choice) || "n".equals(choice)) {
                break;
            }
        }
        //当前用户退出while循环，进行判断
        if (choice.equals("y")) {
            loop = false;
        }
        return;

}


}
