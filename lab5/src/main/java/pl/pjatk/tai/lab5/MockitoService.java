package pl.pjatk.tai.lab5;

public class MockitoService {

    private final MockitoSubService mockitoSubService;

    public MockitoService(MockitoSubService mockitoSubService) {
        this.mockitoSubService = mockitoSubService;
    }

    MockitoModel doStuff(boolean coolParameter) {
        if (coolParameter) {
            return mockitoSubService.returnSomething();
        }
        return null;
    }
}
