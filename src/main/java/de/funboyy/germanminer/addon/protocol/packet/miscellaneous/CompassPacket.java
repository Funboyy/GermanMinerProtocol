package de.funboyy.germanminer.addon.protocol.packet.miscellaneous;

import net.labymod.serverapi.api.packet.Packet;
import net.labymod.serverapi.api.payload.io.PayloadReader;
import net.labymod.serverapi.api.payload.io.PayloadWriter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class CompassPacket implements Packet {

  private String target;
  private int distance;

  public CompassPacket() {
  }

  public CompassPacket(@Nullable final String target, final int distance) {
    this.target = target;
    this.distance = distance;
  }

  @Nullable
  public String getTarget() {
    return this.target;
  }

  public int getDistance() {
    return this.distance;
  }

  @Override
  public void write(@NotNull final PayloadWriter writer) {
    final boolean isEmpty = this.target == null;

    writer.writeBoolean(isEmpty);

    if (!isEmpty) {
      writer.writeString(this.target);
      writer.writeVarInt(this.distance);
    }
  }

  @Override
  public void read(@NotNull final PayloadReader reader) {
    final boolean isEmpty = reader.readBoolean();

    if (!isEmpty) {
      this.target = reader.readString();
      this.distance = reader.readVarInt();
    }
  }

}
