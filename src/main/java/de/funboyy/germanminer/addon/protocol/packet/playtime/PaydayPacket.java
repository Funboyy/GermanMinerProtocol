package de.funboyy.germanminer.addon.protocol.packet.playtime;

import net.labymod.serverapi.api.packet.Packet;
import net.labymod.serverapi.api.payload.io.PayloadReader;
import net.labymod.serverapi.api.payload.io.PayloadWriter;
import org.jetbrains.annotations.NotNull;

public class PaydayPacket implements Packet {

  private int minutes;

  public PaydayPacket() {
  }

  public PaydayPacket(final int minutes) {
    this.minutes = minutes;
  }

  public int getMinutes() {
    return this.minutes;
  }

  @Override
  public void write(@NotNull final PayloadWriter writer) {
    writer.writeVarInt(this.minutes);
  }

  @Override
  public void read(@NotNull final PayloadReader reader) {
    this.minutes = reader.readVarInt();
  }

}
