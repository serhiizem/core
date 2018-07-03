package core.patterns.structural;

import lombok.Getter;

import java.util.StringTokenizer;

@Getter
public class EmployeeLDAP {
    private String cn;
    private String givenName;
    private String displayName;
    private String mail;

    public EmployeeLDAP(String text) {
        StringTokenizer stringTokenizer = new StringTokenizer(text, ",");

        if (stringTokenizer.hasMoreElements()) {
            this.cn = stringTokenizer.nextToken();
        }
        if (stringTokenizer.hasMoreElements()) {
            this.givenName = stringTokenizer.nextToken();
        }
        if (stringTokenizer.hasMoreElements()) {
            this.displayName = stringTokenizer.nextToken();
        }
        if (stringTokenizer.hasMoreElements()) {
            this.mail = stringTokenizer.nextToken();
        }
    }
}
