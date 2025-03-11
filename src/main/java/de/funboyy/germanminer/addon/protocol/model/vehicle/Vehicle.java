package de.funboyy.germanminer.addon.protocol.model.vehicle;

import net.labymod.serverapi.api.payload.io.PayloadReader;
import net.labymod.serverapi.api.payload.io.PayloadWriter;
import org.jetbrains.annotations.NotNull;

public class Vehicle {

  private int id;
  private double x;
  private double y;
  private double z;
  private float yaw;
  private float pitch;

  public Vehicle() {
  }

  public Vehicle(final int id, final double x, final double y, final double z, final float yaw,
      final float pitch) {
    this.id = id;
    this.x = x;
    this.y = y;
    this.z = z;
    this.yaw = yaw;
    this.pitch = pitch;
  }

  public int getId() {
    return this.id;
  }

  public double getX() {
    return this.x;
  }

  public double getY() {
    return this.y;
  }

  public double getZ() {
    return this.z;
  }

  public float getYaw() {
    return this.yaw;
  }

  public float getPitch() {
    return this.pitch;
  }

  public void write(@NotNull final PayloadWriter writer) {
    writer.writeVarInt(this.id);
    writer.writeDouble(this.x);
    writer.writeDouble(this.y);
    writer.writeDouble(this.z);
    writer.writeFloat(this.yaw);
    writer.writeFloat(this.pitch);
  }

  public void read(@NotNull final PayloadReader reader) {
    this.id = reader.readVarInt();
    this.x = reader.readDouble();
    this.y = reader.readDouble();
    this.z = reader.readDouble();
    this.yaw = reader.readFloat();
    this.pitch = reader.readFloat();
  }

}
