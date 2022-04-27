public class EmptyQueueException extends RuntimeException
{
    public EmptyQueueException() {this(null);} // edn defualt constructor

    public EmptyQueueException(String message)
    {
        super(message);
    }
}
