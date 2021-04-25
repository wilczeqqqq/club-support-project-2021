package pl.dowhankuniewski.supporters;

public abstract class AbstractSupporter implements ISupporter {
    protected String belief;
    protected boolean beliefProtection;

    public AbstractSupporter(String belief, boolean beliefProtection) {
        this.belief = belief;
        this.beliefProtection = beliefProtection;
    }

    @Override
    public void changeProtection() {
    }
}
