import java.util.Scanner;

public class LoanCalculator {
    // 贷款总额（万元）
    private double loanAmount;
    // 贷款时间（月数）
    private int loanTermMonths;
    // 月利率
    private double monthlyInterestRate;

    // 构造方法，使用默认参数（这里实际上不需要，因为我们会从用户输入获取值）
    // 但为了保持类的完整性，可以保留一个不带参数的构造方法（可选）
    public LoanCalculator() {}

    // 一个带参数的构造方法，用于直接初始化（如果需要从其他地方传递值时使用）
    public LoanCalculator(double loanAmount, int loanTermMonths, double monthlyInterestRate) {
        this.loanAmount = loanAmount;
        this.loanTermMonths = loanTermMonths;
        this.monthlyInterestRate = monthlyInterestRate;
    }

    // 设置贷款总额
    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    // 设置贷款时间
    public void setLoanTermMonths(int loanTermMonths) {
        this.loanTermMonths = loanTermMonths;
    }

    // 设置月利率
    public void setMonthlyInterestRate(double monthlyInterestRate) {
        this.monthlyInterestRate = monthlyInterestRate;
    }

    // 计算等额本金还款法的总利息
    public double calculateEqualPrincipalInterest() {
        return (loanTermMonths + 1) * loanAmount * monthlyInterestRate / 2;
    }

    // 计算等额本息还款法的总利息
    public double calculateEqualInstallmentInterest() {
        double power = Math.pow(1 + monthlyInterestRate, loanTermMonths);
        double totalInterest = loanAmount * monthlyInterestRate * power / (power - 1) * loanTermMonths - loanAmount;
        return totalInterest;
    }

    // 主方法用于测试和用户输入
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 从用户输入获取贷款总额
        System.out.print("请输入贷款总额（万元）: ");
        double loanAmount = scanner.nextDouble();

        // 从用户输入获取贷款时间（月数）
        System.out.print("请输入贷款时间（月数）: ");
        int loanTermMonths = scanner.nextInt();

        // 从用户输入获取年利率
        System.out.print("请输入年利率（%）: ");
        double annualInterestRate = scanner.nextDouble();

        // 计算月利率
        double monthlyInterestRate = annualInterestRate / 12 / 100;

        // 创建贷款计算器实例并设置值
        LoanCalculator calculator = new LoanCalculator();
        calculator.setLoanAmount(loanAmount);
        calculator.setLoanTermMonths(loanTermMonths);
        calculator.setMonthlyInterestRate(monthlyInterestRate);

        // 计算并输出两种还款方式的总利息
        System.out.println("等额本金还款法的总利息: " + calculator.calculateEqualPrincipalInterest() + " 万元");
        System.out.println("等额本息还款法的总利息: " + calculator.calculateEqualInstallmentInterest() + " 万元");

        // 关闭扫描器
        scanner.close();
    }
}