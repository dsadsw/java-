import java.util.Scanner;

public class TC1 {
    public static boolean isNumber(String str) {
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!Character.isDigit(c))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int a = 0, b = 0, c, checkcode;
        Scanner in = new Scanner(System.in);
        System.out.println("请输入商品条形码的前12位数字：");
        String code = in.nextLine();
        if (code.length() != 12 || !isNumber(code)) {
            System.out.println("输入的数据有误！！！");
        } else {
            for (int i = 0; i < 12; i++) {
                char ch = code.charAt(i);
                if ((i + 1) % 2 == 1)
                    a = a + ch - '0';
                else
                    b = b + 3 * (ch - '0');
            }
            c = (a + b * 3) % 10;
            checkcode = (10 - c) % 10;
            System.out.println("校验码是：" + checkcode);
        }
    }
}
