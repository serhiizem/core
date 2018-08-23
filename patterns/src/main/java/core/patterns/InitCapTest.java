package core.patterns;

public class InitCapTest {

    public static void main(String[] args) {
        String brochures = "brochures";
        String br = "br";
        String b = "b";
        String emptry = "";
        String GUIDE = "GUIDE";
        String BROCHURE = "BROCHURE";
        String nullValue = null;

        System.out.println(initcap(brochures));
        System.out.println(initcap(br));
        System.out.println(initcap(b));
        System.out.println(initcap(emptry));
        System.out.println(initcap(nullValue));
        System.out.println(initcap(GUIDE));
        System.out.println(initcap(BROCHURE));
    }

    private static String initcap(String target) {
        if (target == null) {
            return null;
        }
        if (target.equals("")) {
            return target;
        }
        return target.substring(0, 1).toUpperCase() + target.substring(1).toLowerCase();
    }
}
