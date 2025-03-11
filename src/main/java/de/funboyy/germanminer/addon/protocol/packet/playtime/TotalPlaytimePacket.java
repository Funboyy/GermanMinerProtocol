package de.funboyy.germanminer.addon.protocol.packet.playtime;

public class TotalPlaytimePacket extends AbstractPlaytimePacket {

  public TotalPlaytimePacket() {
    super();
  }

  public TotalPlaytimePacket(final int days, final int hours, final int minutes) {
    super(days, hours, minutes);
  }

}
