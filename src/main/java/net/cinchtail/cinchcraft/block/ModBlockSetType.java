package net.cinchtail.cinchcraft.block;

import it.unimi.dsi.fastutil.objects.ObjectArraySet;
import net.minecraft.world.level.block.state.properties.BlockSetType;

import java.util.Set;
import java.util.stream.Stream;

public class ModBlockSetType {
    private static final Set<BlockSetType> VALUES = new ObjectArraySet<>();
    public static final BlockSetType AZALEA = register(new BlockSetType("azalea"));


    public static BlockSetType register(BlockSetType blockSetType) {
        VALUES.add(blockSetType);
        return blockSetType;
    }

    public static Stream<BlockSetType> values() {
        return VALUES.stream();
    }
}
