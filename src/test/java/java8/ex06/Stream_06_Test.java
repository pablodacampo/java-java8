package java8.ex06;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.logging.Logger;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import org.junit.Test;

/**
 * Exercice 07 - Stream Parallel - Effet de bord
 */
public class Stream_06_Test {

    // Soit une implémentation impérative de la somme
    private long imperativeSum(long n) {
        long result = 0;

        for (long i = 1L; i < n; i++) {
            result += i;
        }
        return result;
    }

    // Soit une structure permettant de stocker le total
    private class Accumulator {
        private long total;

        private void add(long value) {
            total+=value;
        }
    }
    
//    private class Accumulator {
//        private AtomicLong total=new AtomicLong(0);
//
//        private void add(long value) {
//        	total.addAndGet(value);
//        }
//    }

    // TODO compléter la méthode pour que le calcul de la somme soit fait avec une instance d'Accumulator
    private long sumWithAccumulator(long n) {
        // TODO créer une instance de l'accumulateur (classe Accumulator)
        Accumulator acc = new Accumulator();
        LongStream longStream = LongStream.rangeClosed(1, n - 1);

        // TODO pour chaque élément de longStream, invoquer la méthode add de l'accumulateur (acc)
        longStream.forEach(value -> acc.add(value));
        return acc.total;
    }

    // TODO exécuter le test pour valider l'implémentation de sumWithAccumulator
    @Test
    public void test_sumWithAccumulator() throws Exception {
        Stream.of(1L, 1000L, 10000L).forEach(n -> {
            long result1 = imperativeSum(n);
            long result2 = sumWithAccumulator(n);

            assertThat(result1, is(result2));
        });
    }


    // TODO reprendre le code de sumWithAccumulator et rendre le traitement parallèle (.parallel())
    private long sumWithAccumulatorParallel(long n) {
    	Accumulator acc = new Accumulator();
        LongStream longStream = LongStream.rangeClosed(1, n - 1);

        // TODO pour chaque élément de longStream, invoquer la méthode add de l'accumulateur (acc)
        longStream.parallel().forEach(value -> acc.add(value));
        return acc.total;
    }

    // TODO Exécuter le test
    // Que constatez-vous ?
    @Test
    public void test_sumWithAccumulatorParallel() throws Exception {


        Stream.of(1L, 2L, 3L, 10L, 20L, 50L, 1000L, 100000L).forEach(n -> {
            long result1 = imperativeSum(n);
            long result2 = sumWithAccumulator(n);
            long result3 = sumWithAccumulatorParallel(n);

            assertThat("n=" + n, result1, is(result2));
            
            // On constate que la méthode add de la classe Accumulator n'est pas "thread safe". 
            // Pour cela il faut faire l'addition avec l'instance de Accumulator en commentaires et qui utilise AtomicLong.
            assertThat("n=" + n, result1, is(result3));

            Logger.getGlobal().info("Test ok avec n=" + n);
        });
    }

}