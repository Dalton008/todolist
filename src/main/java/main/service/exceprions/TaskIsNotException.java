package main.service.exceprions;

public class TaskIsNotException extends NullPointerException
{
    public TaskIsNotException(String msg)
    {
        super(msg);
    }
}
