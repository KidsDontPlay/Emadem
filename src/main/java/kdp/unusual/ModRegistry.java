package kdp.unusual;

import net.minecraft.tileentity.TileEntityType;

import kdp.unusual.block.DropExtractorBlock;
import kdp.unusual.tile.DropExtractorTile;
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
