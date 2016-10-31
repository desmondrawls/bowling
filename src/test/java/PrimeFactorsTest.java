import org.hamcrest.Matcher;
import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class PrimeFactorsTest {
    private Matcher<List<Integer>> isListOf(Integer... list){
        return is(asList(list));
    }

    @Test
    public void primeFactors() throws Exception {
        assertThat(primeFactorsOf(1), isListOf());
    }

    private List<Integer> primeFactorsOf(int number) {
        return null;
    }
}
