package me.smecsia.test;

/**
 * @author smecsia
 */
public class Main {

    public static void main(String[] args) {
        AgeDescriber describer = new AgeDescriber();
        for (int age = 0; age < 100; age++) {
            for (String gender : new String[]{"male", "female"}) {
                System.out.println(gender + " at age " + age + " is " + describer.describePersonAge(gender, age));
            }
        }
    }
}
