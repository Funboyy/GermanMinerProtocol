package de.funboyy.germanminer.addon.protocol.model.balance;

import net.labymod.serverapi.api.payload.io.PayloadReader;
import net.labymod.serverapi.api.payload.io.PayloadWriter;
import org.jetbrains.annotations.NotNull;

public class Account {

  private String identifier;
  private double balance;

  public Account() {
  }

  public Account(@NotNull final String identifier, final double balance) {
    this.identifier = identifier;
    this.balance = balance;
  }

  public String getIdentifier() {
    return this.identifier;
  }

  public double getBalance() {
    return this.balance;
  }

  public void write(@NotNull final PayloadWriter writer) {
    writer.writeString(this.identifier);
    writer.writeDouble(this.balance);
  }

  public void read(@NotNull final PayloadReader reader) {
    this.identifier = reader.readString();
    this.balance = reader.readDouble();
  }

}
