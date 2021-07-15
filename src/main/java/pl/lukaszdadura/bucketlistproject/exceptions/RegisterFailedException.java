package pl.lukaszdadura.bucketlistproject.exceptions;

public class RegisterFailedException extends RuntimeException{

    public RegisterFailedException(String message) {
        super(message);
    }

}
