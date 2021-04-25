package pl.dowhankuniewski.supporters;

public abstract class AbstractSupporter implements ISupporter {
    protected String belief;
    protected boolean beliefProtection = false;

    public AbstractSupporter(String belief, boolean beliefProtection) {
        this.belief = belief;
        this.beliefProtection = beliefProtection;
    }
}
