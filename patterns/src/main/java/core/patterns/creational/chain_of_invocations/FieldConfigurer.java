package core.patterns.creational.chain_of_invocations;

import core.patterns.creational.chain_of_invocations.search_request.SearchRequest;

public class FieldConfigurer extends SearchConfigurerAdapter {

    FieldConfigurer(SearchRequest searchRequest) {
        super(searchRequest);
    }

    public EqualityConfigurer where(String field) {
        return new EqualityConfigurer(field, searchRequest);
    }
}
