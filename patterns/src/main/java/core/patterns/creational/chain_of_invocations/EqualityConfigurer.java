package core.patterns.creational.chain_of_invocations;

import core.patterns.creational.chain_of_invocations.search_request.FieldDescriptor;
import core.patterns.creational.chain_of_invocations.search_request.SearchRequest;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static java.util.Collections.singletonList;

public class EqualityConfigurer extends SearchConfigurerAdapter {

    private final String field;

    EqualityConfigurer(String field, SearchRequest searchRequest) {
        super(searchRequest);
        this.field = field;
    }

    public ConjunctionConfigurer eq(List<String> values) {
        addDescriptorForOperation(field, values, Operation.EQUALS);
        return new ConjunctionConfigurer(searchRequest);
    }

    public ConjunctionConfigurer eq(String value) {
        addDescriptorForOperation(field, singletonList(value), Operation.EQUALS);
        return new ConjunctionConfigurer(searchRequest);
    }

    public ConjunctionConfigurer gt(List<String> values) {
        addDescriptorForOperation(field, values, Operation.GREATER_THAN);
        return new ConjunctionConfigurer(searchRequest);
    }

    public ConjunctionConfigurer gt(String value) {
        addDescriptorForOperation(field, singletonList(value), Operation.GREATER_THAN);
        return new ConjunctionConfigurer(searchRequest);
    }

    private void addDescriptorForOperation(String field, List<String> descriptorValues, Operation operation) {
        List<FieldDescriptor> fieldDescriptors = this.searchRequest.getFieldDescriptors();
        FieldDescriptor fieldDescriptor = new FieldDescriptor(field, operation.toString(), descriptorValues);
        fieldDescriptors.add(fieldDescriptor);
    }

    @RequiredArgsConstructor
    private enum Operation {
        EQUALS(Constants.EQUALS_OPERATION),
        GREATER_THAN(Constants.GREATER_THAN_OPERATION);

        private final String strValue;

        @Override
        public String toString() {
            return strValue;
        }
    }
}
