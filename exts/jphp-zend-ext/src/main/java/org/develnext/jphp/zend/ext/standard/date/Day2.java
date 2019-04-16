package org.develnext.jphp.zend.ext.standard.date;

import static org.develnext.jphp.zend.ext.standard.date.DateTimeTokenizer.TWO_DIGIT_DAY;

class Day2 extends FixedLengthSymbol {
    private Day2() {
        super(Symbol.DIGITS, 2);
    }

    public static Day2 of() {
        return new Day2();
    }

    @Override
    public boolean matchesInternal(DateTimeParserContext ctx) {
        boolean matches = TWO_DIGIT_DAY.matcher(ctx.tokenizer().readCharBuffer(ctx.tokenAtCursor())).matches();
        return matches;
    }

    @Override
    void apply(DateTimeParserContext ctx) {
        ctx.setDayOfMonth(ctx.readIntAtCursor());
        ctx.cursor().inc();
    }
}