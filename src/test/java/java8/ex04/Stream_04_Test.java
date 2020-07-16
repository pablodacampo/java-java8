package java8.ex04;


import static org.hamcrest.Matchers.arrayContaining;
import static org.junit.Assert.assertThat;

import java.util.stream.Stream;

import org.junit.Test;

/**
 * Exercice 04 - Stream
 */
public class Stream_04_Test {

	@Test
    public void test_of() throws Exception {
    	
        // Construire un stream permettant de rendre le test passant
        Stream<String> result = Stream.of("Alexandra", "Cyril", "Johnny", "Marion", "Sophie");

        assertThat(result.toArray(), arrayContaining("Alexandra", "Cyril", "Johnny", "Marion", "Sophie"));
    }

    @Test
    public void test_builder() throws Exception {

        // TODO compléter pour rendre le test passant
        // TODO utiliser la méthode "add"
        Stream<Object> result = Stream.builder()
        		.add("Alexandra")
        		.add("Cyril")
        		.add("Johnny")
        		.add("Marion")
        		.add("Sophie")
        		.build();

        assertThat(result.toArray(), arrayContaining("Alexandra", "Cyril", "Johnny", "Marion", "Sophie"));
    }

    @Test
    public void test_concat() throws Exception {
        Stream<String> s1 = Stream.of("Alexandra", "Cyril");
        Stream<String> s2 = Stream.of("Johnny", "Marion", "Sophie");

        // TODO concatener les deux streams s1 et s2
        Stream<String> result = Stream.concat(s1, s2);

        assertThat(result.toArray(), arrayContaining("Alexandra", "Cyril", "Johnny", "Marion", "Sophie"));
    }

    @Test
    public void test_iterate() throws Exception {
        // TODO utiliser la méthode "iterate" de Stream afin de rendre le test passant
        Stream<Integer> result1 = Stream.iterate(1, i -> i).limit(5);
        Stream<Integer> result2 = Stream.iterate(1, i -> i+1).limit(5);
        assertThat(result1.toArray(), arrayContaining(1,1,1,1,1));
        assertThat(result2.toArray(), arrayContaining(1,2,3,4,5));
    }
}