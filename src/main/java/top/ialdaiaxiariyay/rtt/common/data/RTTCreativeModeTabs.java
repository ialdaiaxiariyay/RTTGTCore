package top.ialdaiaxiariyay.rtt.common.data;

import net.minecraft.world.item.CreativeModeTab;

import com.tterrag.registrate.util.entry.RegistryEntry;
import top.ialdaiaxiariyay.rtt.RTT;
import top.ialdaiaxiariyay.rtt.api.registries.RTTRegistration;
import top.ialdaiaxiariyay.rtt.common.blocks.RTTBlocks;
import top.ialdaiaxiariyay.rtt.common.items.RTTItem;
import top.ialdaiaxiariyay.rtt.common.machines.machines.RTTMachines;

import static com.gregtechceu.gtceu.common.data.GTCreativeModeTabs.*;

public class RTTCreativeModeTabs {

    public static RegistryEntry<CreativeModeTab> MACHINES_ITEM;
    public static RegistryEntry<CreativeModeTab> BLOCKS_ITEM;
    public static RegistryEntry<CreativeModeTab> RTTGT_ITEM;

    public RTTCreativeModeTabs() {}

    public static void init() {}

    static {
        MACHINES_ITEM = RTTRegistration.REGISTRATE.defaultCreativeTab("machines_item", (builder) -> {
            builder.displayItems(new RegistrateDisplayItemsGenerator("machines_item", RTTRegistration.REGISTRATE))
                    .icon(RTTMachines.LARGE_SHAPE_WORLD_VOID_PUMP::asStack)
                    .title(RTTRegistration.REGISTRATE.addLang("itemGroup", RTT.id("machines_item"), "RTT GregTechL Machines Items"))
                    .build();
        }).register();

        BLOCKS_ITEM = RTTRegistration.REGISTRATE.defaultCreativeTab("blocks_item", (builder) -> {
            builder.displayItems(new RegistrateDisplayItemsGenerator("blocks_item", RTTRegistration.REGISTRATE))
                    .icon(RTTBlocks.VOID_WORLD_BLOCK::asStack)
                    .title(RTTRegistration.REGISTRATE.addLang("itemGroup", RTT.id("blocks_item"), "RTT GregTechLCe Blocks Items"))
                    .build();
        }).register();

        RTTGT_ITEM = RTTRegistration.REGISTRATE.defaultCreativeTab("gtlce_item", (builder) -> {
            builder.displayItems(new RegistrateDisplayItemsGenerator("gtlce_item", RTTRegistration.REGISTRATE))
                    .icon(RTTItem.NEW_WORLD::asStack)
                    .title(RTTRegistration.REGISTRATE.addLang("itemGroup", RTT.id("gtlce_item"), "RTT GregTechLCe Items"))
                    .build();
        }).register();
    }
}
