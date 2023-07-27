package de.aclue.graphqltraining.fanInfo.exceptions;

public class FanInfoNotFoundException extends RuntimeException {

    public FanInfoNotFoundException(Long id) {
        super("UserInfo not found. id: " + id);
    }
}
