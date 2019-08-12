package core.patterns.creational.chain_of_invocations;

import core.patterns.creational.chain_of_invocations.search_request.SearchRequest;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
abstract class SearchConfigurerAdapter {
    SearchRequest searchRequest;
}
