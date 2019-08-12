package core.patterns.creational.chain_of_invocations;

import core.patterns.creational.chain_of_invocations.search_request.SearchRequest;

public class ConjunctionConfigurer extends SearchConfigurerAdapter {

    ConjunctionConfigurer(SearchRequest searchRequest) {
        super(searchRequest);
    }

    public FieldConfigurer and() {
        return new FieldConfigurer(searchRequest);
    }

    public SearchRequest build() {
        return searchRequest;
    }
}
