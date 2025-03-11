package de.funboyy.germanminer.addon.protocol.packet.vehicle;

import de.funboyy.germanminer.addon.protocol.model.vehicle.Vehicle;
import java.util.HashSet;
import java.util.Set;
import net.labymod.serverapi.api.packet.Packet;
import net.labymod.serverapi.api.payload.io.PayloadReader;
import net.labymod.serverapi.api.payload.io.PayloadWriter;
import org.jetbrains.annotations.NotNull;

public class VehiclePositionPacket implements Packet {

  private Set<Vehicle> vehicles;

  public VehiclePositionPacket() {
  }

  public VehiclePositionPacket(@NotNull final Set<Vehicle> vehicles) {
    this.vehicles = vehicles;
  }

  public Set<Vehicle> getVehicles() {
    return this.vehicles;
  }

  @Override
  public void write(@NotNull final PayloadWriter writer) {
    writer.writeVarInt(this.vehicles.size());

    for (final Vehicle vehicle : this.vehicles) {
      vehicle.write(writer);
    }
  }

  @Override
  public void read(@NotNull final PayloadReader reader) {
    final int size = reader.readVarInt();

    this.vehicles = new HashSet<>(size);

    for (int i = 0; i < size; i++) {
      final Vehicle vehicle = new Vehicle();
      vehicle.read(reader);

      this.vehicles.add(vehicle);
    }
  }

}
