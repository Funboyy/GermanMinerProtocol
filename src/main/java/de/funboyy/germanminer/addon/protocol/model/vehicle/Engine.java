package de.funboyy.germanminer.addon.protocol.model.vehicle;

import net.labymod.serverapi.api.payload.io.PayloadReader;
import net.labymod.serverapi.api.payload.io.PayloadWriter;
import org.jetbrains.annotations.NotNull;

public class Engine {

  private State state;
  private Damage damage;

  public Engine() {
  }

  public Engine(@NotNull final State state, @NotNull final Damage damage) {
    this.state = state;
    this.damage = damage;
  }

  public State getState() {
    return this.state;
  }

  public Damage getDamage() {
    return this.damage;
  }

  public void write(@NotNull final PayloadWriter writer) {
    writer.writeVarInt(this.state.ordinal());
    writer.writeVarInt(this.damage.ordinal());
  }

  public void read(@NotNull final PayloadReader reader) {
    this.state = State.values()[reader.readVarInt()];
    this.damage = Damage.values()[reader.readVarInt()];
  }

}
