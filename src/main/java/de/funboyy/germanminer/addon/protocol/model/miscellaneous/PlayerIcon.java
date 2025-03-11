package de.funboyy.germanminer.addon.protocol.model.miscellaneous;

import java.util.UUID;
import net.labymod.serverapi.api.payload.io.PayloadReader;
import net.labymod.serverapi.api.payload.io.PayloadWriter;
import org.jetbrains.annotations.NotNull;

public class PlayerIcon implements Icon {

  private UUID uniqueId;

  public PlayerIcon() {
  }

  public PlayerIcon(@NotNull final UUID uniqueId) {
    this.uniqueId = uniqueId;
  }

  public UUID getUniqueId() {
    return this.uniqueId;
  }

  @Override
  public void write(@NotNull final PayloadWriter writer) {
    writer.writeUUID(this.uniqueId);
  }

  @Override
  public void read(@NotNull final PayloadReader reader) {
    this.uniqueId = reader.readUUID();
  }

}
