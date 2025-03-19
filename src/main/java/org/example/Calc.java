package org.example;

import java.util.Arrays;

public class Calc {

    public static int run(String exp) {

        boolean needToMulti = exp.contains("*");
        boolean needToPlus = exp.contains("+");
        boolean needTole = exp.contains("(");

        boolean needToCompound = needToPlus && needToMulti;

        exp =stripOuterBrackets(exp);
        // 단일항이 들어오면 바로 리턴
        if (!exp.contains(" ")) {
            return Integer.parseInt(exp);
        }

        if (needToCompound&&needTole) {
            int a;
            int b = 0;

            stripOuterBrackets(exp);
            String[] bits = exp.split(" \\* ");
            for (int i = 0; i < bits.length; i++) {

                if (bits[i].contains("+")) {
                    String[] arr = bits[i].split(" \\+ ");
                    for (int j = 0; j < arr.length; j++) {

                        b += Integer.parseInt(arr[j]);

                    }

                } else {
                    a = run(bits[i]);
                    System.out.println("a=" + a);
                    b *= a;
                }
                System.out.println("sum=" + b);
            }
            return b;
        }
        else if (needToCompound) {
            int a;
            int b;
            int sum = 0;
            String[] bits = exp.split(" \\+ ");
            for (int i = 0; i < bits.length; i++) {
                if (bits[i].contains("*")) {
                    a = run(bits[i]);
                    System.out.println("a=" + a);
                    sum += a;
                } else {
                    b = Integer.parseInt(bits[i]);
                    System.out.println("b=" + b);
                    sum += b;
                }
                System.out.println("sum=" + sum);
            }
            return sum;
        }
        if (needToMulti) {

            String[] bits = exp.split(" \\* ");

            int sum = 1;

            for (int i = 0; i < bits.length; i++) {
                sum *= Integer.parseInt(bits[i]);
            }
            return sum;
        } else {
            exp = exp.replace("- ", "+ -");
            if (needTole) {
                stripOuterBrackets(exp);

                String[] bits = exp.split(" \\+ ");
                int sum = 0;
                for (int i = 0; i < bits.length; i++) {
                    sum += Integer.parseInt(bits[i]);
                    System.out.println("sum=" + sum);
                }
                return sum;
            }
            else {
                String[] bits = exp.split(" \\+ ");
                int sum = 0;
                for (int i = 0; i < bits.length; i++) {
                    sum += Integer.parseInt(bits[i]);
                }
                return sum;
            }

        }

    }
    private static String stripOuterBrackets(String exp) {
        if (exp.contains("(")&&exp.contains(")")) {
            exp = exp.replace("(", "");
            exp = exp.replace(")", "");
        }

        return exp;
    }
}