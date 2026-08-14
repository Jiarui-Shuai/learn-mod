package com.learn.mod.items;

// import net.minecraft.client.multiplayer.chat.LoggedChatMessage.Player;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;

// import net.minecraft.world.level.block.TntBlock;
// import ;

public class Boomaxe extends AxeItem {
 
    public Boomaxe(ToolMaterial toolMaterial, float f, float g, Item.Properties properties) {
        super(toolMaterial, f, g, properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        
        if (!level.isClientSide()) {
            // 直接创建爆炸
            level.explode(context.getPlayer(), 
                context.getClickedPos().getX() + 0.5,
                context.getClickedPos().getY() + 0.5,
                context.getClickedPos().getZ() + 0.5,
                4.0f, // 爆炸威力
                Level.ExplosionInteraction.TNT);
        }
        
        return InteractionResult.SUCCESS;
    }
}