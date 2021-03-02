import java.util.Stack;

public class Base7conversion {
    public String convertToBase7(int num) {
        StringBuilder strBase7 = new StringBuilder();
        Stack<Integer> strStack = new Stack<>();
        while (Math.abs(num) >= 7) {
            strStack.push(num % 7);
            num /= 7;
        }
        strStack.push(num);

        while (!strStack.empty()) {
            strBase7.append(strStack.pop());
        }

        return strBase7.toString();
    }

    public static void main(String[] args) {
        new Base7conversion().convertToBase7(100);
        new Base7conversion().convertToBase7(-7);
    }
}
