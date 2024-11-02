import java.util.Scanner;

public class QuadraticEquationSolver {
    // 成员变量存储方程的系数
    private double a;
    private double b;
    private double c;

    // 构造方法
    public QuadraticEquationSolver(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    // 计算判别式的方法
    private double calculateDiscriminant() {
        return b * b - 4 * a * c;
    }

    // 求解方程的方法
    public void solve() {
        double discriminant = calculateDiscriminant();

        if (discriminant > 0) {
            // 两个不同的实根
            double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            System.out.println("方程有两个不同的实根: " + root1 + " 和 " + root2);
        } else if (discriminant == 0) {
            // 一个实根
            double root = -b / (2 * a);
            System.out.println("方程有一个实根: " + root);
        } else {
            // 两个共轭复根
            double realPart = -b / (2 * a);
            double imaginaryPart = Math.sqrt(-discriminant) / (2 * a);
            System.out.println("方程有两个共轭复根: " + realPart + " + " + imaginaryPart + "i 和 " + realPart + " - " + imaginaryPart + "i");
        }
    }

    // 主方法用于测试
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("请输入系数a: ");
        double a = scanner.nextDouble();

        System.out.print("请输入系数b: ");
        double b = scanner.nextDouble();

        System.out.print("请输入系数c: ");
        double c = scanner.nextDouble();

        // 创建求解器实例并设置系数
        QuadraticEquationSolver solver = new QuadraticEquationSolver(a,b,c);
        solver.setA(a);
        solver.setB(b);
        solver.setC(c);

        // 求解方程
        solver.solve();

        // 关闭扫描器
        scanner.close();
    }

    void setC(double c) {
    }

    void setB(double b) {
    }

    void setA(double a) {
    }
}