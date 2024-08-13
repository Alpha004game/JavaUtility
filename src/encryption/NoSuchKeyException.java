package encryption;

public class NoSuchKeyException extends Exception{

    public NoSuchKeyException(String msg)
    {
        super(msg);
    }

    public NoSuchKeyException()
    {
        super();
    }
}
