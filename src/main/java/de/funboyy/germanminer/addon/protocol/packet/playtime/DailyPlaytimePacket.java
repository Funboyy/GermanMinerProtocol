package de.funboyy.germanminer.addon.protocol.packet.playtime;

public class DailyPlaytimePacket extends AbstractPlaytimePacket {

  public DailyPlaytimePacket() {
    super();
  }

  public DailyPlaytimePacket(final int days, final int hours, final int minutes) {
    super(days, hours, minutes);
  }

}
