package de.funboyy.germanminer.addon.protocol.packet.playtime;

import net.labymod.serverapi.api.packet.Packet;
import net.labymod.serverapi.api.payload.io.PayloadReader;
import net.labymod.serverapi.api.payload.io.PayloadWriter;
import org.jetbrains.annotations.NotNull;

public abstract class AbstractPlaytimePacket implements Packet {

  private int days;
  private int hours;
  private int minutes;

  protected AbstractPlaytimePacket() {
  }

  protected AbstractPlaytimePacket(final int days, final int hours, final int minutes) {
    this.days = days;
    this.hours = hours;
    this.minutes = minutes;
  }

  public int getDays() {
    return this.days;
  }

  public int getHours() {
    return this.hours;
  }

  public int getMinutes() {
    return this.minutes;
  }

  @Override
  public void write(@NotNull PayloadWriter writer) {
    writer.writeVarInt(this.days);
    writer.writeVarInt(this.hours);
    writer.writeVarInt(this.minutes);
  }

  @Override
  public void read(@NotNull PayloadReader reader) {
    this.days = reader.readVarInt();
    this.hours = reader.readVarInt();
    this.minutes = reader.readVarInt();
  }

}
