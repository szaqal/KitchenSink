package szaqal.alg.demo.stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

public class BalancedBracketsTest {

    @ParameterizedTest
    @MethodSource("argumentsList")
    public void test(String input, String expected) {
        Assertions.assertEquals(expected, BalancedBrackets.isBalanced(input));
    }

    private static List<Arguments> argumentsList() {
        return List.of(
                Arguments.of("{[()]}", "YES"),
                Arguments.of("{[(])}", "NO"),
                Arguments.of("{{[[(())]]}}", "YES"),
                Arguments.of("}][}}(}][))]", "NO"),
                Arguments.of("[](){()}", "YES"),
                Arguments.of("([{([]({}{}))[]}[{}]])()(()){}[()[]()]()()()[]{}{}()()()[()][[]([])()()[]]([]){}[{[][]}{}]{}{}[][]{}[](())(())()[({{}{[(())()[]]{[{}{()}{}]{[[]][[]]}()[]}}()(){[[]{}][()]()[{({})}][[([]()[{[]({(())()})}][]({})[])([{}]{()})]]}}){}{{()}}{[][[{}]][()[()]({[]{}(())})]}][{}[{}]]()()(())[[]]{[[{()}]]({})[]}({}{(([]))}[]){}[()(()[])]{}(({}))[][{}](){()}[]{({}([][][[]]))}[][((()[]({{}}[[{{[(({()}({}[[]][{([()])}({})][]{[[]{}]})())){}]{}}{()}{[][]}{}{}}][]([{}[[]{}({([]()(()()[]))})[]()]][()](()))[]]{}[[{[][]}[[[]]()[(){}][{[]{}}[{{{[]}}{}}][]([[{{()[]}[{[][{[[{[{}[]()[]]}{{}}{}]]}]}[]]}{}]][[]][{({}[])[[[{}][]]()[]]}{{[{}][]({}([][]{()}[()]){{}{}})}{}{}(([[]]()[]))()}][][{[({})[[]([[{[]}()]](([[]{}]{})))](){}[{}][]{[]}{[]([({{{}()}{[]}((){}{})}[[][]]{}[])]{})}]}{([()()[]][])}()([])])][([[]]()[])([[][]]){}[{[((([]){(){({[]})()}})){{}[()({({})}[[{[]{}}({{}[{{}{}}()]}){}]])]()}{}]{{}}}[]()]]{}{}]]]){}){}){()}()[]({}())]{()[]}[]{}{[]}(){[][[][]{}]}[{}{[{}{}]}]{[{}({}[()({{}})])()()]({[]}()((())))}", "YES")
        );
    }
}
