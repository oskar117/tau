package pl.pjatk.tai.lab5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.mockito.Mockito.*;

public class MockitoServiceTest {

    @Test
    void testMockingSubService() {
        MockitoModel model = new MockitoModel("test", "test");
        MockitoSubService subService = mock(MockitoSubService.class);
        when(subService.returnSomething()).thenReturn(model);
        MockitoService service = new MockitoService(subService);

        MockitoModel result = service.doStuff(true);

        verify(subService).returnSomething();
        Assertions.assertEquals(model, result);
    }

    @Test
    void testMockingSubServiceShouldReturnNull() {
        MockitoModel model = new MockitoModel("test", "test");
        MockitoSubService subService = mock(MockitoSubService.class);
        when(subService.returnSomething()).thenReturn(model);
        MockitoService service = new MockitoService(subService);

        MockitoModel result = service.doStuff(false);

        verify(subService, never()).returnSomething();
        Assertions.assertNull(result);
    }

    @Test
    void testSpyOnModel() {
        MockitoModel model = new MockitoModel("test", "test");
        MockitoModel spyModel = spy(model);

        doReturn("spy works!").when(spyModel).getMsg2();

        Assertions.assertEquals("test", spyModel.getMsg());
        Assertions.assertEquals("spy works!", spyModel.getMsg2());
    }

    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    void testServiceByMockingAndTrueParameter(boolean coolParameter) {
        MockitoModel model = new MockitoModel("test", "test");
        MockitoService service = mock(MockitoService.class);
        when(service.doStuff(anyBoolean())).thenReturn(model);

        MockitoModel result = service.doStuff(coolParameter);

        Assertions.assertEquals(model, result);
    }

    @Test
    void testMockingException() {
        MockitoService service = mock(MockitoService.class);
        when(service.doStuff(anyBoolean())).thenThrow(new RuntimeException());

        Assertions.assertThrows(RuntimeException.class, () -> service.doStuff(true));
    }
}
