package kdp.emadem.block;

import net.minecraft.block.material.Material;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.ToolType;

import kdp.limelib.block.GenericBlock;

public class DropExtractorBlock extends GenericBlock {

    public DropExtractorBlock() {
        super(Properties.create(Material.IRON).hardnessAndResistance(2.5f).harvestTool(ToolType.PICKAXE),
                "drop_extractor", ItemGroup.REDSTONE);
    }
}
