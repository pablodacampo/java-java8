package java8.ex07;

import org.junit.Test;

import java.util.function.IntBinaryOperator;

/**
 * Exercice 07 - java.util.function.IntBinaryOperator
 */
public class Function_07_Test {

    // tag::format[]
    // TODO compléter la méthode pour qu'elle renvoie une chaîne de caractères de la forme "(<nb1><symbol><nb2>)=<resultat>"
    // TODO ex. "(10+11)=21", "(5-2)=3"
    String format(int nb1, int nb2, String symbol, IntBinaryOperator operator) {
        // TODO
        return "("+nb1+symbol+nb2+")="+operator.applyAsInt(nb1, nb2);
    }
    // end::format[]

    // TODO définir sum pour que le test test_format_sum() soit passant
    IntBinaryOperator sum = (nb1, nb2) -> nb1 + nb2;

    @Test
    public void test_format_sum() throws Exception {

        String result = format(12, 13, "+", sum);

        assert result.equals("(12+13)=25");
    }

    // TODO définir substract afin que le test test_format_subtract() soit passant
    IntBinaryOperator substract = (nb1, nb2) -> nb1 - nb2;

    @Test
    public void test_format_subtract() throws Exception {

        String result = format(2, 3, "-", substract);

        assert result.equals("(2-3)=-1");
    }
}



