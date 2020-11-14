import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Feedback {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Class reveal = Privacy.class;

        try{
            Constructor<Privacy> builder =
                    reveal.getDeclaredConstructor(String.class,int.class);
            builder.setAccessible(true);
            System.out.println("写下你的名字以开始这个好玩的程序：");
            Privacy you = builder.newInstance(input.next(),15);
            Method doorOpened = reveal.getDeclaredMethod("doorOpen");
            doorOpened.setAccessible(true);
            Field name = reveal.getDeclaredField("name");
            Field age = reveal.getDeclaredField("age");

            doorOpened.invoke(you);
            Thread.sleep(1000);
            System.out.println("普查员：您好，第七次人口普查正在进行，请您出示自己的身份证，并确认这张表上的信息是否无误。");
            Thread.sleep(1000);
            System.out.println(you.name + "：好吧，配合就是了。");
            Thread.sleep(1000);
            System.out.println("普查表上写着：\n姓名：" + you.name + "\n年龄："  + you.age);
            Thread.sleep(1000);
            System.out.println(you.name + "：天啊，你们用的是过时的数据吧！你们把我的年龄写错了！");
            Thread.sleep(1000);
            System.out.println("普查员：对此我们很抱歉，请在此写下正确的信息：");
            age.setAccessible(true);
            age.set(you,input.nextInt());
            System.out.println("信息修改：你的年龄为：" + you.age);
            Thread.sleep(1000);
            System.out.println("普查员：信息修改完毕，感谢您的配合！");
            Thread.sleep(1000);
            System.out.println(you.name + "：辛苦你了，不过下次别再把我的年龄搞错了！");
            Thread.sleep(1000);
            System.out.println("——全剧终——");
        }catch(Exception e){
            ;
        }
    }
}
