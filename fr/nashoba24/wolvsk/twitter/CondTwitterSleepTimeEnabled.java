package fr.nashoba24.wolvsk.twitter;

import javax.annotation.Nullable;

import org.bukkit.event.Event;

import twitter4j.TwitterException;
import ch.njol.skript.lang.Condition;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.util.Kleenean;

public class CondTwitterSleepTimeEnabled extends Condition {

    @Override
    public boolean init(Expression<?>[] expr, int i, Kleenean kl, ParseResult pr) {
        return true;
    }

    @Override
    public String toString(@Nullable Event e, boolean b) {
        return "sleep time enabled";
    }

    @Override
    public boolean check(Event e) {
    	if(WolvSKTwitter.tf==null) { return false; }
    	try {
			return WolvSKTwitter.tf.getInstance().getAccountSettings().isSleepTimeEnabled();
		} catch (TwitterException e1) {
			e1.printStackTrace();
			return false;
		}
    }

}