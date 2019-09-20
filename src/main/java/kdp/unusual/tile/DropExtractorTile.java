package kdp.unusual.tile;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.google.common.base.Predicates;

import net.minecraft.entity.EntityType;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraftforge.fluids.capability.IFluidHandler;
import net.minecraftforge.fluids.capability.templates.FluidTank;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

import kdp.unusual.ModRegistry;
import kdp.limelib.tile.GenericTile;

public class DropExtractorTile extends GenericTile implements ITickableTileEntity {

    protected ItemStackHandler itemStackHandler = new ItemStackHandler(4) {
        @Override
        protected void onContentsChanged(int slot) {
            markDirty();
        }
    };
    protected FluidTank fluidTank = new FluidTank(FluidAttributes.BUCKET_VOLUME * 4, Predicates.alwaysTrue()/*TODO*/) {
        @Override
        protected void onContentsChanged() {
            markDirty();
        }

        @Nonnull
        @Override
        public FluidStack drain(int maxDrain, FluidAction action) {
            return FluidStack.EMPTY;
        }
    };
    protected final LazyOptional<IFluidHandler> fluidHolder = LazyOptional.of(() -> fluidTank);
    protected final LazyOptional<IItemHandler> itemHolder = LazyOptional.of(() -> itemStackHandler);

    public DropExtractorTile() {
        super(ModRegistry.Tiles.dropExtractor);
    }

    @Override
    public void readFromSyncNBT(CompoundNBT compound) {

    }

    @Override
    public CompoundNBT writeToSyncNBT(CompoundNBT compound) {
        return null;
    }

    @Override
    public void tick() {

        CompoundNBT nbt=new CompoundNBT();
        EntityType.loadEntityUnchecked(nbt,world).ifPresent(e->{

        });
    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
        if (cap == CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY) {
            return fluidHolder.cast();
        }
        if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
            return itemHolder.cast();
        }
        return super.getCapability(cap, side);
    }
}
