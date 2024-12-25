package top.ialdaiaxiariyay.rttgtcore;

import com.gregtechceu.gtceu.api.recipe.GTRecipeType;
import top.ialdaiaxiariyay.rttgtcore.common.data.recipes.RTTGTRecipes;
import top.ialdaiaxiariyay.rttgtcore.common.data.machines.Machines;
import com.gregtechceu.gtceu.api.GTCEuAPI;
import com.gregtechceu.gtceu.api.data.chemical.material.event.MaterialRegistryEvent;
import com.gregtechceu.gtceu.api.data.chemical.material.registry.MaterialRegistry;
import com.gregtechceu.gtceu.api.machine.MachineDefinition;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Mod(RTTGTCore.MOD_ID)
public class RTTGTCore {
	public static final String
			MOD_ID = "rttgtcore",
			NAME = "RTT GTCore";
	public static final Logger LOGGER = LoggerFactory.getLogger(NAME);
	public static MaterialRegistry MATERIAL_REGISTRY;
	public RTTGTCore() {
		RTTGTCore.init();
		var EventBus = FMLJavaModLoadingContext.get().getModEventBus();
		EventBus.register(this);
		EventBus.addGenericListener(GTRecipeType.class, this::registerRecipeTypes);
		EventBus.addGenericListener(MachineDefinition.class, this::registerMachines);
	}
	public static void init() {
	}

	public static ResourceLocation id(String path) {
		return new ResourceLocation(MOD_ID, path);
	}

	@SubscribeEvent
	public void registerMaterialRegistry(MaterialRegistryEvent event) {
		MATERIAL_REGISTRY = GTCEuAPI.materialManager.createRegistry(RTTGTCore.MOD_ID);
	}
	@SubscribeEvent
	public void registerRecipeTypes(GTCEuAPI.RegisterEvent<ResourceLocation, GTRecipeType> event) {

		RTTGTRecipes.init();
	}
	@SubscribeEvent
	public void registerMachines(GTCEuAPI.RegisterEvent<ResourceLocation, MachineDefinition> event) {
		Machines.init();
	}
}