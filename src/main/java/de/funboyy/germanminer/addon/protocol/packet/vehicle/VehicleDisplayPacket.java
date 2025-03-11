package de.funboyy.germanminer.addon.protocol.packet.vehicle;

import de.funboyy.germanminer.addon.protocol.model.vehicle.Engine;
import de.funboyy.germanminer.addon.protocol.model.vehicle.Gear;
import de.funboyy.germanminer.addon.protocol.model.vehicle.Limiter;
import net.labymod.serverapi.api.packet.Packet;
import net.labymod.serverapi.api.payload.io.PayloadReader;
import net.labymod.serverapi.api.payload.io.PayloadWriter;
import org.jetbrains.annotations.NotNull;

public class VehicleDisplayPacket implements Packet {

  private boolean show;
  private int speed;
  private int fuel;
  private int height;
  private Gear gear;
  private Engine engine;
  private Limiter limiter;
  private boolean nightMode;

  public VehicleDisplayPacket() {
  }

  public VehicleDisplayPacket(final boolean show,
      final int speed,
      final int fuel,
      final int height,
      @NotNull final Gear gear,
      @NotNull final Engine engine,
      @NotNull final Limiter limiter,
      final boolean nightMode) {
    this.show = show;
    this.speed = speed;
    this.fuel = fuel;
    this.height = height;
    this.gear = gear;
    this.engine = engine;
    this.limiter = limiter;
    this.nightMode = nightMode;
  }

  public boolean isShow() {
    return this.show;
  }

  public int getSpeed() {
    return this.speed;
  }

  public int getFuel() {
    return this.fuel;
  }

  public int getHeight() {
    return this.height;
  }

  public Gear getGear() {
    return this.gear;
  }

  public Engine getEngine() {
    return this.engine;
  }

  public Limiter getLimiter() {
    return this.limiter;
  }

  public boolean isNightMode() {
    return this.nightMode;
  }

  @Override
  public void write(@NotNull final PayloadWriter writer) {
    writer.writeBoolean(this.show);

    if (this.show) {
      writer.writeVarInt(this.speed);
      writer.writeVarInt(this.fuel);
      writer.writeVarInt(this.height);
      writer.writeVarInt(this.gear.ordinal());
      this.engine.write(writer);
      this.limiter.write(writer);
      writer.writeBoolean(this.nightMode);
    }
  }

  @Override
  public void read(@NotNull final PayloadReader reader) {
    this.show = reader.readBoolean();

    if (this.show) {
      this.speed = reader.readVarInt();
      this.fuel = reader.readVarInt();
      this.height = reader.readVarInt();
      this.gear = Gear.values()[reader.readVarInt()];
      this.engine = new Engine();
      this.engine.read(reader);
      this.limiter = new Limiter();
      this.limiter.read(reader);
      this.nightMode = reader.readBoolean();
    }
  }

}
