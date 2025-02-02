package top.ialdaiaxiariyay.rttgtcore.common.data.blocks;

import com.gregtechceu.gtceu.api.item.tool.GTToolType;
import com.gregtechceu.gtceu.common.data.GTModels;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

import com.tterrag.registrate.util.entry.BlockEntry;
import com.tterrag.registrate.util.nullness.NonNullFunction;
import com.tterrag.registrate.util.nullness.NonNullSupplier;
import top.ialdaiaxiariyay.rttgtcore.RTTGTCore;
import top.ialdaiaxiariyay.rttgtcore.api.registries.Registration;
import top.ialdaiaxiariyay.rttgtcore.common.data.RTTGTCreativeModeTabs;

import java.util.function.Supplier;

import static top.ialdaiaxiariyay.rttgtcore.api.registries.Registration.REGISTRATE;

public class RTTGTBlocks {

    static {
        Registration.REGISTRATE.creativeModeTab(() -> RTTGTCreativeModeTabs.BLOCKS_ITEM);
    }

    public static void init() {}

    public static BlockEntry<Block> createCasingBlock(String name, ResourceLocation texture) {
        return createCasingBlock(name, Block::new, texture, () -> Blocks.IRON_BLOCK,
                () -> RenderType::cutoutMipped);
    }

    @SuppressWarnings("all")
    public static BlockEntry<Block> createCasingBlock(String name,
                                                      NonNullFunction<BlockBehaviour.Properties, Block> blockSupplier,
                                                      ResourceLocation texture,
                                                      NonNullSupplier<? extends Block> properties,
                                                      Supplier<Supplier<RenderType>> type) {
        BlockEntry<Block> blockEntry = REGISTRATE.block(name, blockSupplier)
                .initialProperties(properties)
                .properties(p -> p.isValidSpawn((state, level, pos, ent) -> false))
                .addLayer(type)
                .blockstate(GTModels.cubeAllModel(name, texture))
                .tag(GTToolType.WRENCH.harvestTags.get(0), BlockTags.MINEABLE_WITH_PICKAXE)
                .item(BlockItem::new)
                .build()
                .register();

        REGISTRATE.setCreativeTab(blockEntry, RTTGTCreativeModeTabs.BLOCKS_ITEM);
        return blockEntry;
    }

    @SuppressWarnings("all")
    public static final BlockEntry<Block> VOID_WORLD_BLOCK = createCasingBlock("void_world_block", RTTGTCore.id("block/void_world_block"));
}
