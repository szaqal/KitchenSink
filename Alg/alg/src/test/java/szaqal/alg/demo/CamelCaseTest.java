package szaqal.alg.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CamelCaseTest {
    @Test
    public void test() {
        Assertions.assertEquals(CamelCase.camelCase("saveChangesInTheEditor"), 5);
        Assertions.assertEquals(CamelCase.camelCase3("saveChangesInTheEditor"), 5);
        Assertions.assertEquals(CamelCase.camelCase2("saveChangesInTheEditor"), 5);
    }
}
