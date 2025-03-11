package de.funboyy.germanminer.addon.protocol.packet.version;

import net.labymod.serverapi.api.payload.io.PayloadReader;
import net.labymod.serverapi.api.payload.io.PayloadWriter;
import org.jetbrains.annotations.NotNull;

public class ServerVersionPacket extends AbstractVersionPacket {

  private boolean supported;

  public ServerVersionPacket() {
    super();
  }

  public ServerVersionPacket(final int version, final boolean supported) {

    super(version);

    this.supported = supported;
  }

  public boolean isSupported() {
    return this.supported;
  }

  @Override
  public void write(@NotNull final PayloadWriter writer) {
    super.write(writer);

    writer.writeBoolean(this.supported);
  }

  @Override
  public void read(@NotNull final PayloadReader reader) {
    super.read(reader);

    this.supported = reader.readBoolean();
  }

}
