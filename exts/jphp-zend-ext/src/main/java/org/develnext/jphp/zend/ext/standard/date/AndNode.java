package org.develnext.jphp.zend.ext.standard.date;

class AndNode extends Node {
    private final Node l;
    private final Node r;

    AndNode(Node l, Node r) {
        this.l = l;
        this.r = r;
    }

    static AndNode of(Node l, Node r) {
        return new AndNode(l, r);
    }

    @Override
    public boolean matches(DateTimeParserContext ctx) {
        if (l.matches(ctx)) {
            if (r.matches(ctx)) {
                return true;
            } else {
                ctx.cursor().dec();
                return false;
            }
        }
        return false;
    }

    @Override
    void apply(DateTimeParserContext ctx) {
        l.apply(ctx);
        r.apply(ctx);
    }

    @Override
    public String toString() {
        return "(" + l + " AND " + r + ")";
    }
}