package fr.nashoba24.wolvsk.askyblock;

import ch.njol.skript.lang.Condition;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.util.Kleenean;
import com.wasteofplastic.askyblock.ASkyBlockAPI;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;

import javax.annotation.Nullable;

public class CondASkyBlockIsCoop extends Condition {

    private Expression<Player> player;

    @SuppressWarnings("unchecked")
    @Override
    public boolean init(Expression<?>[] expr, int i, Kleenean kl, ParseResult pr) {
        player = (Expression<Player>) expr[0];
        setNegated(i == 1);
        return true;
    }

    @Override
    public String toString(@Nullable Event e, boolean b) {
        return "player is coop";
    }

    @Override
    public boolean check(Event e) {
    	if(player.getSingle(e)!=null) {
	        return isNegated() != ASkyBlockAPI.getInstance().isCoop(player.getSingle(e));
    	}
    	return isNegated();
    }

}