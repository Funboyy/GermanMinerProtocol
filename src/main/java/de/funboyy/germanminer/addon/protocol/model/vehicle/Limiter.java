package de.funboyy.germanminer.addon.protocol.model.vehicle;

import net.labymod.serverapi.api.payload.io.PayloadReader;
import net.labymod.serverapi.api.payload.io.PayloadWriter;
import org.jetbrains.annotations.NotNull;

public class Limiter {

  private boolean enabled;
  private int speed;

  public Limiter() {
  }

  public Limiter(final boolean enabled, final int speed) {
    this.enabled = enabled;
    this.speed = speed;
  }

  public boolean isEnabled() {
    return this.enabled;
  }

  public int getSpeed() {
    return this.speed;
  }

  public void write(@NotNull final PayloadWriter writer) {
    writer.writeBoolean(this.enabled);

    if (this.enabled) {
      writer.writeVarInt(this.speed);
    }
  }

  public void read(@NotNull final PayloadReader reader) {
    this.enabled = reader.readBoolean();

    if (this.enabled) {
      this.speed = reader.readVarInt();
    }
  }

}
