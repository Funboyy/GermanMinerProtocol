package de.funboyy.germanminer.addon.protocol.packet.balance;

import de.funboyy.germanminer.addon.protocol.model.balance.Account;
import java.util.HashSet;
import java.util.Set;
import net.labymod.serverapi.api.packet.Packet;
import net.labymod.serverapi.api.payload.io.PayloadReader;
import net.labymod.serverapi.api.payload.io.PayloadWriter;
import org.jetbrains.annotations.NotNull;

public class ExtraBalancePacket implements Packet {

  private Set<Account> accounts;

  public ExtraBalancePacket() {
  }

  public ExtraBalancePacket(final Set<Account> accounts) {
    this.accounts = accounts;
  }

  public Set<Account> getAccounts() {
    return this.accounts;
  }

  @Override
  public void write(@NotNull final PayloadWriter writer) {
    writer.writeVarInt(this.accounts.size());

    for (final Account account : this.accounts) {
      account.write(writer);
    }
  }

  @Override
  public void read(@NotNull final PayloadReader reader) {
    final int size = reader.readVarInt();

    this.accounts = new HashSet<>(size);

    for (int i = 0; i < size; i++) {
      final Account account = new Account();
      account.read(reader);

      this.accounts.add(account);
    }
  }

}
