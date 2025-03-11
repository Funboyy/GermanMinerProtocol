package de.funboyy.germanminer.addon.protocol.packet.vehicle;

import de.funboyy.germanminer.addon.protocol.model.vehicle.Key;
import net.labymod.serverapi.api.packet.Packet;
import net.labymod.serverapi.api.payload.io.PayloadReader;
import net.labymod.serverapi.api.payload.io.PayloadWriter;
import org.jetbrains.annotations.NotNull;

public class VehicleKeyPacket implements Packet {

  private Key key;

  public VehicleKeyPacket() {
  }

  public VehicleKeyPacket(@NotNull final Key key) {
    this.key = key;
  }

  public Key getKey() {
    return this.key;
  }

  @Override
  public void write(@NotNull final PayloadWriter writer) {
    writer.writeVarInt(this.key.ordinal());
  }

  @Override
  public void read(@NotNull final PayloadReader reader) {
    this.key = Key.values()[reader.readVarInt()];
  }

}
