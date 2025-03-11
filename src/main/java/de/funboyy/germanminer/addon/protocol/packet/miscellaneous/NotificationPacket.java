package de.funboyy.germanminer.addon.protocol.packet.miscellaneous;

import de.funboyy.germanminer.addon.protocol.model.miscellaneous.Icon;
import de.funboyy.germanminer.addon.protocol.model.miscellaneous.PlayerIcon;
import de.funboyy.germanminer.addon.protocol.model.miscellaneous.RemoteIcon;
import net.labymod.serverapi.api.packet.Packet;
import net.labymod.serverapi.api.payload.io.PayloadReader;
import net.labymod.serverapi.api.payload.io.PayloadWriter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class NotificationPacket implements Packet {

  private Icon icon;
  private String title;
  private String message;

  public NotificationPacket() {
  }

  public NotificationPacket(@NotNull final String title, @NotNull final String message) {
    this(null, title, message);
  }

  public NotificationPacket(@Nullable final Icon icon, @NotNull final String title,
      @NotNull final String message) {
    this.icon = icon;
    this.title = title;
    this.message = message;
  }

  @Nullable
  public Icon getIcon() {
    return this.icon;
  }

  public String getTitle() {
    return this.title;
  }

  public String getMessage() {
    return this.message;
  }

  @Override
  public void write(@NotNull final PayloadWriter writer) {
    final boolean hasIcon = this.icon != null;

    writer.writeBoolean(hasIcon);

    if (hasIcon) {
      writer.writeBoolean(this.icon instanceof PlayerIcon);

      this.icon.write(writer);
    }

    writer.writeString(this.title);
    writer.writeString(this.message);
  }

  @Override
  public void read(@NotNull final PayloadReader reader) {
    final boolean hasIcon = reader.readBoolean();

    if (hasIcon) {
      final Icon icon = reader.readBoolean() ? new PlayerIcon() : new RemoteIcon();
      icon.read(reader);

      this.icon = icon;
    }

    this.title = reader.readString();
    this.message = reader.readString();
  }

}
