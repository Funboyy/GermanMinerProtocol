package de.funboyy.germanminer.addon.protocol.packet.version;

import net.labymod.serverapi.api.packet.Packet;
import net.labymod.serverapi.api.payload.io.PayloadReader;
import net.labymod.serverapi.api.payload.io.PayloadWriter;
import org.jetbrains.annotations.NotNull;

public abstract class AbstractVersionPacket implements Packet {

  private int version;

  protected AbstractVersionPacket() {
  }

  protected AbstractVersionPacket(final int version) {
    this.version = version;
  }

  public int getVersion() {
    return this.version;
  }

  @Override
  public void write(@NotNull final PayloadWriter writer) {
    writer.writeVarInt(this.version);
  }

  @Override
  public void read(@NotNull final PayloadReader reader) {
    this.version = reader.readVarInt();
  }

}
