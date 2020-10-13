package misc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SuppressWarnings("AssertWithSideEffects")
public class RegularExpressions {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("\\s+hola");

        assert pattern.matcher("        hola").matches();
        assert !pattern.matcher("hola").matches();

        pattern = Pattern.compile("^HOLA$", Pattern.CASE_INSENSITIVE);

        assert pattern.matcher("hola").matches();
        assert Pattern.matches("\\x40", String.valueOf((char) 0x40));
        assert Pattern.matches("ho\\\\la", "ho\\la");
        assert Pattern.matches("ho\\nla", "ho\nla");
        assert Pattern.matches("ho\nla", "ho\nla");

        pattern = Pattern.compile("^a_*([^bcd]+?)e?\\s+f\\\\g(h{2,3})i+");
        Matcher matcher = pattern.matcher("a_____ope        f\\ghhhiiiii");

        assert matcher.matches();
        assert matcher.group(1).equals("op");
        assert matcher.group(2).equals("hhh");

        pattern = Pattern.compile("^a_*?([^bcd]+)e?\\s+f\\\\g(h{2,3})i+");
        matcher = pattern.matcher("a_____ope        f\\ghhhiiiii");

        assert matcher.matches();
        assert matcher.group(1).equals("_____ope       ");
        assert matcher.group(2).equals("hhh");
    }
}
