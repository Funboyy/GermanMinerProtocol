package de.funboyy.germanminer.addon.protocol.packet.miscellaneous;

import de.funboyy.germanminer.addon.protocol.model.miscellaneous.PowerUp;
import java.time.Instant;
import net.labymod.serverapi.api.packet.Packet;
import net.labymod.serverapi.api.payload.io.PayloadReader;
import net.labymod.serverapi.api.payload.io.PayloadWriter;
import org.jetbrains.annotations.NotNull;

public class PowerUpPacket implements Packet {

  private PowerUp powerUp;
  private Instant endsAt;

  public PowerUpPacket() {
  }

  public PowerUpPacket(@NotNull final PowerUp powerUp, @NotNull final Instant endsAt) {
    this.powerUp = powerUp;
    this.endsAt = endsAt;
  }

  public PowerUp getPowerUp() {
    return this.powerUp;
  }

  public Instant getEndsAt() {
    return this.endsAt;
  }

  @Override
  public void write(@NotNull final PayloadWriter writer) {
    writer.writeVarInt(this.powerUp.ordinal());
    writer.writeString(this.endsAt.toString());
  }

  @Override
  public void read(@NotNull final PayloadReader reader) {
    this.powerUp = PowerUp.values()[reader.readVarInt()];
    this.endsAt = Instant.parse(reader.readString());
  }

}
