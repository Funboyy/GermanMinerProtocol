package de.funboyy.germanminer.addon.protocol;

import de.funboyy.germanminer.addon.protocol.packet.balance.BankBalancePacket;
import de.funboyy.germanminer.addon.protocol.packet.balance.CashBalancePacket;
import de.funboyy.germanminer.addon.protocol.packet.balance.CompanyBalancePacket;
import de.funboyy.germanminer.addon.protocol.packet.balance.ExtraBalancePacket;
import de.funboyy.germanminer.addon.protocol.packet.experience.ExperienceLevelPacket;
import de.funboyy.germanminer.addon.protocol.packet.experience.ExperiencePointsPacket;
import de.funboyy.germanminer.addon.protocol.packet.version.AddonVersionPacket;
import de.funboyy.germanminer.addon.protocol.packet.version.ServerVersionPacket;
import de.funboyy.germanminer.addon.protocol.packet.miscellaneous.CompassPacket;
import de.funboyy.germanminer.addon.protocol.packet.miscellaneous.InputRequestPacket;
import de.funboyy.germanminer.addon.protocol.packet.miscellaneous.InputResponsePacket;
import de.funboyy.germanminer.addon.protocol.packet.miscellaneous.NotificationPacket;
import de.funboyy.germanminer.addon.protocol.packet.miscellaneous.PowerUpPacket;
import de.funboyy.germanminer.addon.protocol.packet.miscellaneous.VotePacket;
import de.funboyy.germanminer.addon.protocol.packet.miscellaneous.ZonePacket;
import de.funboyy.germanminer.addon.protocol.packet.playtime.DailyPlaytimePacket;
import de.funboyy.germanminer.addon.protocol.packet.playtime.DutyPlaytimePacket;
import de.funboyy.germanminer.addon.protocol.packet.playtime.PaydayPacket;
import de.funboyy.germanminer.addon.protocol.packet.playtime.TotalPlaytimePacket;
import de.funboyy.germanminer.addon.protocol.packet.playtime.WeeklyPlaytimePacket;
import de.funboyy.germanminer.addon.protocol.packet.vehicle.VehicleDisplayPacket;
import de.funboyy.germanminer.addon.protocol.packet.vehicle.VehicleInfoPacket;
import de.funboyy.germanminer.addon.protocol.packet.vehicle.VehicleKeyPacket;
import de.funboyy.germanminer.addon.protocol.packet.vehicle.VehiclePositionPacket;
import java.util.Set;
import net.labymod.serverapi.api.AbstractProtocolService;
import net.labymod.serverapi.api.packet.Direction;
import net.labymod.serverapi.core.AddonProtocol;
import org.jetbrains.annotations.NotNull;

public class GermanMinerProtocol extends AddonProtocol {

  // Dummy change for publish

  public static final int LATEST_VERSION = 3;
  public static final int SNAPSHOT_VERSION = 4;

  public static final Set<Integer> SUPPORTED_VERSIONS = Set.of(
          // SNAPSHOT_VERSION,
          LATEST_VERSION
  );

  public GermanMinerProtocol(@NotNull final AbstractProtocolService protocolService) {
    super(protocolService, "germanminer");

    protocolService.registry().registerProtocol(this);

    this.registerPackets();
  }

  public void registerPackets() {
    // 0-9: Version Packets
    super.registerPacket(0, AddonVersionPacket.class, Direction.SERVERBOUND);
    super.registerPacket(1, ServerVersionPacket.class, Direction.CLIENTBOUND);

    // 10-19: Balance Packets
    super.registerPacket(10, CashBalancePacket.class, Direction.CLIENTBOUND);
    super.registerPacket(11, BankBalancePacket.class, Direction.CLIENTBOUND);
    super.registerPacket(12, CompanyBalancePacket.class, Direction.CLIENTBOUND);
    super.registerPacket(13, ExtraBalancePacket.class, Direction.CLIENTBOUND);

    // 20-29: Experience Packets
    super.registerPacket(20, ExperienceLevelPacket.class, Direction.CLIENTBOUND);
    super.registerPacket(21, ExperiencePointsPacket.class, Direction.CLIENTBOUND);

    // 30-39: Playtime Packets
    super.registerPacket(30, DailyPlaytimePacket.class, Direction.CLIENTBOUND);
    super.registerPacket(31, WeeklyPlaytimePacket.class, Direction.CLIENTBOUND);
    super.registerPacket(32, TotalPlaytimePacket.class, Direction.CLIENTBOUND);
    super.registerPacket(33, DutyPlaytimePacket.class, Direction.CLIENTBOUND);
    super.registerPacket(34, PaydayPacket.class, Direction.CLIENTBOUND);

    // 40-49 Vehicle Packets
    super.registerPacket(40, VehicleDisplayPacket.class, Direction.CLIENTBOUND);
    super.registerPacket(41, VehiclePositionPacket.class, Direction.CLIENTBOUND);
    super.registerPacket(42, VehicleInfoPacket.class, Direction.SERVERBOUND);
    super.registerPacket(43, VehicleKeyPacket.class, Direction.SERVERBOUND);

    // 50-99: Miscellaneous Packets
    super.registerPacket(50, NotificationPacket.class, Direction.CLIENTBOUND);
    super.registerPacket(51, InputRequestPacket.class, Direction.CLIENTBOUND);
    super.registerPacket(52, InputResponsePacket.class, Direction.SERVERBOUND);
    super.registerPacket(53, CompassPacket.class, Direction.CLIENTBOUND);
    super.registerPacket(54, PowerUpPacket.class, Direction.CLIENTBOUND);
    super.registerPacket(55, VotePacket.class, Direction.CLIENTBOUND);
    super.registerPacket(56, ZonePacket.class, Direction.CLIENTBOUND);

    // 99+: Snapshot Packets (will be moved later to normal ID's just for better overview while development)
  }

}
