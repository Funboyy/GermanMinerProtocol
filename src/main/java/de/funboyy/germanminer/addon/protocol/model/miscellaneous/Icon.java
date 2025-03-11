package de.funboyy.germanminer.addon.protocol.model.miscellaneous;

import net.labymod.serverapi.api.payload.io.PayloadReader;
import net.labymod.serverapi.api.payload.io.PayloadWriter;
import org.jetbrains.annotations.NotNull;

public interface Icon {

  void write(@NotNull final PayloadWriter writer);

  void read(@NotNull final PayloadReader reader);

}
