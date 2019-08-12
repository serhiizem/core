package core.patterns.creational;

import com.fasterxml.jackson.databind.ObjectMapper;
import core.patterns.creational.chain_of_invocations.BillingSearchConfigurer;
import core.patterns.creational.chain_of_invocations.search_request.SearchRequest;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static core.patterns.TestUtil.EXPECTED_JSON_CHAIN_OF_INVOCATIONS;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ChainOfInvocationsTest {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @Test
    void shouldCreateRequestThatCorrespondsToExpectedJsonPayload() throws IOException {
        SearchRequest actual = BillingSearchConfigurer.create()
                .parentId("28")
                .where("invoice_id").eq("65")
                .and()
                .where("product_price").gt("75.00")
                .build();

        SearchRequest requestFromExpectedJsonAnalog =
                OBJECT_MAPPER.readValue(EXPECTED_JSON_CHAIN_OF_INVOCATIONS, SearchRequest.class);

        assertEquals(requestFromExpectedJsonAnalog, actual);
    }
}
