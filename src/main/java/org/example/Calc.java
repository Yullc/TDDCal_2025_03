package org.example;

public class Calc {

    public static int run(String exp) {


        if(exp.contains("*")) {
            String[] bits = exp.split(" \\* ");

            System.out.println(bits.length);
            System.out.println(bits[0] + "*" + bits[1] + "*" + bits[2]);

            int a = Integer.parseInt(bits[0]);
              
            int b = Integer.parseInt(bits[1]);
            int c = Integer.parseInt(bits[2]);
                System.out.println(a + "*" + b + "*" + c);
            return a * b * c;
    }
        else{
            exp = exp.replace("- ", "+ -");
            String[] bits = exp.split(" \\+ ");

            int a = Integer.parseInt(bits[0]);
            System.out.println(bits[0]);
            int b = Integer.parseInt(bits[1]);
            int c = 0;

            if (bits.length > 2) {
                c = Integer.parseInt(bits[2]);
            }

            return a + b + c;

        }

    }

}