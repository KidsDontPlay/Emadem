package kdp.emadem;

import net.minecraft.tileentity.TileEntityType;

import kdp.emadem.block.DropExtractorBlock;
import kdp.emadem.tile.DropExtractorTile;
import kdp.limelib.block.GenericBlock;

public interface ModRegistry {

    interface Blocks {
        GenericBlock dropExtractor = new DropExtractorBlock().setTileType(DropExtractorTile::new);
    }

    interface Tiles {
        TileEntityType dropExtractor = Blocks.dropExtractor.getTileEntityType();
    }

    static void init(){
        Blocks.dropExtractor.register();
    }

}
