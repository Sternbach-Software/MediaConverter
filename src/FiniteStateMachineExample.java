public class FiniteStateMachineExample {
    public static void main(String[] args) {
        //Goal: Use a finite state machine to find a string which ends in the pattern (which I will represent using the regex): "@\d+#"
        String s = "A1@312#";
        String digits = "0123456789";
        int state = 0;
        for (int ind = 0; ind < s.length(); ind++) {
            if (state == 0) {
                if (s.charAt(ind) == '@')
                    state = 1;
            }
            else {
                boolean isDigit = digits.indexOf(s.charAt(ind)) != -1;
                if (state == 1) {
                    if (isDigit)
                        state = 2;
                    else if (s.charAt(ind) == '@')
                        state = 1;
                    else
                        state = 0;
                } else if (state == 2) {
                    if (s.charAt(ind) == '#') {
                        state = 3;
                    } else if (isDigit) {
                        state = 2;
                    } else if (s.charAt(ind) == '@')
                        state = 1;
                    else
                        state = 0;
                } else if (state == 3) {
                    if (s.charAt(ind) == '@')
                        state = 1;
                    else
                        state = 0;
                }
            }
        } //end for loop

        if (state == 3)
            System.out.println("It matches");
        else
            System.out.println("It does not match");
    }
}