package pt.yan.utils;

import java.util.concurrent.Callable;

public class ValidationUtils <T> {
    public static <T> T defaultIfNull(ICodeImpl func, T defaultValue){
        try{
            T ret = (T)func.execute();
            return ret != null ? ret : defaultValue;
        }catch(NullPointerException | IndexOutOfBoundsException e){
            return defaultValue;
        }
    }

    public interface ICodeImpl <T>{
        public T execute();
    }
}
