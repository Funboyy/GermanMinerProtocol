package de.funboyy.germanminer.addon.protocol.packet.playtime;

public class WeeklyPlaytimePacket extends AbstractPlaytimePacket {

  public WeeklyPlaytimePacket() {
    super();
  }

  public WeeklyPlaytimePacket(final int days, final int hours, final int minutes) {
    super(days, hours, minutes);
  }

}
