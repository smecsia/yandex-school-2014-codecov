package me.smecsia.test;

/**
 * @author smecsia
 */
public class AgeDescriber {

    public String describePersonAge(String gender, int age) {
        if (gender.equals("male")) {
            if (age > 12 && age < 20) {
                return "A teenager";
            } else if (age < 25) {
                return "A young man";
            } else if (age > 25 && age < 40) {
                return "A man in his prime";
            }
        } else if (gender.equals("female")) {
            if (age < 20) {
                return "A girl";
            } else if (age > 20 && age < 40) {
                return "A young woman in childbearing age";
            } else {
                return "An older woman";
            }
        }
        return "A " + gender + " in undefined age";
    }
}
