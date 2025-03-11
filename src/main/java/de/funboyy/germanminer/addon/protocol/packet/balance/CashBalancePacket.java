package de.funboyy.germanminer.addon.protocol.packet.balance;

public class CashBalancePacket extends AbstractBalancePacket {

  public CashBalancePacket() {
    super();
  }

  public CashBalancePacket(final double balance) {
    super(balance);
  }

}
