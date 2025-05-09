package uz.demo.task_hayot.converter;

import java.util.function.Function;

/**
 * @author Khudayberganov Nuriddin
 * @since : 24/06/24 / 11:39
 */
public class BasicConverter<A, B> {

  Function<A, B> from;
  Function<B, A> to;

  public BasicConverter(Function<A, B> from, Function<B, A> to) {
    this.from = from;
    this.to = to;
  }

  public A to(B b) {
    return to.apply(b);
  }

  public B from(A a) {
    return from.apply(a);
  }
}
