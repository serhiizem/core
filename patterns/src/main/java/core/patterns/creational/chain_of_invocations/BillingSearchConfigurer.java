package core.patterns.creational.chain_of_invocations;

public class BillingSearchConfigurer extends SearchConfigurerAdapter {

    public static ParentConfigurer create() {
        return new ParentConfigurer();
    }
}
