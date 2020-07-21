package fen.fen.exception;

/**
 * @author chenyufeng
 */
public class JpaObjException extends RuntimeException {
    public JpaObjException(Integer id) {
        super("Could not find jpa object with id: " + id);
    }
    public JpaObjException(String message) {
        super(message);
    }
}
