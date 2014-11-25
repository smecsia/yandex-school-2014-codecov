package me.smecsia.test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

/**
 * @author smecsia
 */
public class Steps {
    private final AgeDescriber describer;

    public Steps(AgeDescriber describer) {
        this.describer = describer;
    }

    @Step("describe a teenager")
    public void describeATeenager() {
        assertThat(describer.describePersonAge("male", 16), containsString("teenager"));
    }

    @Step("describe a man in his prime")
    public void describeAManInHisPrime() {
        assertThat(describer.describePersonAge("male", 30), containsString("in his prime"));
    }

    @Step("describe a girl")
    public void describeAGirl() {
        assertThat(describer.describePersonAge("female", 17), containsString("girl"));
    }

    @Step("describe a young and old boy")
    public void describeYoungAndOldBoy() {
        assertThat(describer.describePersonAge("male", 8), containsString("young"));
        assertThat(describer.describePersonAge("male", 40), containsString("undefined"));
    }
}
