package de.funboyy.germanminer.addon.protocol.packet.miscellaneous;

import java.util.UUID;
import net.labymod.serverapi.api.packet.Packet;
import net.labymod.serverapi.api.payload.io.PayloadReader;
import net.labymod.serverapi.api.payload.io.PayloadWriter;
import org.jetbrains.annotations.NotNull;

public class InputRequestPacket implements Packet {

  private UUID identifier;
  private String message;
  private String positive;
  private String negative;

  public InputRequestPacket() {
  }

  public InputRequestPacket(@NotNull final UUID identifier, @NotNull final String message,
      @NotNull final String positive, @NotNull final String negative) {
    this.identifier = identifier;
    this.message = message;
    this.positive = positive;
    this.negative = negative;
  }

  public UUID getIdentifier() {
    return this.identifier;
  }

  public String getMessage() {
    return this.message;
  }

  public String getPositive() {
    return this.positive;
  }

  public String getNegative() {
    return this.negative;
  }

  @Override
  public void write(@NotNull final PayloadWriter writer) {
    writer.writeUUID(this.identifier);
    writer.writeString(this.message);
    writer.writeString(this.positive);
    writer.writeString(this.negative);
  }

  @Override
  public void read(@NotNull final PayloadReader reader) {
    this.identifier = reader.readUUID();
    this.message = reader.readString();
    this.positive = reader.readString();
    this.negative = reader.readString();
  }

}
