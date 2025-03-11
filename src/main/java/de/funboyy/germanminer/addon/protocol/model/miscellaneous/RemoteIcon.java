package de.funboyy.germanminer.addon.protocol.model.miscellaneous;

import net.labymod.serverapi.api.payload.io.PayloadReader;
import net.labymod.serverapi.api.payload.io.PayloadWriter;
import org.jetbrains.annotations.NotNull;

public class RemoteIcon implements Icon {

  private String url;

  public RemoteIcon() {
  }

  public RemoteIcon(@NotNull final String url) {
    this.url = url;
  }

  public String getUrl() {
    return this.url;
  }

  @Override
  public void write(@NotNull final PayloadWriter writer) {
    writer.writeString(this.url);
  }

  @Override
  public void read(@NotNull final PayloadReader reader) {
    this.url = reader.readString();
  }

}
