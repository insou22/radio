package co.insou.radio.util.title;

import net.minecraft.server.v1_9_R1.IChatBaseComponent;
import net.minecraft.server.v1_9_R1.PacketPlayOutTitle;
import net.minecraft.server.v1_9_R1.PlayerConnection;
import org.bukkit.ChatColor;
import org.bukkit.craftbukkit.v1_9_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class Title {

    private PlayerConnection con;
    PacketPlayOutTitle title = null;
    PacketPlayOutTitle subtitle = null;
    PacketPlayOutTitle times = null;

    public Title(Player p, String title) { con = ((CraftPlayer) p).getHandle().playerConnection; title(title); }
   
    public Title title(String title) {
         IChatBaseComponent comp = IChatBaseComponent.ChatSerializer.a("[\"\",{\"text\":\"" + ChatColor.translateAlternateColorCodes('&', title) + "\"}]");
         this.title = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.TITLE, comp);
        return this;
    }
   
    public Title subtitle(String subtitle) {
         IChatBaseComponent comp = IChatBaseComponent.ChatSerializer.a("[\"\",{\"text\":\"" + ChatColor.translateAlternateColorCodes('&', subtitle) + "\"}]");
        this.subtitle = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.SUBTITLE, comp);
        return this;
    }
   
    public Title times(int fadeIn, int displayTime, int fadeOut) {
        times = new PacketPlayOutTitle(fadeIn, displayTime, fadeOut);
        return this;
    }
   
    public void send() {
        if (title != null) {
            con.sendPacket(title);
            if (subtitle != null) {
                con.sendPacket(subtitle);
            }
            if (times != null) {
                con.sendPacket(times);
            }
        }
    }
}