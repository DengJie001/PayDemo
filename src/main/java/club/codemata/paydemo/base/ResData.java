package club.codemata.paydemo.base;

import lombok.Data;

@Data
public class ResData<T> {
    private int code;
    private T data;
    private String msg;

    public static<T> ResData<T> create(int code, T data, String msg) {
        ResData<T> resData = new ResData<>();
        resData.setCode(code);
        resData.setData(data);
        resData.setMsg(msg);
        return resData;
    }

    public static<T> ResData<T> create(T data) {
        return ResData.create(0, data, null);
    }

    public static<T> ResData<T> create(int code, String msg) {
        return ResData.create(code, null, msg);
    }
}
