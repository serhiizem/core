package core.patterns.creational.chain_of_invocations.search_request;

import lombok.*;

import java.util.List;

@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class FieldDescriptor {
    private String field;
    private String condition;
    private List<String> values;
}
