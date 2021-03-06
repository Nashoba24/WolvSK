package fr.nashoba24.wolvsk.maths;

import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;
import org.bukkit.event.Event;

import javax.annotation.Nullable;

public class ExprMathsExpBase extends SimpleExpression<Double> {

    private Expression<Number> nb;
    private Expression<Number> base;

    @Override
    public boolean isSingle() {
        return true;
    }

    @Override
    public Class<? extends Double> getReturnType() {
        return Double.class;
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean init(Expression<?>[] expr, int matchedPattern, Kleenean paramKleenean, ParseResult paramParseResult) {
        if (matchedPattern == 1) {
            nb = (Expression<Number>) expr[1];
            base = (Expression<Number>) expr[0];
        } else {
            nb = (Expression<Number>) expr[0];
            base = (Expression<Number>) expr[1];
        }
        return true;
    }

    @Override
    public String toString(@Nullable Event e, boolean paramBoolean) {
        return "exp in base a";
    }

    @Override
    @Nullable
    protected Double[] get(Event e) {
        return new Double[]{Math.exp(nb.getSingle(e).doubleValue() * Math.log(base.getSingle(e).doubleValue()))};
    }
}

