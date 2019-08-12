package core.patterns;

public class TestUtil {
    private TestUtil() {
    }

    public static final String EXPECTED_JSON_CHAIN_OF_INVOCATIONS =
            "{  \n" +
                    "   \"parentId\":\"28\",\n" +
                    "   \"fieldDescriptors\":[  \n" +
                    "      {  \n" +
                    "         \"field\":\"invoice_id\",\n" +
                    "         \"condition\":\"eq\",\n" +
                    "         \"values\":[  \n" +
                    "            \"65\"\n" +
                    "         ]\n" +
                    "      },\n" +
                    "      {  \n" +
                    "         \"field\":\"product_price\",\n" +
                    "         \"condition\":\"gt\",\n" +
                    "         \"values\":[  \n" +
                    "            \"75.00\"\n" +
                    "         ]\n" +
                    "      }\n" +
                    "   ]\n" +
                    "}";
}
