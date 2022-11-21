public interface IOTask<T> {

    void input(String fileName);

    void output(T data);
    
}
