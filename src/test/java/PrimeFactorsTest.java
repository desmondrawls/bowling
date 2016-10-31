import org.hamcrest.Matcher;
import org.junit.Test;

import java.util.ArrayList;
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
        assertThat(primeFactorsOf(2), isListOf(2));
        assertThat(primeFactorsOf(3), isListOf(3));
        assertThat(primeFactorsOf(4), isListOf(2,2));
        assertThat(primeFactorsOf(5), isListOf(5));
        assertThat(primeFactorsOf(6), isListOf(2,3));
        assertThat(primeFactorsOf(7), isListOf(7));
        assertThat(primeFactorsOf(8), isListOf(2,2,2));
        assertThat(primeFactorsOf(9), isListOf(3,3));
    }

    private List<Integer> primeFactorsOf(int number) {
        ArrayList<Integer> primeFactors = new ArrayList();
        for(int divisor = 2; number > 1; divisor++){
            for(;number % divisor == 0; number /= divisor){
              primeFactors.add(divisor);
            }
        }
        return primeFactors;
    }
}
