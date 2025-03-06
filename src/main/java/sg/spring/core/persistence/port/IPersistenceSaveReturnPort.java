package sg.spring.core.persistence.port;


import org.dfa.core.persistence.IPortMarker;

public interface IPersistenceSaveReturnPort<D> extends IPortMarker {
    D saveReturn(D d);
}
