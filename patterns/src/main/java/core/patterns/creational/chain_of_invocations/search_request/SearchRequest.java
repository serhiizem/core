package core.patterns.creational.chain_of_invocations.search_request;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
@EqualsAndHashCode
public class SearchRequest {
    private String parentId;
    private List<FieldDescriptor> fieldDescriptors = new ArrayList<>();

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }
}
