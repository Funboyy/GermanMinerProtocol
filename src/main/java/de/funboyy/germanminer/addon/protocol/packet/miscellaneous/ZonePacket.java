package de.funboyy.germanminer.addon.protocol.packet.miscellaneous;

import net.labymod.serverapi.api.packet.Packet;
import net.labymod.serverapi.api.payload.io.PayloadReader;
import net.labymod.serverapi.api.payload.io.PayloadWriter;
import org.jetbrains.annotations.NotNull;

public class ZonePacket implements Packet {

  private String zone;

  public ZonePacket() {
  }

  public ZonePacket(@NotNull final String zone) {
    this.zone = zone;
  }

  public String getZone() {
    return this.zone;
  }

  @Override
  public void write(@NotNull final PayloadWriter writer) {
    writer.writeString(this.zone);
  }

  @Override
  public void read(@NotNull final PayloadReader reader) {
    this.zone = reader.readString();
  }

}
