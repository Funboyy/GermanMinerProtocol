package de.funboyy.germanminer.addon.protocol.packet.experience;

import net.labymod.serverapi.api.packet.Packet;
import net.labymod.serverapi.api.payload.io.PayloadReader;
import net.labymod.serverapi.api.payload.io.PayloadWriter;
import org.jetbrains.annotations.NotNull;

public class ExperienceLevelPacket implements Packet {

  private int level;

  public ExperienceLevelPacket() {
  }

  public ExperienceLevelPacket(final int level) {
    this.level = level;
  }

  public int getLevel() {
    return this.level;
  }

  @Override
  public void write(@NotNull final PayloadWriter writer) {
    writer.writeVarInt(this.level);
  }

  @Override
  public void read(@NotNull final PayloadReader reader) {
    this.level = reader.readVarInt();
  }

}
