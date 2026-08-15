package com.learn.mod;

import net.fabricmc.api.ModInitializer;
import com.mojang.brigadier.arguments.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.ChatFormatting;
import net.minecraft.commands.Commands;
import net.minecraft.commands.arguments.coordinates.Vec3Argument;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.Level;
import net.minecraft.resources.Identifier;

import java.net.URI;
import java.util.Collection;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

import com.learn.mod.util.AnsiColors;
import com.learn.mod.cmds.DebugCommand;
import com.learn.mod.cmds.TestCommand;

import net.minecraft.network.chat.ClickEvent;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.HoverEvent;
import net.minecraft.network.chat.MutableComponent;

// import net.minecraft.core.registries.BuiltInRegistries;
// import net.minecraft.world.item.ToolMaterial;
// import net.minecraft.core.Registry;
// import net.minecraft.world.item.Item;
// import com.learn.mod.items.Boomaxe;



public class LearnMod implements ModInitializer {
	

	public static final String MOD_ID = "learn";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which 1`mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);


	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

    	LOGGER.info("Hello Fabric world!");
		Identifier id = Identifier.fromNamespaceAndPath(MOD_ID, "testid");
		LOGGER.info(AnsiColors.success("Identifier: " + id)); // 应该输出 "your_mod_id:boom_axe"
		
		CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
			dispatcher.register(
				Commands.literal(MOD_ID)
					.then(Commands.literal("foo")
						.executes(context -> {
						context.getSource().sendSuccess(
							() -> net.minecraft.network.chat.Component.literal("""
								
								/\\___/\\
								( o   o )
								(  =^=  )
								(        )
								(         )
								(          )))))))))))
								
								COMMAND RUNS ACTIVATED!
								"""),
							false
						);
						return 1;
					})
					)
				    .then(Commands.literal("bar")
						.executes(context -> {
							context.getSource().sendSuccess(() -> net.minecraft.network.chat.Component.literal("调用 mycmd 带有 bar"), false);
							return 1;
						})
					)
					.then(Commands.literal("mul")
						.then(Commands.argument("num1", IntegerArgumentType.integer())
							.then(Commands.argument("num2", IntegerArgumentType.integer())
								.executes(context->{
									int num1 = IntegerArgumentType.getInteger(context, "num1");
									int num2 = IntegerArgumentType.getInteger(context, "num2");
									int result = num1 * num2;
									context.getSource().sendSuccess(
										() -> net.minecraft.network.chat.Component.literal(num1+"*"+num2+"=" + result), false
									);
									return 1;
								})
							)
						)
					)
					.then(Commands.literal("sq")
						.then(Commands.argument("num", IntegerArgumentType.integer())
							.executes(context->{
								int num = IntegerArgumentType.getInteger(context, "num");
								// code here
								context.getSource().sendSuccess(
									() -> net.minecraft.network.chat.Component.literal(num+"^2"+"=" + num*num), false
								);
								return 1;
							})
					))
					.then(Commands.literal("momentum")
						.then(Commands.argument("entity", EntityArgument.entities())
								.then(Commands.argument("momentumVector", Vec3Argument.vec3())
								.executes(context->{
									Vec3 addmomentum = Vec3Argument.getVec3(context, "momentumVector");
									LOGGER.warn(AnsiColors.rainbow(addmomentum.toString()));
									Collection<? extends Entity> entities = EntityArgument.getEntities(context, "entity");
									for(Entity entity : entities){
										entity.setDeltaMovement(entity.getDeltaMovement().add(addmomentum));
										
									}
									return 1;
								})
							)
						)

					)
					.then(Commands.literal("debug")
						.then(Commands.argument("entity", EntityArgument.entity())
							.executes(DebugCommand::execute)
						)

					)
					.then(Commands.literal("never_gonna_give_you_up")
						.executes(context -> {
								context.getSource().sendSuccess(
								() -> net.minecraft.network.chat.Component.literal("""
								We're no strangers to love
								You know the rules and so do I
								A full commitment's what I'm thinking of
								You wouldn't get this from any other guy
								I just wanna tell you how I'm feeling
								Gotta make you understand
								Never gonna give you up never gonna let you down
								Never gonna run around and desert you
								Never gonna make you cry never gonna say goodbye
								Never gonna tell a lie and hurt you
								We've known each other for so long
								Your heart's been aching but you're too shy to say it
								Inside we both know what's been going on
								We know the game and we're gonna play it
								And if you ask me how I'm feeling
								Don't tell me you're too blind to see
								Never gonna give you up never gonna let you down
								Never gonna run around and desert you
								Never gonna make you cry never gonna say goodbye
								Never gonna tell a lie and hurt you
								Never gonna give you up never gonna let you down
								Never gonna run around and desert you
								Never gonna make you cry never gonna say goodbye
								Never gonna tell a lie and hurt you
								(Ooh give you up)
								(Ooh give you up)
								(Ooh) never gonna give never gonna give (give you up)
								(Ooh) never gonna give never gonna give (give you up)
								We've known each other for so long
								Your heart's been aching but you're too shy to say it
								Inside we both know what's been going on
								We know the game and we're gonna play it
								I just wanna tell you how I'm feeling
								Gotta make you understand
								Never gonna give you up never gonna let you down
								Never gonna run around and desert you
								Never gonna make you cry never gonna say goodbye
								Never gonna tell a lie and hurt you
								Never gonna give you up never gonna let you down
								Never gonna run around and desert you
								Never gonna make you cry never gonna say goodbye
								Never gonna tell a lie and hurt you
								Never gonna give you up never gonna let you down
								Never gonna run around and desert you
								Never gonna make you cry never gonna say goodbye
								Never gonna tell a lie and hurt you
									"""),
								false
							);
							return 1;
						})
					)
					.then(Commands.literal("never_gonna_give_you_up_cn")
						.executes(context -> {
								context.getSource().sendSuccess(
								() -> net.minecraft.network.chat.Component.literal("""
									我们都是情场老手
									你和我都知道爱情的规则
									我在想的正是一份实打实的承诺
									你从其他人那里得不到的
									我只是想告诉你我的感觉
									必须让你明白
									永不放弃你，从不让你失望
									永不舍弃你
									永不让你哭泣，从不对你说再见
									永不对你撒谎，从不伤害你
									我们都彼此了解很长时间了
									你很心痛因为你不好意思开口告白
									事实上我们都知道我们的关系发展成了什么样子
									我们知道游戏规则并且乐此不疲
									如果你问我感觉怎么样
									不要告诉我你没看见
									永不放弃你，从不让你失望
									永不舍弃你
									永不让你哭泣，从不对你说再见
									永不对你撒谎，从不伤害你
									永不放弃你，从不让你失望
									永不舍弃你
									永不让你哭泣，从不对你说再见
									永不对你撒谎，从不伤害你
									放弃你
									放弃你
									永不放弃你，永不放弃
									永不放弃你，永不放弃
									我们都对彼此了解很久了
									你很心痛因为不好意思开口告白
									但是我们都知道我们之间的发展
									我们知道游戏规则并乐此不疲
									我只是想告诉你我的感受
									必须让你明白
									永不放弃你，从不让你失望
									永不舍弃你
									永不让你哭泣，从不对你说再见
									永不对你撒谎，从不伤害你
									永不放弃你，从不让你失望
									永不舍弃你
									永不让你哭泣，从不对你说再见
									永不对你撒谎，从不伤害你
									永不放弃你，从不让你失望
									永不舍弃你
									永不让你哭泣，从不对你说再见
									永不对你撒谎，从不伤害你
									"""),
								false
							);
							return 1;
						})
					)
					.then(Commands.literal("a_big_melon")
						.executes(
							context -> {
								MutableComponent msg = Component.literal("[ 惊天大瓜, 速看 -> ]");
								ClickEvent ce = new ClickEvent.OpenUrl(URI.create("https://www.bilibili.com/video/BV1GJ411x7h7/"));
								HoverEvent he = new HoverEvent.ShowText(Component.literal("点击查看重磅独家消息！"));
								msg.withStyle(style -> style.withClickEvent(ce))
								   .withStyle(style -> style.withHoverEvent(he))
								   .withStyle(ChatFormatting.GOLD)
								   .withStyle(ChatFormatting.UNDERLINE);
								context.getSource().sendSuccess(
									() -> msg, false
								);
								if (context.getSource().isPlayer()){
									ItemStack is = new ItemStack(Items.MELON);
									Player p = context.getSource().getPlayer();
									p.addItem(is);

								} 
								return 1;
							}
						)
					)
					.then(Commands.literal("count")
						.executes(TestCommand::execute)
					)

			);}
		);

		CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
			dispatcher.register(
				Commands.literal("explode")
					.then(Commands.argument("pos", Vec3Argument.vec3())
						.then(Commands.argument("Power", FloatArgumentType.floatArg())
							.executes(context -> {
								Vec3 pos = Vec3Argument.getVec3(context, "pos");
								float power = FloatArgumentType.getFloat(context, "Power");
								context.getSource().getLevel().explode(null, pos.x, pos.y, pos.z, power, false, Level.ExplosionInteraction.TNT);
								context.getSource().sendSuccess(
									() -> net.minecraft.network.chat.Component.literal("已在"+pos.toString()+"创建威力为"+power+"的爆炸！"), 
									false
								);
								return 1;
							})
						)
					)
					
				);
			}
		);
	}
}