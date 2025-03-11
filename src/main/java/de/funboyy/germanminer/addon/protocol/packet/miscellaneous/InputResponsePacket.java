package de.funboyy.germanminer.addon.protocol.packet.miscellaneous;

import java.util.UUID;
import net.labymod.serverapi.api.packet.Packet;
import net.labymod.serverapi.api.payload.io.PayloadReader;
import net.labymod.serverapi.api.payload.io.PayloadWriter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class InputResponsePacket implements Packet {

  private UUID identifier;
  private String input;
  private boolean cancelled;

  public InputResponsePacket() {
  }

  public InputResponsePacket(@NotNull final UUID identifier, final boolean cancelled) {
    this.identifier = identifier;
    this.cancelled = cancelled;
  }

  public InputResponsePacket(@NotNull final UUID identifier, @NotNull final String input) {
    this.identifier = identifier;
    this.input = input;
    this.cancelled = false;
  }

  public UUID getIdentifier() {
    return this.identifier;
  }

  @Nullable
  public String getInput() {
    return this.input;
  }

  public boolean isCancelled() {
    return this.cancelled;
  }

  @Override
  public void write(@NotNull final PayloadWriter writer) {
    writer.writeUUID(this.identifier);
    writer.writeBoolean(this.cancelled);

    if (!this.cancelled) {
      writer.writeString(this.input);
    }
  }

  @Override
  public void read(@NotNull final PayloadReader reader) {
    this.identifier = reader.readUUID();
    this.cancelled = reader.readBoolean();

    if (!this.cancelled) {
      this.input = reader.readString();
    }
  }

}
