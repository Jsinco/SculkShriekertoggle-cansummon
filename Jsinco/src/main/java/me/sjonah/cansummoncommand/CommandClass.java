package me.sjonah.cansummoncommand;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.block.data.type.SculkShrieker;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandClass implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player player = (sender instanceof Player) ? (Player)sender : null;

        if (player != null) {
            Block block = player.getTargetBlock(null, 5);
            if (block.getType() == Material.SCULK_SHRIEKER) {

                SculkShrieker shrieker = (SculkShrieker) block.getBlockData();
                if (shrieker.isCanSummon()) {
                    shrieker.setCanSummon(false);
                    block.setBlockData(shrieker);
                    player.sendMessage(ChatColor.GRAY + ">> " + ChatColor.BLUE + "This " + ChatColor.GOLD + "Sculk Shrieker " + ChatColor.BLUE + "can no longer spawn wardens");
                    player.playSound(player.getLocation(), Sound.ENTITY_WARDEN_AGITATED, 15, 1);
                } else {
                    shrieker.setCanSummon(true);
                    block.setBlockData(shrieker);
                    player.sendMessage(ChatColor.GRAY + ">> " + ChatColor.BLUE + "This " + ChatColor.GOLD + "Sculk Shrieker " + ChatColor.BLUE + "can now spawn wardens");
                    player.playSound(player.getLocation(), Sound.ENTITY_WARDEN_AGITATED, 15, 1);
                }


            } else {
                player.sendMessage(ChatColor.GRAY + ">> " + ChatColor.BLUE + "Look at a " + ChatColor.GOLD + "Sculk Shrieker");
                player.playSound(player.getLocation(), Sound.ENTITY_WARDEN_LISTENING, 15, 0);
            }

        } else {
            System.out.println("This command can only be run by a player");
            Bukkit.broadcastMessage("This command can only be run by a player");
        }

        return true;
    }

}
