package de.funboyy.germanminer.addon.protocol.packet.playtime;

public class DutyPlaytimePacket extends AbstractPlaytimePacket {

  public DutyPlaytimePacket() {
    super();
  }

  public DutyPlaytimePacket(final int days, final int hours, final int minutes) {
    super(days, hours, minutes);
  }

}
