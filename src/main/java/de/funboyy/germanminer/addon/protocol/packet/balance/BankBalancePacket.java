package de.funboyy.germanminer.addon.protocol.packet.balance;

public class BankBalancePacket extends AbstractBalancePacket {

  public BankBalancePacket() {
    super();
  }

  public BankBalancePacket(final double balance) {
    super(balance);
  }

}
