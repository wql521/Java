import java.util.Scanner;

public class StringDemo6 {
    /*把2135变成：零佰零拾零万贰仟壹佰叁拾伍元
      把789变成：零佰零拾零万零仟柒佰捌拾玖元*/
    public static void main(String[] args) {
        //1.键盘录入一个金额
        Scanner sc = new Scanner(System.in);
        int money;
        while (true){
            System.out.print("请录入一个金额:");
            money = sc.nextInt();
            if (money >= 0 && money <= 9999999){
                break;
            }else {
                System.out.println("金额无效");
            }
        }
        //定义一个变量用来表示钱的大写
        String moneyst = "";

        //2.得到money中的每一位数字
        while (true){//123
            //从右往左获取数据，获取个为
            int ge = money % 10;
            String capitanumber = getCapitaNumber(ge);
            //把转换之后的大写拼接到moneyStr当中
            moneyst = capitanumber + moneyst;
            //第一次循环 ： "伍" + "" = "伍"
            //第二次循环 ： "叁" + "伍" = "叁伍"
            //去掉刚刚获取的数据
            money = money / 10; //12
            //如果数字上的每一位全部获取到了，那么money记录的就是0，此时循环结束
            if (money == 0){
                break;
            }
        }

        //3.在前面补0，补齐7位
        int count = 7 - moneyst.length();
        for (int i = 0; i < count; i++) {
            moneyst = "零" + moneyst;
        }

        //4.插入单位
        String[] arr = {"佰","拾","万","仟","佰","拾","元"};
        //遍历moneyStr，依次得到 零    零   零   贰   壹   叁   伍
        //然后把arr的单位插入进去

        String result = "";
        for (int i = 0; i < moneyst.length(); i++) {
            char c = moneyst.charAt(i);
            //把大写数字和单位拼接到result当中
            result = result + c + arr[i];
        }

        //5.打印最终结果
        System.out.println(result);

    }
    //定义一个方法把数字变成大写的中文
    public static String getCapitaNumber(int number){
        //定义数组，让数字跟大写的中文产生一个对应关系
        String[] arr = {"零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖"};
        //返回结果
        return arr[number];
    }
}
