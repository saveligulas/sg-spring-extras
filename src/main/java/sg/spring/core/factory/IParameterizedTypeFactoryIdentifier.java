package sg.spring.core.factory;

import org.springframework.core.ParameterizedTypeReference;
import sg.spring.core.persistence.IPortMarker;

import java.util.List;

public interface IParameterizedTypeFactoryIdentifier {
    List<ParameterizedTypeReference<? extends IPortMarker>> getImplementedTypes();
}
