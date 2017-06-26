package daggerok.async.error;

public class AsyncException extends RuntimeException {

  private AsyncException(final String message) {
    super(message);
  }

  public static void throwById(final Long id) {
    throw new AsyncException(id + " async error.");
  }
}
