public class DemoApplication {
    public static void main(String[] args) {
        System.out.println(Solution.cutRope(15));
    }
}

/*
* 自上而下分析，将一条绳子的剪段乘积最大值问题，等价为两条绳子的剪段乘积最大值问题
* 自下而上计算，
* 只需将中间值存储下来即可
* */