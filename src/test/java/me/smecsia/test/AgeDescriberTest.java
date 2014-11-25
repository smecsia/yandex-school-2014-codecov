package me.smecsia.test;

import org.junit.Test;

/**
 * @author smecsia
 */
public class AgeDescriberTest {
    Steps steps = new Steps(new AgeDescriber());

    @Test
    public void testAllDescribeVariants() {
        steps.describeYoungAndOldBoy();
        steps.describeATeenager();
        steps.describeAGirl();
        steps.describeAManInHisPrime();
    }

}
