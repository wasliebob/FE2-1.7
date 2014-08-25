package forestryextras.items.bees;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import com.mojang.authlib.GameProfile;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import forestry.api.apiculture.EnumBeeType;
import forestry.api.apiculture.IAlleleBeeSpecies;
import forestry.api.apiculture.IBeeGenome;
import forestry.api.apiculture.IBeeHousing;
import forestry.api.apiculture.IBeeRoot;
import forestry.api.core.EnumHumidity;
import forestry.api.core.EnumTemperature;
import forestry.api.core.IIconProvider;
import forestry.api.genetics.AlleleManager;
import forestry.api.genetics.IAllele;
import forestry.api.genetics.IClassification;
import forestry.api.genetics.IIndividual;
import forestryextras.main.init.FEBees;

public class Species implements IAlleleBeeSpecies, IIconProvider{
	private String binomial;
    private String authority;
    private int primaryColour;
    private int secondaryColour;
    private EnumTemperature temperature;
    private EnumHumidity humidity;
    private boolean hasEffect;
    private boolean isSecret;
    private boolean isCounted;
    private boolean isActive;
    private boolean isNocturnal;
    private IClassification branch;
    private HashMap<ItemStack, Integer> products;
    private HashMap<ItemStack, Integer> specialties;
    private IAllele genomeTemplate[];
    private String uid;
    private boolean dominant;
    
    @SideOnly(Side.CLIENT)
    private IIcon[][] icons;

    public Species(String speciesName, String genusName, IClassification classification, int firstColour,
                    int secondColour, EnumTemperature preferredTemp, EnumHumidity preferredHumidity,
                    boolean hasGlowEffect, boolean isSpeciesSecret, boolean isSpeciesCounted,
                    boolean isSpeciesDominant) {
        this.uid = "fe.bees.species." + speciesName;
        this.dominant = isSpeciesDominant;
        AlleleManager.alleleRegistry.registerAllele(this);
        binomial = genusName;
        authority = "wasliebob";
        primaryColour = firstColour;
        secondaryColour = secondColour;
        temperature = preferredTemp;
        humidity = preferredHumidity;
        hasEffect = hasGlowEffect;
        isSecret = isSpeciesSecret;
        isCounted = isSpeciesCounted;
        products = new HashMap<ItemStack, Integer>();
        specialties = new HashMap<ItemStack, Integer>();
        this.branch = classification;
        this.branch.addMemberSpecies(this);
        this.isActive = true;
        this.isNocturnal = false;
        
        FEBees.specieNames.put(FEBees.specieNames.size(), this.getName() + " Bee");
    }

	@Override
    public IBeeRoot getRoot() {
        return FEBees.beeRoot;
    }

    @Override
    public boolean isNocturnal() {
        return isNocturnal;
    }

    @Override
    public Map<ItemStack, Integer> getProducts() {
        return products;
    }

    public Species addProduct(ItemStack out, int percentileChance) {
        products.put(out, percentileChance);
        return this;
    }

    @Override
    public Map<ItemStack, Integer> getSpecialty() {
        return specialties;
    }

    public Species addSpeciality(ItemStack out, int percentileChance) {
        specialties.put(out, percentileChance);
        return this;
    }

    @Override
    public boolean isJubilant(IBeeGenome genome, IBeeHousing housing) {
        return true;
    }

    @Override
    public IIcon getIcon(EnumBeeType type, int renderPass) {
        return icons[type.ordinal()][Math.min(renderPass, 2)];
    }

    @Override
    public String getEntityTexture() {
        return "/gfx/forestry/entities/bees/honeyBee.png";
    }

    @Override
    public String getDescription() {
        return StatCollector.translateToLocal(getUID() + ".description");
    }

    @Override
    public String getBinomial() {
        return binomial;
    }

    @Override
    public String getAuthority() {
        return authority;
    }

    @Override
    public IClassification getBranch() {
        return branch;
    }

    @Override
    public int getComplexity() {
        return 0;
    }

    @Override
    public float getResearchSuitability(ItemStack itemstack) {
        return 0f;
    }

    @Override
    public EnumTemperature getTemperature() {
        return temperature;
    }

    @Override
    public EnumHumidity getHumidity() {
        return humidity;
    }

    @Override
    public boolean hasEffect() {
        return hasEffect;
    }

    @Override
    public boolean isSecret() {
        return isSecret;
    }

    @Override
    public boolean isCounted() {
        return isCounted;
    }

    @Override
    public int getIconColour(int renderPass) {
        int value = 0xffffff;
        if (renderPass == 0) {
            value = this.primaryColour;
        }
        else if (renderPass == 1) {
            value = this.secondaryColour;
        }
        return value;
    }

    @Override
    public IIconProvider getIconProvider() {
        return this;
    }

    @Override
    public String getUID() {
        return uid;
    }

    @Override
    public boolean isDominant() {
        return dominant;
    }

    @Override
    public String getName() {
        return StatCollector.translateToLocal(getUID());
    }

    @Override
    public IIcon getIcon(short texUID) {
        return icons[0][0];
    }

    @Override
    public void registerIcons(IIconRegister itemMap) {
        this.icons = new IIcon[EnumBeeType.values().length][3];
        String root = "Forestry:bees/default/";
        IIcon body1 = itemMap.registerIcon(root + "body1");
        for (int i = 0; i < EnumBeeType.values().length; i++){
            if(EnumBeeType.values()[i] == EnumBeeType.NONE)
                continue;

            icons[i][0] = itemMap.registerIcon(root +
                    EnumBeeType.values()[i].toString().toLowerCase(Locale.ENGLISH) + ".outline");
            icons[i][1] = (EnumBeeType.values()[i] != EnumBeeType.LARVAE) ? body1 : itemMap.registerIcon(root +
                    EnumBeeType.values()[i].toString().toLowerCase(Locale.ENGLISH) + ".body");
            icons[i][2] = itemMap.registerIcon(root +
                    EnumBeeType.values()[i].toString().toLowerCase(Locale.ENGLISH) + ".body2");
        }
    }
    
	public Species setGenome(IAllele genome[]){
		genomeTemplate = genome;
		return this;
	}

	public IAllele[] getGenome(){
		return genomeTemplate;
	}
	
	public Species register(){
		FEBees.beeRoot.registerTemplate(this.getGenome());
		if (!this.isActive){
			AlleleManager.alleleRegistry.blacklistAllele(this.getUID());
		}
		return this;
	}

	@Override
	public ItemStack[] getResearchBounty(World world, GameProfile gameProfile,
			IIndividual individual, int bountyLevel) {
        return new ItemStack[0];
	}

	@Override
	public String getUnlocalizedName() {
		return this.getName();
	}
}