package examples.patterns.behavior.chainofresponsibility;

/**
 * Паттерн Chain of responsibility
 */
public abstract class HandlerBase<C> implements Handler<C> {
    private Handler.Chain<C> chain;

    void setChain(Chain<C> chain) {
        this.chain = chain;
    }

    @Override
    public void handle(C context) {
        boolean success = doHandle(context);
        if (!success) {
            return;
        }
        Handler<C> nextHandler = nextHandler();
        if (nextHandler != null) {
            nextHandler.handle(context);
        }
    }

    protected abstract boolean doHandle(C context);

    @Override
    public Handler<C> nextHandler() {
        return chain.getNext(this);
    }
}
