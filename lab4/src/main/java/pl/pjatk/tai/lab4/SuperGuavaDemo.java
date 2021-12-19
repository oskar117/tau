package pl.pjatk.tai.lab4;

import com.google.common.base.Strings;

public class SuperGuavaDemo {

    static final String PREFIX = "DUDUDU ";

    String transformString(String s) {
        String s1 = Strings.nullToEmpty(s);
        if (s1.isEmpty()) {
            return s1;
        }
        if (s.equals("1234")) {
            throw new IllegalArgumentException("Illegal string");
        }
        return Strings.commonPrefix(s1, PREFIX);
    }
}
