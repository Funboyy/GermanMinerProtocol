package de.funboyy.germanminer.addon.protocol.packet.experience;

import net.labymod.serverapi.api.packet.Packet;
import net.labymod.serverapi.api.payload.io.PayloadReader;
import net.labymod.serverapi.api.payload.io.PayloadWriter;
import org.jetbrains.annotations.NotNull;

public class ExperiencePointsPacket implements Packet {

  private int points;
  private int requiredPoints;

  public ExperiencePointsPacket() {
  }

  public ExperiencePointsPacket(final int points, final int requiredPoints) {
    this.points = points;
    this.requiredPoints = requiredPoints;
  }

  public int getPoints() {
    return this.points;
  }

  public int getRequiredPoints() {
    return this.requiredPoints;
  }

  @Override
  public void write(@NotNull final PayloadWriter writer) {
    writer.writeVarInt(this.points);
    writer.writeVarInt(this.requiredPoints);
  }

  @Override
  public void read(@NotNull final PayloadReader reader) {
    this.points = reader.readVarInt();
    this.requiredPoints = reader.readVarInt();
  }

}
