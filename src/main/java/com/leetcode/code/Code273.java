package com.leetcode.code;

public class Code273 {

    public static void main(String[] args) {
        System.out.println(numberToWords(1000000));
    }

    // 单个数字 0,1,2,3,4,5,6,7,8,9
    private static String[] OneNum = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    // 十几 10,11,12,13,14,15,16,17,18,19
    private static String[] TenNum = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    // 整十 10,20,30,40,50,60,70,80,90
    private static String[] AnyTen = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    // 三位一组 几千，几百万，几十亿
    private static String[] ThreeNum = {"", "Thousand", "Million", "Billion"};

    public static String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        StringBuilder sb = new StringBuilder();
        // 每三位一组，比如1234567891 => 1,234,567,891
        // 1Billion 234Million 567Thousand 891
        int idx = 3;
        for (int x = 1000000000; x > 0; x/=1000) {
            // 此处%1000，为了防止000后边出现Million Thousand
            if (num/x%1000 != 0) {
                // 三位一组进行计算
                System.out.println(num/x%1000);
                sb.append(calcThreeNum(num/x%1000)).append(" ").append(ThreeNum[idx]).append(" ");
            }
            idx--;
        }
        return sb.toString().trim();
    }

    // 计算一位数 [0, 9]
    private static String calcOneNum (int num) {
        return OneNum[num];
    }

    // 计算两位数 [01, 99]
    private static String calcTwoNum (int num) {
        if (10 <= num && num < 20) {
            return TenNum[num-10];
        }
        return num<10 ? calcOneNum(num%10) : AnyTen[num/10] + (num%10==0 ? "" : " "+OneNum[num%10]);
    }

    // 计算三位数 [001, 999]
    private static String calcThreeNum (int num) {
        // 比如：001  012  345
        // 001 [001, 009]
        if (num / 10 == 0) {
            return calcOneNum(num);
        }
        // 012 [010, 099]
        if (num / 10 < 10) {
            return calcTwoNum(num);
        }
        // 345 [100, 999]
        return calcOneNum(num/100) + " Hundred" + (num%100==0 ? "" : " "+calcTwoNum(num%100));
    }

}
