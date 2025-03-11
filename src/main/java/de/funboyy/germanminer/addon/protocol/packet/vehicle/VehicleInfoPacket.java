package de.funboyy.germanminer.addon.protocol.packet.vehicle;

import net.labymod.serverapi.api.packet.Packet;
import net.labymod.serverapi.api.payload.io.PayloadReader;
import net.labymod.serverapi.api.payload.io.PayloadWriter;
import org.jetbrains.annotations.NotNull;

public class VehicleInfoPacket implements Packet {

  private boolean enabled;

  public VehicleInfoPacket() {
  }

  public VehicleInfoPacket(final boolean enabled) {
    this.enabled = enabled;
  }

  public boolean isEnabled() {
    return this.enabled;
  }

  @Override
  public void write(@NotNull final PayloadWriter writer) {
    writer.writeBoolean(this.enabled);
  }

  @Override
  public void read(@NotNull final PayloadReader reader) {
    this.enabled = reader.readBoolean();
  }

}
