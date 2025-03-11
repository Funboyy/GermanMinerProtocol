package de.funboyy.germanminer.addon.protocol.packet.balance;

import net.labymod.serverapi.api.packet.Packet;
import net.labymod.serverapi.api.payload.io.PayloadReader;
import net.labymod.serverapi.api.payload.io.PayloadWriter;
import org.jetbrains.annotations.NotNull;

public abstract class AbstractBalancePacket implements Packet {

  private double balance;

  protected AbstractBalancePacket() {
  }

  protected AbstractBalancePacket(final double balance) {
    this.balance = balance;
  }

  public double getBalance() {
    return this.balance;
  }

  @Override
  public void write(@NotNull final PayloadWriter writer) {
    writer.writeDouble(this.balance);
  }

  @Override
  public void read(@NotNull final PayloadReader reader) {
    this.balance = reader.readDouble();
  }

}
