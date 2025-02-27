package hensal.spellpackblood.constants;

import net.minecraft.util.IStringSerializable;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import hensal.spellpackblood.MySpellPack;

import javax.annotation.Nullable;

public enum MySpellPackElement implements IStringSerializable {

    BLOOD(new Style().setColor(TextFormatting.RED),"blood");

    private final Style colour;

    private final String unlocalisedName;

    private final ResourceLocation icon;

    MySpellPackElement(Style colour, String name){
        this(colour, name, MySpellPack.MODID);
    }

    MySpellPackElement(Style colour, String name, String modid){
        this.colour = colour;
        this.unlocalisedName = name;
        this.icon = new ResourceLocation(modid, "textures/gui/container/element_icon_" + unlocalisedName + ".png");
    }

    public static MySpellPackElement fromName(String name){

        for(MySpellPackElement element : values()){
            if(element.unlocalisedName.equals(name)) return element;
        }

        throw new IllegalArgumentException("No such element with unlocalised name: " + name);
    }

    @Nullable
    public static MySpellPackElement fromName(String name, @Nullable MySpellPackElement fallback){

        for(MySpellPackElement element : values()){
            if(element.unlocalisedName.equals(name)) return element;
        }

        return fallback;
    }

    /** Returns the translated display name of this element, without formatting. */
    public String getDisplayName(){
        return MySpellPack.proxy.translate("element." + getName());
    }

    /** Returns the {@link Style} object representing the colour of this element. */
    public Style getColour(){
        return colour;
    }

    /** Returns the string formatting code which corresponds to the colour of this element. */
    public String getFormattingCode(){
        return colour.getFormattingCode();
    }

    /** Returns the translated display name for wizards of this element, shown in the trading GUI. */
    public ITextComponent getWizardName(){
        return new TextComponentTranslation("element." + getName() + ".wizard");
    }

    /** Returns this element's unlocalised name. Also used as the serialised string in block properties. */
    @Override
    public String getName(){
        return unlocalisedName;
    }

    /** Returns the {@link ResourceLocation} for this element's 8x8 icon (displayed in the arcane workbench GUI). */
    public ResourceLocation getIcon(){
        return icon;
    }
}
