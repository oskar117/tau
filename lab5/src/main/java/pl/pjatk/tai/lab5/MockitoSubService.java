package pl.pjatk.tai.lab5;

public interface MockitoSubService {

    MockitoModel returnSomething();

    default String getCoolString() {
        return "Cool string";
    }
}
