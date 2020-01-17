package nsgl.function.iterative;

import nsgl.function.Function;

public abstract class Step<I,O> extends Function<O,O>{
    public abstract O init(I input);
}
