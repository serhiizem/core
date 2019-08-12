package core.patterns.creational.chain_of_invocations;

import core.patterns.creational.chain_of_invocations.search_request.SearchRequest;

public class ParentConfigurer extends SearchConfigurerAdapter {

    public FieldConfigurer parentId(String parentId) {
        SearchRequest searchRequest = new SearchRequest();
        searchRequest.setParentId(parentId);
        return new FieldConfigurer(searchRequest);
    }
}
