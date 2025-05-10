package szaqal.alg.demo;

public class CamelCase {
    public static int camelCase(String s) {
        char[] charArray = s.toCharArray();
        int found = 1;//first start with lower always
        for (char c : charArray) {
            String s1 = String.valueOf(c);
            if(s1.toUpperCase().equals(s1)) {
                found ++;
            }
        }
        return found;
    }
}
