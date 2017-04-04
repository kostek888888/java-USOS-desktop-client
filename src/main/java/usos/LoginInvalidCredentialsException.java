package usos;

public class LoginInvalidCredentialsException extends Exception{
	
    public LoginInvalidCredentialsException() {}

    public LoginInvalidCredentialsException(String message)
    {
       super(message);
    }

}
