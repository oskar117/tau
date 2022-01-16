package pl.pjatk.tai.lab5;

import java.util.Objects;

public class MockitoModel {

    private String msg;
    private String msg2;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MockitoModel model = (MockitoModel) o;
        return Objects.equals(msg, model.msg) && Objects.equals(msg2, model.msg2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(msg, msg2);
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg2() {
        return msg2;
    }

    public void setMsg2(String msg2) {
        this.msg2 = msg2;
    }

    public MockitoModel(String msg, String msg2) {
        this.msg = msg;
        this.msg2 = msg2;
    }
}
