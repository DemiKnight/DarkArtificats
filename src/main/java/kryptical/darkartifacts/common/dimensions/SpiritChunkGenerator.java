package kryptical.darkartifacts.common.dimensions;

import com.google.common.collect.Lists;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldEntitySpawner;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.MapGenBase;
import net.minecraft.world.gen.MapGenCaves;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Random;

public class SpiritChunkGenerator implements IChunkGenerator {

    private final World worldObj;
    private Random random;
    private Biome[] biomesForGeneration;

//    private List<Biome.SpawnListEntry> mobs = Lists.newArrayList(new Biome.SpawnListEntry(EntityWeirdZombie.class, 100, 2, 2));

    private MapGenBase caveGenerator = new MapGenCaves();
    private SpiritTerrainGenerator terraingen = new SpiritTerrainGenerator();


    public SpiritChunkGenerator(World worldObj) {
        this.worldObj = worldObj;
        long seed = worldObj.getSeed();
        this.random = new Random((seed + 516)*314);
    }

    /**
     *
     *
     * @param x
     * @param z
     * @return
     */
    @Override
    public Chunk generateChunk(int x, int z) {
        ChunkPrimer chunkPrime = new ChunkPrimer();

        // Setup biomes for terraingen
        this.biomesForGeneration = this.worldObj.getBiomeProvider().getBiomesForGeneration(this.biomesForGeneration, x*4 - 2, z*4 - 2,10,10);
        terraingen.setBiomesForGeneration(biomesForGeneration);
        terraingen.generate(x, z, chunkPrime);

        //Setup biomes for decoration
        this.biomesForGeneration = this.worldObj.getBiomeProvider().getBiomes(this.biomesForGeneration, x*16, z*16,16,16);

        //Biome specific blocks
//        terraingen.replaceBiomeBlocks(x, z, chunkPrime, this, biomesForGeneration);


        //Generate caves
        this.caveGenerator.generate(this.worldObj, x, z,chunkPrime);

        Chunk returnChunk = new Chunk(this.worldObj,chunkPrime,x,z);

        byte[] biomeArray = returnChunk.getBiomeArray();
        for(int i = 0; i < biomeArray.length; ++i)
        {
            biomeArray[i] = (byte)Biome.getIdForBiome(this.biomesForGeneration[i]);
        }
        returnChunk.generateSkylightMap();

        return returnChunk;
    }

    /**
     *
     * @param x
     * @param z
     */
    @Override
    public void populate(int x, int z) {
        int i = x * 16;
        int j = z * 16;

        BlockPos blockPosition = new BlockPos(i, 0, j);

        Biome biome = this.worldObj.getBiome(blockPosition.add(16,0,16));

        //Add biome decoration, like flowers in vanilla
        biome.decorate(this.worldObj, this.random, blockPosition);

        WorldEntitySpawner.performWorldGenSpawning(this.worldObj, biome, i + 8, j + 8, 16,16, this.random);
    }



    @Override
    public boolean generateStructures(Chunk chunkIn, int x, int z) {
        return false;
    }

    @Override
    public List<Biome.SpawnListEntry> getPossibleCreatures(EnumCreatureType creatureType, BlockPos pos) {
        // If you want normal creatures appropriate for this biome then uncomment the
        // following two lines:
        Biome biome = this.worldObj.getBiome(pos);
        return biome.getSpawnableList(creatureType);

//        if (creatureType == EnumCreatureType.MONSTER){
//            return mobs;
//        }
//        return ImmutableList.of();
    }

    @Nullable
    @Override
    public BlockPos getNearestStructurePos(World worldIn, String structureName, BlockPos position, boolean findUnexplored) {
        return null;
    }

    @Override
    public void recreateStructures(Chunk chunkIn, int x, int z) {

    }

    @Override
    public boolean isInsideStructure(World worldIn, String structureName, BlockPos pos) {
        return false;
    }
}
