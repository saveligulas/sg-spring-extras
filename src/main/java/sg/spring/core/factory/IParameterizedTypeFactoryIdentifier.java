package sg.spring.core.factory;

import org.dfa.core.persistence.IPortMarker;
import org.springframework.core.ParameterizedTypeReference;

import java.util.List;

public interface IParameterizedTypeFactoryIdentifier {
    List<ParameterizedTypeReference<? extends IPortMarker>> getImplementedTypes();
}
